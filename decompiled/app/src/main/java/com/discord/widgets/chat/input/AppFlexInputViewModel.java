package com.discord.widgets.chat.input;

import android.content.Context;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.FragmentActivity;
import b.a.d.AppViewModel;
import b.b.a.h.FlexInputEvent;
import b.d.b.a.outline;
import b.i.a.f.e.o.f;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.api.sticker.Sticker;
import com.discord.app.AppPermissions2;
import com.discord.panels.PanelState;
import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreExpressionSuggestions;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStickers;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.ChatInputComponentTypes;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stickers.StickerUtils;
import com.discord.widgets.home.WidgetHome;
import com.discord.widgets.settings.premium.WidgetSettingsGifting;
import com.lytefast.flexinput.FlexInputListener;
import com.lytefast.flexinput.FlexInputListener2;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.viewmodel.FlexInputState;
import com.lytefast.flexinput.viewmodel.FlexInputViewModel;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t.Sets5;
import d0.t._Collections;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import d0.z.d.TypeIntrinsics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: AppFlexInputViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 w2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002wxBG\u0012\u0006\u0010^\u001a\u00020]\u0012\b\b\u0002\u0010s\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010t\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b\u0012\b\b\u0002\u0010j\u001a\u00020i\u0012\b\b\u0002\u0010X\u001a\u00020W\u0012\b\b\u0002\u0010[\u001a\u00020Z¢\u0006\u0004\bu\u0010vJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH\u0017¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bH\u0017¢\u0006\u0004\b\u000f\u0010\rJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0017¢\u0006\u0004\b\u0010\u0010\nJ\u000f\u0010\u0011\u001a\u00020\u0006H\u0017¢\u0006\u0004\b\u0011\u0010\nJ\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0017¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0006H\u0017¢\u0006\u0004\b\u0016\u0010\nJ\u000f\u0010\u0017\u001a\u00020\u0006H\u0017¢\u0006\u0004\b\u0017\u0010\nJ!\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0017¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0018H\u0017¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u001aH\u0017¢\u0006\u0004\b!\u0010\"J\u0019\u0010%\u001a\u00020\u00062\b\u0010$\u001a\u0004\u0018\u00010#H\u0017¢\u0006\u0004\b%\u0010&J\u0019\u0010(\u001a\u00020\u00062\b\b\u0002\u0010'\u001a\u00020\u001aH\u0007¢\u0006\u0004\b(\u0010)J\u0017\u0010,\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020*H\u0017¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u001aH\u0017¢\u0006\u0004\b.\u0010)J#\u00103\u001a\u00020\u00062\u0012\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u000201000/H\u0017¢\u0006\u0004\b3\u00104J\u001d\u00106\u001a\u00020\u00062\f\u00105\u001a\b\u0012\u0004\u0012\u00020100H\u0016¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020\u0006H\u0017¢\u0006\u0004\b8\u0010\nJ\u000f\u00109\u001a\u00020\u001aH\u0017¢\u0006\u0004\b9\u0010\"J\u000f\u0010:\u001a\u00020\u001aH\u0017¢\u0006\u0004\b:\u0010\"J\u000f\u0010;\u001a\u00020\u0006H\u0017¢\u0006\u0004\b;\u0010\nJ\u0017\u0010=\u001a\u00020\u00062\u0006\u0010<\u001a\u00020\u001aH\u0016¢\u0006\u0004\b=\u0010)J\u000f\u0010>\u001a\u00020\u0006H\u0016¢\u0006\u0004\b>\u0010\nJ\u001d\u0010A\u001a\u00020\u00062\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00060?H\u0016¢\u0006\u0004\bA\u0010BJ\u000f\u0010C\u001a\u00020\u001aH\u0016¢\u0006\u0004\bC\u0010\"J\u0017\u0010F\u001a\u00020\u00062\u0006\u0010E\u001a\u00020DH\u0016¢\u0006\u0004\bF\u0010GJ\u001b\u0010H\u001a\u00020\u00062\n\u00105\u001a\u0006\u0012\u0002\b\u000300H\u0016¢\u0006\u0004\bH\u00107J\u0017\u0010J\u001a\u00020\u00062\u0006\u0010I\u001a\u00020\u001aH\u0016¢\u0006\u0004\bJ\u0010)J\u000f\u0010K\u001a\u00020\u001aH\u0016¢\u0006\u0004\bK\u0010\"J\u000f\u0010L\u001a\u00020\u001aH\u0016¢\u0006\u0004\bL\u0010\"J\u0017\u0010N\u001a\u00020\u00062\u0006\u0010M\u001a\u00020\u001aH\u0016¢\u0006\u0004\bN\u0010)J\u0017\u0010P\u001a\u00020\u00062\u0006\u0010O\u001a\u00020\u001aH\u0007¢\u0006\u0004\bP\u0010)J\r\u0010Q\u001a\u00020\u0006¢\u0006\u0004\bQ\u0010\nJ\u001b\u0010S\u001a\b\u0012\u0004\u0012\u00020R0/2\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\bS\u0010TJ\r\u0010U\u001a\u00020\u0006¢\u0006\u0004\bU\u0010\nJ\r\u0010V\u001a\u00020\u0006¢\u0006\u0004\bV\u0010\nR\u0016\u0010X\u001a\u00020W8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010[\u001a\u00020Z8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010^\u001a\u00020]8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b^\u0010_R$\u0010`\u001a\u0004\u0018\u00010D8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010GR\"\u0010e\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\be\u0010f\u001a\u0004\bg\u0010\"\"\u0004\bh\u0010)R\u0016\u0010j\u001a\u00020i8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bj\u0010kR:\u0010n\u001a&\u0012\f\u0012\n m*\u0004\u0018\u00010\u000e0\u000e m*\u0012\u0012\f\u0012\n m*\u0004\u0018\u00010\u000e0\u000e\u0018\u00010l0l8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010oR\"\u0010p\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bp\u0010f\u001a\u0004\bq\u0010\"\"\u0004\br\u0010)¨\u0006y"}, d2 = {"Lcom/discord/widgets/chat/input/AppFlexInputViewModel;", "Lb/a/d/d0;", "Lcom/lytefast/flexinput/viewmodel/FlexInputState;", "Lcom/lytefast/flexinput/viewmodel/FlexInputViewModel;", "Lcom/discord/widgets/chat/input/AppFlexInputViewModel$StoreState;", "storeState", "", "handleStoreState", "(Lcom/discord/widgets/chat/input/AppFlexInputViewModel$StoreState;)V", "showKeyboard", "()V", "Lrx/Observable;", "observeState", "()Lrx/Observable;", "Lb/b/a/h/a;", "observeEvents", "onGiftButtonClicked", "onGalleryButtonClicked", "", "index", "onContentDialogPageChanged", "(I)V", "onExpandButtonClicked", "onExpressionTrayButtonClicked", "", "inputText", "", "focused", "onInputTextChanged", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "appendText", "onInputTextAppended", "(Ljava/lang/String;)V", "onInputTextClicked", "()Z", "Lcom/lytefast/flexinput/FlexInputListener;", "inputListener", "onSendButtonClicked", "(Lcom/lytefast/flexinput/FlexInputListener;)V", "clearText", "clean", "(Z)V", "Landroid/view/View;", "button", "onToolTipButtonLongPressed", "(Landroid/view/View;)Z", "onContentDialogDismissed", "", "Lcom/lytefast/flexinput/model/Attachment;", "", "attachments", "onAttachmentsUpdated", "(Ljava/util/List;)V", "attachment", "onSingleAttachmentSelected", "(Lcom/lytefast/flexinput/model/Attachment;)V", "onFlexInputFragmentPause", "hideExpressionTray", "showExpressionTray", "onShowDialog", "showBadge", "setShowExpressionTrayButtonBadge", "onCreateThreadSelected", "Lkotlin/Function0;", "onSuccess", "requestMediaPermissions", "(Lkotlin/jvm/functions/Function0;)V", "hasMediaPermissions", "Lcom/lytefast/flexinput/FlexInputAttachmentListener;", "attachmentListener", "setAttachmentSelectedListener", "(Lcom/lytefast/flexinput/FlexInputAttachmentListener;)V", "removeAttachment", "enabled", "setAttachmentViewEnabled", "isAttachmentViewEnabled", "isSingleSelectMode", "singleSelect", "setModeSingleSelect", "shouldClearInput", "onStickerSuggestionSent", "showKeyboardAndHideExpressionTray", "Lcom/discord/api/sticker/Sticker;", "getMatchingStickers", "(Ljava/lang/String;)Ljava/util/List;", "hideKeyboard", "focus", "Lcom/discord/stores/StoreAnalytics;", "storeAnalytics", "Lcom/discord/stores/StoreAnalytics;", "Lcom/discord/stores/StoreExpressionSuggestions;", "storeExpressionSuggestions", "Lcom/discord/stores/StoreExpressionSuggestions;", "Lcom/discord/app/AppPermissionsRequests;", "permissionRequests", "Lcom/discord/app/AppPermissionsRequests;", "singleAttachmentSelectedListener", "Lcom/lytefast/flexinput/FlexInputAttachmentListener;", "getSingleAttachmentSelectedListener", "()Lcom/lytefast/flexinput/FlexInputAttachmentListener;", "setSingleAttachmentSelectedListener", "attachmentView", "Z", "getAttachmentView", "setAttachmentView", "Lcom/discord/stores/StoreStickers;", "storeStickers", "Lcom/discord/stores/StoreStickers;", "Lrx/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "eventSubject", "Lrx/subjects/PublishSubject;", "singleSelectMode", "getSingleSelectMode", "setSingleSelectMode", "initialViewState", "storeObservable", "<init>", "(Lcom/discord/app/AppPermissionsRequests;Lcom/lytefast/flexinput/viewmodel/FlexInputState;Lrx/Observable;Lcom/discord/stores/StoreStickers;Lcom/discord/stores/StoreAnalytics;Lcom/discord/stores/StoreExpressionSuggestions;)V", "Companion", "StoreState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class AppFlexInputViewModel extends AppViewModel<FlexInputState> implements FlexInputViewModel {
    private static final String CHAT_GIFTING_NOTICE = "CHAT_GIFTING_NOTICE";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private boolean attachmentView;
    private PublishSubject<FlexInputEvent> eventSubject;
    private final AppPermissions2 permissionRequests;
    private FlexInputListener2 singleAttachmentSelectedListener;
    private boolean singleSelectMode;
    private final StoreAnalytics storeAnalytics;
    private final StoreExpressionSuggestions storeExpressionSuggestions;
    private final StoreStickers storeStickers;

    /* compiled from: AppFlexInputViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/chat/input/AppFlexInputViewModel$StoreState;", "p1", "", "invoke", "(Lcom/discord/widgets/chat/input/AppFlexInputViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.AppFlexInputViewModel$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<StoreState, Unit> {
        public AnonymousClass1(AppFlexInputViewModel appFlexInputViewModel) {
            super(1, appFlexInputViewModel, AppFlexInputViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/chat/input/AppFlexInputViewModel$StoreState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "p1");
            AppFlexInputViewModel.access$handleStoreState((AppFlexInputViewModel) this.receiver, storeState);
        }
    }

    /* compiled from: AppFlexInputViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/discord/widgets/chat/input/AppFlexInputViewModel$Companion;", "", "Lrx/Observable;", "Lcom/discord/widgets/chat/input/AppFlexInputViewModel$StoreState;", "observeStores", "()Lrx/Observable;", "", AppFlexInputViewModel.CHAT_GIFTING_NOTICE, "Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStores(Companion companion) {
            return companion.observeStores();
        }

        private final Observable<StoreState> observeStores() {
            Observable observableY = StoreStream.INSTANCE.getChannelsSelected().observeResolvedSelectedChannel().Y(AppFlexInputViewModel2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableY, "StoreStream\n          .g…            }\n          }");
            return observableY;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: AppFlexInputViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\u0017\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u0019\u001a\u00020\u0010\u0012\u0006\u0010\u001a\u001a\u00020\u0010¢\u0006\u0004\b1\u00102J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0012Jb\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0017\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0019\u001a\u00020\u00102\b\b\u0002\u0010\u001a\u001a\u00020\u0010HÆ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010!\u001a\u00020 HÖ\u0001¢\u0006\u0004\b!\u0010\"J\u001a\u0010$\u001a\u00020\u00102\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b$\u0010%R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010&\u001a\u0004\b'\u0010\bR\u0019\u0010\u0019\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010(\u001a\u0004\b)\u0010\u0012R\u0019\u0010\u0014\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010*\u001a\u0004\b+\u0010\u0004R\u0019\u0010\u001a\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010(\u001a\u0004\b\u001a\u0010\u0012R!\u0010\u0017\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010,\u001a\u0004\b-\u0010\fR\u001b\u0010\u0018\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010.\u001a\u0004\b/\u0010\u000fR\u0019\u0010\u0015\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010*\u001a\u0004\b0\u0010\u0004¨\u00063"}, d2 = {"Lcom/discord/widgets/chat/input/AppFlexInputViewModel$StoreState;", "", "Lcom/discord/panels/PanelState;", "component1", "()Lcom/discord/panels/PanelState;", "component2", "Lcom/discord/api/channel/Channel;", "component3", "()Lcom/discord/api/channel/Channel;", "", "Lcom/discord/api/permission/PermissionBit;", "component4", "()Ljava/lang/Long;", "Lcom/discord/stores/StoreNotices$Notice;", "component5", "()Lcom/discord/stores/StoreNotices$Notice;", "", "component6", "()Z", "component7", "leftPanelState", "rightPanelState", "selectedChannel", "channelPermission", "notice", "stickerSuggestionsEnabled", "isThreadCreation", "copy", "(Lcom/discord/panels/PanelState;Lcom/discord/panels/PanelState;Lcom/discord/api/channel/Channel;Ljava/lang/Long;Lcom/discord/stores/StoreNotices$Notice;ZZ)Lcom/discord/widgets/chat/input/AppFlexInputViewModel$StoreState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/channel/Channel;", "getSelectedChannel", "Z", "getStickerSuggestionsEnabled", "Lcom/discord/panels/PanelState;", "getLeftPanelState", "Ljava/lang/Long;", "getChannelPermission", "Lcom/discord/stores/StoreNotices$Notice;", "getNotice", "getRightPanelState", "<init>", "(Lcom/discord/panels/PanelState;Lcom/discord/panels/PanelState;Lcom/discord/api/channel/Channel;Ljava/lang/Long;Lcom/discord/stores/StoreNotices$Notice;ZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final Long channelPermission;
        private final boolean isThreadCreation;
        private final PanelState leftPanelState;
        private final StoreNotices.Notice notice;
        private final PanelState rightPanelState;
        private final Channel selectedChannel;
        private final boolean stickerSuggestionsEnabled;

        public StoreState(PanelState panelState, PanelState panelState2, Channel channel, Long l, StoreNotices.Notice notice, boolean z2, boolean z3) {
            Intrinsics3.checkNotNullParameter(panelState, "leftPanelState");
            Intrinsics3.checkNotNullParameter(panelState2, "rightPanelState");
            this.leftPanelState = panelState;
            this.rightPanelState = panelState2;
            this.selectedChannel = channel;
            this.channelPermission = l;
            this.notice = notice;
            this.stickerSuggestionsEnabled = z2;
            this.isThreadCreation = z3;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, PanelState panelState, PanelState panelState2, Channel channel, Long l, StoreNotices.Notice notice, boolean z2, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                panelState = storeState.leftPanelState;
            }
            if ((i & 2) != 0) {
                panelState2 = storeState.rightPanelState;
            }
            PanelState panelState3 = panelState2;
            if ((i & 4) != 0) {
                channel = storeState.selectedChannel;
            }
            Channel channel2 = channel;
            if ((i & 8) != 0) {
                l = storeState.channelPermission;
            }
            Long l2 = l;
            if ((i & 16) != 0) {
                notice = storeState.notice;
            }
            StoreNotices.Notice notice2 = notice;
            if ((i & 32) != 0) {
                z2 = storeState.stickerSuggestionsEnabled;
            }
            boolean z4 = z2;
            if ((i & 64) != 0) {
                z3 = storeState.isThreadCreation;
            }
            return storeState.copy(panelState, panelState3, channel2, l2, notice2, z4, z3);
        }

        /* renamed from: component1, reason: from getter */
        public final PanelState getLeftPanelState() {
            return this.leftPanelState;
        }

        /* renamed from: component2, reason: from getter */
        public final PanelState getRightPanelState() {
            return this.rightPanelState;
        }

        /* renamed from: component3, reason: from getter */
        public final Channel getSelectedChannel() {
            return this.selectedChannel;
        }

        /* renamed from: component4, reason: from getter */
        public final Long getChannelPermission() {
            return this.channelPermission;
        }

        /* renamed from: component5, reason: from getter */
        public final StoreNotices.Notice getNotice() {
            return this.notice;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getStickerSuggestionsEnabled() {
            return this.stickerSuggestionsEnabled;
        }

        /* renamed from: component7, reason: from getter */
        public final boolean getIsThreadCreation() {
            return this.isThreadCreation;
        }

        public final StoreState copy(PanelState leftPanelState, PanelState rightPanelState, Channel selectedChannel, Long channelPermission, StoreNotices.Notice notice, boolean stickerSuggestionsEnabled, boolean isThreadCreation) {
            Intrinsics3.checkNotNullParameter(leftPanelState, "leftPanelState");
            Intrinsics3.checkNotNullParameter(rightPanelState, "rightPanelState");
            return new StoreState(leftPanelState, rightPanelState, selectedChannel, channelPermission, notice, stickerSuggestionsEnabled, isThreadCreation);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.leftPanelState, storeState.leftPanelState) && Intrinsics3.areEqual(this.rightPanelState, storeState.rightPanelState) && Intrinsics3.areEqual(this.selectedChannel, storeState.selectedChannel) && Intrinsics3.areEqual(this.channelPermission, storeState.channelPermission) && Intrinsics3.areEqual(this.notice, storeState.notice) && this.stickerSuggestionsEnabled == storeState.stickerSuggestionsEnabled && this.isThreadCreation == storeState.isThreadCreation;
        }

        public final Long getChannelPermission() {
            return this.channelPermission;
        }

        public final PanelState getLeftPanelState() {
            return this.leftPanelState;
        }

        public final StoreNotices.Notice getNotice() {
            return this.notice;
        }

        public final PanelState getRightPanelState() {
            return this.rightPanelState;
        }

        public final Channel getSelectedChannel() {
            return this.selectedChannel;
        }

        public final boolean getStickerSuggestionsEnabled() {
            return this.stickerSuggestionsEnabled;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            PanelState panelState = this.leftPanelState;
            int iHashCode = (panelState != null ? panelState.hashCode() : 0) * 31;
            PanelState panelState2 = this.rightPanelState;
            int iHashCode2 = (iHashCode + (panelState2 != null ? panelState2.hashCode() : 0)) * 31;
            Channel channel = this.selectedChannel;
            int iHashCode3 = (iHashCode2 + (channel != null ? channel.hashCode() : 0)) * 31;
            Long l = this.channelPermission;
            int iHashCode4 = (iHashCode3 + (l != null ? l.hashCode() : 0)) * 31;
            StoreNotices.Notice notice = this.notice;
            int iHashCode5 = (iHashCode4 + (notice != null ? notice.hashCode() : 0)) * 31;
            boolean z2 = this.stickerSuggestionsEnabled;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode5 + i) * 31;
            boolean z3 = this.isThreadCreation;
            return i2 + (z3 ? 1 : z3 ? 1 : 0);
        }

        public final boolean isThreadCreation() {
            return this.isThreadCreation;
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(leftPanelState=");
            sbU.append(this.leftPanelState);
            sbU.append(", rightPanelState=");
            sbU.append(this.rightPanelState);
            sbU.append(", selectedChannel=");
            sbU.append(this.selectedChannel);
            sbU.append(", channelPermission=");
            sbU.append(this.channelPermission);
            sbU.append(", notice=");
            sbU.append(this.notice);
            sbU.append(", stickerSuggestionsEnabled=");
            sbU.append(this.stickerSuggestionsEnabled);
            sbU.append(", isThreadCreation=");
            return outline.O(sbU, this.isThreadCreation, ")");
        }
    }

    /* compiled from: AppFlexInputViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "inputText", "", "Lcom/discord/api/sticker/Sticker;", "invoke", "(Ljava/lang/String;)Ljava/util/Set;", "getStickerMatchesForInput"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.AppFlexInputViewModel$getMatchingStickers$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<String, Set<? extends Sticker>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Set<? extends Sticker> invoke(String str) {
            return invoke2(str);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Set<Sticker> invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "inputText");
            StickerUtils stickerUtils = StickerUtils.INSTANCE;
            return StickerUtils.findStickerMatches$default(stickerUtils, str, StickerUtils.getStickersForAutocomplete$default(stickerUtils, null, null, null, null, null, 31, null), false, 4, null);
        }
    }

    /* compiled from: AppFlexInputViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/fragment/app/FragmentActivity;", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "", "invoke", "(Landroidx/fragment/app/FragmentActivity;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.AppFlexInputViewModel$onGiftButtonClicked$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<FragmentActivity, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
            return Boolean.valueOf(invoke2(fragmentActivity));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(FragmentActivity fragmentActivity) {
            Intrinsics3.checkNotNullParameter(fragmentActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Channel channelFindChannelById = companion.getChannels().findChannelById(companion.getChannelsSelected().getId());
            WidgetSettingsGifting.INSTANCE.launch(fragmentActivity, new Traits.Location((channelFindChannelById == null || channelFindChannelById.getGuildId() != 0) ? Traits.Location.Page.GUILD_CHANNEL : "DM Channel", Traits.Location.Section.CHANNEL_TEXT_AREA, "Button Icon", "gift", null, 16, null));
            StoreNotices.markSeen$default(companion.getNotices(), AppFlexInputViewModel.CHAT_GIFTING_NOTICE, 0L, 2, null);
            return true;
        }
    }

    /* compiled from: AppFlexInputViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "shouldClean", "", "invoke", "(Z)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.AppFlexInputViewModel$onSendButtonClicked$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Boolean, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
            if (z2) {
                AppFlexInputViewModel.clean$default(AppFlexInputViewModel.this, false, 1, null);
            }
        }
    }

    public /* synthetic */ AppFlexInputViewModel(AppPermissions2 appPermissions2, FlexInputState flexInputState, Observable observable, StoreStickers storeStickers, StoreAnalytics storeAnalytics, StoreExpressionSuggestions storeExpressionSuggestions, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(appPermissions2, (i & 2) != 0 ? new FlexInputState(null, false, null, false, false, null, false, false, false, false, false, null, null, 8191) : flexInputState, (i & 4) != 0 ? Companion.access$observeStores(INSTANCE) : observable, (i & 8) != 0 ? StoreStream.INSTANCE.getStickers() : storeStickers, (i & 16) != 0 ? StoreStream.INSTANCE.getAnalytics() : storeAnalytics, (i & 32) != 0 ? StoreStream.INSTANCE.getExpressionSuggestions() : storeExpressionSuggestions);
    }

    public static final /* synthetic */ void access$handleStoreState(AppFlexInputViewModel appFlexInputViewModel, StoreState storeState) {
        appFlexInputViewModel.handleStoreState(storeState);
    }

    public static /* synthetic */ void clean$default(AppFlexInputViewModel appFlexInputViewModel, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        appFlexInputViewModel.clean(z2);
    }

    private final void handleStoreState(StoreState storeState) {
        boolean z2;
        FlexInputState flexInputStateRequireViewState = requireViewState();
        Channel selectedChannel = storeState.getSelectedChannel();
        Long channelPermission = storeState.getChannelPermission();
        PanelState leftPanelState = storeState.getLeftPanelState();
        PanelState.a aVar = PanelState.a.a;
        boolean z3 = (Intrinsics3.areEqual(leftPanelState, aVar) ^ true) || (Intrinsics3.areEqual(storeState.getRightPanelState(), aVar) ^ true);
        boolean z4 = (storeState.getNotice() == null || storeState.getNotice().isInAppNotification() || storeState.getNotice().isPopup()) ? false : true;
        boolean zCan = selectedChannel == null ? false : storeState.isThreadCreation() ? PermissionUtils.can(Permission.SEND_MESSAGES_IN_THREADS, channelPermission) : PermissionUtils.INSTANCE.hasAccessWrite(selectedChannel, channelPermission);
        Integer numValueOf = selectedChannel != null ? Integer.valueOf(selectedChannel.getType()) : null;
        boolean z5 = (numValueOf != null && numValueOf.intValue() == 15) ? zCan && storeState.isThreadCreation() : zCan;
        boolean z6 = selectedChannel != null && (ChannelUtils.B(selectedChannel) || PermissionUtils.can(Permission.ATTACH_FILES, channelPermission));
        boolean z7 = flexInputStateRequireViewState.showExpressionTray;
        if (z4 || z3) {
            hideKeyboard();
            z2 = false;
        } else {
            z2 = z7;
        }
        updateViewState(FlexInputState.a(flexInputStateRequireViewState, null, false, null, false, false, null, z5, z6, z2, false, storeState.getStickerSuggestionsEnabled(), selectedChannel != null ? Long.valueOf(selectedChannel.getId()) : null, selectedChannel != null ? Long.valueOf(selectedChannel.getGuildId()) : null, 575));
    }

    private final void showKeyboard() {
        PublishSubject<FlexInputEvent> publishSubject = this.eventSubject;
        publishSubject.k.onNext(FlexInputEvent.c.a);
    }

    @MainThread
    public final void clean(boolean clearText) {
        FlexInputState viewState = getViewState();
        if (viewState != null) {
            updateViewState(FlexInputState.a(viewState, clearText ? "" : viewState.inputText, true, Collections2.emptyList(), false, false, null, false, false, false, false, false, null, null, 8152));
        }
    }

    public final void focus() {
        PublishSubject<FlexInputEvent> publishSubject = this.eventSubject;
        publishSubject.k.onNext(FlexInputEvent.a.a);
    }

    public final boolean getAttachmentView() {
        return this.attachmentView;
    }

    public final List<Sticker> getMatchingStickers(String inputText) {
        Intrinsics3.checkNotNullParameter(inputText, "inputText");
        AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
        int length = inputText.length();
        return _Collections.toList(3 <= length && 50 >= length ? anonymousClass1.invoke2(inputText) : Sets5.emptySet());
    }

    public final FlexInputListener2 getSingleAttachmentSelectedListener() {
        return this.singleAttachmentSelectedListener;
    }

    public final boolean getSingleSelectMode() {
        return this.singleSelectMode;
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    public boolean hasMediaPermissions() {
        return this.permissionRequests.hasMedia();
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    @MainThread
    public boolean hideExpressionTray() {
        FlexInputState viewState = getViewState();
        if (viewState == null || !viewState.showExpressionTray) {
            return false;
        }
        updateViewState(FlexInputState.a(viewState, null, false, null, false, false, null, false, false, false, false, false, null, null, 7935));
        return true;
    }

    public final void hideKeyboard() {
        PublishSubject<FlexInputEvent> publishSubject = this.eventSubject;
        publishSubject.k.onNext(FlexInputEvent.b.a);
    }

    public boolean isAttachmentViewEnabled() {
        return this.attachmentView;
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    public boolean isSingleSelectMode() {
        return this.singleSelectMode;
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    @MainThread
    public Observable<FlexInputEvent> observeEvents() {
        PublishSubject<FlexInputEvent> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    @MainThread
    public Observable<FlexInputState> observeState() {
        return observeViewState();
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    @MainThread
    public void onAttachmentsUpdated(List<? extends Attachment<? extends Object>> attachments) {
        Intrinsics3.checkNotNullParameter(attachments, "attachments");
        updateViewState(FlexInputState.a(requireViewState(), null, false, new ArrayList(attachments), false, false, null, false, false, false, false, false, null, null, 8187));
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    @MainThread
    public void onContentDialogDismissed(boolean showKeyboard) {
        if (showKeyboard) {
            showKeyboard();
        }
        updateViewState(FlexInputState.a(requireViewState(), null, false, null, false, false, null, false, false, false, false, false, null, null, 8159));
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    @MainThread
    public void onContentDialogPageChanged(int index) {
        updateViewState(FlexInputState.a(requireViewState(), null, false, null, false, false, Integer.valueOf(index), false, false, false, false, false, null, null, 8159));
        if (index == 0) {
            this.storeAnalytics.trackChatInputComponentViewed(ChatInputComponentTypes.MEDIA_PICKER);
        } else if (index == 1) {
            this.storeAnalytics.trackChatInputComponentViewed(ChatInputComponentTypes.FILES);
        } else {
            if (index != 2) {
                return;
            }
            this.storeAnalytics.trackChatInputComponentViewed(ChatInputComponentTypes.CAMERA);
        }
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    public void onCreateThreadSelected() {
        Long l = requireViewState().channelId;
        Long l2 = requireViewState().guildId;
        if (l != null) {
            l.longValue();
            if (l2 != null) {
                l2.longValue();
                ChannelSelector.openCreateThread$default(ChannelSelector.INSTANCE.getInstance(), l2.longValue(), l.longValue(), null, "Plus Button", 4, null);
                onContentDialogDismissed(false);
            }
        }
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    @MainThread
    public void onExpandButtonClicked() {
        updateViewState(FlexInputState.a(requireViewState(), null, true, null, false, false, null, false, false, false, false, false, null, null, 8189));
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    @MainThread
    public void onExpressionTrayButtonClicked() {
        FlexInputState flexInputStateRequireViewState = requireViewState();
        if (flexInputStateRequireViewState.showExpressionTray) {
            showKeyboard();
        } else {
            hideKeyboard();
        }
        updateViewState(FlexInputState.a(flexInputStateRequireViewState, null, false, null, false, false, null, false, false, !flexInputStateRequireViewState.showExpressionTray, false, false, null, null, 7935));
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    @MainThread
    public void onFlexInputFragmentPause() {
        hideKeyboard();
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    @MainThread
    public void onGalleryButtonClicked() {
        FlexInputState flexInputStateRequireViewState = requireViewState();
        if (flexInputStateRequireViewState.ableToAttachFiles) {
            hideKeyboard();
            updateViewState(FlexInputState.a(flexInputStateRequireViewState, null, false, null, false, false, 0, false, false, false, false, false, null, null, 7903));
        } else {
            PublishSubject<FlexInputEvent> publishSubject = this.eventSubject;
            publishSubject.k.onNext(new FlexInputEvent.e(R.string.cannot_attach_files));
        }
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    @MainThread
    public void onGiftButtonClicked() {
        hideKeyboard();
        StoreStream.INSTANCE.getNotices().requestToShow(new StoreNotices.Notice(CHAT_GIFTING_NOTICE, null, 0L, 0, false, CollectionsJVM.listOf(Reflection2.getOrCreateKotlinClass(WidgetHome.class)), 0L, false, 0L, AnonymousClass1.INSTANCE, 150, null));
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    @MainThread
    public void onInputTextAppended(String appendText) {
        Intrinsics3.checkNotNullParameter(appendText, "appendText");
        f.P0(this, outline.J(new StringBuilder(), requireViewState().inputText, appendText), null, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0049  */
    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    @MainThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onInputTextChanged(String inputText, Boolean focused) {
        boolean z2;
        Intrinsics3.checkNotNullParameter(inputText, "inputText");
        FlexInputState flexInputStateRequireViewState = requireViewState();
        if (Intrinsics3.areEqual(inputText, flexInputStateRequireViewState.inputText) || !flexInputStateRequireViewState.ableToSendMessages) {
            return;
        }
        if (Intrinsics3.areEqual(focused, Boolean.TRUE)) {
            showKeyboard();
        } else if (Intrinsics3.areEqual(focused, Boolean.FALSE)) {
            hideKeyboard();
        }
        if (flexInputStateRequireViewState.showExpandedButtons) {
            if (inputText.length() > 0) {
                z2 = false;
            }
        } else {
            z2 = flexInputStateRequireViewState.showExpandedButtons;
        }
        if (inputText.length() > 0) {
            this.storeStickers.fetchEnabledStickerDirectory();
        }
        if (inputText.length() == 0) {
            this.storeExpressionSuggestions.setExpressionSuggestionsEnabled(true);
        }
        updateViewState(FlexInputState.a(flexInputStateRequireViewState, inputText, z2, null, false, false, null, false, false, false, false, false, null, null, 8188));
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    @MainThread
    public boolean onInputTextClicked() {
        showKeyboard();
        updateViewState(FlexInputState.a(requireViewState(), null, false, null, false, false, null, false, false, false, false, false, null, null, 7935));
        return false;
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    @MainThread
    public void onSendButtonClicked(FlexInputListener inputListener) {
        FlexInputState viewState = getViewState();
        if (viewState == null || inputListener == null) {
            return;
        }
        inputListener.onSend(viewState.inputText, viewState.attachments, new AnonymousClass1());
    }

    @MainThread
    public void onShowDialog() {
        hideKeyboard();
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    public void onSingleAttachmentSelected(Attachment<? extends Object> attachment) {
        Intrinsics3.checkNotNullParameter(attachment, "attachment");
        FlexInputListener2 flexInputListener2 = this.singleAttachmentSelectedListener;
        if (flexInputListener2 != null) {
            flexInputListener2.onAttachmentSelected(attachment);
        }
    }

    @MainThread
    public final void onStickerSuggestionSent(boolean shouldClearInput) {
        FlexInputState viewState = getViewState();
        if (viewState != null) {
            updateViewState(FlexInputState.a(viewState, shouldClearInput ? "" : viewState.inputText, true, Collections2.emptyList(), false, false, null, false, false, false, false, false, null, null, 8152));
            if (shouldClearInput) {
                hideKeyboard();
            } else {
                this.storeExpressionSuggestions.setExpressionSuggestionsEnabled(false);
            }
        }
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    @MainThread
    public boolean onToolTipButtonLongPressed(View button) {
        Intrinsics3.checkNotNullParameter(button, "button");
        PublishSubject<FlexInputEvent> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new FlexInputEvent.d(button.getContentDescription().toString()));
        return true;
    }

    public void removeAttachment(Attachment<?> attachment) {
        List<? extends Attachment<? extends Object>> mutableList;
        List<Attachment<Object>> list;
        Intrinsics3.checkNotNullParameter(attachment, "attachment");
        FlexInputState viewState = getViewState();
        if (viewState == null || (list = viewState.attachments) == null || (mutableList = _Collections.toMutableList((Collection) list)) == null) {
            mutableList = null;
        } else {
            TypeIntrinsics.asMutableCollection(mutableList).remove(attachment);
        }
        if (mutableList != null) {
            onAttachmentsUpdated(mutableList);
        }
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    public void requestMediaPermissions(Function0<Unit> onSuccess) {
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        this.permissionRequests.requestMedia(onSuccess);
    }

    public void setAttachmentSelectedListener(FlexInputListener2 attachmentListener) {
        Intrinsics3.checkNotNullParameter(attachmentListener, "attachmentListener");
        this.singleAttachmentSelectedListener = attachmentListener;
    }

    public final void setAttachmentView(boolean z2) {
        this.attachmentView = z2;
    }

    public void setAttachmentViewEnabled(boolean enabled) {
        this.attachmentView = enabled;
        FlexInputState viewState = getViewState();
        if (viewState == null || viewState.attachmentViewEnabled != enabled) {
            FlexInputState viewState2 = getViewState();
            if (viewState2 == null) {
                viewState2 = new FlexInputState(null, false, null, false, false, null, false, false, false, false, false, null, null, 8191);
            }
            updateViewState(FlexInputState.a(viewState2, null, false, null, enabled, false, null, false, false, false, false, false, null, null, 8183));
        }
    }

    public void setModeSingleSelect(boolean singleSelect) {
        this.singleSelectMode = singleSelect;
        FlexInputState viewState = getViewState();
        if (viewState == null || viewState.singleSelectMode != singleSelect) {
            FlexInputState viewState2 = getViewState();
            if (viewState2 == null) {
                viewState2 = new FlexInputState(null, false, null, false, false, null, false, false, false, false, false, null, null, 8191);
            }
            updateViewState(FlexInputState.a(viewState2, null, false, null, false, singleSelect, null, false, false, false, false, false, null, null, 8175));
        }
    }

    public void setShowExpressionTrayButtonBadge(boolean showBadge) {
        updateViewState(FlexInputState.a(requireViewState(), null, false, null, false, false, null, false, false, false, showBadge, false, null, null, 7679));
    }

    public final void setSingleAttachmentSelectedListener(FlexInputListener2 flexInputListener2) {
        this.singleAttachmentSelectedListener = flexInputListener2;
    }

    public final void setSingleSelectMode(boolean z2) {
        this.singleSelectMode = z2;
    }

    @MainThread
    public boolean showExpressionTray() {
        FlexInputState viewState = getViewState();
        if (viewState == null || viewState.showExpressionTray) {
            return false;
        }
        updateViewState(FlexInputState.a(viewState, null, false, null, false, false, null, false, false, true, false, false, null, null, 7935));
        return true;
    }

    public final void showKeyboardAndHideExpressionTray() {
        updateViewState(FlexInputState.a(requireViewState(), null, false, null, false, false, null, false, false, false, false, false, null, null, 7935));
        showKeyboard();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppFlexInputViewModel(AppPermissions2 appPermissions2, FlexInputState flexInputState, Observable<StoreState> observable, StoreStickers storeStickers, StoreAnalytics storeAnalytics, StoreExpressionSuggestions storeExpressionSuggestions) {
        super(flexInputState);
        Intrinsics3.checkNotNullParameter(appPermissions2, "permissionRequests");
        Intrinsics3.checkNotNullParameter(flexInputState, "initialViewState");
        Intrinsics3.checkNotNullParameter(observable, "storeObservable");
        Intrinsics3.checkNotNullParameter(storeStickers, "storeStickers");
        Intrinsics3.checkNotNullParameter(storeAnalytics, "storeAnalytics");
        Intrinsics3.checkNotNullParameter(storeExpressionSuggestions, "storeExpressionSuggestions");
        this.permissionRequests = appPermissions2;
        this.storeStickers = storeStickers;
        this.storeAnalytics = storeAnalytics;
        this.storeExpressionSuggestions = storeExpressionSuggestions;
        this.eventSubject = PublishSubject.k0();
        Observable observableR = ObservableExtensionsKt.computationLatest(observable).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "storeObservable\n        …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableR, this, null, 2, null), AppFlexInputViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        this.attachmentView = true;
    }
}
