package sky.fragment.adapter.refresh


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.data_fragment.*

class DataFragment : Fragment() {

    private var data: String? = null
   /* override fun onAttach(context: Context?) {
        super.onAttach(context)
        Log.i("sky.blu", "onAttach:。。。。。。。。。。。。")
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        data = arguments?.getString(EX_DATA)
        Log.i("sky.blu", "$data:onCreate")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.i("sky.blu", "$data:onCreateView")
        return inflater.inflate(R.layout.data_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        data?.let { tv_data.text = it }
        Log.i("sky.blu", "$data:onViewCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.i("sky.blu", "$data:onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("sky.blu", "$data:onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("sky.blu", "$data:onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("sky.blu", "$data:onPause")
    }


    companion object {
        private const val EX_DATA = "data"
        fun newInstance(data: String): DataFragment {
            val args = Bundle()
            args.putString(EX_DATA, data)
            val fragment = DataFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
