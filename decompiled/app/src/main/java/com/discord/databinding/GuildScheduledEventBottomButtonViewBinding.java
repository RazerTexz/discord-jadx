package com.discord.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.R;

/* loaded from: classes.dex */
public final class GuildScheduledEventBottomButtonViewBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f2118b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final ImageView e;

    @NonNull
    public final TextView f;

    @NonNull
    public final ImageView g;

    public GuildScheduledEventBottomButtonViewBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull TextView textView, @NonNull ImageView imageView3, @NonNull TextView textView2, @NonNull ImageView imageView4) {
        this.a = constraintLayout;
        this.f2118b = imageView;
        this.c = imageView2;
        this.d = textView;
        this.e = imageView3;
        this.f = textView2;
        this.g = imageView4;
    }

    @NonNull
    public static GuildScheduledEventBottomButtonViewBinding a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.guild_scheduled_event_bottom_button_view, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        int i = R.id.extra_button;
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.extra_button);
        if (imageView != null) {
            i = R.id.primary_button;
            ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.primary_button);
            if (imageView2 != null) {
                i = R.id.primary_button_text;
                TextView textView = (TextView) viewInflate.findViewById(R.id.primary_button_text);
                if (textView != null) {
                    i = R.id.secondary_button;
                    ImageView imageView3 = (ImageView) viewInflate.findViewById(R.id.secondary_button);
                    if (imageView3 != null) {
                        i = R.id.secondary_button_text;
                        TextView textView2 = (TextView) viewInflate.findViewById(R.id.secondary_button_text);
                        if (textView2 != null) {
                            i = R.id.share_button;
                            ImageView imageView4 = (ImageView) viewInflate.findViewById(R.id.share_button);
                            if (imageView4 != null) {
                                return new GuildScheduledEventBottomButtonViewBinding((ConstraintLayout) viewInflate, imageView, imageView2, textView, imageView3, textView2, imageView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
