package com.discord.widgets.voice.controls;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppTransitionActivity;
import com.discord.databinding.WidgetScreenShareNfxSheetBinding;
import com.discord.utilities.cache.SharedPreferencesProvider;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.utilities.voice.VoiceEngineServiceController;
import com.discord.widgets.chat.list.TextInVoiceFeatureFlag;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen;
import com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet;
import com.discord.widgets.voice.stream.StreamNavigator;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetScreenShareNfxSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 (2\u00020\u0001:\u0002()B\u0007¢\u0006\u0004\b'\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\n\u001a\u00060\u0005j\u0002`\tH\u0002¢\u0006\u0004\b\n\u0010\bJ\u0011\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 R\u001d\u0010&\u001a\u00020!8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%¨\u0006*"}, d2 = {"Lcom/discord/widgets/voice/controls/WidgetScreenShareNfxSheet;", "Lcom/discord/app/AppBottomSheet;", "", "maybeNavigateToVoiceBottomSheet", "()V", "", "Lcom/discord/primitives/ChannelId;", "getChannelId", "()J", "Lcom/discord/primitives/GuildId;", "getGuildId", "Lcom/discord/widgets/voice/controls/WidgetScreenShareNfxSheet$VoiceBottomSheetParams;", "getVoiceBottomSheetParams", "()Lcom/discord/widgets/voice/controls/WidgetScreenShareNfxSheet$VoiceBottomSheetParams;", "", "getContentViewResId", "()I", "requestCode", "resultCode", "Landroid/content/Intent;", "intent", "onActivityResult", "(IILandroid/content/Intent;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/content/DialogInterface;", "dialog", "onCancel", "(Landroid/content/DialogInterface;)V", "Lcom/discord/databinding/WidgetScreenShareNfxSheetBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetScreenShareNfxSheetBinding;", "binding", "<init>", "Companion", "VoiceBottomSheetParams", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetScreenShareNfxSheet extends AppBottomSheet {
    private static final String ARG_VOICE_BOTTOM_SHEET_PARAMS = "ARG_VOICE_BOTTOM_SHEET_PARAMS";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetScreenShareNfxSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetScreenShareNfxSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetScreenShareNfxSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J9\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\n\u0010\b\u001a\u00060\u0004j\u0002`\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/discord/widgets/voice/controls/WidgetScreenShareNfxSheet$Companion;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "Lcom/discord/primitives/ChannelId;", "channelId", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/widgets/voice/controls/WidgetScreenShareNfxSheet$VoiceBottomSheetParams;", "voiceBottomSheetParams", "", "show", "(Landroidx/fragment/app/FragmentManager;JJLcom/discord/widgets/voice/controls/WidgetScreenShareNfxSheet$VoiceBottomSheetParams;)V", "", "canShow", "()Z", "", WidgetScreenShareNfxSheet.ARG_VOICE_BOTTOM_SHEET_PARAMS, "Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void show$default(Companion companion, FragmentManager fragmentManager, long j, long j2, VoiceBottomSheetParams voiceBottomSheetParams, int i, Object obj) {
            if ((i & 8) != 0) {
                voiceBottomSheetParams = null;
            }
            companion.show(fragmentManager, j, j2, voiceBottomSheetParams);
        }

        public final boolean canShow() {
            return !SharedPreferencesProvider.INSTANCE.get().getBoolean("CACHE_KEY_SCREEN_SHARE_NFX_SHEET_SHOWN", false);
        }

        public final void show(FragmentManager fragmentManager, long channelId, long guildId, VoiceBottomSheetParams voiceBottomSheetParams) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetScreenShareNfxSheet widgetScreenShareNfxSheet = new WidgetScreenShareNfxSheet();
            Bundle bundleT = outline.T("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            bundleT.putLong("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            bundleT.putSerializable(WidgetScreenShareNfxSheet.ARG_VOICE_BOTTOM_SHEET_PARAMS, voiceBottomSheetParams);
            widgetScreenShareNfxSheet.setArguments(bundleT);
            widgetScreenShareNfxSheet.show(fragmentManager, WidgetScreenShareNfxSheet.class.getName());
            SharedPreferences.Editor editorEdit = SharedPreferencesProvider.INSTANCE.get().edit();
            Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
            editorEdit.putBoolean("CACHE_KEY_SCREEN_SHARE_NFX_SHEET_SHOWN", true);
            editorEdit.apply();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetScreenShareNfxSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007¨\u0006\u001c"}, d2 = {"Lcom/discord/widgets/voice/controls/WidgetScreenShareNfxSheet$VoiceBottomSheetParams;", "Ljava/io/Serializable;", "", "component1", "()Z", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheet$FeatureContext;", "component2", "()Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheet$FeatureContext;", "forwardToFullscreenIfVideoActivated", "featureContext", "copy", "(ZLcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheet$FeatureContext;)Lcom/discord/widgets/voice/controls/WidgetScreenShareNfxSheet$VoiceBottomSheetParams;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getForwardToFullscreenIfVideoActivated", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheet$FeatureContext;", "getFeatureContext", "<init>", "(ZLcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheet$FeatureContext;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class VoiceBottomSheetParams implements Serializable {
        private final WidgetVoiceBottomSheet.FeatureContext featureContext;
        private final boolean forwardToFullscreenIfVideoActivated;

        public VoiceBottomSheetParams(boolean z2, WidgetVoiceBottomSheet.FeatureContext featureContext) {
            Intrinsics3.checkNotNullParameter(featureContext, "featureContext");
            this.forwardToFullscreenIfVideoActivated = z2;
            this.featureContext = featureContext;
        }

        public static /* synthetic */ VoiceBottomSheetParams copy$default(VoiceBottomSheetParams voiceBottomSheetParams, boolean z2, WidgetVoiceBottomSheet.FeatureContext featureContext, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = voiceBottomSheetParams.forwardToFullscreenIfVideoActivated;
            }
            if ((i & 2) != 0) {
                featureContext = voiceBottomSheetParams.featureContext;
            }
            return voiceBottomSheetParams.copy(z2, featureContext);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getForwardToFullscreenIfVideoActivated() {
            return this.forwardToFullscreenIfVideoActivated;
        }

        /* renamed from: component2, reason: from getter */
        public final WidgetVoiceBottomSheet.FeatureContext getFeatureContext() {
            return this.featureContext;
        }

        public final VoiceBottomSheetParams copy(boolean forwardToFullscreenIfVideoActivated, WidgetVoiceBottomSheet.FeatureContext featureContext) {
            Intrinsics3.checkNotNullParameter(featureContext, "featureContext");
            return new VoiceBottomSheetParams(forwardToFullscreenIfVideoActivated, featureContext);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VoiceBottomSheetParams)) {
                return false;
            }
            VoiceBottomSheetParams voiceBottomSheetParams = (VoiceBottomSheetParams) other;
            return this.forwardToFullscreenIfVideoActivated == voiceBottomSheetParams.forwardToFullscreenIfVideoActivated && Intrinsics3.areEqual(this.featureContext, voiceBottomSheetParams.featureContext);
        }

        public final WidgetVoiceBottomSheet.FeatureContext getFeatureContext() {
            return this.featureContext;
        }

        public final boolean getForwardToFullscreenIfVideoActivated() {
            return this.forwardToFullscreenIfVideoActivated;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean z2 = this.forwardToFullscreenIfVideoActivated;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            WidgetVoiceBottomSheet.FeatureContext featureContext = this.featureContext;
            return i + (featureContext != null ? featureContext.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("VoiceBottomSheetParams(forwardToFullscreenIfVideoActivated=");
            sbU.append(this.forwardToFullscreenIfVideoActivated);
            sbU.append(", featureContext=");
            sbU.append(this.featureContext);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: WidgetScreenShareNfxSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/content/Intent;", "it", "", "invoke", "(Landroid/content/Intent;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.controls.WidgetScreenShareNfxSheet$onActivityResult$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Intent, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Intent intent) {
            invoke2(intent);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Intent intent) {
            Intrinsics3.checkNotNullParameter(intent, "it");
            VoiceEngineServiceController.INSTANCE.getINSTANCE().startStream(intent);
            if (!WidgetScreenShareNfxSheet.this.requireAppActivity().h(Reflection2.getOrCreateKotlinClass(WidgetCallFullscreen.class))) {
                WidgetCallFullscreen.Companion companion = WidgetCallFullscreen.INSTANCE;
                Context contextRequireContext = WidgetScreenShareNfxSheet.this.requireContext();
                Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                WidgetCallFullscreen.Companion.launch$default(companion, contextRequireContext, WidgetScreenShareNfxSheet.this.requireArguments().getLong("com.discord.intent.extra.EXTRA_CHANNEL_ID"), false, null, null, 28, null);
            }
            WidgetScreenShareNfxSheet.this.dismiss();
        }
    }

    /* compiled from: WidgetScreenShareNfxSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.controls.WidgetScreenShareNfxSheet$onViewCreated$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            StreamNavigator.requestStartStream(WidgetScreenShareNfxSheet.this);
        }
    }

    /* compiled from: WidgetScreenShareNfxSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.controls.WidgetScreenShareNfxSheet$onViewCreated$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetScreenShareNfxSheet.this.dismiss();
            WidgetScreenShareNfxSheet.access$maybeNavigateToVoiceBottomSheet(WidgetScreenShareNfxSheet.this);
        }
    }

    public WidgetScreenShareNfxSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetScreenShareNfxSheet2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$maybeNavigateToVoiceBottomSheet(WidgetScreenShareNfxSheet widgetScreenShareNfxSheet) {
        widgetScreenShareNfxSheet.maybeNavigateToVoiceBottomSheet();
    }

    private final WidgetScreenShareNfxSheetBinding getBinding() {
        return (WidgetScreenShareNfxSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getChannelId() {
        return requireArguments().getLong("com.discord.intent.extra.EXTRA_CHANNEL_ID");
    }

    private final long getGuildId() {
        return requireArguments().getLong("com.discord.intent.extra.EXTRA_GUILD_ID");
    }

    private final VoiceBottomSheetParams getVoiceBottomSheetParams() {
        return (VoiceBottomSheetParams) requireArguments().getSerializable(ARG_VOICE_BOTTOM_SHEET_PARAMS);
    }

    private final void maybeNavigateToVoiceBottomSheet() {
        VoiceBottomSheetParams voiceBottomSheetParams = getVoiceBottomSheetParams();
        if (voiceBottomSheetParams != null) {
            if (TextInVoiceFeatureFlag.INSTANCE.getINSTANCE().isEnabled(Long.valueOf(getGuildId()))) {
                WidgetCallPreviewFullscreen.Companion companion = WidgetCallPreviewFullscreen.INSTANCE;
                Context contextRequireContext = requireContext();
                Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                companion.launch(contextRequireContext, getChannelId(), AppTransitionActivity.Transition.TYPE_SLIDE_VERTICAL_WITH_FADE);
                return;
            }
            WidgetVoiceBottomSheet.Companion companion2 = WidgetVoiceBottomSheet.INSTANCE;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion2.show(parentFragmentManager, getChannelId(), voiceBottomSheetParams.getForwardToFullscreenIfVideoActivated(), voiceBottomSheetParams.getFeatureContext());
        }
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_screen_share_nfx_sheet;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        StreamNavigator.handleActivityResult(requestCode, resultCode, intent, new AnonymousClass1());
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialog) {
        Intrinsics3.checkNotNullParameter(dialog, "dialog");
        super.onCancel(dialog);
        maybeNavigateToVoiceBottomSheet();
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().c.setOnClickListener(new AnonymousClass1());
        getBinding().f2521b.setOnClickListener(new AnonymousClass2());
    }
}
