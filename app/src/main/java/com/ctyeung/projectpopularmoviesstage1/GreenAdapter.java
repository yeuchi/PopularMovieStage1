/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ctyeung.projectpopularmoviesstage1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Callback;
import android.content.Context;
import android.widget.Toast;
import com.ctyeung.projectpopularmoviesstage1.utilities.JSONhelper;

public class GreenAdapter extends RecyclerView.Adapter<GreenAdapter.NumberViewHolder> {

    private static final String TAG = GreenAdapter.class.getSimpleName();
    final private ListItemClickListener mOnClickListener;


    private static int viewHolderCount;
    final static String BASE_URL = "http://image.tmdb.org/t/p/";
    final static String KEY_TITLE = "title";
    final static String KEY_POSTER_PATH = "poster_path";
    private int mNumberItems;
    private JSONArray mJsonArray;

    public interface ListItemClickListener
    {
        void onListItemClick(int clickItemIndex);
    }

    public GreenAdapter(int numberOfItems, ListItemClickListener listener, JSONArray jsonArray) {
        mJsonArray = jsonArray;
        mNumberItems = numberOfItems;
        mOnClickListener = listener;
        viewHolderCount = 0;
    }

    @Override
    public NumberViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.recyclerview_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        NumberViewHolder viewHolder = new NumberViewHolder(view);

        JSONObject json = JSONhelper.parseJsonFromArray(mJsonArray, viewHolderCount);
        String title = JSONhelper.parseValueByKey(json, KEY_TITLE);

        viewHolder.viewHolderName.setText(title);

        Log.d(TAG, "onCreateViewHolder: number of ViewHolders created: " + viewHolderCount);

        String url = BASE_URL + getSizeByIndex(3) + JSONhelper.parseValueByKey(json, KEY_POSTER_PATH);

        Picasso.with(context)
                .load(url)
                .placeholder(R.drawable.placeholder)   // optional
                .error(R.drawable.placeholder)      // optional
                .into(viewHolder.viewHolderImage, new Callback() {
                @Override
                public void onSuccess() {
                    //Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onError() {
                    //Toast.makeText(context, "failed", Toast.LENGTH_SHORT).show();
                }
        });

        viewHolderCount++;

        return viewHolder;
    }


    protected static String getSizeByIndex(int i)
    {
        switch (i) {
            case 0:
                return "w92/";

            case 1:
                return "w154/";

            default:
            case 2:
                return "w185/";

            case 3:
                return "w342/";

            case 4:
                return "w500/";

            case 5:
                return "w780/";

            case 6:
                return "original/";
        }
    }

    /**
     * OnBindViewHolder is called by the RecyclerView to display the data at the specified
     * position. In this method, we update the contents of the ViewHolder to display the correct
     * indices in the list for this particular position, using the "position" argument that is conveniently
     * passed into us.
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(NumberViewHolder holder, int position) {
        Log.d(TAG, "#" + position);
        holder.bind(position);
    }

    /**
     * This method simply returns the number of items to display. It is used behind the scenes
     * to help layout our Views and for animations.
     *
     * @return The number of items available
     */
    @Override
    public int getItemCount() {
        return mNumberItems;
    }

    /**
     * Cache of the children views for a list item.
     */
    class NumberViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        // Will display the position in the list, ie 0 through getItemCount() - 1
        TextView viewHolderName;
        // Will display which ViewHolder is displaying this data
        ImageView viewHolderImage;

        /**
         * Constructor for our ViewHolder. Within this constructor, we get a reference to our
         * TextViews and set an onClickListener to listen for clicks. Those will be handled in the
         * onClick method below.
         * @param itemView The View that you inflated in
         *                 {@link GreenAdapter#onCreateViewHolder(ViewGroup, int)}
         */
        public NumberViewHolder(View itemView) {
            super(itemView);

            viewHolderName = (TextView) itemView.findViewById(R.id.txt_movie);
            viewHolderImage = (ImageView) itemView.findViewById(R.id.iv_movie);
            itemView.setOnClickListener(this);
        }

        /**
         * A method we wrote for convenience. This method will take an integer as input and
         * use that integer to display the appropriate text within a list item.
         * @param listIndex Position of the item in the list
         */
        void bind(int listIndex)
        {

            //viewHolderName.setText(String.valueOf(listIndex));
        }

        @Override
        public void onClick(View view)
        {
            int clickPosition = getAdapterPosition();
            mOnClickListener.onListItemClick(clickPosition);
        }

    }
}
