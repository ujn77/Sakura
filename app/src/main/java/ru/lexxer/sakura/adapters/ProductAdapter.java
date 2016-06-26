package ru.lexxer.sakura.adapters;

/**
 * Date: 26.06.2016
 * Time: 13:59
 *
 * @author Alexey Buynichev
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import ru.lexxer.sakura.R;

public class ProductAdapter extends BaseAdapter {
    private Context mContext;
    private String[] mData;

    public ProductAdapter(Context context, String[] objects) {
        mContext = context;
        mData = objects;
    }

    static class ViewHolder {
        TextView mTextName;
        TextView mTextPrice;
    }

    @Override
    public String getItem(int i) {
        return mData[i];
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_list, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.mTextName = (TextView) convertView.findViewById(R.id.textName);
            viewHolder.mTextPrice = (TextView) convertView.findViewById(R.id.textPrice);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.mTextName.setText(getItem(position));

        return convertView;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getCount() {
        return mData.length;
    }
}

