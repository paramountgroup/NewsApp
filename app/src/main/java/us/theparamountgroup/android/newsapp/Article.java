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

import java.util.Date;

/**
 * An {@link Article} object contains information related to a single earthquake.
 */
public class Article {

    /**
     * Date of the article
     */
    private Date mdate;

    /**
     * Title of the article
     */
    private String mwebTitle;

    /**
     * section the article belongs to
     */
    private String msectionName;

    /**
     * Website URL of the guardian article
     */
    private String mUrl;

    /**
     * Letter for use in article icon
     */
    private String mIconLetter;

    /**
     * Constructs a new {@link Article} object.
     *
     * @param date        is the date (size) of the earthquake
     * @param webTitle    is the webTitle where the earthquake happened
     * @param sectionName is the time in milliseconds (from the Epoch) when the
     *                    earthquake happened
     * @param url         is the website URL to find more details about the earthquake
     */
    public Article(Date date, String webTitle, String sectionName, String url, String iconLetter) {
        mdate = date;
        mwebTitle = webTitle;
        msectionName = sectionName;
        mUrl = url;
        mIconLetter = iconLetter;
    }

    /**
     * Returns the date of the article.
     */
    public Date getDate() {
        return mdate;
    }

    /**
     * Returns the title of the article.
     */
    public String getTitle() {
        return mwebTitle;
    }

    /**
     * Returns the section the article belongs.
     */
    public String getSectionName() {
        return msectionName;
    }

    /**
     * Returns the website URL to find more information about the earthquake.
     */
    public String getUrl() {
        return mUrl;
    }

    /**
     * Returns the icon letter for use in UI
     */
    public String getIconLetter() {
        return mIconLetter;
    }

    /**
     * Set the icon letter for use in the UI
     */
    public void setIconLetter(String iconLetter) {
        this.mIconLetter = iconLetter;
    }

}
