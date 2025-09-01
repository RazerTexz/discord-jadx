package com.discord.widgets.chat;

import android.content.Context;
import android.content.pm.ShortcutManager;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.content.pm.ShortcutManagerCompat;
import b.d.b.a.outline;
import com.discord.api.message.MessageReference;
import com.discord.api.message.allowedmentions.MessageAllowedMentions;
import com.discord.api.message.allowedmentions.MessageAllowedMentions2;
import com.discord.api.sticker.BaseSticker;
import com.discord.api.user.User;
import com.discord.models.guild.Guild;
import com.discord.models.message.Message;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreApplicationInteractions;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreMessageReplies;
import com.discord.stores.StoreMessages;
import com.discord.stores.StorePendingReplies;
import com.discord.stores.StoreSlowMode;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.error.Error;
import com.discord.utilities.messagesend.MessageQueue4;
import com.discord.utilities.rest.SendUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.chat.input.models.ApplicationCommandData;
import com.lytefast.flexinput.model.Attachment;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t._Arrays;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Func2;

/* compiled from: MessageManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0004XYZ[B_\u0012\u0006\u0010Q\u001a\u00020P\u0012\b\b\u0002\u0010C\u001a\u00020B\u0012\b\b\u0002\u0010:\u001a\u000209\u0012\b\b\u0002\u0010@\u001a\u00020?\u0012\b\b\u0002\u0010F\u001a\u00020E\u0012\b\b\u0002\u0010T\u001a\u00020S\u0012\b\b\u0002\u0010I\u001a\u00020H\u0012\b\b\u0002\u0010L\u001a\u00020K\u0012\b\b\u0002\u0010=\u001a\u00020<¢\u0006\u0004\bV\u0010WJA\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J)\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\n\u0010\u0017\u001a\u00060\u0015j\u0002`\u00162\n\u0010\u0019\u001a\u00060\u0015j\u0002`\u0018H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJY\u0010!\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u001a\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d2\u001a\u0010 \u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d¢\u0006\u0004\b!\u0010\"J³\u0001\u0010)\u001a\u00020\t2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u00042\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0010\b\u0002\u0010\u0017\u001a\n\u0018\u00010\u0015j\u0004\u0018\u0001`\u00162\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010%\u001a\u00020\t2\u001c\b\u0002\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d2\u001c\b\u0002\u0010 \u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d2\u0014\b\u0002\u0010(\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u001e0&¢\u0006\u0004\b)\u0010*JW\u0010+\u001a\u00020\t2\n\u0010\u0019\u001a\u00060\u0015j\u0002`\u00182\n\u0010\u0017\u001a\u00060\u0015j\u0002`\u00162\u0006\u0010\u0003\u001a\u00020\u00022\u001c\b\u0002\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b+\u0010,J\u0087\u0001\u00107\u001a\u00020\t2\n\u0010\u0017\u001a\u00060\u0015j\u0002`\u00162\u000e\u0010.\u001a\n\u0018\u00010\u0015j\u0004\u0018\u0001`-2\b\u0010/\u001a\u0004\u0018\u00010\u00022\u0006\u00101\u001a\u0002002\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00102\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u001e032\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020\u001e0&2\u001c\b\u0002\u0010 \u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d¢\u0006\u0004\b7\u00108R\u0016\u0010:\u001a\u0002098\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010=\u001a\u00020<8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010@\u001a\u00020?8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010C\u001a\u00020B8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010F\u001a\u00020E8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010I\u001a\u00020H8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010L\u001a\u00020K8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\"\u0010N\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u001e0&8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010Q\u001a\u00020P8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010T\u001a\u00020S8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010U¨\u0006\\"}, d2 = {"Lcom/discord/widgets/chat/MessageManager;", "", "", "content", "", "Lcom/discord/api/sticker/BaseSticker;", "stickers", "Lcom/discord/models/user/MeUser;", "meUser", "", "isEditing", "", "previousMessageLength", "Lcom/discord/widgets/chat/MessageManager$ContentValidationResult;", "validateMessageContent", "(Ljava/lang/String;Ljava/util/List;Lcom/discord/models/user/MeUser;ZLjava/lang/Integer;)Lcom/discord/widgets/chat/MessageManager$ContentValidationResult;", "Lcom/discord/widgets/chat/MessageManager$AttachmentsRequest;", "attachmentsRequest", "Lcom/discord/widgets/chat/MessageManager$AttachmentValidationResult;", "validateAttachments", "(Lcom/discord/widgets/chat/MessageManager$AttachmentsRequest;)Lcom/discord/widgets/chat/MessageManager$AttachmentValidationResult;", "", "Lcom/discord/primitives/ChannelId;", "channelId", "Lcom/discord/primitives/MessageId;", "messageId", "Lcom/discord/api/message/allowedmentions/MessageAllowedMentions;", "getAllowedMentionsForMessageEdit", "(JJ)Lcom/discord/api/message/allowedmentions/MessageAllowedMentions;", "Lkotlin/Function2;", "", "onMessageTooLong", "onFilesTooLarge", "isValidForumPostFirstMessage", "(Ljava/lang/String;Lcom/discord/widgets/chat/MessageManager$AttachmentsRequest;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)Z", "Lcom/discord/models/user/User;", "mentions", "consumePendingReply", "Lkotlin/Function1;", "Lcom/discord/widgets/chat/MessageManager$MessageSendResult;", "messageSendResultHandler", "sendMessage", "(Ljava/lang/String;Ljava/util/List;Lcom/discord/widgets/chat/MessageManager$AttachmentsRequest;Ljava/lang/Long;Ljava/util/List;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)Z", "editMessage", "(JJLjava/lang/String;Lkotlin/jvm/functions/Function2;Ljava/lang/Integer;)Z", "Lcom/discord/primitives/GuildId;", "guildId", "version", "Lcom/discord/widgets/chat/input/models/ApplicationCommandData;", "data", "attachmentRequest", "Lkotlin/Function0;", "onSuccess", "Lcom/discord/utilities/error/Error;", "onFail", "sendCommand", "(JLjava/lang/Long;Ljava/lang/String;Lcom/discord/widgets/chat/input/models/ApplicationCommandData;Lcom/discord/widgets/chat/MessageManager$AttachmentsRequest;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Z", "Lcom/discord/stores/StoreApplicationInteractions;", "storeApplicationInteractions", "Lcom/discord/stores/StoreApplicationInteractions;", "Lcom/discord/stores/StoreMessageReplies;", "storeMessageReplies", "Lcom/discord/stores/StoreMessageReplies;", "Lcom/discord/stores/StoreUser;", "storeUser", "Lcom/discord/stores/StoreUser;", "Lcom/discord/stores/StoreMessages;", "storeMessages", "Lcom/discord/stores/StoreMessages;", "Lcom/discord/stores/StoreChannelsSelected;", "storeChannelsSelected", "Lcom/discord/stores/StoreChannelsSelected;", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "Lcom/discord/stores/StoreGuilds;", "Lcom/discord/stores/StorePendingReplies;", "storePendingReplies", "Lcom/discord/stores/StorePendingReplies;", "defaultMessageResultHandler", "Lkotlin/jvm/functions/Function1;", "Landroid/content/Context;", "context", "Landroid/content/Context;", "Lcom/discord/stores/StoreSlowMode;", "storeSlowMode", "Lcom/discord/stores/StoreSlowMode;", "<init>", "(Landroid/content/Context;Lcom/discord/stores/StoreMessages;Lcom/discord/stores/StoreApplicationInteractions;Lcom/discord/stores/StoreUser;Lcom/discord/stores/StoreChannelsSelected;Lcom/discord/stores/StoreSlowMode;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StorePendingReplies;Lcom/discord/stores/StoreMessageReplies;)V", "AttachmentValidationResult", "AttachmentsRequest", "ContentValidationResult", "MessageSendResult", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class MessageManager {
    private final Context context;
    private final Function1<MessageSendResult, Unit> defaultMessageResultHandler;
    private final StoreApplicationInteractions storeApplicationInteractions;
    private final StoreChannelsSelected storeChannelsSelected;
    private final StoreGuilds storeGuilds;
    private final StoreMessageReplies storeMessageReplies;
    private final StoreMessages storeMessages;
    private final StorePendingReplies storePendingReplies;
    private final StoreSlowMode storeSlowMode;
    private final StoreUser storeUser;

    /* compiled from: MessageManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/discord/widgets/chat/MessageManager$AttachmentValidationResult;", "", "<init>", "()V", "EmptyAttachments", "FilesTooLarge", "Success", "Lcom/discord/widgets/chat/MessageManager$AttachmentValidationResult$EmptyAttachments;", "Lcom/discord/widgets/chat/MessageManager$AttachmentValidationResult$FilesTooLarge;", "Lcom/discord/widgets/chat/MessageManager$AttachmentValidationResult$Success;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class AttachmentValidationResult {

        /* compiled from: MessageManager.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/chat/MessageManager$AttachmentValidationResult$EmptyAttachments;", "Lcom/discord/widgets/chat/MessageManager$AttachmentValidationResult;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class EmptyAttachments extends AttachmentValidationResult {
            public static final EmptyAttachments INSTANCE = new EmptyAttachments();

            private EmptyAttachments() {
                super(null);
            }
        }

        /* compiled from: MessageManager.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/chat/MessageManager$AttachmentValidationResult$FilesTooLarge;", "Lcom/discord/widgets/chat/MessageManager$AttachmentValidationResult;", "Lcom/discord/widgets/chat/MessageManager$AttachmentsRequest;", "component1", "()Lcom/discord/widgets/chat/MessageManager$AttachmentsRequest;", "attachmentsRequest", "copy", "(Lcom/discord/widgets/chat/MessageManager$AttachmentsRequest;)Lcom/discord/widgets/chat/MessageManager$AttachmentValidationResult$FilesTooLarge;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/chat/MessageManager$AttachmentsRequest;", "getAttachmentsRequest", "<init>", "(Lcom/discord/widgets/chat/MessageManager$AttachmentsRequest;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class FilesTooLarge extends AttachmentValidationResult {
            private final AttachmentsRequest attachmentsRequest;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FilesTooLarge(AttachmentsRequest attachmentsRequest) {
                super(null);
                Intrinsics3.checkNotNullParameter(attachmentsRequest, "attachmentsRequest");
                this.attachmentsRequest = attachmentsRequest;
            }

            public static /* synthetic */ FilesTooLarge copy$default(FilesTooLarge filesTooLarge, AttachmentsRequest attachmentsRequest, int i, Object obj) {
                if ((i & 1) != 0) {
                    attachmentsRequest = filesTooLarge.attachmentsRequest;
                }
                return filesTooLarge.copy(attachmentsRequest);
            }

            /* renamed from: component1, reason: from getter */
            public final AttachmentsRequest getAttachmentsRequest() {
                return this.attachmentsRequest;
            }

            public final FilesTooLarge copy(AttachmentsRequest attachmentsRequest) {
                Intrinsics3.checkNotNullParameter(attachmentsRequest, "attachmentsRequest");
                return new FilesTooLarge(attachmentsRequest);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof FilesTooLarge) && Intrinsics3.areEqual(this.attachmentsRequest, ((FilesTooLarge) other).attachmentsRequest);
                }
                return true;
            }

            public final AttachmentsRequest getAttachmentsRequest() {
                return this.attachmentsRequest;
            }

            public int hashCode() {
                AttachmentsRequest attachmentsRequest = this.attachmentsRequest;
                if (attachmentsRequest != null) {
                    return attachmentsRequest.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("FilesTooLarge(attachmentsRequest=");
                sbU.append(this.attachmentsRequest);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: MessageManager.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/chat/MessageManager$AttachmentValidationResult$Success;", "Lcom/discord/widgets/chat/MessageManager$AttachmentValidationResult;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Success extends AttachmentValidationResult {
            public static final Success INSTANCE = new Success();

            private Success() {
                super(null);
            }
        }

        private AttachmentValidationResult() {
        }

        public /* synthetic */ AttachmentValidationResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: MessageManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0018\u00010\f¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR%\u0010\u000e\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/discord/widgets/chat/MessageManager$AttachmentsRequest;", "", "", "maxFileSizeMB", "I", "getMaxFileSizeMB", "()I", "", "currentFileSizeMB", "F", "getCurrentFileSizeMB", "()F", "", "Lcom/lytefast/flexinput/model/Attachment;", "attachments", "Ljava/util/List;", "getAttachments", "()Ljava/util/List;", "<init>", "(FILjava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class AttachmentsRequest {
        private final List<Attachment<?>> attachments;
        private final float currentFileSizeMB;
        private final int maxFileSizeMB;

        /* JADX WARN: Multi-variable type inference failed */
        public AttachmentsRequest(float f, int i, List<? extends Attachment<?>> list) {
            this.currentFileSizeMB = f;
            this.maxFileSizeMB = i;
            this.attachments = list;
        }

        public final List<Attachment<?>> getAttachments() {
            return this.attachments;
        }

        public final float getCurrentFileSizeMB() {
            return this.currentFileSizeMB;
        }

        public final int getMaxFileSizeMB() {
            return this.maxFileSizeMB;
        }

        public /* synthetic */ AttachmentsRequest(float f, int i, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(f, i, (i2 & 4) != 0 ? null : list);
        }
    }

    /* compiled from: MessageManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/discord/widgets/chat/MessageManager$ContentValidationResult;", "", "<init>", "()V", "EmptyContent", "MessageTooLong", "Success", "Lcom/discord/widgets/chat/MessageManager$ContentValidationResult$EmptyContent;", "Lcom/discord/widgets/chat/MessageManager$ContentValidationResult$MessageTooLong;", "Lcom/discord/widgets/chat/MessageManager$ContentValidationResult$Success;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ContentValidationResult {

        /* compiled from: MessageManager.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/chat/MessageManager$ContentValidationResult$EmptyContent;", "Lcom/discord/widgets/chat/MessageManager$ContentValidationResult;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class EmptyContent extends ContentValidationResult {
            public static final EmptyContent INSTANCE = new EmptyContent();

            private EmptyContent() {
                super(null);
            }
        }

        /* compiled from: MessageManager.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\u0004J\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/chat/MessageManager$ContentValidationResult$MessageTooLong;", "Lcom/discord/widgets/chat/MessageManager$ContentValidationResult;", "", "component1", "()I", "maxMessageLength", "copy", "(I)Lcom/discord/widgets/chat/MessageManager$ContentValidationResult$MessageTooLong;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getMaxMessageLength", "<init>", "(I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class MessageTooLong extends ContentValidationResult {
            private final int maxMessageLength;

            public MessageTooLong(int i) {
                super(null);
                this.maxMessageLength = i;
            }

            public static /* synthetic */ MessageTooLong copy$default(MessageTooLong messageTooLong, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = messageTooLong.maxMessageLength;
                }
                return messageTooLong.copy(i);
            }

            /* renamed from: component1, reason: from getter */
            public final int getMaxMessageLength() {
                return this.maxMessageLength;
            }

            public final MessageTooLong copy(int maxMessageLength) {
                return new MessageTooLong(maxMessageLength);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof MessageTooLong) && this.maxMessageLength == ((MessageTooLong) other).maxMessageLength;
                }
                return true;
            }

            public final int getMaxMessageLength() {
                return this.maxMessageLength;
            }

            public int hashCode() {
                return this.maxMessageLength;
            }

            public String toString() {
                return outline.B(outline.U("MessageTooLong(maxMessageLength="), this.maxMessageLength, ")");
            }
        }

        /* compiled from: MessageManager.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/chat/MessageManager$ContentValidationResult$Success;", "Lcom/discord/widgets/chat/MessageManager$ContentValidationResult;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Success extends ContentValidationResult {
            public static final Success INSTANCE = new Success();

            private Success() {
                super(null);
            }
        }

        private ContentValidationResult() {
        }

        public /* synthetic */ ContentValidationResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: MessageManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001c"}, d2 = {"Lcom/discord/widgets/chat/MessageManager$MessageSendResult;", "", "Lcom/discord/utilities/messagesend/MessageResult;", "component1", "()Lcom/discord/utilities/messagesend/MessageResult;", "Lcom/discord/models/guild/Guild;", "component2", "()Lcom/discord/models/guild/Guild;", "messageResult", "guild", "copy", "(Lcom/discord/utilities/messagesend/MessageResult;Lcom/discord/models/guild/Guild;)Lcom/discord/widgets/chat/MessageManager$MessageSendResult;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/guild/Guild;", "getGuild", "Lcom/discord/utilities/messagesend/MessageResult;", "getMessageResult", "<init>", "(Lcom/discord/utilities/messagesend/MessageResult;Lcom/discord/models/guild/Guild;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class MessageSendResult {
        private final Guild guild;
        private final MessageQueue4 messageResult;

        public MessageSendResult(MessageQueue4 messageQueue4, Guild guild) {
            Intrinsics3.checkNotNullParameter(messageQueue4, "messageResult");
            this.messageResult = messageQueue4;
            this.guild = guild;
        }

        public static /* synthetic */ MessageSendResult copy$default(MessageSendResult messageSendResult, MessageQueue4 messageQueue4, Guild guild, int i, Object obj) {
            if ((i & 1) != 0) {
                messageQueue4 = messageSendResult.messageResult;
            }
            if ((i & 2) != 0) {
                guild = messageSendResult.guild;
            }
            return messageSendResult.copy(messageQueue4, guild);
        }

        /* renamed from: component1, reason: from getter */
        public final MessageQueue4 getMessageResult() {
            return this.messageResult;
        }

        /* renamed from: component2, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        public final MessageSendResult copy(MessageQueue4 messageResult, Guild guild) {
            Intrinsics3.checkNotNullParameter(messageResult, "messageResult");
            return new MessageSendResult(messageResult, guild);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MessageSendResult)) {
                return false;
            }
            MessageSendResult messageSendResult = (MessageSendResult) other;
            return Intrinsics3.areEqual(this.messageResult, messageSendResult.messageResult) && Intrinsics3.areEqual(this.guild, messageSendResult.guild);
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final MessageQueue4 getMessageResult() {
            return this.messageResult;
        }

        public int hashCode() {
            MessageQueue4 messageQueue4 = this.messageResult;
            int iHashCode = (messageQueue4 != null ? messageQueue4.hashCode() : 0) * 31;
            Guild guild = this.guild;
            return iHashCode + (guild != null ? guild.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("MessageSendResult(messageResult=");
            sbU.append(this.messageResult);
            sbU.append(", guild=");
            sbU.append(this.guild);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: MessageManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.MessageManager$sendCommand$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    }

    /* compiled from: MessageManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.MessageManager$sendCommand$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
        }
    }

    /* compiled from: MessageManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\n \u0001*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/discord/utilities/messagesend/MessageResult;", "kotlin.jvm.PlatformType", "messageResult", "Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/widgets/chat/MessageManager$MessageSendResult;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/utilities/messagesend/MessageResult;Lcom/discord/models/guild/Guild;)Lcom/discord/widgets/chat/MessageManager$MessageSendResult;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.MessageManager$sendMessage$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, R> implements Func2<MessageQueue4, Guild, MessageSendResult> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ MessageSendResult call(MessageQueue4 messageQueue4, Guild guild) {
            return call2(messageQueue4, guild);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final MessageSendResult call2(MessageQueue4 messageQueue4, Guild guild) {
            Intrinsics3.checkNotNullExpressionValue(messageQueue4, "messageResult");
            return new MessageSendResult(messageQueue4, guild);
        }
    }

    /* compiled from: MessageManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/chat/MessageManager$MessageSendResult;", "kotlin.jvm.PlatformType", "messageSendResult", "", "invoke", "(Lcom/discord/widgets/chat/MessageManager$MessageSendResult;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.MessageManager$sendMessage$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<MessageSendResult, Unit> {
        public final /* synthetic */ Function1 $messageSendResultHandler;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Function1 function1) {
            super(1);
            this.$messageSendResultHandler = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MessageSendResult messageSendResult) {
            invoke2(messageSendResult);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MessageSendResult messageSendResult) {
            Function1 function1 = this.$messageSendResultHandler;
            Intrinsics3.checkNotNullExpressionValue(messageSendResult, "messageSendResult");
            function1.invoke(messageSendResult);
        }
    }

    public MessageManager(Context context, StoreMessages storeMessages, StoreApplicationInteractions storeApplicationInteractions, StoreUser storeUser, StoreChannelsSelected storeChannelsSelected, StoreSlowMode storeSlowMode, StoreGuilds storeGuilds, StorePendingReplies storePendingReplies, StoreMessageReplies storeMessageReplies) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(storeMessages, "storeMessages");
        Intrinsics3.checkNotNullParameter(storeApplicationInteractions, "storeApplicationInteractions");
        Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
        Intrinsics3.checkNotNullParameter(storeChannelsSelected, "storeChannelsSelected");
        Intrinsics3.checkNotNullParameter(storeSlowMode, "storeSlowMode");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        Intrinsics3.checkNotNullParameter(storePendingReplies, "storePendingReplies");
        Intrinsics3.checkNotNullParameter(storeMessageReplies, "storeMessageReplies");
        this.context = context;
        this.storeMessages = storeMessages;
        this.storeApplicationInteractions = storeApplicationInteractions;
        this.storeUser = storeUser;
        this.storeChannelsSelected = storeChannelsSelected;
        this.storeSlowMode = storeSlowMode;
        this.storeGuilds = storeGuilds;
        this.storePendingReplies = storePendingReplies;
        this.storeMessageReplies = storeMessageReplies;
        this.defaultMessageResultHandler = new MessageManager2(this);
    }

    public static final /* synthetic */ Context access$getContext$p(MessageManager messageManager) {
        return messageManager.context;
    }

    public static final /* synthetic */ StoreMessages access$getStoreMessages$p(MessageManager messageManager) {
        return messageManager.storeMessages;
    }

    public static final /* synthetic */ StorePendingReplies access$getStorePendingReplies$p(MessageManager messageManager) {
        return messageManager.storePendingReplies;
    }

    public static /* synthetic */ boolean editMessage$default(MessageManager messageManager, long j, long j2, String str, Function2 function2, Integer num, int i, Object obj) {
        return messageManager.editMessage(j, j2, str, (i & 8) != 0 ? null : function2, (i & 16) != 0 ? null : num);
    }

    private final MessageAllowedMentions getAllowedMentionsForMessageEdit(long channelId, long messageId) {
        Integer type;
        MessageReference messageReference;
        Long messageId2;
        Message message = this.storeMessages.getMessage(channelId, messageId);
        if (message != null && (type = message.getType()) != null && type.intValue() == 19 && (messageReference = message.getMessageReference()) != null && (messageId2 = messageReference.getMessageId()) != null) {
            StoreMessageReplies.MessageState messageState = this.storeMessageReplies.getAllMessageReferences().get(Long.valueOf(messageId2.longValue()));
            if (messageState == null || !(messageState instanceof StoreMessageReplies.MessageState.Loaded)) {
                return null;
            }
            List<User> mentions = message.getMentions();
            if (mentions != null) {
                boolean z2 = false;
                if (!mentions.isEmpty()) {
                    Iterator<T> it = mentions.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        long id2 = ((User) it.next()).getId();
                        User author = ((StoreMessageReplies.MessageState.Loaded) messageState).getMessage().getAuthor();
                        if (author != null && id2 == author.getId()) {
                            z2 = true;
                            break;
                        }
                    }
                }
                if (z2) {
                    return null;
                }
            }
            return new MessageAllowedMentions(_Arrays.toList(MessageAllowedMentions2.values()), null, null, Boolean.FALSE, 6);
        }
        return null;
    }

    public static /* synthetic */ boolean isValidForumPostFirstMessage$default(MessageManager messageManager, String str, AttachmentsRequest attachmentsRequest, Function2 function2, Function2 function22, int i, Object obj) {
        if ((i & 2) != 0) {
            attachmentsRequest = null;
        }
        return messageManager.isValidForumPostFirstMessage(str, attachmentsRequest, function2, function22);
    }

    public static /* synthetic */ boolean sendCommand$default(MessageManager messageManager, long j, Long l, String str, ApplicationCommandData applicationCommandData, AttachmentsRequest attachmentsRequest, Function0 function0, Function1 function1, Function2 function2, int i, Object obj) {
        return messageManager.sendCommand(j, l, str, applicationCommandData, (i & 16) != 0 ? null : attachmentsRequest, function0, function1, (i & 128) != 0 ? null : function2);
    }

    public static /* synthetic */ boolean sendMessage$default(MessageManager messageManager, String str, List list, AttachmentsRequest attachmentsRequest, Long l, List list2, boolean z2, Function2 function2, Function2 function22, Function1 function1, int i, Object obj) {
        return messageManager.sendMessage((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : attachmentsRequest, (i & 8) != 0 ? null : l, (i & 16) != 0 ? Collections2.emptyList() : list2, (i & 32) != 0 ? true : z2, (i & 64) != 0 ? null : function2, (i & 128) == 0 ? function22 : null, (i & 256) != 0 ? messageManager.defaultMessageResultHandler : function1);
    }

    private final AttachmentValidationResult validateAttachments(AttachmentsRequest attachmentsRequest) {
        if (attachmentsRequest == null) {
            return AttachmentValidationResult.EmptyAttachments.INSTANCE;
        }
        List<Attachment<?>> attachments = attachmentsRequest.getAttachments();
        return (attachments == null || attachments.isEmpty()) ? AttachmentValidationResult.EmptyAttachments.INSTANCE : attachmentsRequest.getCurrentFileSizeMB() >= ((float) attachmentsRequest.getMaxFileSizeMB()) ? new AttachmentValidationResult.FilesTooLarge(attachmentsRequest) : AttachmentValidationResult.Success.INSTANCE;
    }

    private final ContentValidationResult validateMessageContent(String content, List<? extends BaseSticker> stickers, MeUser meUser, boolean isEditing, Integer previousMessageLength) {
        boolean z2 = true;
        int i = (UserUtils.INSTANCE.isPremiumTier2(meUser) || (isEditing && previousMessageLength != null && previousMessageLength.intValue() > 2000)) ? SendUtils.MAX_MESSAGE_CHARACTER_COUNT_PREMIUM : 2000;
        if (content.length() == 0) {
            if (stickers != null && !stickers.isEmpty()) {
                z2 = false;
            }
            if (z2) {
                return ContentValidationResult.EmptyContent.INSTANCE;
            }
        }
        return content.length() > i ? new ContentValidationResult.MessageTooLong(i) : ContentValidationResult.Success.INSTANCE;
    }

    public static /* synthetic */ ContentValidationResult validateMessageContent$default(MessageManager messageManager, String str, List list, MeUser meUser, boolean z2, Integer num, int i, Object obj) {
        if ((i & 16) != 0) {
            num = null;
        }
        return messageManager.validateMessageContent(str, list, meUser, z2, num);
    }

    public final boolean editMessage(long messageId, long channelId, String content, Function2<? super Integer, ? super Integer, Unit> onMessageTooLong, Integer previousMessageLength) {
        Intrinsics3.checkNotNullParameter(content, "content");
        ContentValidationResult contentValidationResultValidateMessageContent = validateMessageContent(content, Collections2.emptyList(), this.storeUser.getMeSnapshot(), true, previousMessageLength);
        if (contentValidationResultValidateMessageContent instanceof ContentValidationResult.MessageTooLong) {
            if (onMessageTooLong != null) {
                onMessageTooLong.invoke(Integer.valueOf(content.length()), Integer.valueOf(((ContentValidationResult.MessageTooLong) contentValidationResultValidateMessageContent).getMaxMessageLength()));
            }
            return false;
        }
        if (Intrinsics3.areEqual(contentValidationResultValidateMessageContent, ContentValidationResult.EmptyContent.INSTANCE)) {
            return false;
        }
        Intrinsics3.areEqual(contentValidationResultValidateMessageContent, ContentValidationResult.Success.INSTANCE);
        this.storeMessages.editMessage(messageId, channelId, content, getAllowedMentionsForMessageEdit(channelId, messageId));
        return true;
    }

    public final boolean isValidForumPostFirstMessage(String content, AttachmentsRequest attachmentsRequest, Function2<? super Integer, ? super Integer, Unit> onMessageTooLong, Function2<? super Integer, ? super Boolean, Unit> onFilesTooLarge) {
        Intrinsics3.checkNotNullParameter(content, "content");
        MeUser meSnapshot = this.storeUser.getMeSnapshot();
        ContentValidationResult contentValidationResultValidateMessageContent$default = validateMessageContent$default(this, content, Collections2.emptyList(), meSnapshot, false, null, 16, null);
        if (contentValidationResultValidateMessageContent$default instanceof ContentValidationResult.MessageTooLong) {
            if (onMessageTooLong != null) {
                onMessageTooLong.invoke(Integer.valueOf(content.length()), Integer.valueOf(((ContentValidationResult.MessageTooLong) contentValidationResultValidateMessageContent$default).getMaxMessageLength()));
            }
            return false;
        }
        AttachmentValidationResult attachmentValidationResultValidateAttachments = validateAttachments(attachmentsRequest);
        if (!(attachmentValidationResultValidateAttachments instanceof AttachmentValidationResult.FilesTooLarge)) {
            return true;
        }
        if (onFilesTooLarge != null) {
            onFilesTooLarge.invoke(Integer.valueOf(((AttachmentValidationResult.FilesTooLarge) attachmentValidationResultValidateAttachments).getAttachmentsRequest().getMaxFileSizeMB()), Boolean.valueOf(UserUtils.INSTANCE.isPremium(meSnapshot)));
        }
        return false;
    }

    public final boolean sendCommand(long channelId, Long guildId, String version, ApplicationCommandData data, AttachmentsRequest attachmentRequest, Function0<Unit> onSuccess, Function1<? super Error, Unit> onFail, Function2<? super Integer, ? super Boolean, Unit> onFilesTooLarge) {
        Intrinsics3.checkNotNullParameter(data, "data");
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics3.checkNotNullParameter(onFail, "onFail");
        MeUser meSnapshot = this.storeUser.getMeSnapshot();
        AttachmentValidationResult attachmentValidationResultValidateAttachments = validateAttachments(attachmentRequest);
        if (!(attachmentValidationResultValidateAttachments instanceof AttachmentValidationResult.FilesTooLarge)) {
            this.storeApplicationInteractions.sendApplicationCommand(channelId, guildId, version, data, attachmentRequest != null ? attachmentRequest.getAttachments() : null, AnonymousClass1.INSTANCE, AnonymousClass2.INSTANCE);
            return true;
        }
        AttachmentsRequest attachmentsRequest = ((AttachmentValidationResult.FilesTooLarge) attachmentValidationResultValidateAttachments).getAttachmentsRequest();
        if (onFilesTooLarge == null) {
            return false;
        }
        onFilesTooLarge.invoke(Integer.valueOf(attachmentsRequest.getMaxFileSizeMB()), Boolean.valueOf(UserUtils.INSTANCE.isPremium(meSnapshot)));
        return false;
    }

    public final boolean sendMessage(String content, List<? extends com.discord.models.user.User> mentions, AttachmentsRequest attachmentsRequest, Long channelId, List<? extends BaseSticker> stickers, boolean consumePendingReply, Function2<? super Integer, ? super Integer, Unit> onMessageTooLong, Function2<? super Integer, ? super Boolean, Unit> onFilesTooLarge, Function1<? super MessageSendResult, Unit> messageSendResultHandler) {
        ShortcutManager shortcutManager;
        Intrinsics3.checkNotNullParameter(content, "content");
        Intrinsics3.checkNotNullParameter(stickers, "stickers");
        Intrinsics3.checkNotNullParameter(messageSendResultHandler, "messageSendResultHandler");
        MeUser meSnapshot = this.storeUser.getMeSnapshot();
        ContentValidationResult contentValidationResultValidateMessageContent$default = validateMessageContent$default(this, content, stickers, meSnapshot, false, null, 16, null);
        if (contentValidationResultValidateMessageContent$default instanceof ContentValidationResult.MessageTooLong) {
            if (onMessageTooLong != null) {
                onMessageTooLong.invoke(Integer.valueOf(content.length()), Integer.valueOf(((ContentValidationResult.MessageTooLong) contentValidationResultValidateMessageContent$default).getMaxMessageLength()));
            }
            return false;
        }
        AttachmentValidationResult attachmentValidationResultValidateAttachments = validateAttachments(attachmentsRequest);
        if (attachmentValidationResultValidateAttachments instanceof AttachmentValidationResult.FilesTooLarge) {
            AttachmentsRequest attachmentsRequest2 = ((AttachmentValidationResult.FilesTooLarge) attachmentValidationResultValidateAttachments).getAttachmentsRequest();
            if (onFilesTooLarge != null) {
                onFilesTooLarge.invoke(Integer.valueOf(attachmentsRequest2.getMaxFileSizeMB()), Boolean.valueOf(UserUtils.INSTANCE.isPremium(meSnapshot)));
            }
            return false;
        }
        List<Attachment<?>> attachments = attachmentsRequest != null ? attachmentsRequest.getAttachments() : null;
        long jLongValue = channelId != null ? channelId.longValue() : this.storeChannelsSelected.getId();
        if (Build.VERSION.SDK_INT >= 25) {
            List<ShortcutInfoCompat> dynamicShortcuts = ShortcutManagerCompat.getDynamicShortcuts(this.context);
            Intrinsics3.checkNotNullExpressionValue(dynamicShortcuts, "ShortcutManagerCompat.getDynamicShortcuts(context)");
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(dynamicShortcuts, 10));
            for (ShortcutInfoCompat shortcutInfoCompat : dynamicShortcuts) {
                Intrinsics3.checkNotNullExpressionValue(shortcutInfoCompat, "it");
                arrayList.add(shortcutInfoCompat.getId());
            }
            if (_Collections.toSet(arrayList).contains(String.valueOf(jLongValue)) && (shortcutManager = (ShortcutManager) this.context.getSystemService(ShortcutManager.class)) != null) {
                shortcutManager.reportShortcutUsed(String.valueOf(jLongValue));
            }
        }
        StorePendingReplies.PendingReply pendingReply = consumePendingReply ? this.storePendingReplies.getPendingReply(jLongValue) : null;
        Observable observableZ = Observable.j(this.storeSlowMode.observeCooldownSecs(channelId, StoreSlowMode.Type.MessageSend.INSTANCE).Z(1).Y(new MessageManager3(this, pendingReply, jLongValue, meSnapshot, content, mentions, attachments, stickers, (pendingReply == null || pendingReply.getShouldMention()) ? null : new MessageAllowedMentions(_Arrays.toList(MessageAllowedMentions2.values()), null, null, Boolean.FALSE, 6))), this.storeGuilds.observeFromChannelId(jLongValue), AnonymousClass1.INSTANCE).Z(1);
        Intrinsics3.checkNotNullExpressionValue(observableZ, "Observable.combineLatest…d)\n    }\n        .take(1)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(ObservableExtensionsKt.restSubscribeOn$default(observableZ, false, 1, null)), MessageManager.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(messageSendResultHandler), 62, (Object) null);
        return true;
    }

    public /* synthetic */ MessageManager(Context context, StoreMessages storeMessages, StoreApplicationInteractions storeApplicationInteractions, StoreUser storeUser, StoreChannelsSelected storeChannelsSelected, StoreSlowMode storeSlowMode, StoreGuilds storeGuilds, StorePendingReplies storePendingReplies, StoreMessageReplies storeMessageReplies, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? StoreStream.INSTANCE.getMessages() : storeMessages, (i & 4) != 0 ? StoreStream.INSTANCE.getInteractions() : storeApplicationInteractions, (i & 8) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser, (i & 16) != 0 ? StoreStream.INSTANCE.getChannelsSelected() : storeChannelsSelected, (i & 32) != 0 ? StoreStream.INSTANCE.getSlowMode() : storeSlowMode, (i & 64) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 128) != 0 ? StoreStream.INSTANCE.getPendingReplies() : storePendingReplies, (i & 256) != 0 ? StoreStream.INSTANCE.getRepliedMessages() : storeMessageReplies);
    }
}
