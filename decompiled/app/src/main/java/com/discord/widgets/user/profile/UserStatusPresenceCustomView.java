package com.discord.widgets.user.profile;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.databinding.ViewUserStatusPresenceCustomBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import com.discord.models.domain.emoji.ModelEmojiUnicode;
import com.discord.stores.StoreStream;
import com.discord.utilities.fresco.GrayscalePostprocessor;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: UserStatusPresenceCustomView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0003\u001c\u001d\u001eB\u0017\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\r\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u001f"}, d2 = {"Lcom/discord/widgets/user/profile/UserStatusPresenceCustomView;", "Landroid/widget/LinearLayout;", "Lcom/discord/widgets/user/profile/UserStatusPresenceCustomView$Emoji;", "emoji", "", "configureStatusEmoji", "(Lcom/discord/widgets/user/profile/UserStatusPresenceCustomView$Emoji;)V", "Lcom/discord/models/domain/emoji/ModelEmojiUnicode;", "placeholderEmoji", "configurePlaceholderEmoji", "(Lcom/discord/models/domain/emoji/ModelEmojiUnicode;)V", "Lkotlin/Function0;", "onClear", "setOnClear", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/discord/widgets/user/profile/UserStatusPresenceCustomView$ViewState;", "viewState", "updateViewState", "(Lcom/discord/widgets/user/profile/UserStatusPresenceCustomView$ViewState;)V", "Lcom/discord/databinding/ViewUserStatusPresenceCustomBinding;", "binding", "Lcom/discord/databinding/ViewUserStatusPresenceCustomBinding;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Companion", "Emoji", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class UserStatusPresenceCustomView extends LinearLayout {
    private final ViewUserStatusPresenceCustomBinding binding;
    private static final GrayscalePostprocessor CUSTOM_EMOJI_PLACEHOLDER_POSTPROCESSOR = new GrayscalePostprocessor();

    /* compiled from: UserStatusPresenceCustomView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ2\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0017\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u000b\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/user/profile/UserStatusPresenceCustomView$Emoji;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Z", ModelAuditLogEntry.CHANGE_KEY_ID, ModelAuditLogEntry.CHANGE_KEY_NAME, "isAnimated", "copy", "(Ljava/lang/String;Ljava/lang/String;Z)Lcom/discord/widgets/user/profile/UserStatusPresenceCustomView$Emoji;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getName", "getId", "Z", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Emoji {
        private final String id;
        private final boolean isAnimated;
        private final String name;

        public Emoji(String str, String str2, boolean z2) {
            this.id = str;
            this.name = str2;
            this.isAnimated = z2;
        }

        public static /* synthetic */ Emoji copy$default(Emoji emoji, String str, String str2, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = emoji.id;
            }
            if ((i & 2) != 0) {
                str2 = emoji.name;
            }
            if ((i & 4) != 0) {
                z2 = emoji.isAnimated;
            }
            return emoji.copy(str, str2, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsAnimated() {
            return this.isAnimated;
        }

        public final Emoji copy(String id2, String name, boolean isAnimated) {
            return new Emoji(id2, name, isAnimated);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Emoji)) {
                return false;
            }
            Emoji emoji = (Emoji) other;
            return Intrinsics3.areEqual(this.id, emoji.id) && Intrinsics3.areEqual(this.name, emoji.name) && this.isAnimated == emoji.isAnimated;
        }

        public final String getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            String str = this.id;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.name;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            boolean z2 = this.isAnimated;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode2 + i;
        }

        public final boolean isAnimated() {
            return this.isAnimated;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Emoji(id=");
            sbU.append(this.id);
            sbU.append(", name=");
            sbU.append(this.name);
            sbU.append(", isAnimated=");
            return outline.O(sbU, this.isAnimated, ")");
        }
    }

    /* compiled from: UserStatusPresenceCustomView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/user/profile/UserStatusPresenceCustomView$ViewState;", "", "<init>", "()V", "WithPlaceholder", "WithStatus", "Lcom/discord/widgets/user/profile/UserStatusPresenceCustomView$ViewState$WithStatus;", "Lcom/discord/widgets/user/profile/UserStatusPresenceCustomView$ViewState$WithPlaceholder;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: UserStatusPresenceCustomView.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/user/profile/UserStatusPresenceCustomView$ViewState$WithPlaceholder;", "Lcom/discord/widgets/user/profile/UserStatusPresenceCustomView$ViewState;", "Lcom/discord/models/domain/emoji/ModelEmojiUnicode;", "component1", "()Lcom/discord/models/domain/emoji/ModelEmojiUnicode;", "placeholderEmoji", "copy", "(Lcom/discord/models/domain/emoji/ModelEmojiUnicode;)Lcom/discord/widgets/user/profile/UserStatusPresenceCustomView$ViewState$WithPlaceholder;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/domain/emoji/ModelEmojiUnicode;", "getPlaceholderEmoji", "<init>", "(Lcom/discord/models/domain/emoji/ModelEmojiUnicode;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class WithPlaceholder extends ViewState {
            private final ModelEmojiUnicode placeholderEmoji;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public WithPlaceholder(ModelEmojiUnicode modelEmojiUnicode) {
                super(null);
                Intrinsics3.checkNotNullParameter(modelEmojiUnicode, "placeholderEmoji");
                this.placeholderEmoji = modelEmojiUnicode;
            }

            public static /* synthetic */ WithPlaceholder copy$default(WithPlaceholder withPlaceholder, ModelEmojiUnicode modelEmojiUnicode, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelEmojiUnicode = withPlaceholder.placeholderEmoji;
                }
                return withPlaceholder.copy(modelEmojiUnicode);
            }

            /* renamed from: component1, reason: from getter */
            public final ModelEmojiUnicode getPlaceholderEmoji() {
                return this.placeholderEmoji;
            }

            public final WithPlaceholder copy(ModelEmojiUnicode placeholderEmoji) {
                Intrinsics3.checkNotNullParameter(placeholderEmoji, "placeholderEmoji");
                return new WithPlaceholder(placeholderEmoji);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof WithPlaceholder) && Intrinsics3.areEqual(this.placeholderEmoji, ((WithPlaceholder) other).placeholderEmoji);
                }
                return true;
            }

            public final ModelEmojiUnicode getPlaceholderEmoji() {
                return this.placeholderEmoji;
            }

            public int hashCode() {
                ModelEmojiUnicode modelEmojiUnicode = this.placeholderEmoji;
                if (modelEmojiUnicode != null) {
                    return modelEmojiUnicode.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("WithPlaceholder(placeholderEmoji=");
                sbU.append(this.placeholderEmoji);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: UserStatusPresenceCustomView.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001b\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/user/profile/UserStatusPresenceCustomView$ViewState$WithStatus;", "Lcom/discord/widgets/user/profile/UserStatusPresenceCustomView$ViewState;", "Lcom/discord/widgets/user/profile/UserStatusPresenceCustomView$Emoji;", "component1", "()Lcom/discord/widgets/user/profile/UserStatusPresenceCustomView$Emoji;", "", "component2", "()Ljava/lang/String;", "emoji", "statusText", "copy", "(Lcom/discord/widgets/user/profile/UserStatusPresenceCustomView$Emoji;Ljava/lang/String;)Lcom/discord/widgets/user/profile/UserStatusPresenceCustomView$ViewState$WithStatus;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/user/profile/UserStatusPresenceCustomView$Emoji;", "getEmoji", "Ljava/lang/String;", "getStatusText", "<init>", "(Lcom/discord/widgets/user/profile/UserStatusPresenceCustomView$Emoji;Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class WithStatus extends ViewState {
            private final Emoji emoji;
            private final String statusText;

            public WithStatus(Emoji emoji, String str) {
                super(null);
                this.emoji = emoji;
                this.statusText = str;
            }

            public static /* synthetic */ WithStatus copy$default(WithStatus withStatus, Emoji emoji, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    emoji = withStatus.emoji;
                }
                if ((i & 2) != 0) {
                    str = withStatus.statusText;
                }
                return withStatus.copy(emoji, str);
            }

            /* renamed from: component1, reason: from getter */
            public final Emoji getEmoji() {
                return this.emoji;
            }

            /* renamed from: component2, reason: from getter */
            public final String getStatusText() {
                return this.statusText;
            }

            public final WithStatus copy(Emoji emoji, String statusText) {
                return new WithStatus(emoji, statusText);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof WithStatus)) {
                    return false;
                }
                WithStatus withStatus = (WithStatus) other;
                return Intrinsics3.areEqual(this.emoji, withStatus.emoji) && Intrinsics3.areEqual(this.statusText, withStatus.statusText);
            }

            public final Emoji getEmoji() {
                return this.emoji;
            }

            public final String getStatusText() {
                return this.statusText;
            }

            public int hashCode() {
                Emoji emoji = this.emoji;
                int iHashCode = (emoji != null ? emoji.hashCode() : 0) * 31;
                String str = this.statusText;
                return iHashCode + (str != null ? str.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("WithStatus(emoji=");
                sbU.append(this.emoji);
                sbU.append(", statusText=");
                return outline.J(sbU, this.statusText, ")");
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: UserStatusPresenceCustomView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/facebook/imagepipeline/request/ImageRequestBuilder;", "it", "", "invoke", "(Lcom/facebook/imagepipeline/request/ImageRequestBuilder;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.profile.UserStatusPresenceCustomView$configurePlaceholderEmoji$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ImageRequestBuilder, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ImageRequestBuilder imageRequestBuilder) {
            invoke2(imageRequestBuilder);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ImageRequestBuilder imageRequestBuilder) {
            Intrinsics3.checkNotNullParameter(imageRequestBuilder, "it");
            imageRequestBuilder.l = UserStatusPresenceCustomView.access$getCUSTOM_EMOJI_PLACEHOLDER_POSTPROCESSOR$cp();
        }
    }

    /* compiled from: UserStatusPresenceCustomView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.profile.UserStatusPresenceCustomView$setOnClear$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Function0 $onClear;

        public AnonymousClass1(Function0 function0) {
            this.$onClear = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onClear.invoke();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserStatusPresenceCustomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrs");
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.view_user_status_presence_custom, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R.id.user_status_presence_custom_clear;
        AppCompatImageView appCompatImageView = (AppCompatImageView) viewInflate.findViewById(R.id.user_status_presence_custom_clear);
        if (appCompatImageView != null) {
            i = R.id.user_status_presence_custom_emoji;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(R.id.user_status_presence_custom_emoji);
            if (simpleDraweeView != null) {
                i = R.id.user_status_presence_custom_text;
                TextView textView = (TextView) viewInflate.findViewById(R.id.user_status_presence_custom_text);
                if (textView != null) {
                    ViewUserStatusPresenceCustomBinding viewUserStatusPresenceCustomBinding = new ViewUserStatusPresenceCustomBinding((LinearLayout) viewInflate, appCompatImageView, simpleDraweeView, textView);
                    Intrinsics3.checkNotNullExpressionValue(viewUserStatusPresenceCustomBinding, "ViewUserStatusPresenceCu…rom(context), this, true)");
                    this.binding = viewUserStatusPresenceCustomBinding;
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ GrayscalePostprocessor access$getCUSTOM_EMOJI_PLACEHOLDER_POSTPROCESSOR$cp() {
        return CUSTOM_EMOJI_PLACEHOLDER_POSTPROCESSOR;
    }

    private final void configurePlaceholderEmoji(ModelEmojiUnicode placeholderEmoji) {
        SimpleDraweeView simpleDraweeView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.userStatusPresenceCustomEmoji");
        MGImages.setImage$default(simpleDraweeView, ModelEmojiUnicode.getImageUri(placeholderEmoji.getCodePoints(), getContext()), 0, 0, false, AnonymousClass1.INSTANCE, null, 92, null);
        SimpleDraweeView simpleDraweeView2 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.userStatusPresenceCustomEmoji");
        simpleDraweeView2.setVisibility(0);
    }

    private final void configureStatusEmoji(Emoji emoji) {
        String imageUri = null;
        if (emoji != null) {
            if (emoji.getId() != null) {
                imageUri = ModelEmojiCustom.getImageUri(Long.parseLong(emoji.getId()), emoji.isAnimated(), IconUtils.getMediaProxySize(getResources().getDimensionPixelSize(R.dimen.custom_status_emoji_preview_size)));
            } else {
                ModelEmojiUnicode modelEmojiUnicode = StoreStream.INSTANCE.getEmojis().getUnicodeEmojiSurrogateMap().get(emoji.getName());
                if (modelEmojiUnicode != null) {
                    imageUri = ModelEmojiUnicode.getImageUri(modelEmojiUnicode.getCodePoints(), getContext());
                }
            }
        }
        SimpleDraweeView simpleDraweeView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.userStatusPresenceCustomEmoji");
        MGImages.setImage$default(simpleDraweeView, imageUri, 0, 0, false, null, null, 124, null);
        SimpleDraweeView simpleDraweeView2 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.userStatusPresenceCustomEmoji");
        simpleDraweeView2.setVisibility(imageUri != null ? 0 : 8);
    }

    public final void setOnClear(Function0<Unit> onClear) {
        Intrinsics3.checkNotNullParameter(onClear, "onClear");
        this.binding.f2216b.setOnClickListener(new AnonymousClass1(onClear));
    }

    public final void updateViewState(ViewState viewState) {
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        if (!(viewState instanceof ViewState.WithStatus)) {
            if (viewState instanceof ViewState.WithPlaceholder) {
                configurePlaceholderEmoji(((ViewState.WithPlaceholder) viewState).getPlaceholderEmoji());
                this.binding.d.setText(R.string.custom_status_set_custom_status);
                AppCompatImageView appCompatImageView = this.binding.f2216b;
                Intrinsics3.checkNotNullExpressionValue(appCompatImageView, "binding.userStatusPresenceCustomClear");
                appCompatImageView.setVisibility(8);
                return;
            }
            return;
        }
        ViewState.WithStatus withStatus = (ViewState.WithStatus) viewState;
        configureStatusEmoji(withStatus.getEmoji());
        TextView textView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.userStatusPresenceCustomText");
        textView.setText(withStatus.getStatusText());
        AppCompatImageView appCompatImageView2 = this.binding.f2216b;
        Intrinsics3.checkNotNullExpressionValue(appCompatImageView2, "binding.userStatusPresenceCustomClear");
        appCompatImageView2.setVisibility(0);
    }
}
