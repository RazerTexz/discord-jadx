package b.a.a.b;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.i.SingleValuePropPremiumUpsellDialogBinding;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.premium.ShinyButton;
import com.discord.widgets.settings.premium.WidgetSettingsPremium;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: SingleValuePropPremiumUpsellDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001d\u0010\f\u001a\u00020\u00078B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lb/a/a/b/d;", "Lcom/discord/app/AppDialog;", "Landroid/view/View;", "view", "", "onViewBound", "(Landroid/view/View;)V", "Lb/a/i/p1;", "l", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "g", "()Lb/a/i/p1;", "binding", "<init>", "()V", "k", "b", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: b.a.a.b.d, reason: use source file name */
/* loaded from: classes.dex */
public final class SingleValuePropPremiumUpsellDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {outline.d0(SingleValuePropPremiumUpsellDialog.class, "binding", "getBinding()Lcom/discord/databinding/SingleValuePropPremiumUpsellDialogBinding;", 0)};

    /* renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* compiled from: java-style lambda group */
    /* renamed from: b.a.a.b.d$a */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int j;
        public final /* synthetic */ Object k;

        public a(int i, Object obj) {
            this.j = i;
            this.k = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.j;
            if (i == 0) {
                ((SingleValuePropPremiumUpsellDialog) this.k).dismiss();
                return;
            }
            if (i != 1) {
                throw null;
            }
            SingleValuePropPremiumUpsellDialog singleValuePropPremiumUpsellDialog = (SingleValuePropPremiumUpsellDialog) this.k;
            KProperty[] kPropertyArr = SingleValuePropPremiumUpsellDialog.j;
            Objects.requireNonNull(singleValuePropPremiumUpsellDialog);
            WidgetSettingsPremium.Companion companion = WidgetSettingsPremium.INSTANCE;
            Context contextRequireContext = singleValuePropPremiumUpsellDialog.requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            WidgetSettingsPremium.Companion.launch$default(companion, contextRequireContext, null, null, 6, null);
            singleValuePropPremiumUpsellDialog.dismiss();
        }
    }

    /* compiled from: SingleValuePropPremiumUpsellDialog.kt */
    /* renamed from: b.a.a.b.d$b, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final void a(FragmentManager fragmentManager, AnalyticsTracker.PremiumUpsellType premiumUpsellType, @DrawableRes int i, String str, String str2, String str3, String str4, String str5) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(premiumUpsellType, "premiumUpsellType");
            SingleValuePropPremiumUpsellDialog singleValuePropPremiumUpsellDialog = new SingleValuePropPremiumUpsellDialog();
            Bundle bundle = new Bundle();
            bundle.putInt("extra_image_drawable_res", i);
            bundle.putString("extra_header_text", str);
            bundle.putString("extra_body_text", str2);
            singleValuePropPremiumUpsellDialog.setArguments(bundle);
            singleValuePropPremiumUpsellDialog.show(fragmentManager, SingleValuePropPremiumUpsellDialog.class.getName());
            AnalyticsTracker.premiumUpsellViewed$default(AnalyticsTracker.INSTANCE, premiumUpsellType, null, null, new Traits.Source(str3, str4, str5, null, null, 24, null), 6, null);
        }
    }

    /* compiled from: SingleValuePropPremiumUpsellDialog.kt */
    /* renamed from: b.a.a.b.d$c */
    public static final /* synthetic */ class c extends FunctionReferenceImpl implements Function1<View, SingleValuePropPremiumUpsellDialogBinding> {
        public static final c j = new c();

        public c() {
            super(1, SingleValuePropPremiumUpsellDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/SingleValuePropPremiumUpsellDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public SingleValuePropPremiumUpsellDialogBinding invoke(View view) {
            View view2 = view;
            Intrinsics3.checkNotNullParameter(view2, "p1");
            int i = R.id.button_container;
            LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.button_container);
            if (linearLayout != null) {
                i = R.id.close_button;
                MaterialButton materialButton = (MaterialButton) view2.findViewById(R.id.close_button);
                if (materialButton != null) {
                    i = R.id.content_background;
                    View viewFindViewById = view2.findViewById(R.id.content_background);
                    if (viewFindViewById != null) {
                        i = R.id.get_premium_button;
                        ShinyButton shinyButton = (ShinyButton) view2.findViewById(R.id.get_premium_button);
                        if (shinyButton != null) {
                            i = R.id.transparent_space;
                            View viewFindViewById2 = view2.findViewById(R.id.transparent_space);
                            if (viewFindViewById2 != null) {
                                i = R.id.upsell_body_text;
                                TextView textView = (TextView) view2.findViewById(R.id.upsell_body_text);
                                if (textView != null) {
                                    i = R.id.upsell_header_text;
                                    TextView textView2 = (TextView) view2.findViewById(R.id.upsell_header_text);
                                    if (textView2 != null) {
                                        i = R.id.value_prop_image;
                                        ImageView imageView = (ImageView) view2.findViewById(R.id.value_prop_image);
                                        if (imageView != null) {
                                            return new SingleValuePropPremiumUpsellDialogBinding((LinearLayout) view2, linearLayout, materialButton, viewFindViewById, shinyButton, viewFindViewById2, textView, textView2, imageView);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    public SingleValuePropPremiumUpsellDialog() {
        super(R.layout.single_value_prop_premium_upsell_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, c.j, null, 2, null);
    }

    public final SingleValuePropPremiumUpsellDialogBinding g() {
        return (SingleValuePropPremiumUpsellDialogBinding) this.binding.getValue((Fragment) this, j[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        Bundle arguments = getArguments();
        Integer numValueOf = arguments != null ? Integer.valueOf(arguments.getInt("extra_image_drawable_res")) : null;
        Bundle arguments2 = getArguments();
        String string = arguments2 != null ? arguments2.getString("extra_header_text") : null;
        Bundle arguments3 = getArguments();
        String string2 = arguments3 != null ? arguments3.getString("extra_body_text") : null;
        if (numValueOf != null) {
            g().f.setImageDrawable(ContextCompat.getDrawable(requireContext(), numValueOf.intValue()));
        }
        if (string != null) {
            TextView textView = g().e;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.upsellHeaderText");
            textView.setText(string);
        }
        if (string2 != null) {
            TextView textView2 = g().d;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.upsellBodyText");
            textView2.setText(string2);
        }
        g().f178b.setOnClickListener(new a(0, this));
        g().c.setOnClickListener(new a(1, this));
    }
}
