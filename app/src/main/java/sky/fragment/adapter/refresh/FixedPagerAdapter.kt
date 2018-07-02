package sky.fragment.adapter.refresh

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.view.View
import android.view.ViewGroup
import java.util.*


abstract class FixedPagerAdapter<T>(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    private val mCurrentItems = ArrayList<ItemInfo<T>?>()
    override fun instantiateItem(container: ViewGroup, position: Int): ItemInfo<T> {
        while (mCurrentItems.size <= position) {
            mCurrentItems.add(null)
        }
        val fragment = super.instantiateItem(container, position) as Fragment
        val itemObject = ItemInfo(fragment, getItemData(position))
        mCurrentItems[position] = itemObject
        return itemObject
    }

    @Suppress("UNCHECKED_CAST")
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        mCurrentItems[position] = null
        super.destroyItem(container, position, `object`.let { it as ItemInfo<T> }.fragment)
    }

    @Suppress("UNCHECKED_CAST")
    override fun getItemPosition(`object`: Any): Int {

        val itemObject = `object`.let { it as ItemInfo<T> }
        if (mCurrentItems.contains(itemObject)) {
            val oldData = itemObject.t
            val oldPosition = mCurrentItems.indexOf(itemObject)
            val newData = getItemData(oldPosition)
            return if (equalsItem(oldData, newData)) POSITION_UNCHANGED else POSITION_NONE
        }
        return POSITION_UNCHANGED
    }

    @Suppress("UNCHECKED_CAST")
    override fun setPrimaryItem(container: ViewGroup, position: Int, `object`: Any) {
        super.setPrimaryItem(container, position, `object`.let { it as ItemInfo<T> }.fragment)
    }

    @Suppress("UNCHECKED_CAST")
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return super.isViewFromObject(view, `object`.let { it as ItemInfo<T> }.fragment)
    }

    abstract fun getItemData(position: Int): T
    abstract fun getDataPosition(t: T): Int
    abstract fun equalsItem(oldT: T, newT: T): Boolean

    inner class ItemInfo<T>(var fragment: Fragment, var t: T)
}