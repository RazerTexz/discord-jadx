package com.discord.widgets.voice.fullscreen;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetStartCallSheetBinding;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.user.calls.PrivateCallLauncher;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetStartCallSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0016\u001a\u00020\u00118B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetStartCallSheet;", "Lcom/discord/app/AppBottomSheet;", "", "getContentViewResId", "()I", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/discord/widgets/user/calls/PrivateCallLauncher;", "privateCallLauncher", "Lcom/discord/widgets/user/calls/PrivateCallLauncher;", "Lcom/discord/databinding/WidgetStartCallSheetBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetStartCallSheetBinding;", "binding", "<init>", "()V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetStartCallSheet extends AppBottomSheet {
    private static final String ARG_VOICE_CHANNEL_ID = "ARG_VOICE_CHANNEL_ID";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private PrivateCallLauncher privateCallLauncher;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetStartCallSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetStartCallSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetStartCallSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetStartCallSheet$Companion;", "", "", "Lcom/discord/primitives/ChannelId;", "voiceChannelId", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "show", "(JLandroidx/fragment/app/FragmentManager;)V", "", WidgetStartCallSheet.ARG_VOICE_CHANNEL_ID, "Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void show(long voiceChannelId, FragmentManager fragmentManager) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetStartCallSheet widgetStartCallSheet = new WidgetStartCallSheet();
            Bundle bundle = new Bundle();
            bundle.putLong(WidgetStartCallSheet.ARG_VOICE_CHANNEL_ID, voiceChannelId);
            widgetStartCallSheet.setArguments(bundle);
            widgetStartCallSheet.show(fragmentManager, WidgetStartCallSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetStartCallSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetStartCallSheet$onViewCreated$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ long $voiceChannelId;

        public AnonymousClass1(long j) {
            this.$voiceChannelId = j;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetStartCallSheet.access$getPrivateCallLauncher$p(WidgetStartCallSheet.this).launchVoiceCall(this.$voiceChannelId);
            WidgetStartCallSheet.this.dismiss();
        }
    }

    /* compiled from: WidgetStartCallSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetStartCallSheet$onViewCreated$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ long $voiceChannelId;

        public AnonymousClass2(long j) {
            this.$voiceChannelId = j;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetStartCallSheet.access$getPrivateCallLauncher$p(WidgetStartCallSheet.this).launchVideoCall(this.$voiceChannelId);
            WidgetStartCallSheet.this.dismiss();
        }
    }

    public WidgetStartCallSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetStartCallSheet2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ PrivateCallLauncher access$getPrivateCallLauncher$p(WidgetStartCallSheet widgetStartCallSheet) {
        PrivateCallLauncher privateCallLauncher = widgetStartCallSheet.privateCallLauncher;
        if (privateCallLauncher == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("privateCallLauncher");
        }
        return privateCallLauncher;
    }

    public static final /* synthetic */ void access$setPrivateCallLauncher$p(WidgetStartCallSheet widgetStartCallSheet, PrivateCallLauncher privateCallLauncher) {
        widgetStartCallSheet.privateCallLauncher = privateCallLauncher;
    }

    private final WidgetStartCallSheetBinding getBinding() {
        return (WidgetStartCallSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void show(long j, FragmentManager fragmentManager) {
        INSTANCE.show(j, fragmentManager);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_start_call_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context contextRequireContext = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        this.privateCallLauncher = new PrivateCallLauncher(this, this, contextRequireContext, parentFragmentManager);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        long j = getArgumentsOrDefault().getLong(ARG_VOICE_CHANNEL_ID);
        getBinding().c.setOnClickListener(new AnonymousClass1(j));
        getBinding().f2659b.setOnClickListener(new AnonymousClass2(j));
    }
}
