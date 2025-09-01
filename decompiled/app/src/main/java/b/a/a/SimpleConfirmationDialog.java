package b.a.a;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.i.SimpleConfirmationDialogBinding;
import b.a.k.FormatUtils;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.dialogs.SimpleConfirmationDialog2;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.button.MaterialButton;
import d0.LazyJVM;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: SimpleConfirmationDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0019\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R$\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001d\u0010\u0012\u001a\u00020\r8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0018\u001a\u00020\u00138F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lb/a/a/e;", "Lcom/discord/app/AppDialog;", "", "onViewBoundOrOnResume", "()V", "Landroid/view/View$OnClickListener;", "m", "Landroid/view/View$OnClickListener;", "getPositiveClickListener", "()Landroid/view/View$OnClickListener;", "setPositiveClickListener", "(Landroid/view/View$OnClickListener;)V", "positiveClickListener", "Lb/a/i/o1;", "n", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "h", "()Lb/a/i/o1;", "binding", "Lcom/discord/dialogs/SimpleConfirmationDialogArgs;", "l", "Lkotlin/Lazy;", "g", "()Lcom/discord/dialogs/SimpleConfirmationDialogArgs;", "args", "<init>", "k", "c", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: b.a.a.e, reason: use source file name */
/* loaded from: classes.dex */
public final class SimpleConfirmationDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {outline.d0(SimpleConfirmationDialog.class, "binding", "getBinding()Lcom/discord/databinding/SimpleConfirmationDialogBinding;", 0)};

    /* renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l, reason: from kotlin metadata */
    public final Lazy args;

    /* renamed from: m, reason: from kotlin metadata */
    public View.OnClickListener positiveClickListener;

    /* renamed from: n, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* compiled from: java-style lambda group */
    /* renamed from: b.a.a.e$a */
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
            if (i != 0) {
                if (i != 1) {
                    throw null;
                }
                ((SimpleConfirmationDialog) this.k).dismiss();
            } else {
                View.OnClickListener onClickListener = ((SimpleConfirmationDialog) this.k).positiveClickListener;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
                ((SimpleConfirmationDialog) this.k).dismiss();
            }
        }
    }

    /* compiled from: ArgUtils.kt */
    /* renamed from: b.a.a.e$b */
    public static final class b extends Lambda implements Function0<SimpleConfirmationDialog2> {
        public final /* synthetic */ String $argsKey;
        public final /* synthetic */ AppDialog $this_args;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(AppDialog appDialog, String str) {
            super(0);
            this.$this_args = appDialog;
            this.$argsKey = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public SimpleConfirmationDialog2 invoke() {
            Bundle arguments = this.$this_args.getArguments();
            Object obj = arguments != null ? arguments.get(this.$argsKey) : null;
            SimpleConfirmationDialog2 simpleConfirmationDialog2 = (SimpleConfirmationDialog2) (obj instanceof SimpleConfirmationDialog2 ? obj : null);
            if (simpleConfirmationDialog2 != null) {
                return simpleConfirmationDialog2;
            }
            StringBuilder sbU = outline.U("Missing args for class type ");
            outline.l0(SimpleConfirmationDialog2.class, sbU, " + key ");
            throw new IllegalStateException(outline.H(sbU, this.$argsKey, '!'));
        }
    }

    /* compiled from: SimpleConfirmationDialog.kt */
    /* renamed from: b.a.a.e$c, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final SimpleConfirmationDialog a(FragmentManager fragmentManager, SimpleConfirmationDialog2 simpleConfirmationDialog2, View.OnClickListener onClickListener) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(simpleConfirmationDialog2, "args");
            Intrinsics3.checkNotNullParameter(onClickListener, "positiveClickListener");
            SimpleConfirmationDialog simpleConfirmationDialog = new SimpleConfirmationDialog();
            simpleConfirmationDialog.setArguments(AnimatableValueParser.e2(simpleConfirmationDialog2));
            simpleConfirmationDialog.positiveClickListener = onClickListener;
            simpleConfirmationDialog.show(fragmentManager, Reflection2.getOrCreateKotlinClass(SimpleConfirmationDialog.class).toString());
            return simpleConfirmationDialog;
        }
    }

    /* compiled from: SimpleConfirmationDialog.kt */
    /* renamed from: b.a.a.e$d */
    public static final /* synthetic */ class d extends FunctionReferenceImpl implements Function1<View, SimpleConfirmationDialogBinding> {
        public static final d j = new d();

        public d() {
            super(1, SimpleConfirmationDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/SimpleConfirmationDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public SimpleConfirmationDialogBinding invoke(View view) {
            View view2 = view;
            Intrinsics3.checkNotNullParameter(view2, "p1");
            int i = R.id.notice_header_container;
            LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.notice_header_container);
            if (linearLayout != null) {
                i = R.id.simple_confirmation_dialog_description;
                TextView textView = (TextView) view2.findViewById(R.id.simple_confirmation_dialog_description);
                if (textView != null) {
                    i = R.id.simple_confirmation_dialog_negative;
                    MaterialButton materialButton = (MaterialButton) view2.findViewById(R.id.simple_confirmation_dialog_negative);
                    if (materialButton != null) {
                        i = R.id.simple_confirmation_dialog_positive;
                        MaterialButton materialButton2 = (MaterialButton) view2.findViewById(R.id.simple_confirmation_dialog_positive);
                        if (materialButton2 != null) {
                            i = R.id.simple_confirmation_dialog_title;
                            TextView textView2 = (TextView) view2.findViewById(R.id.simple_confirmation_dialog_title);
                            if (textView2 != null) {
                                return new SimpleConfirmationDialogBinding((LinearLayout) view2, linearLayout, textView, materialButton, materialButton2, textView2);
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    public SimpleConfirmationDialog() {
        super(R.layout.simple_confirmation_dialog);
        this.args = LazyJVM.lazy(new b(this, "intent_args_key"));
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, d.j, null, 2, null);
    }

    public final SimpleConfirmationDialog2 g() {
        return (SimpleConfirmationDialog2) this.args.getValue();
    }

    public final SimpleConfirmationDialogBinding h() {
        return (SimpleConfirmationDialogBinding) this.binding.getValue((Fragment) this, j[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        requireDialog().setCanceledOnTouchOutside(true);
        h().d.setOnClickListener(new a(0, this));
        h().d.setText(g().l);
        h().c.setOnClickListener(new a(1, this));
        MaterialButton materialButton = h().c;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.simpleConfirmationDialogNegative");
        materialButton.setText(g().m);
        TextView textView = h().e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.simpleConfirmationDialogTitle");
        FormatUtils.a(textView, g().j);
        TextView textView2 = h().f172b;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.simpleConfirmationDialogDescription");
        FormatUtils.a(textView2, g().k);
    }
}
