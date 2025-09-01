package com.discord.widgets.chat.overlay;

import a0.a.a.b;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppViewModelDelegates2;
import b.a.i.WidgetChatInputStickerSuggestionsBinding;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.sticker.Sticker;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChatOverlayBinding;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.search.SearchUtils;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.sticker.StickerView;
import com.discord.views.typing.TypingDots;
import com.discord.widgets.chat.input.AppFlexInputViewModel;
import com.discord.widgets.chat.input.ChatInputViewModel;
import com.discord.widgets.chat.overlay.ChatTypingModel;
import com.lytefast.flexinput.viewmodel.FlexInputState;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.t._Collections;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.functions.Func3;

/* compiled from: WidgetChatOverlay.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0003\u001e\u001f B\u0007¢\u0006\u0004\b\u001d\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001d\u0010\u000e\u001a\u00020\t8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0017\u001a\u00020\u00128B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u001c\u001a\u00020\u00188B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u001b¨\u0006!"}, d2 = {"Lcom/discord/widgets/chat/overlay/WidgetChatOverlay;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/chat/overlay/WidgetChatOverlay$StickerAutocompleteState;", "stickerAutocompleteState", "", "configureStickerSuggestions", "(Lcom/discord/widgets/chat/overlay/WidgetChatOverlay$StickerAutocompleteState;)V", "onViewBoundOrOnResume", "()V", "Lcom/discord/databinding/WidgetChatOverlayBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetChatOverlayBinding;", "binding", "Lcom/discord/widgets/chat/overlay/WidgetChatOverlay$TypingIndicatorViewHolder;", "typingIndicatorViewHolder", "Lcom/discord/widgets/chat/overlay/WidgetChatOverlay$TypingIndicatorViewHolder;", "Lcom/discord/widgets/chat/input/AppFlexInputViewModel;", "flexInputViewModel$delegate", "Lkotlin/Lazy;", "getFlexInputViewModel", "()Lcom/discord/widgets/chat/input/AppFlexInputViewModel;", "flexInputViewModel", "Lcom/discord/widgets/chat/input/ChatInputViewModel;", "chatInputViewModel$delegate", "getChatInputViewModel", "()Lcom/discord/widgets/chat/input/ChatInputViewModel;", "chatInputViewModel", "<init>", "OldMessageModel", "StickerAutocompleteState", "TypingIndicatorViewHolder", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChatOverlay extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetChatOverlay.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChatOverlayBinding;", 0)};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: chatInputViewModel$delegate, reason: from kotlin metadata */
    private final Lazy chatInputViewModel;

    /* renamed from: flexInputViewModel$delegate, reason: from kotlin metadata */
    private final Lazy flexInputViewModel;
    private TypingIndicatorViewHolder typingIndicatorViewHolder;

    /* compiled from: WidgetChatOverlay.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0082\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u001b\u0012\n\u0010\t\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\u001aJ\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ(\u0010\u000b\u001a\u00020\u00002\f\b\u0002\u0010\t\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0014\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001d\u0010\t\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0005R\u0019\u0010\n\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\n\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/discord/widgets/chat/overlay/WidgetChatOverlay$OldMessageModel;", "", "", "Lcom/discord/primitives/ChannelId;", "component1", "()J", "", "component2", "()Z", "channelId", "isViewingOldMessages", "copy", "(JZ)Lcom/discord/widgets/chat/overlay/WidgetChatOverlay$OldMessageModel;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "J", "getChannelId", "Z", "<init>", "(JZ)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class OldMessageModel {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final long channelId;
        private final boolean isViewingOldMessages;

        /* compiled from: WidgetChatOverlay.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/discord/widgets/chat/overlay/WidgetChatOverlay$OldMessageModel$Companion;", "", "Lrx/Observable;", "Lcom/discord/widgets/chat/overlay/WidgetChatOverlay$OldMessageModel;", "get", "()Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public final Observable<OldMessageModel> get() {
                Observable observableY = StoreStream.INSTANCE.getChannelsSelected().observeId().r().Y(WidgetChatOverlay3.INSTANCE);
                Intrinsics3.checkNotNullExpressionValue(observableY, "StoreStream\n            …          }\n            }");
                return observableY;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public OldMessageModel(long j, boolean z2) {
            this.channelId = j;
            this.isViewingOldMessages = z2;
        }

        public static /* synthetic */ OldMessageModel copy$default(OldMessageModel oldMessageModel, long j, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = oldMessageModel.channelId;
            }
            if ((i & 2) != 0) {
                z2 = oldMessageModel.isViewingOldMessages;
            }
            return oldMessageModel.copy(j, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final long getChannelId() {
            return this.channelId;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsViewingOldMessages() {
            return this.isViewingOldMessages;
        }

        public final OldMessageModel copy(long channelId, boolean isViewingOldMessages) {
            return new OldMessageModel(channelId, isViewingOldMessages);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OldMessageModel)) {
                return false;
            }
            OldMessageModel oldMessageModel = (OldMessageModel) other;
            return this.channelId == oldMessageModel.channelId && this.isViewingOldMessages == oldMessageModel.isViewingOldMessages;
        }

        public final long getChannelId() {
            return this.channelId;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int iA = b.a(this.channelId) * 31;
            boolean z2 = this.isViewingOldMessages;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iA + i;
        }

        public final boolean isViewingOldMessages() {
            return this.isViewingOldMessages;
        }

        public String toString() {
            StringBuilder sbU = outline.U("OldMessageModel(channelId=");
            sbU.append(this.channelId);
            sbU.append(", isViewingOldMessages=");
            return outline.O(sbU, this.isViewingOldMessages, ")");
        }
    }

    /* compiled from: WidgetChatOverlay.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u000b\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/discord/widgets/chat/overlay/WidgetChatOverlay$StickerAutocompleteState;", "", "", "component1", "()Z", "Lcom/lytefast/flexinput/viewmodel/FlexInputState;", "component2", "()Lcom/lytefast/flexinput/viewmodel/FlexInputState;", "component3", "autocompleteVisible", "flexInputState", "isForumPostDraftCreation", "copy", "(ZLcom/lytefast/flexinput/viewmodel/FlexInputState;Z)Lcom/discord/widgets/chat/overlay/WidgetChatOverlay$StickerAutocompleteState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Lcom/lytefast/flexinput/viewmodel/FlexInputState;", "getFlexInputState", "getAutocompleteVisible", "<init>", "(ZLcom/lytefast/flexinput/viewmodel/FlexInputState;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StickerAutocompleteState {
        private final boolean autocompleteVisible;
        private final FlexInputState flexInputState;
        private final boolean isForumPostDraftCreation;

        public StickerAutocompleteState(boolean z2, FlexInputState flexInputState, boolean z3) {
            Intrinsics3.checkNotNullParameter(flexInputState, "flexInputState");
            this.autocompleteVisible = z2;
            this.flexInputState = flexInputState;
            this.isForumPostDraftCreation = z3;
        }

        public static /* synthetic */ StickerAutocompleteState copy$default(StickerAutocompleteState stickerAutocompleteState, boolean z2, FlexInputState flexInputState, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = stickerAutocompleteState.autocompleteVisible;
            }
            if ((i & 2) != 0) {
                flexInputState = stickerAutocompleteState.flexInputState;
            }
            if ((i & 4) != 0) {
                z3 = stickerAutocompleteState.isForumPostDraftCreation;
            }
            return stickerAutocompleteState.copy(z2, flexInputState, z3);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getAutocompleteVisible() {
            return this.autocompleteVisible;
        }

        /* renamed from: component2, reason: from getter */
        public final FlexInputState getFlexInputState() {
            return this.flexInputState;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsForumPostDraftCreation() {
            return this.isForumPostDraftCreation;
        }

        public final StickerAutocompleteState copy(boolean autocompleteVisible, FlexInputState flexInputState, boolean isForumPostDraftCreation) {
            Intrinsics3.checkNotNullParameter(flexInputState, "flexInputState");
            return new StickerAutocompleteState(autocompleteVisible, flexInputState, isForumPostDraftCreation);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StickerAutocompleteState)) {
                return false;
            }
            StickerAutocompleteState stickerAutocompleteState = (StickerAutocompleteState) other;
            return this.autocompleteVisible == stickerAutocompleteState.autocompleteVisible && Intrinsics3.areEqual(this.flexInputState, stickerAutocompleteState.flexInputState) && this.isForumPostDraftCreation == stickerAutocompleteState.isForumPostDraftCreation;
        }

        public final boolean getAutocompleteVisible() {
            return this.autocompleteVisible;
        }

        public final FlexInputState getFlexInputState() {
            return this.flexInputState;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            boolean z2 = this.autocompleteVisible;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            FlexInputState flexInputState = this.flexInputState;
            int iHashCode = (i + (flexInputState != null ? flexInputState.hashCode() : 0)) * 31;
            boolean z3 = this.isForumPostDraftCreation;
            return iHashCode + (z3 ? 1 : z3 ? 1 : 0);
        }

        public final boolean isForumPostDraftCreation() {
            return this.isForumPostDraftCreation;
        }

        public String toString() {
            StringBuilder sbU = outline.U("StickerAutocompleteState(autocompleteVisible=");
            sbU.append(this.autocompleteVisible);
            sbU.append(", flexInputState=");
            sbU.append(this.flexInputState);
            sbU.append(", isForumPostDraftCreation=");
            return outline.O(sbU, this.isForumPostDraftCreation, ")");
        }
    }

    /* compiled from: WidgetChatOverlay.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/discord/widgets/chat/overlay/WidgetChatOverlay$TypingIndicatorViewHolder;", "", "Lcom/discord/widgets/chat/overlay/ChatTypingModel$Typing;", "model", "", "configureTyping", "(Lcom/discord/widgets/chat/overlay/ChatTypingModel$Typing;)V", "", "cooldownSecs", "channelRateLimit", "", "hasTypingText", "", "getSlowmodeText", "(IIZ)Ljava/lang/CharSequence;", "Landroid/content/res/Resources;", "resources", "", "typingUsers", "getTypingString", "(Landroid/content/res/Resources;Ljava/util/List;)Ljava/lang/CharSequence;", "Lcom/discord/widgets/chat/overlay/ChatTypingModel;", "configureUI", "(Lcom/discord/widgets/chat/overlay/ChatTypingModel;)V", "Lcom/discord/databinding/WidgetChatOverlayBinding;", "binding", "Lcom/discord/databinding/WidgetChatOverlayBinding;", "<init>", "(Lcom/discord/databinding/WidgetChatOverlayBinding;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class TypingIndicatorViewHolder {
        private final WidgetChatOverlayBinding binding;

        public TypingIndicatorViewHolder(WidgetChatOverlayBinding widgetChatOverlayBinding) {
            Intrinsics3.checkNotNullParameter(widgetChatOverlayBinding, "binding");
            this.binding = widgetChatOverlayBinding;
        }

        private final void configureTyping(ChatTypingModel.Typing model) throws Resources.NotFoundException {
            if (model.getTypingUsers().isEmpty() && model.getChannelRateLimit() <= 0) {
                this.binding.d.c();
                RelativeLayout relativeLayout = this.binding.c;
                Intrinsics3.checkNotNullExpressionValue(relativeLayout, "binding.chatOverlayTyping");
                relativeLayout.setVisibility(8);
                return;
            }
            RelativeLayout relativeLayout2 = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(relativeLayout2, "binding.chatOverlayTyping");
            relativeLayout2.setVisibility(0);
            ConstraintLayout constraintLayout = this.binding.a;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.root");
            Resources resources = constraintLayout.getResources();
            Intrinsics3.checkNotNullExpressionValue(resources, "binding.root.resources");
            CharSequence typingString = getTypingString(resources, model.getTypingUsers());
            CharSequence slowmodeText = getSlowmodeText(model.getCooldownSecs(), model.getChannelRateLimit(), !StringsJVM.isBlank(typingString));
            TextView textView = this.binding.g;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.chatTypingUsersTyping");
            ViewExtensions.setTextAndVisibilityBy(textView, typingString);
            TypingDots typingDots = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(typingDots, "binding.chatOverlayTypingDots");
            typingDots.setVisibility(model.getTypingUsers().isEmpty() ^ true ? 0 : 8);
            TypingDots typingDots2 = this.binding.d;
            if (!model.getTypingUsers().isEmpty()) {
                TypingDots.b(typingDots2, false, 1);
            } else {
                typingDots2.c();
            }
            TextView textView2 = this.binding.e;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.chatTypingUsersSlowmode");
            ViewExtensions.setTextAndVisibilityBy(textView2, slowmodeText);
            ImageView imageView = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.chatTypingUsersSlowmodeIcon");
            imageView.setVisibility(model.getChannelRateLimit() > 0 ? 0 : 8);
        }

        private final CharSequence getSlowmodeText(int cooldownSecs, int channelRateLimit, boolean hasTypingText) throws Resources.NotFoundException {
            if (cooldownSecs > 0) {
                return TimeUtils.toFriendlyStringSimple$default(TimeUtils.INSTANCE, 1000 * cooldownSecs, null, null, 6, null);
            }
            if (channelRateLimit <= 0 || hasTypingText) {
                return "";
            }
            ConstraintLayout constraintLayout = this.binding.a;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.root");
            String string = constraintLayout.getResources().getString(R.string.channel_slowmode_desc_short);
            Intrinsics3.checkNotNullExpressionValue(string, "binding.root.resources.g…nnel_slowmode_desc_short)");
            return string;
        }

        private final CharSequence getTypingString(Resources resources, List<? extends CharSequence> typingUsers) {
            int size = typingUsers.size();
            return size != 0 ? size != 1 ? size != 2 ? size != 3 ? FormatUtils.i(resources, R.string.several_users_typing, new Object[0], null, 4) : FormatUtils.i(resources, R.string.three_users_typing, new Object[]{typingUsers.get(0), typingUsers.get(1), typingUsers.get(2)}, null, 4) : FormatUtils.i(resources, R.string.two_users_typing, new Object[]{typingUsers.get(0), typingUsers.get(1)}, null, 4) : FormatUtils.i(resources, R.string.one_user_typing, new Object[]{typingUsers.get(0)}, null, 4) : "";
        }

        public final void configureUI(ChatTypingModel model) throws Resources.NotFoundException {
            Intrinsics3.checkNotNullParameter(model, "model");
            if (model instanceof ChatTypingModel.Hide) {
                RelativeLayout relativeLayout = this.binding.c;
                Intrinsics3.checkNotNullExpressionValue(relativeLayout, "binding.chatOverlayTyping");
                relativeLayout.setVisibility(8);
            } else if (model instanceof ChatTypingModel.Typing) {
                configureTyping((ChatTypingModel.Typing) model);
            }
        }
    }

    /* compiled from: WidgetChatOverlay.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.overlay.WidgetChatOverlay$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            StoreStream.INSTANCE.getExpressionSuggestions().setExpressionSuggestionsEnabled(false);
        }
    }

    /* compiled from: WidgetChatOverlay.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.overlay.WidgetChatOverlay$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            StoreStream.INSTANCE.getMessagesLoader().requestNewestMessages();
        }
    }

    /* compiled from: WidgetChatOverlay.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/chat/overlay/WidgetChatOverlay$OldMessageModel;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Lcom/discord/widgets/chat/overlay/WidgetChatOverlay$OldMessageModel;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.overlay.WidgetChatOverlay$onViewBoundOrOnResume$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<OldMessageModel, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(OldMessageModel oldMessageModel) {
            invoke2(oldMessageModel);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(OldMessageModel oldMessageModel) {
            if (oldMessageModel.isViewingOldMessages()) {
                WidgetChatOverlay.access$getBinding$p(WidgetChatOverlay.this).f2345b.show();
            } else {
                WidgetChatOverlay.access$getBinding$p(WidgetChatOverlay.this).f2345b.hide();
            }
        }
    }

    /* compiled from: WidgetChatOverlay.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/chat/overlay/ChatTypingModel;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Lcom/discord/widgets/chat/overlay/ChatTypingModel;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.overlay.WidgetChatOverlay$onViewBoundOrOnResume$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function1<ChatTypingModel, Unit> {
        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ChatTypingModel chatTypingModel) throws Resources.NotFoundException {
            invoke2(chatTypingModel);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ChatTypingModel chatTypingModel) throws Resources.NotFoundException {
            TypingIndicatorViewHolder typingIndicatorViewHolderAccess$getTypingIndicatorViewHolder$p = WidgetChatOverlay.access$getTypingIndicatorViewHolder$p(WidgetChatOverlay.this);
            Intrinsics3.checkNotNullExpressionValue(chatTypingModel, "it");
            typingIndicatorViewHolderAccess$getTypingIndicatorViewHolder$p.configureUI(chatTypingModel);
        }
    }

    /* compiled from: WidgetChatOverlay.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\n\u001a\n \u0001*\u0004\u0018\u00010\u00070\u00072\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"", "kotlin.jvm.PlatformType", "autocompleteVisible", "Lcom/lytefast/flexinput/viewmodel/FlexInputState;", "flexInputState", "Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel;", "resolvedSelectedChannel", "Lcom/discord/widgets/chat/overlay/WidgetChatOverlay$StickerAutocompleteState;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Boolean;Lcom/lytefast/flexinput/viewmodel/FlexInputState;Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel;)Lcom/discord/widgets/chat/overlay/WidgetChatOverlay$StickerAutocompleteState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.overlay.WidgetChatOverlay$onViewBoundOrOnResume$5, reason: invalid class name */
    public static final class AnonymousClass5<T1, T2, T3, R> implements Func3<Boolean, FlexInputState, StoreChannelsSelected.ResolvedSelectedChannel, StickerAutocompleteState> {
        public static final AnonymousClass5 INSTANCE = new AnonymousClass5();

        @Override // rx.functions.Func3
        public /* bridge */ /* synthetic */ StickerAutocompleteState call(Boolean bool, FlexInputState flexInputState, StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
            return call2(bool, flexInputState, resolvedSelectedChannel);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final StickerAutocompleteState call2(Boolean bool, FlexInputState flexInputState, StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
            Channel parentChannel;
            if (!(resolvedSelectedChannel instanceof StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft)) {
                resolvedSelectedChannel = null;
            }
            StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft threadDraft = (StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft) resolvedSelectedChannel;
            Intrinsics3.checkNotNullExpressionValue(bool, "autocompleteVisible");
            boolean zBooleanValue = bool.booleanValue();
            Intrinsics3.checkNotNullExpressionValue(flexInputState, "flexInputState");
            return new StickerAutocompleteState(zBooleanValue, flexInputState, (threadDraft == null || (parentChannel = threadDraft.getParentChannel()) == null || !ChannelUtils.q(parentChannel)) ? false : true);
        }
    }

    /* compiled from: WidgetChatOverlay.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/chat/overlay/WidgetChatOverlay$StickerAutocompleteState;", "p1", "", "invoke", "(Lcom/discord/widgets/chat/overlay/WidgetChatOverlay$StickerAutocompleteState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.overlay.WidgetChatOverlay$onViewBoundOrOnResume$6, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass6 extends FunctionReferenceImpl implements Function1<StickerAutocompleteState, Unit> {
        public AnonymousClass6(WidgetChatOverlay widgetChatOverlay) {
            super(1, widgetChatOverlay, WidgetChatOverlay.class, "configureStickerSuggestions", "configureStickerSuggestions(Lcom/discord/widgets/chat/overlay/WidgetChatOverlay$StickerAutocompleteState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StickerAutocompleteState stickerAutocompleteState) {
            invoke2(stickerAutocompleteState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StickerAutocompleteState stickerAutocompleteState) {
            Intrinsics3.checkNotNullParameter(stickerAutocompleteState, "p1");
            WidgetChatOverlay.access$configureStickerSuggestions((WidgetChatOverlay) this.receiver, stickerAutocompleteState);
        }
    }

    public WidgetChatOverlay() {
        super(R.layout.widget_chat_overlay);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetChatOverlay6.INSTANCE, null, 2, null);
        this.flexInputViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(AppFlexInputViewModel.class), new WidgetChatOverlay$appActivityViewModels$$inlined$activityViewModels$1(this), new AppViewModelDelegates2(new WidgetChatOverlay8(this)));
        this.chatInputViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(ChatInputViewModel.class), new WidgetChatOverlay$appActivityViewModels$$inlined$activityViewModels$3(this), new AppViewModelDelegates2(WidgetChatOverlay7.INSTANCE));
    }

    public static final /* synthetic */ void access$configureStickerSuggestions(WidgetChatOverlay widgetChatOverlay, StickerAutocompleteState stickerAutocompleteState) {
        widgetChatOverlay.configureStickerSuggestions(stickerAutocompleteState);
    }

    public static final /* synthetic */ WidgetChatOverlayBinding access$getBinding$p(WidgetChatOverlay widgetChatOverlay) {
        return widgetChatOverlay.getBinding();
    }

    public static final /* synthetic */ ChatInputViewModel access$getChatInputViewModel$p(WidgetChatOverlay widgetChatOverlay) {
        return widgetChatOverlay.getChatInputViewModel();
    }

    public static final /* synthetic */ AppFlexInputViewModel access$getFlexInputViewModel$p(WidgetChatOverlay widgetChatOverlay) {
        return widgetChatOverlay.getFlexInputViewModel();
    }

    public static final /* synthetic */ TypingIndicatorViewHolder access$getTypingIndicatorViewHolder$p(WidgetChatOverlay widgetChatOverlay) {
        TypingIndicatorViewHolder typingIndicatorViewHolder = widgetChatOverlay.typingIndicatorViewHolder;
        if (typingIndicatorViewHolder == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("typingIndicatorViewHolder");
        }
        return typingIndicatorViewHolder;
    }

    public static final /* synthetic */ void access$setTypingIndicatorViewHolder$p(WidgetChatOverlay widgetChatOverlay, TypingIndicatorViewHolder typingIndicatorViewHolder) {
        widgetChatOverlay.typingIndicatorViewHolder = typingIndicatorViewHolder;
    }

    private final void configureStickerSuggestions(StickerAutocompleteState stickerAutocompleteState) {
        boolean autocompleteVisible = stickerAutocompleteState.getAutocompleteVisible();
        FlexInputState flexInputState = stickerAutocompleteState.getFlexInputState();
        boolean isForumPostDraftCreation = stickerAutocompleteState.getIsForumPostDraftCreation();
        if (!flexInputState.expressionSuggestionsEnabled || autocompleteVisible || isForumPostDraftCreation) {
            WidgetChatInputStickerSuggestionsBinding widgetChatInputStickerSuggestionsBinding = getBinding().h;
            Intrinsics3.checkNotNullExpressionValue(widgetChatInputStickerSuggestionsBinding, "binding.stickersSuggestions");
            LinearLayout linearLayout = widgetChatInputStickerSuggestionsBinding.a;
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.stickersSuggestions.root");
            linearLayout.setVisibility(8);
            return;
        }
        List listTake = _Collections.take(getFlexInputViewModel().getMatchingStickers(flexInputState.inputText), 4);
        boolean z2 = SearchUtils.INSTANCE.getQueriesFromSearchText(flexInputState.inputText).size() == 1;
        if (listTake == null || listTake.isEmpty()) {
            WidgetChatInputStickerSuggestionsBinding widgetChatInputStickerSuggestionsBinding2 = getBinding().h;
            Intrinsics3.checkNotNullExpressionValue(widgetChatInputStickerSuggestionsBinding2, "binding.stickersSuggestions");
            LinearLayout linearLayout2 = widgetChatInputStickerSuggestionsBinding2.a;
            Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.stickersSuggestions.root");
            linearLayout2.setVisibility(8);
            return;
        }
        StoreStream.INSTANCE.getExpressionSuggestions().trackExpressionSuggestionsDisplayed(flexInputState.inputText);
        WidgetChatInputStickerSuggestionsBinding widgetChatInputStickerSuggestionsBinding3 = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(widgetChatInputStickerSuggestionsBinding3, "binding.stickersSuggestions");
        LinearLayout linearLayout3 = widgetChatInputStickerSuggestionsBinding3.a;
        Intrinsics3.checkNotNullExpressionValue(linearLayout3, "binding.stickersSuggestions.root");
        linearLayout3.setVisibility(0);
        int i = 0;
        for (Object obj : Collections2.listOf((Object[]) new StickerView[]{getBinding().h.f230b, getBinding().h.c, getBinding().h.d, getBinding().h.e})) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            StickerView stickerView = (StickerView) obj;
            Sticker sticker = i < listTake.size() ? (Sticker) listTake.get(i) : null;
            Intrinsics3.checkNotNullExpressionValue(stickerView, "stickerView");
            stickerView.setVisibility(sticker != null ? 0 : 8);
            if (sticker != null) {
                StickerView.e(stickerView, sticker, null, 2);
                stickerView.setOnClickListener(new WidgetChatOverlay2(sticker, stickerView, sticker, this, listTake, z2));
            }
            i = i2;
        }
    }

    private final WidgetChatOverlayBinding getBinding() {
        return (WidgetChatOverlayBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final ChatInputViewModel getChatInputViewModel() {
        return (ChatInputViewModel) this.chatInputViewModel.getValue();
    }

    private final AppFlexInputViewModel getFlexInputViewModel() {
        return (AppFlexInputViewModel) this.flexInputViewModel.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        WidgetChatOverlayBinding binding = getBinding();
        Intrinsics3.checkNotNullExpressionValue(binding, "binding");
        this.typingIndicatorViewHolder = new TypingIndicatorViewHolder(binding);
        WidgetChatInputStickerSuggestionsBinding widgetChatInputStickerSuggestionsBinding = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(widgetChatInputStickerSuggestionsBinding, "binding.stickersSuggestions");
        LinearLayout linearLayout = widgetChatInputStickerSuggestionsBinding.a;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.stickersSuggestions.root");
        Drawable background = linearLayout.getBackground();
        Intrinsics3.checkNotNullExpressionValue(background, "binding.stickersSuggestions.root.background");
        background.setAlpha(216);
        getBinding().h.f.setOnClickListener(AnonymousClass1.INSTANCE);
        getBinding().f2345b.setOnClickListener(AnonymousClass2.INSTANCE);
        Observable<OldMessageModel> observableR = OldMessageModel.INSTANCE.get().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "OldMessageModel.get()\n  …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), WidgetChatOverlay.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(), 62, (Object) null);
        Observable observableR2 = ObservableExtensionsKt.computationLatest(ChatTypingModel.INSTANCE.get()).r();
        Intrinsics3.checkNotNullExpressionValue(observableR2, "ChatTypingModel\n        …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableR2, this, null, 2, null), WidgetChatOverlay.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass4(), 62, (Object) null);
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable observableI = Observable.i(companion.getAutocomplete().observeAutocompleteVisibility().r(), getFlexInputViewModel().observeState().r(), companion.getChannelsSelected().observeResolvedSelectedChannel(), AnonymousClass5.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableI, "Observable.combineLatest…() == true,\n      )\n    }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableI, this, null, 2, null), WidgetChatOverlay.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass6(this), 62, (Object) null);
    }
}
