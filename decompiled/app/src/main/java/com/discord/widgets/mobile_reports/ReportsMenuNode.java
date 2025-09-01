package com.discord.widgets.mobile_reports;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import b.a.i.ViewMobileReportBlockUserBinding;
import b.a.i.ViewMobileReportsChannelPreviewBinding;
import b.a.i.ViewMobileReportsChildBinding;
import b.a.i.ViewMobileReportsMulticheckItemBinding;
import b.a.i.WidgetChatListAdapterItemSingleLineMessagePreviewBinding;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.api.report.NodeResult;
import com.discord.api.report.ReportNode;
import com.discord.api.report.ReportNodeBottomButton;
import com.discord.api.report.ReportNodeChild;
import com.discord.api.report.ReportNodeElementData;
import com.discord.databinding.ViewReportsMenuNodeBinding;
import com.discord.models.user.User;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.guilds.GuildUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.CheckedSetting;
import com.discord.widgets.mobile_reports.MobileReportsViewModel;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ReportsMenuNode.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010B\u001a\u00020A¢\u0006\u0004\bC\u0010DB\u001d\b\u0016\u0012\u0006\u0010B\u001a\u00020A\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010E¢\u0006\u0004\bC\u0010GB'\b\u0016\u0012\u0006\u0010B\u001a\u00020A\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010E\u0012\b\b\u0002\u0010I\u001a\u00020H¢\u0006\u0004\bC\u0010JJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0015\u0010\u0010J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0016\u0010\u0010J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0017\u0010\u0010J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0018\u0010\u0010J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0019\u0010\u0010J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001a\u0010\u0010J\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001b\u0010\u0010J\u0017\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001c\u0010\u0010J\u0017\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001d\u0010\u0010J\u000f\u0010\u001e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010 \u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b \u0010\u0010R\u0018\u0010!\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R0\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R*\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R*\u00101\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010,\u001a\u0004\b2\u0010.\"\u0004\b3\u00100R6\u00105\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0004\u0018\u0001048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0016\u0010<\u001a\u00020;8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R*\u0010>\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010,\u001a\u0004\b?\u0010.\"\u0004\b@\u00100¨\u0006K"}, d2 = {"Lcom/discord/widgets/mobile_reports/ReportsMenuNode;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/discord/api/report/ReportNodeChild;", "destination", "", "childClickListener", "(Lcom/discord/api/report/ReportNodeChild;)V", "Lcom/discord/api/report/ReportNodeBottomButton;", "button", "bottomButtonClickListener", "(Lcom/discord/api/report/ReportNodeBottomButton;)V", "blockUserClickListener", "()V", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$NodeState;", "viewState", "setupBlockUser", "(Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$NodeState;)V", "", "showSuccess", "setupSuccess", "(Z)V", "setupTextElements", "setupChildren", "setupBottomButton", "setupBreadCrumbs", "setupCheckbox", "setupMessagePreview", "setupChannelPreview", "setupEventPreview", "setupDirectoryServerPreview", "getViewState", "()Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$NodeState;", "setup", "prevViewState", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$NodeState;", "Lkotlin/Function1;", "handlePressBottomButton", "Lkotlin/jvm/functions/Function1;", "getHandlePressBottomButton", "()Lkotlin/jvm/functions/Function1;", "setHandlePressBottomButton", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function0;", "handleCancel", "Lkotlin/jvm/functions/Function0;", "getHandleCancel", "()Lkotlin/jvm/functions/Function0;", "setHandleCancel", "(Lkotlin/jvm/functions/Function0;)V", "handleSubmit", "getHandleSubmit", "setHandleSubmit", "Lkotlin/Function2;", "handleSelectChild", "Lkotlin/jvm/functions/Function2;", "getHandleSelectChild", "()Lkotlin/jvm/functions/Function2;", "setHandleSelectChild", "(Lkotlin/jvm/functions/Function2;)V", "Lcom/discord/databinding/ViewReportsMenuNodeBinding;", "binding", "Lcom/discord/databinding/ViewReportsMenuNodeBinding;", "handleBlock", "getHandleBlock", "setHandleBlock", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ReportsMenuNode extends ConstraintLayout {
    private final ViewReportsMenuNodeBinding binding;
    private Function0<Unit> handleBlock;
    private Function0<Unit> handleCancel;
    private Function1<? super ReportNodeBottomButton, Unit> handlePressBottomButton;
    private Function2<? super ReportNodeChild, ? super MobileReportsViewModel.NodeState, Unit> handleSelectChild;
    private Function0<Unit> handleSubmit;
    private MobileReportsViewModel.NodeState prevViewState;

    /* compiled from: ReportsMenuNode.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.mobile_reports.ReportsMenuNode$setupBlockUser$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ReportsMenuNode.access$blockUserClickListener(ReportsMenuNode.this);
        }
    }

    /* compiled from: ReportsMenuNode.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/report/ReportNodeBottomButton;", "p1", "", "invoke", "(Lcom/discord/api/report/ReportNodeBottomButton;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.mobile_reports.ReportsMenuNode$setupBottomButton$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<ReportNodeBottomButton, Unit> {
        public AnonymousClass1(ReportsMenuNode reportsMenuNode) {
            super(1, reportsMenuNode, ReportsMenuNode.class, "bottomButtonClickListener", "bottomButtonClickListener(Lcom/discord/api/report/ReportNodeBottomButton;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ReportNodeBottomButton reportNodeBottomButton) {
            invoke2(reportNodeBottomButton);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ReportNodeBottomButton reportNodeBottomButton) {
            Intrinsics3.checkNotNullParameter(reportNodeBottomButton, "p1");
            ReportsMenuNode.access$bottomButtonClickListener((ReportsMenuNode) this.receiver, reportNodeBottomButton);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReportsMenuNode(Context context) {
        super(context);
        Intrinsics3.checkNotNullParameter(context, "context");
        ViewReportsMenuNodeBinding viewReportsMenuNodeBindingA = ViewReportsMenuNodeBinding.a(LayoutInflater.from(getContext()), this, true);
        Intrinsics3.checkNotNullExpressionValue(viewReportsMenuNodeBindingA, "ViewReportsMenuNodeBindi…rom(context), this, true)");
        this.binding = viewReportsMenuNodeBindingA;
    }

    public static final /* synthetic */ void access$blockUserClickListener(ReportsMenuNode reportsMenuNode) {
        reportsMenuNode.blockUserClickListener();
    }

    public static final /* synthetic */ void access$bottomButtonClickListener(ReportsMenuNode reportsMenuNode, ReportNodeBottomButton reportNodeBottomButton) {
        reportsMenuNode.bottomButtonClickListener(reportNodeBottomButton);
    }

    public static final /* synthetic */ void access$childClickListener(ReportsMenuNode reportsMenuNode, ReportNodeChild reportNodeChild) {
        reportsMenuNode.childClickListener(reportNodeChild);
    }

    private final void blockUserClickListener() {
        Function0<Unit> function0 = this.handleBlock;
        if (function0 != null) {
            function0.invoke();
        }
    }

    private final void bottomButtonClickListener(ReportNodeBottomButton button) {
        Function0<Unit> function0;
        Function2<? super ReportNodeChild, ? super MobileReportsViewModel.NodeState, Unit> function2;
        if ((button instanceof ReportNodeBottomButton.Done) || (button instanceof ReportNodeBottomButton.Cancel)) {
            Function0<Unit> function02 = this.handleCancel;
            if (function02 != null) {
                function02.invoke();
                return;
            }
            return;
        }
        if (!(button instanceof ReportNodeBottomButton.Next)) {
            if (!(button instanceof ReportNodeBottomButton.Submit) || (function0 = this.handleSubmit) == null) {
                return;
            }
            function0.invoke();
            return;
        }
        ReportNodeChild reportNodeChild = new ReportNodeChild("", ((ReportNodeBottomButton.Next) button).getTarget());
        MobileReportsViewModel.NodeState nodeState = this.prevViewState;
        if (nodeState == null || (function2 = this.handleSelectChild) == null) {
            return;
        }
        function2.invoke(reportNodeChild, nodeState);
    }

    private final void childClickListener(ReportNodeChild destination) {
        Function2<? super ReportNodeChild, ? super MobileReportsViewModel.NodeState, Unit> function2;
        MobileReportsViewModel.NodeState nodeState = this.prevViewState;
        if (nodeState == null || (function2 = this.handleSelectChild) == null) {
            return;
        }
        function2.invoke(destination, nodeState);
    }

    private final void setupBlockUser(MobileReportsViewModel.NodeState viewState) {
        Context context;
        int i;
        MobileReportsViewModel.BlockUserElement blockUserElement = viewState.getBlockUserElement();
        ViewMobileReportBlockUserBinding viewMobileReportBlockUserBinding = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(viewMobileReportBlockUserBinding, "binding.mobileReportsNodeBlockUser");
        LinearLayout linearLayout = viewMobileReportBlockUserBinding.a;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.mobileReportsNodeBlockUser.root");
        linearLayout.setVisibility(blockUserElement != null ? 0 : 8);
        if (blockUserElement == null) {
            return;
        }
        User user = blockUserElement.getUser();
        boolean zIsBlocked = blockUserElement.isBlocked();
        TextView textView = this.binding.f.d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.mobileReportsNod…obileReportsBlockUserName");
        textView.setText(UserUtils.INSTANCE.getUserNameWithDiscriminator(user, Integer.valueOf(ColorCompat.getThemedColor(getContext(), R.attr.colorHeaderSecondary)), Float.valueOf(0.8f)));
        SimpleDraweeView simpleDraweeView = this.binding.f.f173b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.mobileReportsNod…ileReportsBlockUserAvatar");
        IconUtils.setIcon$default(simpleDraweeView, user, R.dimen.avatar_size_standard, null, null, null, 56, null);
        this.binding.f.c.setOnClickListener(new AnonymousClass1());
        MaterialButton materialButton = this.binding.f.c;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.mobileReportsNod…ileReportsBlockUserButton");
        ViewExtensions.setEnabledAndAlpha(materialButton, !zIsBlocked, 0.5f);
        MaterialButton materialButton2 = this.binding.f.c;
        Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.mobileReportsNod…ileReportsBlockUserButton");
        if (zIsBlocked) {
            context = getContext();
            i = R.string.blocked;
        } else {
            context = getContext();
            i = R.string.block;
        }
        materialButton2.setText(context.getString(i));
    }

    private final void setupBottomButton(MobileReportsViewModel.NodeState viewState) {
        ReportNodeBottomButton bottomButton = viewState.getBottomButton();
        MobileReportsBottomButton mobileReportsBottomButton = this.binding.g;
        Intrinsics3.checkNotNullExpressionValue(mobileReportsBottomButton, "binding.mobileReportsNodeBottomButton");
        mobileReportsBottomButton.setVisibility(bottomButton != null ? 0 : 8);
        this.binding.g.setup(bottomButton, viewState.getSubmitState(), new AnonymousClass1(this));
    }

    private final void setupBreadCrumbs(MobileReportsViewModel.NodeState viewState) {
        MobileReportsBreadcrumbs mobileReportsBreadcrumbs = this.binding.h;
        Intrinsics3.checkNotNullExpressionValue(mobileReportsBreadcrumbs, "binding.mobileReportsNodeBreadcrumbs");
        mobileReportsBreadcrumbs.setVisibility(viewState.getBreadcrumbsElement() != null ? 0 : 8);
        List<NodeResult> breadcrumbsElement = viewState.getBreadcrumbsElement();
        if (!Intrinsics3.areEqual(breadcrumbsElement, this.prevViewState != null ? r1.getBreadcrumbsElement() : null)) {
            this.binding.h.setup(viewState.getBreadcrumbsElement());
        }
    }

    private final void setupChannelPreview(MobileReportsViewModel.NodeState viewState) {
        MobileReportsViewModel.ChannelPreview channelPreviewElement = viewState.getChannelPreviewElement();
        ViewReportsMenuNodeBinding viewReportsMenuNodeBinding = this.binding;
        ViewMobileReportsChannelPreviewBinding viewMobileReportsChannelPreviewBinding = viewReportsMenuNodeBinding.f2206b;
        if (channelPreviewElement == null) {
            MaterialCardView materialCardView = viewReportsMenuNodeBinding.i;
            Intrinsics3.checkNotNullExpressionValue(materialCardView, "binding.mobileReportsNodeChannelPreview");
            materialCardView.setVisibility(8);
            return;
        }
        TextView textView = viewMobileReportsChannelPreviewBinding.c;
        Intrinsics3.checkNotNullExpressionValue(textView, "kicker");
        textView.setText(channelPreviewElement.getStageInstance().getTopic());
        LinkifiedTextView linkifiedTextView = viewMobileReportsChannelPreviewBinding.d;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        linkifiedTextView.setText(channelPreviewElement.getGuild().getName());
        viewMobileReportsChannelPreviewBinding.f179b.a(IconUtils.getForGuild$default(channelPreviewElement.getGuild(), null, false, null, 14, null), channelPreviewElement.getGuild().getShortName());
        MaterialCardView materialCardView2 = this.binding.i;
        Intrinsics3.checkNotNullExpressionValue(materialCardView2, "binding.mobileReportsNodeChannelPreview");
        materialCardView2.setVisibility(0);
    }

    private final void setupCheckbox(MobileReportsViewModel.NodeState viewState) {
        List<ReportNodeElementData> data;
        MobileReportsViewModel.CheckboxElement checkboxElement = viewState.getCheckboxElement();
        LinearLayout linearLayout = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.mobileReportsMultiselect");
        linearLayout.setVisibility(checkboxElement != null ? 0 : 8);
        MobileReportsViewModel.CheckboxElement checkboxElement2 = viewState.getCheckboxElement();
        if (!Intrinsics3.areEqual(checkboxElement2, this.prevViewState != null ? r1.getCheckboxElement() : null)) {
            this.binding.e.removeAllViewsInLayout();
            if (checkboxElement == null || (data = checkboxElement.getData()) == null) {
                return;
            }
            for (ReportNodeElementData reportNodeElementData : data) {
                LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
                LinearLayout linearLayout2 = this.binding.e;
                View viewInflate = layoutInflaterFrom.inflate(R.layout.view_mobile_reports_multicheck_item, (ViewGroup) linearLayout2, false);
                linearLayout2.addView(viewInflate);
                Objects.requireNonNull(viewInflate, "rootView");
                CheckedSetting checkedSetting = (CheckedSetting) viewInflate;
                Intrinsics3.checkNotNullExpressionValue(new ViewMobileReportsMulticheckItemBinding(checkedSetting), "checkbox");
                checkedSetting.setText(reportNodeElementData.getElementValue());
                Intrinsics3.checkNotNullExpressionValue(checkedSetting, "checkbox.root");
                checkedSetting.setChecked(checkboxElement.getSelections().contains(reportNodeElementData));
                checkedSetting.setOnCheckedListener(new ReportsMenuNode2(reportNodeElementData, this, checkboxElement));
            }
        }
    }

    private final void setupChildren(MobileReportsViewModel.NodeState viewState) {
        ReportNode node;
        MobileReportsViewModel.NodeState nodeState = this.prevViewState;
        if (!Intrinsics3.areEqual((nodeState == null || (node = nodeState.getNode()) == null) ? null : node.b(), viewState.getNode().b())) {
            LinearLayout linearLayout = this.binding.j;
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.mobileReportsNodeChildList");
            Iterator<View> it = androidx.core.view.ViewGroup.getChildren(linearLayout).iterator();
            while (it.hasNext()) {
                it.next().setOnClickListener(null);
            }
            this.binding.j.removeAllViewsInLayout();
            for (ReportNodeChild reportNodeChild : viewState.getNode().b()) {
                LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
                LinearLayout linearLayout2 = this.binding.j;
                View viewInflate = layoutInflaterFrom.inflate(R.layout.view_mobile_reports_child, (ViewGroup) linearLayout2, false);
                linearLayout2.addView(viewInflate);
                int i = R.id.mobile_reports_child;
                CardView cardView = (CardView) viewInflate.findViewById(R.id.mobile_reports_child);
                if (cardView != null) {
                    i = R.id.mobile_reports_child_menu_title;
                    TextView textView = (TextView) viewInflate.findViewById(R.id.mobile_reports_child_menu_title);
                    if (textView != null) {
                        FrameLayout frameLayout = (FrameLayout) viewInflate;
                        Intrinsics3.checkNotNullExpressionValue(new ViewMobileReportsChildBinding(frameLayout, cardView, textView), "childView");
                        frameLayout.setOnClickListener(new ReportsMenuNode3(reportNodeChild, this));
                        Intrinsics3.checkNotNullExpressionValue(textView, "childView.mobileReportsChildMenuTitle");
                        textView.setText(reportNodeChild.getName());
                    }
                }
                throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
            }
        }
    }

    private final void setupDirectoryServerPreview(MobileReportsViewModel.NodeState viewState) {
        MaterialCardView materialCardView = this.binding.k;
        Intrinsics3.checkNotNullExpressionValue(materialCardView, "binding.mobileReportsNodeDirectoryChannelPreview");
        materialCardView.setVisibility(viewState.getDirectoryServerPreviewElement() != null ? 0 : 8);
        TextView textView = this.binding.l;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.mobileReportsNod…ectoryChannelPreviewTitle");
        textView.setVisibility(viewState.getDirectoryServerPreviewElement() != null ? 0 : 8);
        MobileReportsViewModel.DirectoryServerPreview directoryServerPreviewElement = viewState.getDirectoryServerPreviewElement();
        if (directoryServerPreviewElement != null) {
            ViewMobileReportsChannelPreviewBinding viewMobileReportsChannelPreviewBinding = this.binding.c;
            LinkifiedTextView linkifiedTextView = viewMobileReportsChannelPreviewBinding.d;
            Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            linkifiedTextView.setText(directoryServerPreviewElement.getDirectoryEntry().getGuild().getName());
            TextView textView2 = viewMobileReportsChannelPreviewBinding.c;
            Intrinsics3.checkNotNullExpressionValue(textView2, "kicker");
            textView2.setText(directoryServerPreviewElement.getHub().getName());
            viewMobileReportsChannelPreviewBinding.f179b.a(IconUtils.getForGuild$default(Long.valueOf(directoryServerPreviewElement.getDirectoryEntry().getGuild().getId()), directoryServerPreviewElement.getDirectoryEntry().getGuild().getIcon(), null, false, null, 28, null), GuildUtils.computeShortName(directoryServerPreviewElement.getDirectoryEntry().getGuild().getName()));
        }
    }

    private final void setupEventPreview(MobileReportsViewModel.NodeState viewState) {
        MobileReportsViewModel.GuildScheduledEventPreview eventPreviewElement = viewState.getEventPreviewElement();
        ViewReportsMenuNodeBinding viewReportsMenuNodeBinding = this.binding;
        ViewMobileReportsChannelPreviewBinding viewMobileReportsChannelPreviewBinding = viewReportsMenuNodeBinding.f2206b;
        if (eventPreviewElement == null) {
            MaterialCardView materialCardView = viewReportsMenuNodeBinding.i;
            Intrinsics3.checkNotNullExpressionValue(materialCardView, "binding.mobileReportsNodeChannelPreview");
            materialCardView.setVisibility(8);
            return;
        }
        TextView textView = viewMobileReportsChannelPreviewBinding.c;
        Intrinsics3.checkNotNullExpressionValue(textView, "kicker");
        textView.setText(eventPreviewElement.getGuild().getName());
        LinkifiedTextView linkifiedTextView = viewMobileReportsChannelPreviewBinding.d;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        linkifiedTextView.setText(eventPreviewElement.getEvent().getName());
        viewMobileReportsChannelPreviewBinding.f179b.a(IconUtils.getForGuild$default(eventPreviewElement.getGuild(), null, false, null, 14, null), eventPreviewElement.getGuild().getShortName());
        MaterialCardView materialCardView2 = this.binding.i;
        Intrinsics3.checkNotNullExpressionValue(materialCardView2, "binding.mobileReportsNodeChannelPreview");
        materialCardView2.setVisibility(0);
    }

    private final void setupMessagePreview(MobileReportsViewModel.NodeState viewState) {
        MobileReportsViewModel.MessagePreview messagePreviewElement = viewState.getMessagePreviewElement();
        ViewReportsMenuNodeBinding viewReportsMenuNodeBinding = this.binding;
        if (messagePreviewElement == null) {
            WidgetChatListAdapterItemSingleLineMessagePreviewBinding widgetChatListAdapterItemSingleLineMessagePreviewBinding = viewReportsMenuNodeBinding.d;
            Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemSingleLineMessagePreviewBinding, "mobileReportsMessagePreview");
            ConstraintLayout constraintLayout = widgetChatListAdapterItemSingleLineMessagePreviewBinding.a;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout, "mobileReportsMessagePreview.root");
            constraintLayout.setVisibility(8);
            return;
        }
        TextView textView = viewReportsMenuNodeBinding.d.e;
        Intrinsics3.checkNotNullExpressionValue(textView, "mobileReportsMessagePrev…atListAdapterItemTextName");
        textView.setText(messagePreviewElement.getAuthorName());
        viewReportsMenuNodeBinding.d.e.setTextColor(messagePreviewElement.getAuthorNameColor());
        SimpleDraweeView simpleDraweeView = viewReportsMenuNodeBinding.d.d;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "mobileReportsMessagePrev…ListAdapterItemTextAvatar");
        IconUtils.setIcon$default(simpleDraweeView, messagePreviewElement.getAuthor(), R.dimen.avatar_size_small, null, null, null, 56, null);
        viewReportsMenuNodeBinding.d.c.setDraweeSpanStringBuilder(messagePreviewElement.getText());
        ImageView imageView = viewReportsMenuNodeBinding.d.f241b;
        Intrinsics3.checkNotNullExpressionValue(imageView, "mobileReportsMessagePrev…terItemChatAttachmentIcon");
        imageView.setVisibility(messagePreviewElement.getHasEmbeds() ? 0 : 8);
        WidgetChatListAdapterItemSingleLineMessagePreviewBinding widgetChatListAdapterItemSingleLineMessagePreviewBinding2 = viewReportsMenuNodeBinding.d;
        Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemSingleLineMessagePreviewBinding2, "mobileReportsMessagePreview");
        ConstraintLayout constraintLayout2 = widgetChatListAdapterItemSingleLineMessagePreviewBinding2.a;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout2, "mobileReportsMessagePreview.root");
        constraintLayout2.setVisibility(0);
    }

    private final void setupSuccess(boolean showSuccess) {
        ImageView imageView = this.binding.q;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.mobileReportsNodeSuccessShield");
        imageView.setVisibility(showSuccess ? 0 : 8);
    }

    private final void setupTextElements(MobileReportsViewModel.NodeState viewState) {
        TextView textView = this.binding.m;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.mobileReportsNodeHeader");
        textView.setText(FormatUtils.l(viewState.getNode().getHeader(), new Object[0], null, 2));
        String subheader = viewState.getNode().getSubheader();
        LinkifiedTextView linkifiedTextView = this.binding.p;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.mobileReportsNodeSubheader");
        linkifiedTextView.setVisibility(subheader != null ? 0 : 8);
        LinkifiedTextView linkifiedTextView2 = this.binding.p;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView2, "binding.mobileReportsNodeSubheader");
        FormatUtils.o(linkifiedTextView2, subheader, new Object[0], null, 4);
        String info = viewState.getNode().getInfo();
        MaterialCardView materialCardView = this.binding.n;
        Intrinsics3.checkNotNullExpressionValue(materialCardView, "binding.mobileReportsNodeInfoBox");
        materialCardView.setVisibility(info != null ? 0 : 8);
        TextView textView2 = this.binding.o;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.mobileReportsNodeInfoText");
        FormatUtils.o(textView2, info, new Object[0], null, 4);
    }

    public final Function0<Unit> getHandleBlock() {
        return this.handleBlock;
    }

    public final Function0<Unit> getHandleCancel() {
        return this.handleCancel;
    }

    public final Function1<ReportNodeBottomButton, Unit> getHandlePressBottomButton() {
        return this.handlePressBottomButton;
    }

    public final Function2<ReportNodeChild, MobileReportsViewModel.NodeState, Unit> getHandleSelectChild() {
        return this.handleSelectChild;
    }

    public final Function0<Unit> getHandleSubmit() {
        return this.handleSubmit;
    }

    /* renamed from: getViewState, reason: from getter */
    public final MobileReportsViewModel.NodeState getPrevViewState() {
        return this.prevViewState;
    }

    public final void setHandleBlock(Function0<Unit> function0) {
        this.handleBlock = function0;
    }

    public final void setHandleCancel(Function0<Unit> function0) {
        this.handleCancel = function0;
    }

    public final void setHandlePressBottomButton(Function1<? super ReportNodeBottomButton, Unit> function1) {
        this.handlePressBottomButton = function1;
    }

    public final void setHandleSelectChild(Function2<? super ReportNodeChild, ? super MobileReportsViewModel.NodeState, Unit> function2) {
        this.handleSelectChild = function2;
    }

    public final void setHandleSubmit(Function0<Unit> function0) {
        this.handleSubmit = function0;
    }

    public final void setup(MobileReportsViewModel.NodeState viewState) {
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        setupSuccess(viewState.getSuccessElement());
        setupMessagePreview(viewState);
        setupChannelPreview(viewState);
        setupDirectoryServerPreview(viewState);
        setupEventPreview(viewState);
        setupBreadCrumbs(viewState);
        setupTextElements(viewState);
        setupChildren(viewState);
        setupCheckbox(viewState);
        setupBottomButton(viewState);
        setupBlockUser(viewState);
        this.prevViewState = viewState;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReportsMenuNode(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        ViewReportsMenuNodeBinding viewReportsMenuNodeBindingA = ViewReportsMenuNodeBinding.a(LayoutInflater.from(getContext()), this, true);
        Intrinsics3.checkNotNullExpressionValue(viewReportsMenuNodeBindingA, "ViewReportsMenuNodeBindi…rom(context), this, true)");
        this.binding = viewReportsMenuNodeBindingA;
    }

    public /* synthetic */ ReportsMenuNode(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public /* synthetic */ ReportsMenuNode(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReportsMenuNode(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        ViewReportsMenuNodeBinding viewReportsMenuNodeBindingA = ViewReportsMenuNodeBinding.a(LayoutInflater.from(getContext()), this, true);
        Intrinsics3.checkNotNullExpressionValue(viewReportsMenuNodeBindingA, "ViewReportsMenuNodeBindi…rom(context), this, true)");
        this.binding = viewReportsMenuNodeBindingA;
    }
}
