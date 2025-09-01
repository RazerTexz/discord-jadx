package b.a.a.g;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.a.i.WidgetMaskedLinksDialogBinding;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.string.StringUtils2;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetMaskedLinksDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0015\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eR\u001d\u0010\u0014\u001a\u00020\u000f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lb/a/a/g/a;", "Lcom/discord/app/AppDialog;", "Landroid/view/View;", "view", "", "onViewBound", "(Landroid/view/View;)V", "onDestroy", "()V", "Landroid/content/Context;", "context", "", "url", "h", "(Landroid/content/Context;Ljava/lang/String;)V", "Lb/a/i/q5;", "l", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "g", "()Lb/a/i/q5;", "binding", "<init>", "k", "b", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: b.a.a.g.a, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetMaskedLinksDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {outline.d0(WidgetMaskedLinksDialog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetMaskedLinksDialogBinding;", 0)};

    /* renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* compiled from: java-style lambda group */
    /* renamed from: b.a.a.g.a$a */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int j;
        public final /* synthetic */ Object k;
        public final /* synthetic */ Object l;

        public a(int i, Object obj, Object obj2) {
            this.j = i;
            this.k = obj;
            this.l = obj2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.j;
            if (i == 0) {
                WidgetMaskedLinksDialog widgetMaskedLinksDialog = (WidgetMaskedLinksDialog) this.k;
                Intrinsics3.checkNotNullExpressionValue(view, "v");
                Context context = view.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "v.context");
                String str = (String) this.l;
                KProperty[] kPropertyArr = WidgetMaskedLinksDialog.j;
                widgetMaskedLinksDialog.h(context, str);
                return;
            }
            if (i != 1) {
                throw null;
            }
            WidgetMaskedLinksDialog widgetMaskedLinksDialog2 = (WidgetMaskedLinksDialog) this.k;
            Intrinsics3.checkNotNullExpressionValue(view, "v");
            Context context2 = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context2, "v.context");
            String str2 = (String) this.l;
            KProperty[] kPropertyArr2 = WidgetMaskedLinksDialog.j;
            Objects.requireNonNull(widgetMaskedLinksDialog2);
            StoreStream.INSTANCE.getMaskedLinks().trustDomain(str2);
            widgetMaskedLinksDialog2.h(context2, str2);
        }
    }

    /* compiled from: WidgetMaskedLinksDialog.kt */
    /* renamed from: b.a.a.g.a$b, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: WidgetMaskedLinksDialog.kt */
    /* renamed from: b.a.a.g.a$c */
    public static final /* synthetic */ class c extends FunctionReferenceImpl implements Function1<View, WidgetMaskedLinksDialogBinding> {
        public static final c j = new c();

        public c() {
            super(1, WidgetMaskedLinksDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetMaskedLinksDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public WidgetMaskedLinksDialogBinding invoke(View view) {
            View view2 = view;
            Intrinsics3.checkNotNullParameter(view2, "p1");
            int i = R.id.masked_links_body_text;
            TextView textView = (TextView) view2.findViewById(R.id.masked_links_body_text);
            if (textView != null) {
                i = R.id.masked_links_cancel;
                MaterialButton materialButton = (MaterialButton) view2.findViewById(R.id.masked_links_cancel);
                if (materialButton != null) {
                    i = R.id.masked_links_confirm;
                    MaterialButton materialButton2 = (MaterialButton) view2.findViewById(R.id.masked_links_confirm);
                    if (materialButton2 != null) {
                        i = R.id.masked_links_trust_domain;
                        TextView textView2 = (TextView) view2.findViewById(R.id.masked_links_trust_domain);
                        if (textView2 != null) {
                            i = R.id.view_dialog_confirmation_header;
                            TextView textView3 = (TextView) view2.findViewById(R.id.view_dialog_confirmation_header);
                            if (textView3 != null) {
                                return new WidgetMaskedLinksDialogBinding((LinearLayout) view2, textView, materialButton, materialButton2, textView2, textView3);
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* compiled from: WidgetMaskedLinksDialog.kt */
    /* renamed from: b.a.a.g.a$d */
    public static final class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetMaskedLinksDialog.this.dismiss();
        }
    }

    public WidgetMaskedLinksDialog() {
        super(R.layout.widget_masked_links_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, c.j, null, 2, null);
    }

    public final WidgetMaskedLinksDialogBinding g() {
        return (WidgetMaskedLinksDialogBinding) this.binding.getValue((Fragment) this, j[0]);
    }

    public final void h(Context context, String url) {
        UriHandler.handle$default(UriHandler.INSTANCE, context, url, false, false, null, 28, null);
        dismiss();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        StoreNotices notices = StoreStream.INSTANCE.getNotices();
        Objects.requireNonNull(INSTANCE);
        StoreNotices.markSeen$default(notices, "WIDGET_SPOOPY_LINKS_DIALOG", 0L, 2, null);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        String string;
        Object punyCodeASCIIUrl;
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString("WIDGET_SPOOPY_LINKS_DIALOG_URL")) == null) {
            string = "";
        }
        Intrinsics3.checkNotNullExpressionValue(string, "arguments?.getString(DIALOG_URL) ?: \"\"");
        try {
            punyCodeASCIIUrl = StringUtils2.toPunyCodeASCIIUrl(string);
        } catch (Exception unused) {
            dismiss();
            punyCodeASCIIUrl = Unit.a;
        }
        TextView textView = g().f188b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.maskedLinksBodyText");
        FormatUtils.n(textView, R.string.masked_link_body, new Object[]{punyCodeASCIIUrl}, null, 4);
        g().c.setOnClickListener(new d());
        g().d.setOnClickListener(new a(0, this, string));
        g().e.setOnClickListener(new a(1, this, string));
    }
}
