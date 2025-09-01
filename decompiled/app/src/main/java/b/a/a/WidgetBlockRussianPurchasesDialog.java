package b.a.a;

import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.a.d.AppHelpDesk;
import b.a.i.WidgetBlockRussianPurchasesDialogBinding;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetBlockRussianPurchasesDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001d\u0010\f\u001a\u00020\u00078B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lb/a/a/r;", "Lcom/discord/app/AppDialog;", "Landroid/view/View;", "view", "", "onViewBound", "(Landroid/view/View;)V", "Lb/a/i/o4;", "l", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "g", "()Lb/a/i/o4;", "binding", "<init>", "()V", "k", "a", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: b.a.a.r, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetBlockRussianPurchasesDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {outline.d0(WidgetBlockRussianPurchasesDialog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetBlockRussianPurchasesDialogBinding;", 0)};

    /* renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* compiled from: WidgetBlockRussianPurchasesDialog.kt */
    /* renamed from: b.a.a.r$a, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: WidgetBlockRussianPurchasesDialog.kt */
    /* renamed from: b.a.a.r$b */
    public static final /* synthetic */ class b extends FunctionReferenceImpl implements Function1<View, WidgetBlockRussianPurchasesDialogBinding> {
        public static final b j = new b();

        public b() {
            super(1, WidgetBlockRussianPurchasesDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetBlockRussianPurchasesDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public WidgetBlockRussianPurchasesDialogBinding invoke(View view) {
            View view2 = view;
            Intrinsics3.checkNotNullParameter(view2, "p1");
            int i = R.id.notice_body_container;
            LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.notice_body_container);
            if (linearLayout != null) {
                i = R.id.notice_body_text;
                LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view2.findViewById(R.id.notice_body_text);
                if (linkifiedTextView != null) {
                    i = R.id.notice_header;
                    TextView textView = (TextView) view2.findViewById(R.id.notice_header);
                    if (textView != null) {
                        i = R.id.notice_header_container;
                        LinearLayout linearLayout2 = (LinearLayout) view2.findViewById(R.id.notice_header_container);
                        if (linearLayout2 != null) {
                            i = R.id.notice_ok;
                            MaterialButton materialButton = (MaterialButton) view2.findViewById(R.id.notice_ok);
                            if (materialButton != null) {
                                return new WidgetBlockRussianPurchasesDialogBinding((LinearLayout) view2, linearLayout, linkifiedTextView, textView, linearLayout2, materialButton);
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* compiled from: WidgetBlockRussianPurchasesDialog.kt */
    /* renamed from: b.a.a.r$c */
    public static final class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetBlockRussianPurchasesDialog.this.dismiss();
        }
    }

    public WidgetBlockRussianPurchasesDialog() {
        super(R.layout.widget_block_russian_purchases_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, b.j, null, 2, null);
    }

    public final WidgetBlockRussianPurchasesDialogBinding g() {
        return (WidgetBlockRussianPurchasesDialogBinding) this.binding.getValue((Fragment) this, j[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        LinkifiedTextView linkifiedTextView = g().f175b;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.noticeBodyText");
        FormatUtils.n(linkifiedTextView, R.string.region_blocked_payments_cta, new Object[]{AppHelpDesk.a.a(4708041338391L, null)}, null, 4);
        LinkifiedTextView linkifiedTextView2 = g().f175b;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView2, "binding.noticeBodyText");
        linkifiedTextView2.setMovementMethod(LinkMovementMethod.getInstance());
        g().c.setOnClickListener(new c());
    }
}
