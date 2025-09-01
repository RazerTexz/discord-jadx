package com.discord.widgets.settings.premium;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.t.b.b.SimpleMarkdownRules5;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetOutboundPromoTermsBinding;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.Parser;
import com.discord.utilities.textprocessing.AstRenderer;
import com.discord.utilities.textprocessing.MessageParseState;
import com.discord.utilities.textprocessing.Rules;
import com.discord.utilities.textprocessing.node.UrlNode;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetOutboundPromoTerms.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001d\u0010\u0011\u001a\u00020\f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R.\u0010\u0016\u001a\u001a\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0014\u0012\u0004\u0012\u00020\u00150\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00138B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/discord/widgets/settings/premium/WidgetOutboundPromoTerms;", "Lcom/discord/app/AppBottomSheet;", "", "getContentViewResId", "()I", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/discord/databinding/WidgetOutboundPromoTermsBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetOutboundPromoTermsBinding;", "binding", "Lcom/discord/simpleast/core/parser/Parser;", "Lcom/discord/utilities/textprocessing/node/UrlNode$RenderContext;", "Lcom/discord/simpleast/core/node/Node;", "Lcom/discord/utilities/textprocessing/MessageParseState;", "parser", "Lcom/discord/simpleast/core/parser/Parser;", "getRenderContext", "()Lcom/discord/utilities/textprocessing/node/UrlNode$RenderContext;", "renderContext", "<init>", "()V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetOutboundPromoTerms extends AppBottomSheet {
    private static final String ARG_CONTENT = "ARG_CONTENT";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final Parser<UrlNode.RenderContext, Node<UrlNode.RenderContext>, MessageParseState> parser;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetOutboundPromoTerms.class, "binding", "getBinding()Lcom/discord/databinding/WidgetOutboundPromoTermsBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetOutboundPromoTerms.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/discord/widgets/settings/premium/WidgetOutboundPromoTerms$Companion;", "", "", "content", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "show", "(Ljava/lang/String;Landroidx/fragment/app/FragmentManager;)V", WidgetOutboundPromoTerms.ARG_CONTENT, "Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void show(String content, FragmentManager fragmentManager) {
            Intrinsics3.checkNotNullParameter(content, "content");
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetOutboundPromoTerms widgetOutboundPromoTerms = new WidgetOutboundPromoTerms();
            Bundle bundle = new Bundle();
            bundle.putString(WidgetOutboundPromoTerms.ARG_CONTENT, content);
            widgetOutboundPromoTerms.setArguments(bundle);
            widgetOutboundPromoTerms.show(fragmentManager, WidgetOutboundPromoTerms.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetOutboundPromoTerms.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.WidgetOutboundPromoTerms$onViewCreated$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetOutboundPromoTerms.this.dismiss();
        }
    }

    public WidgetOutboundPromoTerms() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetOutboundPromoTerms2.INSTANCE, null, 2, null);
        Parser parser = new Parser(false, 1, null);
        Rules rules = Rules.INSTANCE;
        this.parser = parser.addRule(rules.createMaskedLinkRule()).addRule(rules.createUrlRule()).addRules(SimpleMarkdownRules5.b(false, false, 3));
    }

    private final WidgetOutboundPromoTermsBinding getBinding() {
        return (WidgetOutboundPromoTermsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final UrlNode.RenderContext getRenderContext() {
        return new WidgetOutboundPromoTerms3(this);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_outbound_promo_terms;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().f2507b.setOnClickListener(new AnonymousClass1());
        String string = getArgumentsOrDefault().getString(ARG_CONTENT, "");
        Parser<UrlNode.RenderContext, Node<UrlNode.RenderContext>, MessageParseState> parser = this.parser;
        Intrinsics3.checkNotNullExpressionValue(string, "content");
        getBinding().c.setDraweeSpanStringBuilder(AstRenderer.render(Parser.parse$default(parser, string, MessageParseState.INSTANCE.getInitialState(), null, 4, null), getRenderContext()));
    }
}
