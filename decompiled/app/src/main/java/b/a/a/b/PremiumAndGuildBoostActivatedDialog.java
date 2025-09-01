package b.a.a.b;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.a.i.PremiumAndGuildBoostActivatedDialogBinding;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: PremiumAndGuildBoostActivatedDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R*\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001d\u0010\u0012\u001a\u00020\r8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Lb/a/a/b/g;", "Lcom/discord/app/AppDialog;", "", "onViewBoundOrOnResume", "()V", "Lkotlin/Function0;", "l", "Lkotlin/jvm/functions/Function0;", "getOnDismiss", "()Lkotlin/jvm/functions/Function0;", "setOnDismiss", "(Lkotlin/jvm/functions/Function0;)V", "onDismiss", "Lb/a/i/e1;", "m", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lb/a/i/e1;", "binding", "<init>", "k", "a", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: b.a.a.b.g, reason: use source file name */
/* loaded from: classes.dex */
public final class PremiumAndGuildBoostActivatedDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {outline.d0(PremiumAndGuildBoostActivatedDialog.class, "binding", "getBinding()Lcom/discord/databinding/PremiumAndGuildBoostActivatedDialogBinding;", 0)};

    /* renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l, reason: from kotlin metadata */
    public Function0<Unit> onDismiss;

    /* renamed from: m, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* compiled from: PremiumAndGuildBoostActivatedDialog.kt */
    /* renamed from: b.a.a.b.g$a, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: PremiumAndGuildBoostActivatedDialog.kt */
    /* renamed from: b.a.a.b.g$b */
    public static final /* synthetic */ class b extends FunctionReferenceImpl implements Function1<View, PremiumAndGuildBoostActivatedDialogBinding> {
        public static final b j = new b();

        public b() {
            super(1, PremiumAndGuildBoostActivatedDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/PremiumAndGuildBoostActivatedDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public PremiumAndGuildBoostActivatedDialogBinding invoke(View view) {
            View view2 = view;
            Intrinsics3.checkNotNullParameter(view2, "p1");
            int i = R.id.premium_activated_confirm;
            MaterialButton materialButton = (MaterialButton) view2.findViewById(R.id.premium_activated_confirm);
            if (materialButton != null) {
                i = R.id.premium_and_guild_boost_activated_text;
                TextView textView = (TextView) view2.findViewById(R.id.premium_and_guild_boost_activated_text);
                if (textView != null) {
                    return new PremiumAndGuildBoostActivatedDialogBinding((LinearLayout) view2, materialButton, textView);
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* compiled from: PremiumAndGuildBoostActivatedDialog.kt */
    /* renamed from: b.a.a.b.g$c */
    public static final class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function0<Unit> function0 = PremiumAndGuildBoostActivatedDialog.this.onDismiss;
            if (function0 != null) {
                function0.invoke();
            }
            PremiumAndGuildBoostActivatedDialog.this.dismiss();
        }
    }

    public PremiumAndGuildBoostActivatedDialog() {
        super(R.layout.premium_and_guild_boost_activated_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, b.j, null, 2, null);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        String string;
        super.onViewBoundOrOnResume();
        if (this.onDismiss == null) {
            dismiss();
        }
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString("extra_plan_text")) == null) {
            string = "";
        }
        Intrinsics3.checkNotNullExpressionValue(string, "arguments?.getString(EXTRA_PLAN_NAME) ?: \"\"");
        FragmentViewBindingDelegate fragmentViewBindingDelegate = this.binding;
        KProperty<?>[] kPropertyArr = j;
        TextView textView = ((PremiumAndGuildBoostActivatedDialogBinding) fragmentViewBindingDelegate.getValue((Fragment) this, kPropertyArr[0])).c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.premiumAndGuildBoostActivatedText");
        FormatUtils.n(textView, R.string.billing_premium_and_premium_guild_plan_activated, new Object[]{string}, null, 4);
        requireDialog().setCanceledOnTouchOutside(true);
        ((PremiumAndGuildBoostActivatedDialogBinding) this.binding.getValue((Fragment) this, kPropertyArr[0])).f103b.setOnClickListener(new c());
    }
}
