package com.discord.widgets.settings.billing;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.StyleRes;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.databinding.PaymentSourceViewBinding;
import com.discord.models.domain.ModelPaymentSource;
import com.discord.utilities.billing.PremiumUtils2;
import com.discord.utilities.time.TimeUtils;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: PaymentSourceView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0003\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u001a"}, d2 = {"Lcom/discord/widgets/settings/billing/PaymentSourceView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/discord/models/domain/ModelPaymentSource$ModelPaymentSourceCard;", "paymentSource", "", "bindCard", "(Lcom/discord/models/domain/ModelPaymentSource$ModelPaymentSourceCard;)V", "Lcom/discord/models/domain/ModelPaymentSource$ModelPaymentSourcePaypal;", "bindPaypal", "(Lcom/discord/models/domain/ModelPaymentSource$ModelPaymentSourcePaypal;)V", "Lcom/discord/models/domain/ModelPaymentSource;", "", "isPremium", "bind", "(Lcom/discord/models/domain/ModelPaymentSource;Z)V", "Lcom/discord/databinding/PaymentSourceViewBinding;", "binding", "Lcom/discord/databinding/PaymentSourceViewBinding;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class PaymentSourceView extends ConstraintLayout {
    private final PaymentSourceViewBinding binding;

    public PaymentSourceView(Context context) {
        this(context, null, 0, 6, null);
    }

    public PaymentSourceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ PaymentSourceView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void bindCard(ModelPaymentSource.ModelPaymentSourceCard paymentSource) {
        TextView textView = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.paymentSourceViewTitle");
        FormatUtils.n(textView, R.string.payment_source_card_ending, new Object[]{paymentSource.getBrand(), paymentSource.getLast4()}, null, 4);
        TimeUtils timeUtils = TimeUtils.INSTANCE;
        int expiresMonth = paymentSource.getExpiresMonth();
        TextView textView2 = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.paymentSourceViewSubtext");
        Context context = textView2.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "binding.paymentSourceViewSubtext.context");
        String localizedMonthName = timeUtils.getLocalizedMonthName(expiresMonth, context);
        TextView textView3 = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.paymentSourceViewSubtext");
        FormatUtils.n(textView3, R.string.payment_source_card_expires, new Object[]{localizedMonthName, Integer.valueOf(paymentSource.getExpiresYear())}, null, 4);
    }

    private final void bindPaypal(ModelPaymentSource.ModelPaymentSourcePaypal paymentSource) {
        this.binding.f.setText(R.string.payment_source_paypal);
        TextView textView = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.paymentSourceViewSubtext");
        textView.setText(paymentSource.getEmail());
    }

    public final void bind(ModelPaymentSource paymentSource, boolean isPremium) {
        Intrinsics3.checkNotNullParameter(paymentSource, "paymentSource");
        this.binding.f2135b.setImageResource(PremiumUtils2.getPaymentSourceIcon(paymentSource));
        TextView textView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.paymentSourceViewInvalid");
        textView.setVisibility(paymentSource.getInvalid() ? 0 : 8);
        ImageView imageView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.paymentSourceViewPremium");
        imageView.setVisibility(isPremium ? 0 : 8);
        if (paymentSource instanceof ModelPaymentSource.ModelPaymentSourcePaypal) {
            bindPaypal((ModelPaymentSource.ModelPaymentSourcePaypal) paymentSource);
        } else if (paymentSource instanceof ModelPaymentSource.ModelPaymentSourceCard) {
            bindCard((ModelPaymentSource.ModelPaymentSourceCard) paymentSource);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaymentSourceView(Context context, AttributeSet attributeSet, @StyleRes int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.payment_source_view, this);
        int i2 = R.id.payment_source_view_icon;
        ImageView imageView = (ImageView) findViewById(R.id.payment_source_view_icon);
        if (imageView != null) {
            i2 = R.id.payment_source_view_icon_wrapper;
            CardView cardView = (CardView) findViewById(R.id.payment_source_view_icon_wrapper);
            if (cardView != null) {
                i2 = R.id.payment_source_view_invalid;
                TextView textView = (TextView) findViewById(R.id.payment_source_view_invalid);
                if (textView != null) {
                    i2 = R.id.payment_source_view_premium;
                    ImageView imageView2 = (ImageView) findViewById(R.id.payment_source_view_premium);
                    if (imageView2 != null) {
                        i2 = R.id.payment_source_view_subtext;
                        TextView textView2 = (TextView) findViewById(R.id.payment_source_view_subtext);
                        if (textView2 != null) {
                            i2 = R.id.payment_source_view_title;
                            TextView textView3 = (TextView) findViewById(R.id.payment_source_view_title);
                            if (textView3 != null) {
                                PaymentSourceViewBinding paymentSourceViewBinding = new PaymentSourceViewBinding(this, imageView, cardView, textView, imageView2, textView2, textView3);
                                Intrinsics3.checkNotNullExpressionValue(paymentSourceViewBinding, "PaymentSourceViewBinding…ater.from(context), this)");
                                this.binding = paymentSourceViewBinding;
                                return;
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i2)));
    }
}
