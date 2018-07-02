package sky.fragment.adapter.refresh

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.text.TextUtils

class MyFixedPagerAdapter(fm: FragmentManager, val data: ArrayList<String>) : FixedPagerAdapter<String>(fm) {
    override fun getItemData(position: Int): String {
        return if (data.size > position) data[position] else ""
    }

    override fun getDataPosition(t: String): Int {
        return if (t.isEmpty()) -1 else data.indexOf(t)
    }

    override fun equalsItem(oldT: String, newT: String): Boolean {
        return TextUtils.equals(oldT, newT)
    }

    override fun getItem(position: Int): Fragment {
        return DataFragment.newInstance(data[position]).let { it as Fragment }
    }

    override fun getCount(): Int {
        return data.size
    }
}