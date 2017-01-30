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
package us.theparamountgroup.android.newsapp;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * An {@link ArticleAdapter} knows how to create a list item layout for each article
 * in the data source (a list of {@link Article} objects).
 *
 * These list item layouts will be provided to an adapter view like ListView
 * to be displayed to the user.
 */


public class ArticleAdapter extends ArrayAdapter<Article> {
    private static final String LOG_TAG = ArticleAdapter.class.getName();


    /**
     * Constructs a new {@link ArticleAdapter}.
     *
     * @param context of the app
     * @param articles is the list of articles, which is the data source of the adapter
     */
    public ArticleAdapter(Context context, List<Article> articles) {
        super(context, 0, articles);
    }

    /**
     * Returns a list item view that displays information about the article at the given position
     * in the list of articles.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.article_list_item, parent, false);
        }

        // Find the article at the given position in the list of articles
        Article currentArticle = getItem(position);

        // Find the TextView with view ID magnitude
        TextView iconView = (TextView) listItemView.findViewById(R.id.icon);

        // Set the proper background color on the icon circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable iconCircle = (GradientDrawable) iconView.getBackground();

        // Get the appropriate background color based on the current icon section
        String sectionName = currentArticle.getSectionName();
        int iconColor = getIconColor(sectionName, currentArticle);

        // Set the color on the magnitude circle
        iconCircle.setColor(iconColor);

        // Set icon letter to match the article section
        iconView.setText(currentArticle.getIconLetter());

        // Get the tille string from the Article object,
        String articleTitle = currentArticle.getTitle();

        // Find the TextView with view ID location
        TextView titleView = (TextView) listItemView.findViewById(R.id.web_title);
        // Display the location of the current earthquake in that TextView
        titleView.setText(articleTitle);

        // Find the TextView with view ID section_name
        TextView sectionView = (TextView) listItemView.findViewById(R.id.section_name);

        // Display the section of the current article in that TextView
        sectionView.setText(sectionName);

        // Find the TextView with view ID date
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);

        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(currentArticle.getDate());

        // Display the date of the current article in that TextView
        dateView.setText(formattedDate);

        return listItemView;
    }

    /**
     * Return the color and icon letter for the icon circle based on the section name.
     *
     * @param sectionName of the article
     */
    private int getIconColor(String sectionName, Article currentArticle) {

        int iconColorResourceId;
        sectionName = sectionName.toUpperCase();

        switch (sectionName) {
            case "US NEWS":
            case "SPORT":
                iconColorResourceId = R.color.magnitude1;
                currentArticle.setIconLetter("S");
                break;
            case "FOOTBALL":
                iconColorResourceId = R.color.magnitude2;
                currentArticle.setIconLetter("FB");
                break;
            case "FILM":
                iconColorResourceId = R.color.magnitude3;
                currentArticle.setIconLetter("F");
                break;
            case "MEDIA":
                iconColorResourceId = R.color.magnitude4;
                currentArticle.setIconLetter("M");
                break;
            case "SOCIETY":
                iconColorResourceId = R.color.magnitude5;
                currentArticle.setIconLetter("SC");
                break;
            case "POLITICS":
                iconColorResourceId = R.color.magnitude6;
                currentArticle.setIconLetter("P");
                break;
            case "TECHNOLOGY":
                iconColorResourceId = R.color.magnitude7;
                currentArticle.setIconLetter("T");
                break;
            case "BUSINESS":
                iconColorResourceId = R.color.magnitude8;
                currentArticle.setIconLetter("B");
                break;
            case "GUARDIAN SUSTAINABLE BUSINESS":
                iconColorResourceId = R.color.magnitude9;
                currentArticle.setIconLetter("SB");
                break;
            default:
                iconColorResourceId = R.color.magnitude10plus;
                currentArticle.setIconLetter("*");
                break;
        }

        return ContextCompat.getColor(getContext(), iconColorResourceId);
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }
}
