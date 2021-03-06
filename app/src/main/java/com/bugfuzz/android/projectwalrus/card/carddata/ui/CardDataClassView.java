/*
 * Copyright 2018 Daniel Underhay & Matthew Daley.
 *
 * This file is part of Walrus.
 *
 * Walrus is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Walrus is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Walrus.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.bugfuzz.android.projectwalrus.card.carddata.ui;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bugfuzz.android.projectwalrus.R;
import com.bugfuzz.android.projectwalrus.card.carddata.CardData;

public class CardDataClassView extends FrameLayout {

    public CardDataClassView(Context context) {
        super(context);

        addView(inflate(getContext(), R.layout.view_card_data_class, null));
    }

    public void setCardDataClass(Class<? extends CardData> cardDataClass) {
        CardData.Metadata metadata = cardDataClass.getAnnotation(
                CardData.Metadata.class);

        ImageView image = findViewById(R.id.image);
        image.setImageDrawable(ContextCompat.getDrawable(getContext(), metadata.iconId()));
        image.setContentDescription(metadata.name());
        ((TextView) findViewById(R.id.name)).setText(metadata.name());
    }
}
