package de.tum.in.tumcampus.cards;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.ViewGroup;

import de.tum.in.tumcampus.R;
import de.tum.in.tumcampus.models.managers.CardManager;

/**
 * Card that describes how to dismiss a card
 */
public class FirstUseCard1 extends Card {

    public FirstUseCard1(Context context) {
        super(context);
    }

    @Override
    public int getTyp() {
        return CardManager.CARD_FIRST_USE_1;
    }

    @Override
    public View getCardView(Context context, ViewGroup parent) {
        super.getCardView(context, parent);

        return mInflater.inflate(R.layout.card_first_use1, parent, false);
    }

    @Override
    public void discard(Editor editor) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(mContext);
        prefs.edit().putBoolean(CardManager.SHOW_TUTORIAL_1, false).apply();
    }

    @Override
    public boolean shouldShow(SharedPreferences p) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(mContext);
        return prefs.getBoolean(CardManager.SHOW_TUTORIAL_1, true);
    }
}
