package com.discord.widgets.stage.sheet;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.stageinstance.StageInstance;
import com.discord.api.stageinstance.StageInstancePrivacyLevel;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetStageAudienceNoticeBottomSheetBinding;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetStageAudienceNoticeBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u001e\u0010\u0011J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0017\u001a\u00020\u00128B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u001d\u001a\u00020\u00188B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/discord/widgets/stage/sheet/WidgetStageAudienceNoticeBottomSheet;", "Lcom/discord/app/AppBottomSheet;", "Lcom/discord/api/stageinstance/StageInstance;", "stageInstance", "", "configureUI", "(Lcom/discord/api/stageinstance/StageInstance;)V", "", "getContentViewResId", "()I", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "()V", "", "channelId$delegate", "Lkotlin/Lazy;", "getChannelId", "()J", "channelId", "Lcom/discord/databinding/WidgetStageAudienceNoticeBottomSheetBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetStageAudienceNoticeBottomSheetBinding;", "binding", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetStageAudienceNoticeBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetStageAudienceNoticeBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetStageAudienceNoticeBottomSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;

    /* compiled from: WidgetStageAudienceNoticeBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/discord/widgets/stage/sheet/WidgetStageAudienceNoticeBottomSheet$Companion;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "Lcom/discord/primitives/ChannelId;", "channelId", "", "show", "(Landroidx/fragment/app/FragmentManager;J)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, long channelId) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetStageAudienceNoticeManager widgetStageAudienceNoticeManager = WidgetStageAudienceNoticeManager.INSTANCE;
            if (widgetStageAudienceNoticeManager.hasUserSeenAudienceNotice()) {
                return;
            }
            widgetStageAudienceNoticeManager.markUserSeenAudienceNotice();
            WidgetStageAudienceNoticeBottomSheet widgetStageAudienceNoticeBottomSheet = new WidgetStageAudienceNoticeBottomSheet();
            Bundle bundle = new Bundle();
            bundle.putLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            widgetStageAudienceNoticeBottomSheet.setArguments(bundle);
            widgetStageAudienceNoticeBottomSheet.show(fragmentManager, WidgetStageAudienceNoticeBottomSheet.class.getSimpleName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetStageAudienceNoticeBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/stageinstance/StageInstance;", "it", "", "invoke", "(Lcom/discord/api/stageinstance/StageInstance;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stage.sheet.WidgetStageAudienceNoticeBottomSheet$onResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<StageInstance, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StageInstance stageInstance) {
            invoke2(stageInstance);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StageInstance stageInstance) {
            WidgetStageAudienceNoticeBottomSheet.access$configureUI(WidgetStageAudienceNoticeBottomSheet.this, stageInstance);
        }
    }

    /* compiled from: WidgetStageAudienceNoticeBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stage.sheet.WidgetStageAudienceNoticeBottomSheet$onViewCreated$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetStageAudienceNoticeBottomSheet.this.dismiss();
        }
    }

    public WidgetStageAudienceNoticeBottomSheet() {
        super(false, 1, null);
        this.channelId = LazyJVM.lazy(new WidgetStageAudienceNoticeBottomSheet3(this));
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetStageAudienceNoticeBottomSheet2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetStageAudienceNoticeBottomSheet widgetStageAudienceNoticeBottomSheet, StageInstance stageInstance) {
        widgetStageAudienceNoticeBottomSheet.configureUI(stageInstance);
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetStageAudienceNoticeBottomSheet widgetStageAudienceNoticeBottomSheet) {
        return widgetStageAudienceNoticeBottomSheet.getArgumentsOrDefault();
    }

    private final void configureUI(StageInstance stageInstance) {
        boolean z2 = (stageInstance != null ? stageInstance.getPrivacyLevel() : null) == StageInstancePrivacyLevel.PUBLIC;
        ImageView imageView = getBinding().f2648b;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.bullet4Icon");
        imageView.setVisibility(z2 ? 0 : 8);
        TextView textView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.bullet4Label");
        textView.setVisibility(z2 ? 0 : 8);
    }

    private final WidgetStageAudienceNoticeBottomSheetBinding getBinding() {
        return (WidgetStageAudienceNoticeBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getChannelId() {
        return ((Number) this.channelId.getValue()).longValue();
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_stage_audience_notice_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(StoreStream.INSTANCE.getStageInstances().observeStageInstanceForChannel(getChannelId()), this, null, 2, null), WidgetStageAudienceNoticeBottomSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        WidgetStageAudienceNoticeBottomSheetBinding binding = getBinding();
        Intrinsics3.checkNotNullExpressionValue(binding, "binding");
        setPeekHeightBottomView(binding.a);
        getBinding().d.setOnClickListener(new AnonymousClass1());
    }
}
