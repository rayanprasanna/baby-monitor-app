package ammaibabai.universl.com.ammaibabai.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import ammaibabai.universl.com.ammaibabai.R;

public class ButtonListAdapter extends BaseAdapter {
	private Context context;
	private String[] contents;
	private String[] titles;
	private static LayoutInflater inflater = null;

	public ButtonListAdapter(Context context , String[] contents,String[] titles) {
		this.context = context;
		this.contents = contents;
		this.titles = titles;
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

	}

	@Override
	public int getCount() {
		return contents.length;
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		View rowView = inflater.inflate(R.layout.list_item_button, null);
		TextView textView = (TextView) rowView.findViewById(R.id.textView);
		textView.setText(titles[position]);
		return rowView;
	}


}