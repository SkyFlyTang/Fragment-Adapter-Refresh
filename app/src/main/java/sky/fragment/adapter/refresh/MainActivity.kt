package sky.fragment.adapter.refresh

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private val random by lazy { Random() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val data = ArrayList<String>()
        for (i in 0..5) {
            data.add(i.toString())
        }
        val pagerAdapter = MyFixedPagerAdapter(supportFragmentManager, data)
        vp_content.adapter = pagerAdapter
        tv_test_add.setOnClickListener {
            val index = random.nextInt(data.size)
            data.add(index, "this is add data ${random.nextInt()}")
            pagerAdapter.notifyDataSetChanged()
        }
        tv_test_delete.setOnClickListener {
            if (data.size > 0) {
                data.removeAt(random.nextInt(data.size))
                pagerAdapter.notifyDataSetChanged()
            }
        }
    }
}
