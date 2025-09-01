package com.discord.stores;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.NotificationCompat;
import androidx.work.Constraints;
import androidx.work.ExistingWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.Operation;
import androidx.work.WorkManager;
import com.discord.api.activity.Activity;
import com.discord.api.application.Application;
import com.discord.api.interaction.InteractionModalCreate;
import com.discord.api.interaction.InteractionStateUpdate;
import com.discord.api.message.LocalAttachment;
import com.discord.api.message.MessageReference;
import com.discord.api.message.activity.MessageActivity;
import com.discord.api.message.allowedmentions.MessageAllowedMentions;
import com.discord.api.message.attachment.MessageAttachment;
import com.discord.api.message.reaction.MessageReactionUpdate;
import com.discord.api.sticker.BaseSticker;
import com.discord.api.user.User;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.app.AppLog;
import com.discord.models.commands.ApplicationCommandLocalSendData;
import com.discord.models.domain.ModelMessageDelete;
import com.discord.models.domain.ModelPayload;
import com.discord.models.message.Message;
import com.discord.models.user.CoreUser;
import com.discord.stores.StoreMessagesLoader;
import com.discord.utilities.attachments.AttachmentUtils;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.message.LocalMessageCreators;
import com.discord.utilities.messagesend.MessageQueue;
import com.discord.utilities.messagesend.MessageQueue3;
import com.discord.utilities.messagesend.MessageQueue4;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rest.SendUtils3;
import com.discord.utilities.rest.SendUtils5;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.utilities.user.UserUtils;
import com.discord.workers.BackgroundMessageSendWorker;
import com.lytefast.flexinput.model.Attachment;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.a.OnSubscribeFromIterable;
import j0.l.a.OnSubscribeLift;
import j0.l.a.OperatorMerge;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$ObjectRef;
import org.objectweb.asm.Opcodes;
import rx.Emitter;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func2;
import rx.functions.Func3;
import rx.subjects.BehaviorSubject;

/* compiled from: StoreMessages.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000È\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ¸\u00012\u00020\u0001:\u0002¸\u0001B'\u0012\b\u0010³\u0001\u001a\u00030²\u0001\u0012\b\u0010\u0099\u0001\u001a\u00030\u0098\u0001\u0012\b\u0010®\u0001\u001a\u00030\u00ad\u0001¢\u0006\u0006\b¶\u0001\u0010·\u0001J+\u0010\t\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\u00060\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0002¢\u0006\u0004\b\t\u0010\nJ+\u0010\u000b\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\u00060\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0002¢\u0006\u0004\b\u000b\u0010\nJ;\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0018\u0010\u0010\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u000f0\fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0017\u001a\u00020\u00162\u000e\u0010\u0013\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0016H\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0016H\u0003¢\u0006\u0004\b\u001b\u0010\u001aJ\u001b\u0010\u001d\u001a\u00020\u00162\n\u0010\u001c\u001a\u00060\u0007j\u0002`\bH\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ-\u0010!\u001a\u00020\u00162\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0010\u0010 \u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u001f0\u0006H\u0002¢\u0006\u0004\b!\u0010\"J\u001b\u0010#\u001a\u00020\u00162\n\u0010\u0013\u001a\u00060\u0007j\u0002`\bH\u0003¢\u0006\u0004\b#\u0010\u001eJ#\u0010#\u001a\u00020\u00162\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010$\u001a\u00020\u0014H\u0003¢\u0006\u0004\b#\u0010%J+\u0010+\u001a\u00020\u00162\u0006\u0010'\u001a\u00020&2\b\b\u0002\u0010)\u001a\u00020(2\b\b\u0002\u0010*\u001a\u00020(H\u0003¢\u0006\u0004\b+\u0010,J\u001b\u0010-\u001a\u00020\u00162\n\u0010\u0013\u001a\u00060\u0007j\u0002`\bH\u0003¢\u0006\u0004\b-\u0010\u001eJ'\u00100\u001a\u00020\u00162\n\u0010\u0013\u001a\u00060\u0007j\u0002`\b2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010.H\u0003¢\u0006\u0004\b0\u00101J\u001b\u00102\u001a\u00020\u00162\n\u0010\u0013\u001a\u00060\u0007j\u0002`\bH\u0003¢\u0006\u0004\b2\u0010\u001eJ\u001b\u00104\u001a\u0002032\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0003¢\u0006\u0004\b4\u00105J#\u00108\u001a\u00020\u00162\n\u0010\u0013\u001a\u00060\u0007j\u0002`\b2\u0006\u00107\u001a\u000206H\u0002¢\u0006\u0004\b8\u00109J\u0013\u0010;\u001a\b\u0012\u0004\u0012\u00020(0:¢\u0006\u0004\b;\u0010<J)\u0010=\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\u00060\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b=\u0010\nJ\u001f\u0010>\u001a\b\u0012\u0004\u0012\u00020(0\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b>\u0010\nJ3\u0010=\u001a\u0010\u0012\f\u0012\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b0\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010?\u001a\u00060\u0002j\u0002`\u001f¢\u0006\u0004\b=\u0010@J)\u0010A\u001a\u0004\u0018\u00010\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010?\u001a\u00060\u0002j\u0002`\u001fH\u0007¢\u0006\u0004\bA\u0010BJÑ\u0001\u0010[\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010D\u001a\u00020C2\u0006\u0010E\u001a\u00020\u00142\u000e\u0010F\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010\u00062\u0012\u0010H\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030G\u0018\u00010\u00062\u0010\b\u0002\u0010J\u001a\n\u0012\u0004\u0012\u00020I\u0018\u00010\u00062\n\b\u0002\u0010L\u001a\u0004\u0018\u00010K2\n\b\u0002\u0010N\u001a\u0004\u0018\u00010M2\n\b\u0002\u0010P\u001a\u0004\u0018\u00010O2\n\b\u0002\u0010R\u001a\u0004\u0018\u00010Q2\n\b\u0002\u0010T\u001a\u0004\u0018\u00010S2\n\b\u0002\u0010U\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010V\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010X\u001a\u0004\u0018\u00010W2\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010Y¢\u0006\u0004\b[\u0010\\J=\u0010[\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00052\n\u0010\u001c\u001a\u00060\u0007j\u0002`\b2\u0006\u0010^\u001a\u00020]2\u0014\b\u0002\u0010H\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030G\u0018\u00010\u0006¢\u0006\u0004\b[\u0010_J+\u0010`\u001a\u00020\u00162\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\b\u0010$\u001a\u0004\u0018\u00010\u00142\u0006\u0010Z\u001a\u00020Y¢\u0006\u0004\b`\u0010aJ#\u0010b\u001a\u00020\u00162\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\b\u0010$\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\bb\u0010%J\u001d\u0010c\u001a\u00020\u00162\u000e\u0010\u001c\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b¢\u0006\u0004\bc\u0010\u001eJ#\u0010d\u001a\u00020\u00162\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010$\u001a\u00020\u0014H\u0007¢\u0006\u0004\bd\u0010%J7\u0010e\u001a\u00020\u00162\n\u0010?\u001a\u00060\u0002j\u0002`\u001f2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010E\u001a\u00020\u00142\b\u0010N\u001a\u0004\u0018\u00010M¢\u0006\u0004\be\u0010fJ5\u0010h\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00052\n\u0010\u001c\u001a\u00060\u0007j\u0002`\b2\b\b\u0002\u0010g\u001a\u00020(2\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010Y¢\u0006\u0004\bh\u0010iJ!\u0010k\u001a\u00020\u00162\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010j\u001a\u00020\u0014¢\u0006\u0004\bk\u0010%J\u0017\u0010n\u001a\u00020\u00162\u0006\u0010m\u001a\u00020lH\u0016¢\u0006\u0004\bn\u0010oJ\u0017\u0010q\u001a\u00020\u00162\u0006\u0010p\u001a\u00020(H\u0007¢\u0006\u0004\bq\u0010rJ\u0015\u0010u\u001a\u00020\u00162\u0006\u0010t\u001a\u00020s¢\u0006\u0004\bu\u0010vJ\u0019\u0010w\u001a\u00020\u00162\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\bw\u0010xJ\u001f\u0010|\u001a\u00020\u00162\u0010\u0010{\u001a\f\u0012\b\u0012\u00060yj\u0002`z0\u0006¢\u0006\u0004\b|\u0010}J\r\u0010~\u001a\u00020\u0016¢\u0006\u0004\b~\u0010\u001aJ\u001a\u0010\u007f\u001a\u00020\u00162\n\u0010\u001c\u001a\u00060yj\u0002`z¢\u0006\u0005\b\u007f\u0010\u0080\u0001J\u0018\u0010!\u001a\u00020\u00162\b\u0010\u0082\u0001\u001a\u00030\u0081\u0001¢\u0006\u0005\b!\u0010\u0083\u0001J\u001a\u0010\u0086\u0001\u001a\u00020\u00162\b\u0010\u0085\u0001\u001a\u00030\u0084\u0001¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J)\u0010\u008b\u0001\u001a\u00020\u00162\u000e\u0010\u0089\u0001\u001a\t\u0012\u0005\u0012\u00030\u0088\u00010\u00062\u0007\u0010\u008a\u0001\u001a\u00020(¢\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J\u001a\u0010\u008e\u0001\u001a\u00020\u00162\b\u0010\u008d\u0001\u001a\u00030\u0088\u0001¢\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001J\u001a\u0010\u0090\u0001\u001a\u00020\u00162\b\u0010\u008d\u0001\u001a\u00030\u0088\u0001¢\u0006\u0006\b\u0090\u0001\u0010\u008f\u0001J\u001a\u0010\u0091\u0001\u001a\u00020\u00162\u0006\u0010'\u001a\u00020&H\u0007¢\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001J\u001a\u0010\u0093\u0001\u001a\u00020\u00162\u0006\u0010'\u001a\u00020&H\u0007¢\u0006\u0006\b\u0093\u0001\u0010\u0092\u0001J\u001c\u0010\u0096\u0001\u001a\u00020\u00162\b\u0010\u0095\u0001\u001a\u00030\u0094\u0001H\u0007¢\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001R\u001a\u0010\u0099\u0001\u001a\u00030\u0098\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u009a\u0001R\u001a\u0010\u009c\u0001\u001a\u00030\u009b\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009c\u0001\u0010\u009d\u0001R?\u0010 \u0001\u001a(\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u0002030\u009e\u0001j\u0013\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u000203`\u009f\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b \u0001\u0010¡\u0001R\u001a\u0010£\u0001\u001a\u00030¢\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b£\u0001\u0010¤\u0001R'\u0010¨\u0001\u001a\u0013\u0012\u000f\u0012\r\u0012\b\u0012\u00060\u0002j\u0002`\u00030¥\u00010\u00058F@\u0006¢\u0006\b\u001a\u0006\b¦\u0001\u0010§\u0001R$\u0010«\u0001\u001a\r ª\u0001*\u0005\u0018\u00010©\u00010©\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b«\u0001\u0010¬\u0001R\u001a\u0010®\u0001\u001a\u00030\u00ad\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b®\u0001\u0010¯\u0001R@\u0010°\u0001\u001a)\u0012\r\u0012\u000b ª\u0001*\u0004\u0018\u00010(0( ª\u0001*\u0013\u0012\r\u0012\u000b ª\u0001*\u0004\u0018\u00010(0(\u0018\u00010:0:8\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b°\u0001\u0010±\u0001R\u001a\u0010³\u0001\u001a\u00030²\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b³\u0001\u0010´\u0001R\u0017\u0010m\u001a\u00020l8\u0002@\u0002X\u0082.¢\u0006\u0007\n\u0005\bm\u0010µ\u0001¨\u0006¹\u0001"}, d2 = {"Lcom/discord/stores/StoreMessages;", "Lcom/discord/stores/Store;", "", "Lcom/discord/primitives/ChannelId;", "channelId", "Lrx/Observable;", "", "Lcom/discord/models/message/Message;", "Lcom/discord/stores/ClientMessage;", "observeSyncedMessagesForChannel", "(J)Lrx/Observable;", "observeLocalMessagesForChannel", "Lkotlin/Function1;", "Lrx/Emitter;", "Lcom/discord/utilities/messagesend/MessageResult;", "Lcom/discord/utilities/messagesend/MessageRequest;", "createRequest", "enqueueRequest", "(JLkotlin/jvm/functions/Function1;)Lrx/Observable;", "localMessage", "", "errorMessage", "", "handleSendMessageValidationError", "(Lcom/discord/models/message/Message;Ljava/lang/String;)V", "resendAllLocalMessages", "()V", "markLocalCaptchaRequiredMessagesFailed", "message", "handleLocalMessageCreate", "(Lcom/discord/models/message/Message;)V", "Lcom/discord/primitives/MessageId;", "messageIds", "handleMessageDelete", "(JLjava/util/List;)V", "handleLocalMessageDelete", "nonce", "(JLjava/lang/String;)V", "Lcom/discord/api/interaction/InteractionStateUpdate;", "interactionUpdate", "", "isFailed", "isLoading", "handleInteractionStateUpdate", "(Lcom/discord/api/interaction/InteractionStateUpdate;ZZ)V", "handleSendMessageFailure", "Lcom/discord/api/utcdatetime/UtcDateTime;", "editedTimestamp", "handleSendMessageFailureAutoMod", "(Lcom/discord/models/message/Message;Lcom/discord/api/utcdatetime/UtcDateTime;)V", "handleSendMessageCaptchaRequired", "Lcom/discord/utilities/messagesend/MessageQueue;", "getOrCreateMessageQueue", "(J)Lcom/discord/utilities/messagesend/MessageQueue;", "Lcom/discord/stores/FailedMessageResolutionType;", "failedMessageResolutionType", "trackFailedLocalMessageResolved", "(Lcom/discord/models/message/Message;Lcom/discord/stores/FailedMessageResolutionType;)V", "Lrx/subjects/BehaviorSubject;", "observeInitResendFinished", "()Lrx/subjects/BehaviorSubject;", "observeMessagesForChannel", "observeIsDetached", "messageId", "(JJ)Lrx/Observable;", "getMessage", "(JJ)Lcom/discord/models/message/Message;", "Lcom/discord/models/user/User;", "author", "content", "mentions", "Lcom/lytefast/flexinput/model/Attachment;", "attachments", "Lcom/discord/api/sticker/BaseSticker;", "stickers", "Lcom/discord/api/message/MessageReference;", "messageReference", "Lcom/discord/api/message/allowedmentions/MessageAllowedMentions;", "allowedMentions", "Lcom/discord/api/application/Application;", "application", "Lcom/discord/api/activity/Activity;", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "Lcom/discord/api/message/activity/MessageActivity;", "messageActivity", "lastManualAttemptTimestamp", "initialAttemptTimestamp", "", "numRetries", "Lcom/discord/utilities/captcha/CaptchaHelper$CaptchaPayload;", "captchaPayload", "sendMessage", "(JLcom/discord/models/user/User;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/discord/api/message/MessageReference;Lcom/discord/api/message/allowedmentions/MessageAllowedMentions;Lcom/discord/api/application/Application;Lcom/discord/api/activity/Activity;Lcom/discord/api/message/activity/MessageActivity;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Lcom/discord/utilities/captcha/CaptchaHelper$CaptchaPayload;)Lrx/Observable;", "Lcom/discord/models/commands/ApplicationCommandLocalSendData;", "applicationCommandLocalSendData", "(Lcom/discord/models/message/Message;Lcom/discord/models/commands/ApplicationCommandLocalSendData;Ljava/util/List;)Lrx/Observable;", "resendMessageWithCaptcha", "(JLjava/lang/String;Lcom/discord/utilities/captcha/CaptchaHelper$CaptchaPayload;)V", "markMessageFailed", "deleteMessage", "deleteLocalMessage", "editMessage", "(JJLjava/lang/String;Lcom/discord/api/message/allowedmentions/MessageAllowedMentions;)V", "isAutoAttempt", "resendMessage", "(Lcom/discord/models/message/Message;ZLcom/discord/utilities/captcha/CaptchaHelper$CaptchaPayload;)Lrx/Observable;", "requestId", "cancelMessageSend", "Landroid/content/Context;", "context", "init", "(Landroid/content/Context;)V", "connected", "handleConnected", "(Z)V", "Lcom/discord/models/domain/ModelPayload;", "payload", "handleConnectionOpen", "(Lcom/discord/models/domain/ModelPayload;)V", "handleChannelSelected", "(J)V", "Lcom/discord/api/message/Message;", "Lcom/discord/stores/ApiMessage;", "messagesList", "handleMessageCreate", "(Ljava/util/List;)V", "handlePreLogout", "handleMessageUpdate", "(Lcom/discord/api/message/Message;)V", "Lcom/discord/models/domain/ModelMessageDelete;", "messageDelete", "(Lcom/discord/models/domain/ModelMessageDelete;)V", "Lcom/discord/stores/StoreMessagesLoader$ChannelChunk;", "chunk", "handleMessagesLoaded", "(Lcom/discord/stores/StoreMessagesLoader$ChannelChunk;)V", "Lcom/discord/api/message/reaction/MessageReactionUpdate;", "updates", "add", "handleReactionUpdate", "(Ljava/util/List;Z)V", "update", "handleReactionsRemoveEmoji", "(Lcom/discord/api/message/reaction/MessageReactionUpdate;)V", "handleReactionsRemoveAll", "handleInteractionCreate", "(Lcom/discord/api/interaction/InteractionStateUpdate;)V", "handleInteractionFailure", "Lcom/discord/api/interaction/InteractionModalCreate;", "interactionModalCreate", "handleInteractionModalCreate", "(Lcom/discord/api/interaction/InteractionModalCreate;)V", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "Lcom/discord/stores/StoreMessagesHolder;", "holder", "Lcom/discord/stores/StoreMessagesHolder;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "messageQueues", "Ljava/util/HashMap;", "Lcom/discord/stores/StoreLocalMessagesHolder;", "localMessagesHolder", "Lcom/discord/stores/StoreLocalMessagesHolder;", "", "getAllDetached", "()Lrx/Observable;", "allDetached", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "queueExecutor", "Ljava/util/concurrent/ExecutorService;", "Lcom/discord/utilities/time/Clock;", "clock", "Lcom/discord/utilities/time/Clock;", "initResendFinished", "Lrx/subjects/BehaviorSubject;", "Lcom/discord/stores/StoreStream;", "stream", "Lcom/discord/stores/StoreStream;", "Landroid/content/Context;", "<init>", "(Lcom/discord/stores/StoreStream;Lcom/discord/stores/Dispatcher;Lcom/discord/utilities/time/Clock;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreMessages extends Store {
    private static final long BACKGROUND_SENDING_DELAY_MS = 120000;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Clock clock;
    private Context context;
    private final Dispatcher dispatcher;
    private final StoreMessagesHolder holder;
    private final BehaviorSubject<Boolean> initResendFinished;
    private final StoreLocalMessagesHolder localMessagesHolder;
    private final HashMap<Long, MessageQueue> messageQueues;
    private final ExecutorService queueExecutor;
    private final StoreStream stream;

    /* compiled from: StoreMessages.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/discord/stores/StoreMessages$Companion;", "", "Landroid/content/Context;", "context", "Landroidx/work/Operation;", "cancelBackgroundSendingWork", "(Landroid/content/Context;)Landroidx/work/Operation;", "", "BACKGROUND_SENDING_DELAY_MS", "J", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Operation access$cancelBackgroundSendingWork(Companion companion, Context context) {
            return companion.cancelBackgroundSendingWork(context);
        }

        private final Operation cancelBackgroundSendingWork(Context context) {
            Operation operationCancelUniqueWork = WorkManager.getInstance(context).cancelUniqueWork("BACKGROUND_MESSAGE_SENDING");
            Intrinsics3.checkNotNullExpressionValue(operationCancelUniqueWork, "WorkManager.getInstance(…dWorker.UNIQUE_WORK_NAME)");
            return operationCancelUniqueWork;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreMessages.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessages$deleteMessage$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
        }
    }

    /* compiled from: StoreMessages.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessages$deleteMessage$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ Message $message;
        public final /* synthetic */ long $messageId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Message message, long j, long j2) {
            super(0);
            this.$message = message;
            this.$channelId = j;
            this.$messageId = j2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (this.$message.isLocal()) {
                String nonce = this.$message.getNonce();
                if (nonce != null) {
                    StoreMessages.access$getOrCreateMessageQueue(StoreMessages.this, this.$channelId).cancel(nonce);
                }
                StoreMessages.access$handleLocalMessageDelete(StoreMessages.this, this.$message);
                Integer type = this.$message.getType();
                if (type != null && type.intValue() == -2) {
                    StoreMessages.access$trackFailedLocalMessageResolved(StoreMessages.this, this.$message, StoreMessages2.DELETED);
                }
            } else if (this.$message.isEphemeralMessage()) {
                StoreMessages.this.handleMessageDelete(new ModelMessageDelete(this.$channelId, this.$messageId));
            }
            StoreMessages.access$getStream$p(StoreMessages.this).handleLocalMessageDelete(this.$message);
        }
    }

    /* compiled from: StoreMessages.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/utilities/messagesend/MessageResult;", "result", "", "isLastMessage", "", "invoke", "(Lcom/discord/utilities/messagesend/MessageResult;Z)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessages$editMessage$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function2<MessageQueue4, Boolean, Unit> {
        public final /* synthetic */ MessageAllowedMentions $allowedMentions;
        public final /* synthetic */ long $attemptTimestamp;
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ String $content;
        public final /* synthetic */ long $messageId;

        /* compiled from: StoreMessages.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreMessages$editMessage$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01571 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ MessageQueue4 $result;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01571(MessageQueue4 messageQueue4) {
                super(0);
                this.$result = messageQueue4;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Message messageCreateLocalMessage$default;
                User author;
                if (this.$result instanceof MessageQueue4.AutoModBlock) {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    Message message = StoreMessages.this.getMessage(anonymousClass1.$channelId, anonymousClass1.$messageId);
                    if (message == null || (author = message.getAuthor()) == null) {
                        messageCreateLocalMessage$default = null;
                    } else {
                        AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                        String str = anonymousClass12.$content;
                        long j = anonymousClass12.$channelId;
                        List<User> mentions = message.getMentions();
                        List<MessageAttachment> attachments = message.getAttachments();
                        boolean z2 = true ^ (attachments == null || attachments.isEmpty());
                        Application application = message.getApplication();
                        MessageActivity activity = message.getActivity();
                        Clock clockAccess$getClock$p = StoreMessages.access$getClock$p(StoreMessages.this);
                        List listEmptyList = Collections2.emptyList();
                        Long lValueOf = Long.valueOf(AnonymousClass1.this.$attemptTimestamp);
                        Long initialAttemptTimestamp = message.getInitialAttemptTimestamp();
                        Long lValueOf2 = Long.valueOf(initialAttemptTimestamp != null ? initialAttemptTimestamp.longValue() : AnonymousClass1.this.$attemptTimestamp);
                        Integer numRetries = message.getNumRetries();
                        messageCreateLocalMessage$default = LocalMessageCreators.createLocalMessage$default(str, j, author, mentions, false, z2, application, activity, clockAccess$getClock$p, listEmptyList, lValueOf, lValueOf2, Integer.valueOf(numRetries != null ? numRetries.intValue() : 0), message.getStickers(), message.getMessageReference(), AnonymousClass1.this.$allowedMentions, null, 65536, null);
                    }
                    if (messageCreateLocalMessage$default != null) {
                        StoreMessages storeMessages = StoreMessages.this;
                        StoreMessages.access$handleSendMessageFailureAutoMod(storeMessages, messageCreateLocalMessage$default, new UtcDateTime(StoreMessages.access$getClock$p(storeMessages).currentTimeMillis()));
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2, String str, long j3, MessageAllowedMentions messageAllowedMentions) {
            super(2);
            this.$channelId = j;
            this.$messageId = j2;
            this.$content = str;
            this.$attemptTimestamp = j3;
            this.$allowedMentions = messageAllowedMentions;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(MessageQueue4 messageQueue4, Boolean bool) {
            invoke(messageQueue4, bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(MessageQueue4 messageQueue4, boolean z2) {
            Intrinsics3.checkNotNullParameter(messageQueue4, "result");
            StoreMessages.access$getDispatcher$p(StoreMessages.this).schedule(new C01571(messageQueue4));
        }
    }

    /* compiled from: StoreMessages.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042*\u0010\u0003\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lrx/Emitter;", "Lcom/discord/utilities/messagesend/MessageResult;", "kotlin.jvm.PlatformType", "emitter", "", NotificationCompat.CATEGORY_CALL, "(Lrx/Emitter;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessages$enqueueRequest$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<Emitter<MessageQueue4>> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ Function1 $createRequest;

        public AnonymousClass1(long j, Function1 function1) {
            this.$channelId = j;
            this.$createRequest = function1;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Emitter<MessageQueue4> emitter) {
            call2(emitter);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Emitter<MessageQueue4> emitter) {
            MessageQueue messageQueueAccess$getOrCreateMessageQueue = StoreMessages.access$getOrCreateMessageQueue(StoreMessages.this, this.$channelId);
            Function1 function1 = this.$createRequest;
            Intrinsics3.checkNotNullExpressionValue(emitter, "emitter");
            messageQueueAccess$getOrCreateMessageQueue.enqueue((MessageQueue3) function1.invoke(emitter));
        }
    }

    /* compiled from: StoreMessages.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessages$markMessageFailed$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Message $localMessage;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Message message) {
            super(0);
            this.$localMessage = message;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreMessages.access$handleSendMessageFailure(StoreMessages.this, this.$localMessage);
        }
    }

    /* compiled from: StoreMessages.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\b\u001a\n \u0003*\u0004\u0018\u00010\u00050\u00052\"\u0010\u0004\u001a\u001e\u0012\b\u0012\u00060\u0001j\u0002`\u0002 \u0003*\u000e\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "kotlin.jvm.PlatformType", "detached", "", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Set;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessages$observeIsDetached$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Set<? extends Long>, Boolean> {
        public final /* synthetic */ long $channelId;

        public AnonymousClass1(long j) {
            this.$channelId = j;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Boolean call(Set<? extends Long> set) {
            return call2((Set<Long>) set);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(Set<Long> set) {
            return Boolean.valueOf(set.contains(Long.valueOf(this.$channelId)));
        }
    }

    /* compiled from: StoreMessages.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u000222\u0010\u0005\u001a.\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002 \u0004*\u0016\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "", "", "Lcom/discord/models/message/Message;", "kotlin.jvm.PlatformType", "messages", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessages$observeLocalMessagesForChannel$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Map<Long, ? extends List<? extends Message>>, List<? extends Message>> {
        public final /* synthetic */ long $channelId;

        public AnonymousClass1(long j) {
            this.$channelId = j;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ List<? extends Message> call(Map<Long, ? extends List<? extends Message>> map) {
            return call2((Map<Long, ? extends List<Message>>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final List<Message> call2(Map<Long, ? extends List<Message>> map) {
            List<Message> list = map.get(Long.valueOf(this.$channelId));
            return list != null ? list : Collections2.emptyList();
        }
    }

    /* compiled from: StoreMessages.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\b\u001a\n \u0002*\u0004\u0018\u00010\u00050\u00052\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u00002\u001a\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/discord/models/message/Message;", "kotlin.jvm.PlatformType", "messages1", "messages2", "", NotificationCompat.CATEGORY_CALL, "(Ljava/util/List;Ljava/util/List;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessages$observeLocalMessagesForChannel$2, reason: invalid class name */
    public static final class AnonymousClass2<T1, T2, R> implements Func2<List<? extends Message>, List<? extends Message>, Boolean> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ Boolean call(List<? extends Message> list, List<? extends Message> list2) {
            return call2((List<Message>) list, (List<Message>) list2);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(List<Message> list, List<Message> list2) {
            return Boolean.valueOf(list == list2);
        }
    }

    /* compiled from: StoreMessages.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\n\u001a\u001e\u0012\b\u0012\u00060\u0001j\u0002`\u0002 \u0003*\u000e\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0018\u00010\u00000\u00002\"\u0010\u0004\u001a\u001e\u0012\b\u0012\u00060\u0001j\u0002`\u0002 \u0003*\u000e\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0018\u00010\u00000\u00002\"\u0010\u0005\u001a\u001e\u0012\b\u0012\u00060\u0001j\u0002`\u0002 \u0003*\u000e\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0018\u00010\u00000\u00002\u000e\u0010\u0007\u001a\n \u0003*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"", "Lcom/discord/models/message/Message;", "Lcom/discord/stores/ClientMessage;", "kotlin.jvm.PlatformType", "messages", "localMessages", "", "isDetached", NotificationCompat.CATEGORY_CALL, "(Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;)Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessages$observeMessagesForChannel$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, T3, R> implements Func3<List<? extends Message>, List<? extends Message>, Boolean, List<? extends Message>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // rx.functions.Func3
        public /* bridge */ /* synthetic */ List<? extends Message> call(List<? extends Message> list, List<? extends Message> list2, Boolean bool) {
            return call2((List<Message>) list, (List<Message>) list2, bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final List<Message> call2(List<Message> list, List<Message> list2, Boolean bool) {
            Intrinsics3.checkNotNullExpressionValue(bool, "isDetached");
            if (bool.booleanValue()) {
                return list;
            }
            Intrinsics3.checkNotNullExpressionValue(list, "messages");
            Intrinsics3.checkNotNullExpressionValue(list2, "localMessages");
            return _Collections.plus((Collection) list, (Iterable) list2);
        }
    }

    /* compiled from: StoreMessages.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\u0007\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00022\"\u0010\u0004\u001a\u001e\u0012\b\u0012\u00060\u0001j\u0002`\u0002 \u0003*\u000e\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/discord/models/message/Message;", "Lcom/discord/stores/ClientMessage;", "kotlin.jvm.PlatformType", "messages", NotificationCompat.CATEGORY_CALL, "(Ljava/util/List;)Lcom/discord/models/message/Message;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessages$observeMessagesForChannel$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements Func1<List<? extends Message>, Message> {
        public final /* synthetic */ long $messageId;

        public AnonymousClass2(long j) {
            this.$messageId = j;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Message call(List<? extends Message> list) {
            return call2((List<Message>) list);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Message call2(List<Message> list) {
            T next;
            Intrinsics3.checkNotNullExpressionValue(list, "messages");
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = (T) null;
                    break;
                }
                next = it.next();
                if (((Message) next).getId() == this.$messageId) {
                    break;
                }
            }
            return next;
        }
    }

    /* compiled from: StoreMessages.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0010%\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010$\n\u0002\b\u0004\u0010\n\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00040\u0004 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00050\u00052~\u0010\u0007\u001az\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0012(\u0012&\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00040\u0004 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00050\u0003 \u0002*<\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0012(\u0012&\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00040\u0004 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00050\u0003\u0018\u00010\u00060\u0000H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"", "", "kotlin.jvm.PlatformType", "", "Lcom/discord/models/message/Message;", "", "", "messages", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessages$observeSyncedMessagesForChannel$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Map<Long, List<Message>>, List<? extends Message>> {
        public final /* synthetic */ long $channelId;

        public AnonymousClass1(long j) {
            this.$channelId = j;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ List<? extends Message> call(Map<Long, List<Message>> map) {
            return call2(map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final List<Message> call2(Map<Long, List<Message>> map) {
            List<Message> list = map.get(Long.valueOf(this.$channelId));
            return list != null ? list : Collections2.emptyList();
        }
    }

    /* compiled from: StoreMessages.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\b\u001a\n \u0002*\u0004\u0018\u00010\u00050\u00052*\u0010\u0003\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00000\u00002*\u0010\u0004\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/discord/models/message/Message;", "kotlin.jvm.PlatformType", "messages1", "messages2", "", NotificationCompat.CATEGORY_CALL, "(Ljava/util/List;Ljava/util/List;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessages$observeSyncedMessagesForChannel$2, reason: invalid class name */
    public static final class AnonymousClass2<T1, T2, R> implements Func2<List<? extends Message>, List<? extends Message>, Boolean> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ Boolean call(List<? extends Message> list, List<? extends Message> list2) {
            return call2((List<Message>) list, (List<Message>) list2);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(List<Message> list, List<Message> list2) {
            return Boolean.valueOf(list == list2);
        }
    }

    /* compiled from: StoreMessages.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessages$resendAllLocalMessages$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
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
            StoreMessages.access$getInitResendFinished$p(StoreMessages.this).onNext(Boolean.TRUE);
        }
    }

    /* compiled from: StoreMessages.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/utilities/messagesend/MessageResult;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Lcom/discord/utilities/messagesend/MessageResult;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessages$resendAllLocalMessages$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<MessageQueue4, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MessageQueue4 messageQueue4) {
            invoke2(messageQueue4);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MessageQueue4 messageQueue4) {
        }
    }

    /* compiled from: StoreMessages.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessages$resendMessage$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Message $message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Message message) {
            super(0);
            this.$message = message;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreMessages.access$handleLocalMessageDelete(StoreMessages.this, this.$message);
        }
    }

    /* compiled from: StoreMessages.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/messagesend/MessageResult;", "it", "", "invoke", "(Lcom/discord/utilities/messagesend/MessageResult;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessages$resendMessageWithCaptcha$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<MessageQueue4, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MessageQueue4 messageQueue4) {
            invoke2(messageQueue4);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MessageQueue4 messageQueue4) {
            Intrinsics3.checkNotNullParameter(messageQueue4, "it");
        }
    }

    /* compiled from: StoreMessages.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessages$sendMessage$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Message $invalidAttachmentsMessage;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Message message) {
            super(0);
            this.$invalidAttachmentsMessage = message;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreMessages.access$handleLocalMessageCreate(StoreMessages.this, this.$invalidAttachmentsMessage);
        }
    }

    /* compiled from: StoreMessages.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042*\u0010\u0003\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lrx/Emitter;", "Lcom/discord/utilities/messagesend/MessageResult;", "kotlin.jvm.PlatformType", "emitter", "", NotificationCompat.CATEGORY_CALL, "(Lrx/Emitter;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessages$sendMessage$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Action1<Emitter<MessageQueue4>> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Emitter<MessageQueue4> emitter) {
            call2(emitter);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Emitter<MessageQueue4> emitter) {
            emitter.onNext(MessageQueue4.NoValidContent.INSTANCE);
            emitter.onCompleted();
        }
    }

    /* compiled from: StoreMessages.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessages$sendMessage$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Message $localMessage;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Message message) {
            super(0);
            this.$localMessage = message;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreMessages.access$handleLocalMessageCreate(StoreMessages.this, this.$localMessage);
        }
    }

    /* compiled from: StoreMessages.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessages$sendMessage$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function0<Unit> {
        public AnonymousClass4() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Context contextAccess$getContext$p = StoreMessages.access$getContext$p(StoreMessages.this);
            Intrinsics3.checkNotNullParameter(contextAccess$getContext$p, "context");
            OneTimeWorkRequest oneTimeWorkRequestBuild = new OneTimeWorkRequest.Builder(BackgroundMessageSendWorker.class).setInitialDelay(StoreMessages.BACKGROUND_SENDING_DELAY_MS, TimeUnit.MILLISECONDS).setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()).build();
            Intrinsics3.checkNotNullExpressionValue(oneTimeWorkRequestBuild, "OneTimeWorkRequestBuilde…     )\n          .build()");
            WorkManager.getInstance(contextAccess$getContext$p).enqueueUniqueWork("BACKGROUND_MESSAGE_SENDING", ExistingWorkPolicy.REPLACE, oneTimeWorkRequestBuild);
        }
    }

    /* compiled from: StoreMessages.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessages$sendMessage$5, reason: invalid class name */
    public static final class AnonymousClass5 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Message $message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(Message message) {
            super(0);
            this.$message = message;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreMessages.access$handleLocalMessageCreate(StoreMessages.this, this.$message);
            Context contextAccess$getContext$p = StoreMessages.access$getContext$p(StoreMessages.this);
            Intrinsics3.checkNotNullParameter(contextAccess$getContext$p, "context");
            OneTimeWorkRequest oneTimeWorkRequestBuild = new OneTimeWorkRequest.Builder(BackgroundMessageSendWorker.class).setInitialDelay(StoreMessages.BACKGROUND_SENDING_DELAY_MS, TimeUnit.MILLISECONDS).setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()).build();
            Intrinsics3.checkNotNullExpressionValue(oneTimeWorkRequestBuild, "OneTimeWorkRequestBuilde…     )\n          .build()");
            WorkManager.getInstance(contextAccess$getContext$p).enqueueUniqueWork("BACKGROUND_MESSAGE_SENDING", ExistingWorkPolicy.REPLACE, oneTimeWorkRequestBuild);
        }
    }

    public StoreMessages(StoreStream storeStream, Dispatcher dispatcher, Clock clock) {
        Intrinsics3.checkNotNullParameter(storeStream, "stream");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        this.stream = storeStream;
        this.dispatcher = dispatcher;
        this.clock = clock;
        this.holder = new StoreMessagesHolder();
        this.localMessagesHolder = new StoreLocalMessagesHolder();
        this.queueExecutor = Executors.newSingleThreadExecutor();
        this.messageQueues = new HashMap<>();
        this.initResendFinished = BehaviorSubject.l0(Boolean.FALSE);
    }

    public static final /* synthetic */ Clock access$getClock$p(StoreMessages storeMessages) {
        return storeMessages.clock;
    }

    public static final /* synthetic */ Context access$getContext$p(StoreMessages storeMessages) {
        Context context = storeMessages.context;
        if (context == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("context");
        }
        return context;
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreMessages storeMessages) {
        return storeMessages.dispatcher;
    }

    public static final /* synthetic */ BehaviorSubject access$getInitResendFinished$p(StoreMessages storeMessages) {
        return storeMessages.initResendFinished;
    }

    public static final /* synthetic */ MessageQueue access$getOrCreateMessageQueue(StoreMessages storeMessages, long j) {
        return storeMessages.getOrCreateMessageQueue(j);
    }

    public static final /* synthetic */ StoreStream access$getStream$p(StoreMessages storeMessages) {
        return storeMessages.stream;
    }

    public static final /* synthetic */ void access$handleLocalMessageCreate(StoreMessages storeMessages, Message message) {
        storeMessages.handleLocalMessageCreate(message);
    }

    public static final /* synthetic */ void access$handleLocalMessageDelete(StoreMessages storeMessages, Message message) {
        storeMessages.handleLocalMessageDelete(message);
    }

    public static final /* synthetic */ void access$handleSendMessageCaptchaRequired(StoreMessages storeMessages, Message message) {
        storeMessages.handleSendMessageCaptchaRequired(message);
    }

    public static final /* synthetic */ void access$handleSendMessageFailure(StoreMessages storeMessages, Message message) {
        storeMessages.handleSendMessageFailure(message);
    }

    public static final /* synthetic */ void access$handleSendMessageFailureAutoMod(StoreMessages storeMessages, Message message, UtcDateTime utcDateTime) {
        storeMessages.handleSendMessageFailureAutoMod(message, utcDateTime);
    }

    public static final /* synthetic */ void access$handleSendMessageValidationError(StoreMessages storeMessages, Message message, String str) {
        storeMessages.handleSendMessageValidationError(message, str);
    }

    public static final /* synthetic */ void access$setContext$p(StoreMessages storeMessages, Context context) {
        storeMessages.context = context;
    }

    public static final /* synthetic */ void access$trackFailedLocalMessageResolved(StoreMessages storeMessages, Message message, StoreMessages2 storeMessages2) {
        storeMessages.trackFailedLocalMessageResolved(message, storeMessages2);
    }

    private final Observable<MessageQueue4> enqueueRequest(long channelId, Function1<? super Emitter<MessageQueue4>, ? extends MessageQueue3> createRequest) {
        Observable<MessageQueue4> observableX = Observable.o(new AnonymousClass1(channelId, createRequest), Emitter.BackpressureMode.ERROR).X(this.dispatcher.getScheduler());
        Intrinsics3.checkNotNullExpressionValue(observableX, "Observable.create<Messag…eOn(dispatcher.scheduler)");
        return observableX;
    }

    @Store3
    private final MessageQueue getOrCreateMessageQueue(long channelId) {
        MessageQueue messageQueue = this.messageQueues.get(Long.valueOf(channelId));
        if (messageQueue == null) {
            Context context = this.context;
            if (context == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("context");
            }
            ContentResolver contentResolver = context.getContentResolver();
            Intrinsics3.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
            ExecutorService executorService = this.queueExecutor;
            Intrinsics3.checkNotNullExpressionValue(executorService, "queueExecutor");
            messageQueue = new MessageQueue(contentResolver, executorService, this.clock);
            this.messageQueues.put(Long.valueOf(channelId), messageQueue);
        }
        return messageQueue;
    }

    @Store3
    private final void handleInteractionStateUpdate(InteractionStateUpdate interactionUpdate, boolean isFailed, boolean isLoading) {
        Message message;
        ApplicationCommandLocalSendData applicationCommandLocalSendData = this.stream.getApplicationInteractions().getApplicationCommandLocalSendDataSet$app_productionGoogleRelease().get(interactionUpdate.getNonce());
        if (applicationCommandLocalSendData == null || (message = this.localMessagesHolder.getMessage(applicationCommandLocalSendData.getChannelId(), applicationCommandLocalSendData.getNonceString())) == null) {
            return;
        }
        this.localMessagesHolder.addMessage(LocalMessageCreators.createLocalApplicationCommandMessage(message, interactionUpdate.getId(), isFailed, isLoading, this.clock));
    }

    public static /* synthetic */ void handleInteractionStateUpdate$default(StoreMessages storeMessages, InteractionStateUpdate interactionStateUpdate, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        if ((i & 4) != 0) {
            z3 = false;
        }
        storeMessages.handleInteractionStateUpdate(interactionStateUpdate, z2, z3);
    }

    @Store3
    private final void handleLocalMessageCreate(Message message) {
        this.localMessagesHolder.addMessage(message);
    }

    @Store3
    private final void handleLocalMessageDelete(Message localMessage) {
        this.localMessagesHolder.deleteMessage(localMessage);
    }

    @Store3
    private final void handleSendMessageCaptchaRequired(Message localMessage) {
        this.localMessagesHolder.addMessage(Message.copy$default(localMessage, 0L, 0L, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -6, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, -131073, Opcodes.LAND, null));
    }

    @Store3
    private final void handleSendMessageFailure(Message localMessage) {
        deleteMessage(localMessage);
        String content = localMessage.getContent();
        if (content == null) {
            content = "";
        }
        String str = content;
        long channelId = localMessage.getChannelId();
        User author = localMessage.getAuthor();
        Intrinsics3.checkNotNull(author);
        handleLocalMessageCreate(LocalMessageCreators.createLocalMessage$default(str, channelId, author, localMessage.getMentions(), true, localMessage.getHasLocalUploads(), localMessage.getApplication(), localMessage.getActivity(), this.clock, localMessage.getLocalAttachments(), localMessage.getLastManualAttemptTimestamp(), localMessage.getInitialAttemptTimestamp(), localMessage.getNumRetries(), localMessage.getStickers(), localMessage.getMessageReference(), localMessage.getAllowedMentions(), null, 65536, null));
    }

    @Store3
    private final void handleSendMessageFailureAutoMod(Message localMessage, UtcDateTime editedTimestamp) {
        handleLocalMessageCreate(Message.copy$default(localMessage, 0L, 0L, null, null, null, null, editedTimestamp, null, null, null, null, null, null, null, null, null, null, -8, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, -131137, Opcodes.LAND, null));
    }

    public static /* synthetic */ void handleSendMessageFailureAutoMod$default(StoreMessages storeMessages, Message message, UtcDateTime utcDateTime, int i, Object obj) {
        if ((i & 2) != 0) {
            utcDateTime = null;
        }
        storeMessages.handleSendMessageFailureAutoMod(message, utcDateTime);
    }

    private final void handleSendMessageValidationError(Message localMessage, String errorMessage) {
        Logger.e$default(AppLog.g, "ValidationError", errorMessage, null, null, 12, null);
        deleteMessage(localMessage);
    }

    @Store3
    private final void markLocalCaptchaRequiredMessagesFailed() {
        List<Message> flattenedMessages = this.localMessagesHolder.getFlattenedMessages();
        ArrayList<Message> arrayList = new ArrayList();
        for (Object obj : flattenedMessages) {
            Integer type = ((Message) obj).getType();
            if (type != null && type.intValue() == -6) {
                arrayList.add(obj);
            }
        }
        for (Message message : arrayList) {
            markMessageFailed(message.getChannelId(), message.getNonce());
        }
    }

    private final Observable<List<Message>> observeLocalMessagesForChannel(long channelId) {
        Observable<R> observableG = this.localMessagesHolder.getMessagesPublisher().G(new AnonymousClass1(channelId));
        Intrinsics3.checkNotNullExpressionValue(observableG, "localMessagesHolder\n    …annelId] ?: emptyList() }");
        Observable<List<Message>> observableS = ObservableExtensionsKt.computationBuffered(observableG).s(AnonymousClass2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableS, "localMessagesHolder\n    …messages1 === messages2 }");
        return observableS;
    }

    private final Observable<List<Message>> observeSyncedMessagesForChannel(long channelId) {
        Observable<R> observableG = this.holder.getMessagesPublisher().G(new AnonymousClass1(channelId));
        Intrinsics3.checkNotNullExpressionValue(observableG, "holder\n          .messag…annelId] ?: emptyList() }");
        Observable<List<Message>> observableS = ObservableExtensionsKt.computationBuffered(observableG).s(AnonymousClass2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableS, "holder\n          .messag…messages1 === messages2 }");
        return observableS;
    }

    @Store3
    private final void resendAllLocalMessages() {
        List<Message> flattenedMessages = this.localMessagesHolder.getFlattenedMessages();
        ArrayList arrayList = new ArrayList();
        for (Object obj : flattenedMessages) {
            Integer type = ((Message) obj).getType();
            if (type != null && type.intValue() == -1) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(resendMessage$default(this, (Message) it.next(), true, null, 4, null));
        }
        Observable observableH0 = Observable.h0(new OnSubscribeLift(Observable.h0(new OnSubscribeFromIterable(arrayList2)).j, OperatorMerge.a.a));
        Intrinsics3.checkNotNullExpressionValue(observableH0, "Observable\n        .mergeDelayError(observables)");
        ObservableExtensionsKt.appSubscribe$default(observableH0, StoreMessages.class, (Context) null, (Function1) null, (Function1) null, new AnonymousClass1(), (Function0) null, AnonymousClass2.INSTANCE, 46, (Object) null);
    }

    public static /* synthetic */ Observable resendMessage$default(StoreMessages storeMessages, Message message, boolean z2, CaptchaHelper.CaptchaPayload captchaPayload, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        if ((i & 4) != 0) {
            captchaPayload = null;
        }
        return storeMessages.resendMessage(message, z2, captchaPayload);
    }

    public static /* synthetic */ Observable sendMessage$default(StoreMessages storeMessages, long j, com.discord.models.user.User user, String str, List list, List list2, List list3, MessageReference messageReference, MessageAllowedMentions messageAllowedMentions, Application application, Activity activity, MessageActivity messageActivity, Long l, Long l2, Integer num, CaptchaHelper.CaptchaPayload captchaPayload, int i, Object obj) {
        return storeMessages.sendMessage(j, user, str, list, list2, (i & 32) != 0 ? null : list3, (i & 64) != 0 ? null : messageReference, (i & 128) != 0 ? null : messageAllowedMentions, (i & 256) != 0 ? null : application, (i & 512) != 0 ? null : activity, (i & 1024) != 0 ? null : messageActivity, (i & 2048) != 0 ? null : l, (i & 4096) != 0 ? null : l2, (i & 8192) != 0 ? null : num, (i & 16384) != 0 ? null : captchaPayload);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void trackFailedLocalMessageResolved(Message localMessage, StoreMessages2 failedMessageResolutionType) {
        boolean z2;
        boolean z3;
        ArrayList arrayList;
        Long l;
        boolean z4;
        boolean z5;
        List<LocalAttachment> localAttachments = localMessage.getLocalAttachments();
        if (localAttachments == null) {
            z2 = false;
        } else if (localAttachments.isEmpty()) {
            z5 = false;
            if (!z5) {
                z2 = true;
            }
        } else {
            for (LocalAttachment localAttachment : localAttachments) {
                Context context = this.context;
                if (context == null) {
                    Intrinsics3.throwUninitializedPropertyAccessException("context");
                }
                ContentResolver contentResolver = context.getContentResolver();
                Intrinsics3.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
                if (AttachmentUtils.isImageAttachment(localAttachment, contentResolver)) {
                    z5 = true;
                    break;
                }
            }
            z5 = false;
            if (!z5) {
            }
        }
        List<LocalAttachment> localAttachments2 = localMessage.getLocalAttachments();
        if (localAttachments2 == null) {
            z3 = false;
        } else if (localAttachments2.isEmpty()) {
            z4 = false;
            if (!z4) {
                z3 = true;
            }
        } else {
            for (LocalAttachment localAttachment2 : localAttachments2) {
                Context context2 = this.context;
                if (context2 == null) {
                    Intrinsics3.throwUninitializedPropertyAccessException("context");
                }
                ContentResolver contentResolver2 = context2.getContentResolver();
                Intrinsics3.checkNotNullExpressionValue(contentResolver2, "context.contentResolver");
                if (AttachmentUtils.isVideoAttachment(localAttachment2, contentResolver2)) {
                    z4 = true;
                    break;
                }
            }
            z4 = false;
            if (!z4) {
            }
        }
        List<LocalAttachment> localAttachments3 = localMessage.getLocalAttachments();
        if (localAttachments3 != null) {
            arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(localAttachments3, 10));
            Iterator<T> it = localAttachments3.iterator();
            while (it.hasNext()) {
                Uri uri = Uri.parse(((LocalAttachment) it.next()).getUriString());
                Intrinsics3.checkNotNullExpressionValue(uri, "Uri.parse(localAttachment.uriString)");
                Context context3 = this.context;
                if (context3 == null) {
                    Intrinsics3.throwUninitializedPropertyAccessException("context");
                }
                ContentResolver contentResolver3 = context3.getContentResolver();
                Intrinsics3.checkNotNullExpressionValue(contentResolver3, "context.contentResolver");
                arrayList.add(Long.valueOf(SendUtils5.computeFileSizeBytes(uri, contentResolver3)));
            }
        } else {
            arrayList = null;
        }
        int iLongValue = (arrayList == null || (l = (Long) _Collections.maxOrNull((Iterable) arrayList)) == null) ? 0 : (int) l.longValue();
        int iSumOfLong = arrayList != null ? (int) _Collections.sumOfLong(arrayList) : 0;
        StoreAnalytics analytics = StoreStream.INSTANCE.getAnalytics();
        List<LocalAttachment> localAttachments4 = localMessage.getLocalAttachments();
        int size = localAttachments4 != null ? localAttachments4.size() : 0;
        Long initialAttemptTimestamp = localMessage.getInitialAttemptTimestamp();
        long jLongValue = initialAttemptTimestamp != null ? initialAttemptTimestamp.longValue() : 0L;
        Integer numRetries = localMessage.getNumRetries();
        analytics.trackFailedMessageResolved(size, iLongValue, iSumOfLong, z2, z3, failedMessageResolutionType, jLongValue, numRetries != null ? numRetries.intValue() : 0, localMessage.getChannelId());
    }

    public final void cancelMessageSend(long channelId, String requestId) {
        Intrinsics3.checkNotNullParameter(requestId, "requestId");
        getOrCreateMessageQueue(channelId).cancel(requestId);
    }

    @Store3
    public final void deleteLocalMessage(long channelId, String nonce) {
        Intrinsics3.checkNotNullParameter(nonce, "nonce");
        getOrCreateMessageQueue(channelId).cancel(nonce);
        handleLocalMessageDelete(channelId, nonce);
    }

    public final void deleteMessage(Message message) {
        if (message == null) {
            return;
        }
        long id2 = message.getId();
        long channelId = message.getChannelId();
        if (message.isLocal() || message.isEphemeralMessage()) {
            this.dispatcher.schedule(new AnonymousClass2(message, channelId, id2));
        } else {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().deleteMessage(channelId, id2), false, 1, null), (Context) null, "deleteMessage", (Function1) null, AnonymousClass1.INSTANCE, (Function1) null, (Function0) null, (Function0) null, 117, (Object) null);
        }
    }

    public final void editMessage(long messageId, long channelId, String content, MessageAllowedMentions allowedMentions) {
        Intrinsics3.checkNotNullParameter(content, "content");
        long jCurrentTimeMillis = this.clock.currentTimeMillis();
        getOrCreateMessageQueue(channelId).enqueue(new MessageQueue3.Edit(channelId, content, messageId, allowedMentions, jCurrentTimeMillis, new AnonymousClass1(channelId, messageId, content, jCurrentTimeMillis, allowedMentions)));
    }

    public final Observable<Set<Long>> getAllDetached() {
        Observable<Set<Long>> detachedChannelsSubject = this.holder.getDetachedChannelsSubject();
        Intrinsics3.checkNotNullExpressionValue(detachedChannelsSubject, "holder\n          .detachedChannelsSubject");
        return ObservableExtensionsKt.computationLatest(detachedChannelsSubject);
    }

    @Store3
    public final Message getMessage(long channelId, long messageId) {
        TreeMap<Long, Message> messagesForChannel = this.holder.getMessagesForChannel(Long.valueOf(channelId));
        if (messagesForChannel != null) {
            return messagesForChannel.get(Long.valueOf(messageId));
        }
        return null;
    }

    public final void handleChannelSelected(long channelId) {
        this.holder.setSelectedChannelId(channelId);
    }

    @Store3
    public final void handleConnected(boolean connected) {
        if (!connected) {
            this.holder.invalidate();
            return;
        }
        Collection<MessageQueue> collectionValues = this.messageQueues.values();
        Intrinsics3.checkNotNullExpressionValue(collectionValues, "messageQueues.values");
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            ((MessageQueue) it.next()).handleConnected();
        }
    }

    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        this.holder.setMyUserId(payload.getMe().getId());
    }

    @Store3
    public final void handleInteractionCreate(InteractionStateUpdate interactionUpdate) {
        Intrinsics3.checkNotNullParameter(interactionUpdate, "interactionUpdate");
        handleInteractionStateUpdate$default(this, interactionUpdate, false, true, 2, null);
    }

    @Store3
    public final void handleInteractionFailure(InteractionStateUpdate interactionUpdate) {
        Intrinsics3.checkNotNullParameter(interactionUpdate, "interactionUpdate");
        handleInteractionStateUpdate$default(this, interactionUpdate, true, false, 4, null);
    }

    @Store3
    public final void handleInteractionModalCreate(InteractionModalCreate interactionModalCreate) {
        Intrinsics3.checkNotNullParameter(interactionModalCreate, "interactionModalCreate");
        ApplicationCommandLocalSendData applicationCommandLocalSendData = this.stream.getApplicationInteractions().getApplicationCommandLocalSendDataSet$app_productionGoogleRelease().get(interactionModalCreate.getNonce());
        if (applicationCommandLocalSendData != null) {
            this.localMessagesHolder.deleteMessage(applicationCommandLocalSendData.getChannelId(), applicationCommandLocalSendData.getNonceString());
        }
    }

    public final void handleMessageCreate(List<com.discord.api.message.Message> messagesList) {
        Intrinsics3.checkNotNullParameter(messagesList, "messagesList");
        for (com.discord.api.message.Message message : messagesList) {
            String nonce = message.getNonce();
            if (nonce != null) {
                this.localMessagesHolder.deleteMessage(message.getChannelId(), nonce);
            }
        }
        StoreMessagesHolder storeMessagesHolder = this.holder;
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(messagesList, 10));
        Iterator<T> it = messagesList.iterator();
        while (it.hasNext()) {
            arrayList.add(new Message((com.discord.api.message.Message) it.next()));
        }
        storeMessagesHolder.addMessages(arrayList);
    }

    public final void handleMessageDelete(ModelMessageDelete messageDelete) {
        Intrinsics3.checkNotNullParameter(messageDelete, "messageDelete");
        long channelId = messageDelete.getChannelId();
        List<Long> messageIds = messageDelete.getMessageIds();
        Intrinsics3.checkNotNullExpressionValue(messageIds, "messageDelete.messageIds");
        handleMessageDelete(channelId, messageIds);
    }

    public final void handleMessageUpdate(com.discord.api.message.Message message) {
        Intrinsics3.checkNotNullParameter(message, "message");
        this.holder.updateMessages(message);
    }

    public final void handleMessagesLoaded(StoreMessagesLoader.ChannelChunk chunk) {
        Intrinsics3.checkNotNullParameter(chunk, "chunk");
        this.holder.loadMessageChunks(CollectionsJVM.listOf(chunk));
    }

    public final void handlePreLogout() {
        this.localMessagesHolder.clearCache();
    }

    public final void handleReactionUpdate(List<MessageReactionUpdate> updates, boolean add) {
        Intrinsics3.checkNotNullParameter(updates, "updates");
        this.holder.updateReactions(updates, add);
    }

    public final void handleReactionsRemoveAll(MessageReactionUpdate update) {
        Intrinsics3.checkNotNullParameter(update, "update");
        this.holder.removeAllReactions(update);
    }

    public final void handleReactionsRemoveEmoji(MessageReactionUpdate update) {
        Intrinsics3.checkNotNullParameter(update, "update");
        this.holder.removeEmojiReactions(update);
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        super.init(context);
        this.context = context;
        this.holder.init(true);
        StoreLocalMessagesHolder.init$default(this.localMessagesHolder, false, 1, null);
        markLocalCaptchaRequiredMessagesFailed();
        resendAllLocalMessages();
    }

    public final void markMessageFailed(long channelId, String nonce) {
        Message message;
        if (nonce == null || (message = this.localMessagesHolder.getMessage(channelId, nonce)) == null) {
            return;
        }
        this.dispatcher.schedule(new AnonymousClass1(message));
    }

    public final BehaviorSubject<Boolean> observeInitResendFinished() {
        BehaviorSubject<Boolean> behaviorSubject = this.initResendFinished;
        Intrinsics3.checkNotNullExpressionValue(behaviorSubject, "initResendFinished");
        return behaviorSubject;
    }

    public final Observable<Boolean> observeIsDetached(long channelId) {
        Observable<Boolean> observableR = getAllDetached().G(new AnonymousClass1(channelId)).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "allDetached\n          .m…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<List<Message>> observeMessagesForChannel(long channelId) {
        Observable<List<Message>> observableI = Observable.i(observeSyncedMessagesForChannel(channelId), observeLocalMessagesForChannel(channelId), observeIsDetached(channelId), AnonymousClass1.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableI, "Observable.combineLatest…ges + localMessages\n    }");
        return observableI;
    }

    public final Observable<MessageQueue4> resendMessage(Message message, boolean isAutoAttempt, CaptchaHelper.CaptchaPayload captchaPayload) {
        ArrayList arrayList;
        ArrayList arrayList2;
        Integer type;
        Integer type2;
        Integer type3;
        Intrinsics3.checkNotNullParameter(message, "message");
        if ((isAutoAttempt && (((type2 = message.getType()) == null || type2.intValue() != -1) && ((type3 = message.getType()) == null || type3.intValue() != -6))) || (!isAutoAttempt && ((type = message.getType()) == null || type.intValue() != -2))) {
            throw new IllegalArgumentException("Incorrect " + isAutoAttempt + " auto attempt and message type " + message.getType());
        }
        this.dispatcher.schedule(new AnonymousClass1(message));
        Integer numRetries = message.getNumRetries();
        int iIntValue = numRetries != null ? numRetries.intValue() : 0;
        long channelId = message.getChannelId();
        User author = message.getAuthor();
        Intrinsics3.checkNotNull(author);
        CoreUser coreUser = new CoreUser(author);
        String content = message.getContent();
        if (content == null) {
            content = "";
        }
        List<User> mentions = message.getMentions();
        if (mentions != null) {
            arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(mentions, 10));
            Iterator<T> it = mentions.iterator();
            while (it.hasNext()) {
                arrayList.add(new CoreUser((User) it.next()));
            }
        } else {
            arrayList = null;
        }
        List<LocalAttachment> localAttachments = message.getLocalAttachments();
        if (localAttachments != null) {
            arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(localAttachments, 10));
            for (LocalAttachment localAttachment : localAttachments) {
                Uri uri = Uri.parse(localAttachment.getUriString());
                long id2 = localAttachment.getId();
                Intrinsics3.checkNotNullExpressionValue(uri, "contentUri");
                arrayList2.add(new Attachment(id2, uri, localAttachment.getDisplayName(), null, false, 16, null));
            }
        } else {
            arrayList2 = null;
        }
        return sendMessage$default(this, channelId, coreUser, content, arrayList, arrayList2, null, message.getMessageReference(), message.getAllowedMentions(), null, null, null, isAutoAttempt ? message.getLastManualAttemptTimestamp() : null, message.getInitialAttemptTimestamp(), Integer.valueOf(iIntValue + 1), captchaPayload, 1824, null);
    }

    public final void resendMessageWithCaptcha(long channelId, String nonce, CaptchaHelper.CaptchaPayload captchaPayload) {
        Message message;
        Intrinsics3.checkNotNullParameter(captchaPayload, "captchaPayload");
        if (nonce == null || (message = this.localMessagesHolder.getMessage(channelId, nonce)) == null) {
            return;
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(resendMessage(message, true, captchaPayload)), StoreMessages.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, AnonymousClass1.INSTANCE, 62, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v5, types: [T, java.util.List] */
    public final Observable<MessageQueue4> sendMessage(long channelId, com.discord.models.user.User author, String content, List<? extends com.discord.models.user.User> mentions, List<? extends Attachment<?>> attachments, List<? extends BaseSticker> stickers, MessageReference messageReference, MessageAllowedMentions allowedMentions, Application application, Activity activity, MessageActivity messageActivity, Long lastManualAttemptTimestamp, Long initialAttemptTimestamp, Integer numRetries, CaptchaHelper.CaptchaPayload captchaPayload) {
        List listEmptyList;
        ArrayList arrayList;
        String content2 = content;
        Intrinsics3.checkNotNullParameter(author, "author");
        Intrinsics3.checkNotNullParameter(content2, "content");
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = attachments;
        if (!(attachments == 0 || attachments.isEmpty())) {
            SendUtils3.Companion companion = SendUtils3.INSTANCE;
            Context context = this.context;
            if (context == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("context");
            }
            SendUtils3 sendUtils3FromAttachments = companion.fromAttachments(attachments, content2, context);
            List<Attachment<?>> invalidAttachments = sendUtils3FromAttachments.getInvalidAttachments();
            if (!invalidAttachments.isEmpty()) {
                User userSynthesizeApiUser = UserUtils.INSTANCE.synthesizeApiUser(author);
                Clock clock = this.clock;
                ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(invalidAttachments, 10));
                Iterator<T> it = invalidAttachments.iterator();
                while (it.hasNext()) {
                    arrayList2.add(AttachmentUtils.toLocalAttachment((Attachment) it.next()));
                }
                this.dispatcher.schedule(new AnonymousClass1(LocalMessageCreators.createInvalidAttachmentsMessage(channelId, userSynthesizeApiUser, clock, arrayList2)));
            }
            ref$ObjectRef.element = sendUtils3FromAttachments.getValidAttachments();
            content2 = sendUtils3FromAttachments.getContent();
            List list = (List) ref$ObjectRef.element;
            if (list == null || list.isEmpty()) {
                if (content2.length() == 0) {
                    Observable<MessageQueue4> observableO = Observable.o(AnonymousClass2.INSTANCE, Emitter.BackpressureMode.ERROR);
                    Intrinsics3.checkNotNullExpressionValue(observableO, "Observable.create({ emit…r.BackpressureMode.ERROR)");
                    return observableO;
                }
            }
        }
        long jLongValue = lastManualAttemptTimestamp != null ? lastManualAttemptTimestamp.longValue() : this.clock.currentTimeMillis();
        User userSynthesizeApiUser2 = UserUtils.INSTANCE.synthesizeApiUser(author);
        if (mentions != null) {
            listEmptyList = new ArrayList(Iterables2.collectionSizeOrDefault(mentions, 10));
            Iterator<T> it2 = mentions.iterator();
            while (it2.hasNext()) {
                listEmptyList.add(UserUtils.INSTANCE.synthesizeApiUser((com.discord.models.user.User) it2.next()));
            }
        } else {
            listEmptyList = Collections2.emptyList();
        }
        List list2 = listEmptyList;
        List list3 = (List) ref$ObjectRef.element;
        boolean z2 = !(list3 == null || list3.isEmpty());
        Clock clock2 = this.clock;
        List list4 = (List) ref$ObjectRef.element;
        if (list4 != null) {
            ArrayList arrayList3 = new ArrayList(Iterables2.collectionSizeOrDefault(list4, 10));
            Iterator it3 = list4.iterator();
            while (it3.hasNext()) {
                arrayList3.add(AttachmentUtils.toLocalAttachment((Attachment) it3.next()));
            }
            arrayList = arrayList3;
        } else {
            arrayList = null;
        }
        Message messageCreateLocalMessage = LocalMessageCreators.createLocalMessage(content2, channelId, userSynthesizeApiUser2, list2, false, z2, application, messageActivity, clock2, arrayList, Long.valueOf(jLongValue), Long.valueOf(initialAttemptTimestamp != null ? initialAttemptTimestamp.longValue() : this.clock.currentTimeMillis()), Integer.valueOf(numRetries != null ? numRetries.intValue() : 0), stickers, messageReference, allowedMentions, captchaPayload);
        if (messageActivity == null) {
            this.dispatcher.schedule(new AnonymousClass3(messageCreateLocalMessage));
        }
        this.dispatcher.schedule(new AnonymousClass4());
        return enqueueRequest(channelId, new StoreMessages3(this, messageCreateLocalMessage, ref$ObjectRef, activity, jLongValue));
    }

    @Store3
    private final void handleLocalMessageDelete(long channelId, String nonce) {
        this.localMessagesHolder.deleteMessage(channelId, nonce);
    }

    private final void handleMessageDelete(long channelId, List<Long> messageIds) {
        this.holder.deleteMessages(channelId, messageIds);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Observable sendMessage$default(StoreMessages storeMessages, Message message, ApplicationCommandLocalSendData applicationCommandLocalSendData, List list, int i, Object obj) {
        if ((i & 4) != 0) {
            list = null;
        }
        return storeMessages.sendMessage(message, applicationCommandLocalSendData, list);
    }

    public final Observable<Message> observeMessagesForChannel(long channelId, long messageId) {
        Observable<Message> observableR = observeMessagesForChannel(channelId).G(new AnonymousClass2(messageId)).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observeMessagesForChanne…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<MessageQueue4> sendMessage(Message message, ApplicationCommandLocalSendData applicationCommandLocalSendData, List<? extends Attachment<?>> attachments) {
        Intrinsics3.checkNotNullParameter(message, "message");
        Intrinsics3.checkNotNullParameter(applicationCommandLocalSendData, "applicationCommandLocalSendData");
        this.dispatcher.schedule(new AnonymousClass5(message));
        return enqueueRequest(message.getChannelId(), new StoreMessages4(this, message, applicationCommandLocalSendData, attachments));
    }
}
