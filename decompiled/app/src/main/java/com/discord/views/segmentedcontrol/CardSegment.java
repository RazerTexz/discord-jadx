package com.discord.views.segmentedcontrol;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;
import b.a.i.CardSegmentViewBinding;
import b.a.y.n0.SegmentedControlSegment;
import com.discord.R;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.chat.input.gifpicker.ViewScalingOnTouchListener;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: CardSegment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\u0007J\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u001a"}, d2 = {"Lcom/discord/views/segmentedcontrol/CardSegment;", "Landroidx/cardview/widget/CardView;", "Lb/a/y/n0/a;", "", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "", "setText", "(Ljava/lang/CharSequence;)V", "Landroid/view/View;", "getCardText", "()Landroid/view/View;", "setBadgeText", "", "selected", "a", "(Z)V", "Lb/a/i/f;", "j", "Lb/a/i/f;", "binding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class CardSegment extends CardView implements SegmentedControlSegment {

    /* renamed from: j, reason: from kotlin metadata */
    public final CardSegmentViewBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardSegment(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.card_segment_view, this);
        int i = R.id.card_segment_badge;
        TextView textView = (TextView) findViewById(R.id.card_segment_badge);
        if (textView != null) {
            i = R.id.card_segment_text;
            TextView textView2 = (TextView) findViewById(R.id.card_segment_text);
            if (textView2 != null) {
                CardSegmentViewBinding cardSegmentViewBinding = new CardSegmentViewBinding(this, textView, textView2);
                Intrinsics3.checkNotNullExpressionValue(cardSegmentViewBinding, "CardSegmentViewBinding.i…ater.from(context), this)");
                this.binding = cardSegmentViewBinding;
                if (attributeSet != null) {
                    TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.a.CardSegment, 0, 0);
                    Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…leable.CardSegment, 0, 0)");
                    try {
                        setText(typedArrayObtainStyledAttributes.getString(0));
                    } finally {
                        typedArrayObtainStyledAttributes.recycle();
                    }
                }
                setOnTouchListener(new ViewScalingOnTouchListener(0.9f));
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    @Override // b.a.y.n0.SegmentedControlSegment
    public void a(boolean selected) {
        int themedColor = selected ? ColorCompat.getThemedColor(this, R.attr.colorBackgroundAccent) : ColorCompat.getColor(this, R.color.transparent);
        int color = selected ? ColorCompat.getColor(this, R.color.white) : ColorCompat.getThemedColor(this, R.attr.colorInteractiveMuted);
        setCardBackgroundColor(themedColor);
        this.binding.c.setTextColor(color);
    }

    public final View getCardText() {
        TextView textView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.cardSegmentText");
        return textView;
    }

    public final void setBadgeText(CharSequence text) {
        TextView textView = this.binding.f109b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.cardSegmentBadge");
        ViewExtensions.setTextAndVisibilityBy(textView, text);
    }

    public final void setText(CharSequence text) {
        TextView textView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.cardSegmentText");
        textView.setText(text);
    }
}
