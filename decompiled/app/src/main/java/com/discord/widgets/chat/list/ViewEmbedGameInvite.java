package com.discord.widgets.chat.list;

import a0.a.a.b;
import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityAssets;
import com.discord.api.activity.ActivityParty;
import com.discord.api.application.Application;
import com.discord.api.message.activity.MessageActivity;
import com.discord.api.message.activity.MessageActivityType;
import com.discord.app.AppLog;
import com.discord.databinding.ViewChatEmbedGameInviteBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.presence.ActivityUtils;
import com.discord.utilities.presence.PresenceUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.channels.list.WidgetCollapsedUsersListAdapter;
import com.discord.widgets.channels.list.items.CollapsedUser;
import com.discord.widgets.chat.list.entries.GameInviteEntry;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import d0.d0._Ranges;
import d0.g0.StringNumberConversions;
import d0.t.Iterators5;
import d0.z.d.Intrinsics3;
import j0.l.e.ScalarSynchronousObservable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: ViewEmbedGameInvite.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 +2\u00020\u0001:\u0002+,B\u0011\b\u0016\u0012\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"B\u001b\b\u0016\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\b\u0010$\u001a\u0004\u0018\u00010#¢\u0006\u0004\b!\u0010%B#\b\u0016\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\b\u0010$\u001a\u0004\u0018\u00010#\u0012\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b!\u0010(B+\b\u0016\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\b\u0010$\u001a\u0004\u0018\u00010#\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010)\u001a\u00020&¢\u0006\u0004\b!\u0010*J\u001b\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\n\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\r\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0010\u0010\u0007R6\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006-"}, d2 = {"Lcom/discord/widgets/chat/list/ViewEmbedGameInvite;", "Landroid/widget/LinearLayout;", "Lcom/discord/widgets/chat/list/ViewEmbedGameInvite$Model;", "Lcom/discord/utilities/time/Clock;", "clock", "", "configureUI", "(Lcom/discord/widgets/chat/list/ViewEmbedGameInvite$Model;Lcom/discord/utilities/time/Clock;)V", "", "isDeadInvite", "configureActivityImages", "(Lcom/discord/widgets/chat/list/ViewEmbedGameInvite$Model;Z)V", "isPartyFull", "onConfigureActionButton", "(Lcom/discord/widgets/chat/list/ViewEmbedGameInvite$Model;ZZ)V", "model", "bind", "Lkotlin/Function2;", "Landroid/view/View;", "onActionButtonClick", "Lkotlin/jvm/functions/Function2;", "getOnActionButtonClick", "()Lkotlin/jvm/functions/Function2;", "setOnActionButtonClick", "(Lkotlin/jvm/functions/Function2;)V", "Lcom/discord/widgets/channels/list/WidgetCollapsedUsersListAdapter;", "userAdapter", "Lcom/discord/widgets/channels/list/WidgetCollapsedUsersListAdapter;", "Lcom/discord/databinding/ViewChatEmbedGameInviteBinding;", "binding", "Lcom/discord/databinding/ViewChatEmbedGameInviteBinding;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "attributeSetId", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion", ExifInterface.TAG_MODEL, "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ViewEmbedGameInvite extends LinearLayout {
    private static final long EMBED_LIFETIME_MILLIS = 7200000;
    private static final long MAX_USERS_SHOWN = 4;
    private final ViewChatEmbedGameInviteBinding binding;
    private Function2<? super View, ? super Model, Unit> onActionButtonClick;
    private final WidgetCollapsedUsersListAdapter userAdapter;

    /* compiled from: ViewEmbedGameInvite.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u0000 I2\u00020\u0001:\u0001IBO\u0012\u0006\u0010\u001d\u001a\u00020\t\u0012\n\u0010\u001e\u001a\u00060\u0002j\u0002`\f\u0012\n\u0010\u001f\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010 \u001a\u00020\u0010\u0012\u0006\u0010!\u001a\u00020\u0013\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0016\u0012\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\u0004\bG\u0010HJ\u0019\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\b\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\r\u001a\u00060\u0002j\u0002`\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0014\u0010\u000f\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000eJ\u0010\u0010\u0011\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJf\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u001d\u001a\u00020\t2\f\b\u0002\u0010\u001e\u001a\u00060\u0002j\u0002`\f2\f\b\u0002\u0010\u001f\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010 \u001a\u00020\u00102\b\b\u0002\u0010!\u001a\u00020\u00132\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00162\u000e\b\u0002\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019HÆ\u0001¢\u0006\u0004\b$\u0010%J\u0010\u0010'\u001a\u00020&HÖ\u0001¢\u0006\u0004\b'\u0010(J\u0010\u0010*\u001a\u00020)HÖ\u0001¢\u0006\u0004\b*\u0010+J\u001a\u0010-\u001a\u00020\u00052\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b-\u0010.R\u0019\u0010/\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b/\u00101R\u0019\u00102\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b2\u00100\u001a\u0004\b3\u00101R\u001f\u00104\u001a\b\u0012\u0004\u0012\u00020&0\u00198\u0006@\u0006¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u0010\u001cR\u001d\u0010\u001f\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u00107\u001a\u0004\b8\u0010\u000eR\u0019\u00109\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b9\u00100\u001a\u0004\b9\u00101R\u0019\u0010!\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010:\u001a\u0004\b;\u0010\u0015R\u001b\u0010\"\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010<\u001a\u0004\b=\u0010\u0018R\u001f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0006@\u0006¢\u0006\f\n\u0004\b#\u00105\u001a\u0004\b>\u0010\u001cR\u001d\u0010\u001e\u001a\u00060\u0002j\u0002`\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u00107\u001a\u0004\b?\u0010\u000eR\u001a\u0010B\u001a\u00060&j\u0002`@8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bA\u0010(R\u0019\u0010\u001d\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010C\u001a\u0004\bD\u0010\u000bR\u0019\u0010 \u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b \u0010E\u001a\u0004\bF\u0010\u0012¨\u0006J"}, d2 = {"Lcom/discord/widgets/chat/list/ViewEmbedGameInvite$Model;", "", "", "Lcom/discord/primitives/Timestamp;", "now", "", "isExpiredInvite", "(J)Z", "isDeadInvite", "Lcom/discord/models/user/MeUser;", "component1", "()Lcom/discord/models/user/MeUser;", "Lcom/discord/primitives/UserId;", "component2", "()J", "component3", "Lcom/discord/api/application/Application;", "component4", "()Lcom/discord/api/application/Application;", "Lcom/discord/api/message/activity/MessageActivity;", "component5", "()Lcom/discord/api/message/activity/MessageActivity;", "Lcom/discord/api/activity/Activity;", "component6", "()Lcom/discord/api/activity/Activity;", "", "Lcom/discord/widgets/channels/list/items/CollapsedUser;", "component7", "()Ljava/util/List;", "meUser", "creatorId", "creationTime", "application", "messageActivity", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "users", "copy", "(Lcom/discord/models/user/MeUser;JJLcom/discord/api/application/Application;Lcom/discord/api/message/activity/MessageActivity;Lcom/discord/api/activity/Activity;Ljava/util/List;)Lcom/discord/widgets/chat/list/ViewEmbedGameInvite$Model;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "isInParty", "Z", "()Z", "canJoin", "getCanJoin", "gPlayPackageNames", "Ljava/util/List;", "getGPlayPackageNames", "J", "getCreationTime", "isPartyMatch", "Lcom/discord/api/message/activity/MessageActivity;", "getMessageActivity", "Lcom/discord/api/activity/Activity;", "getActivity", "getUsers", "getCreatorId", "Lcom/discord/primitives/ActivityPartyId;", "getPartyId", "partyId", "Lcom/discord/models/user/MeUser;", "getMeUser", "Lcom/discord/api/application/Application;", "getApplication", "<init>", "(Lcom/discord/models/user/MeUser;JJLcom/discord/api/application/Application;Lcom/discord/api/message/activity/MessageActivity;Lcom/discord/api/activity/Activity;Ljava/util/List;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Activity activity;
        private final Application application;
        private final boolean canJoin;
        private final long creationTime;
        private final long creatorId;
        private final List<String> gPlayPackageNames;
        private final boolean isInParty;
        private final boolean isPartyMatch;
        private final MeUser meUser;
        private final MessageActivity messageActivity;
        private final List<CollapsedUser> users;

        /* compiled from: ViewEmbedGameInvite.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b'\u0010(JY\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0016\u0010\u000e\u001a\u0012\u0012\b\u0012\u00060\u0004j\u0002`\f\u0012\u0004\u0012\u00020\r0\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013JK\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0016\u0010\u000e\u001a\u0012\u0012\b\u0012\u00060\u0004j\u0002`\f\u0012\u0004\u0012\u00020\r0\u000bH\u0002¢\u0006\u0004\b\u0016\u0010\u0017JA\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0018j\b\u0012\u0004\u0012\u00020\u0019`\u001a2\u0016\u0010\u000e\u001a\u0012\u0012\b\u0012\u00060\u0004j\u0002`\f\u0012\u0004\u0012\u00020\r0\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ1\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\"2\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010!\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b#\u0010$J\u001b\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00110\"2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lcom/discord/widgets/chat/list/ViewEmbedGameInvite$Model$Companion;", "", "Lcom/discord/models/user/MeUser;", "meUser", "", "Lcom/discord/primitives/Timestamp;", "creationTime", "Lcom/discord/api/message/activity/MessageActivity;", "msgActivity", "Lcom/discord/api/activity/Activity;", "gameActivity", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/user/User;", "userMap", "Lcom/discord/api/application/Application;", "application", "Lcom/discord/widgets/chat/list/ViewEmbedGameInvite$Model;", "createForShare", "(Lcom/discord/models/user/MeUser;JLcom/discord/api/message/activity/MessageActivity;Lcom/discord/api/activity/Activity;Ljava/util/Map;Lcom/discord/api/application/Application;)Lcom/discord/widgets/chat/list/ViewEmbedGameInvite$Model;", "Lcom/discord/widgets/chat/list/entries/GameInviteEntry;", "item", "create", "(Lcom/discord/widgets/chat/list/entries/GameInviteEntry;Lcom/discord/models/user/MeUser;Lcom/discord/api/application/Application;Lcom/discord/api/activity/Activity;Ljava/util/Map;)Lcom/discord/widgets/chat/list/ViewEmbedGameInvite$Model;", "Ljava/util/ArrayList;", "Lcom/discord/widgets/channels/list/items/CollapsedUser;", "Lkotlin/collections/ArrayList;", "createPartyUsers", "(Ljava/util/Map;Lcom/discord/api/activity/Activity;)Ljava/util/ArrayList;", "Lcom/discord/utilities/time/Clock;", "clock", "Landroid/net/Uri;", "shareUri", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "Lrx/Observable;", "getForShare", "(Lcom/discord/utilities/time/Clock;Landroid/net/Uri;Lcom/discord/api/activity/Activity;)Lrx/Observable;", "get", "(Lcom/discord/widgets/chat/list/entries/GameInviteEntry;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public static final /* synthetic */ Model access$create(Companion companion, GameInviteEntry gameInviteEntry, MeUser meUser, Application application, Activity activity, Map map) {
                return companion.create(gameInviteEntry, meUser, application, activity, map);
            }

            public static final /* synthetic */ Model access$createForShare(Companion companion, MeUser meUser, long j, MessageActivity messageActivity, Activity activity, Map map, Application application) {
                return companion.createForShare(meUser, j, messageActivity, activity, map, application);
            }

            private final Model create(GameInviteEntry item, MeUser meUser, Application application, Activity gameActivity, Map<Long, ? extends User> userMap) {
                return new Model(meUser, item.getAuthorId(), SnowflakeUtils.DISCORD_EPOCH + (item.getMessageId() >>> 22), application != null ? application : item.getApplication(), item.getActivity(), gameActivity, createPartyUsers(userMap, gameActivity));
            }

            private final Model createForShare(MeUser meUser, long creationTime, MessageActivity msgActivity, Activity gameActivity, Map<Long, ? extends User> userMap, Application application) {
                if (application != null) {
                    return new Model(meUser, meUser.getId(), creationTime, application, msgActivity, gameActivity, createPartyUsers(userMap, gameActivity));
                }
                return null;
            }

            private final ArrayList<CollapsedUser> createPartyUsers(Map<Long, ? extends User> userMap, Activity gameActivity) {
                ActivityParty party;
                ArrayList<CollapsedUser> arrayList = new ArrayList<>();
                Iterator<T> it = userMap.values().iterator();
                while (it.hasNext()) {
                    arrayList.add(new CollapsedUser((User) it.next(), false, 0L, 6, null));
                }
                long maxSize = (gameActivity == null || (party = gameActivity.getParty()) == null) ? 0L : PresenceUtils.INSTANCE.getMaxSize(party);
                Iterator<Long> it2 = _Ranges.until(userMap.size(), Math.min(4L, maxSize)).iterator();
                while (it2.hasNext()) {
                    arrayList.add(CollapsedUser.INSTANCE.createEmptyUser(((Iterators5) it2).nextLong() == 3 ? maxSize - 4 : 0L));
                }
                return arrayList;
            }

            public final Observable<Model> get(GameInviteEntry item) {
                Intrinsics3.checkNotNullParameter(item, "item");
                ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(item);
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableG = Observable.g(scalarSynchronousObservable, StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getApplication().observeApplication(Long.valueOf(item.getApplication().getId())), companion.getPresences().observeApplicationActivity(item.getAuthorId(), item.getApplication().getId()), companion.getGameParty().observeUsersForPartyId(item.getActivity().getPartyId()), new ViewEmbedGameInvite5(new ViewEmbedGameInvite2(this)));
                Intrinsics3.checkNotNullExpressionValue(observableG, "Observable\n            .…   ::create\n            )");
                Observable<Model> observableR = ObservableExtensionsKt.computationLatest(observableG).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "Observable\n            .…  .distinctUntilChanged()");
                return observableR;
            }

            public final Observable<Model> getForShare(Clock clock, Uri shareUri, Activity activity) {
                Intrinsics3.checkNotNullParameter(clock, "clock");
                if (shareUri == null) {
                    ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(null);
                    Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(null)");
                    return scalarSynchronousObservable;
                }
                String queryParameter = shareUri.getQueryParameter(ModelAuditLogEntry.CHANGE_KEY_APPLICATION_ID);
                Long longOrNull = queryParameter != null ? StringNumberConversions.toLongOrNull(queryParameter) : null;
                String queryParameter2 = shareUri.getQueryParameter("party_id");
                String queryParameter3 = shareUri.getQueryParameter("type");
                Integer intOrNull = queryParameter3 != null ? StringNumberConversions.toIntOrNull(queryParameter3) : null;
                if (longOrNull == null || queryParameter2 == null || intOrNull == null || (!Intrinsics3.areEqual(shareUri.getPath(), "/send/activity"))) {
                    Logger.w$default(AppLog.g, "Malformed Share URI: " + shareUri, null, 2, null);
                    ScalarSynchronousObservable scalarSynchronousObservable2 = new ScalarSynchronousObservable(null);
                    Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable2, "Observable.just(null)");
                    return scalarSynchronousObservable2;
                }
                MessageActivity messageActivity = new MessageActivity(MessageActivityType.INSTANCE.a(intOrNull), queryParameter2);
                ScalarSynchronousObservable scalarSynchronousObservable3 = new ScalarSynchronousObservable(activity);
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableF = Observable.f(StoreUser.observeMe$default(companion.getUsers(), false, 1, null), new ScalarSynchronousObservable(Long.valueOf(clock.currentTimeMillis())), new ScalarSynchronousObservable(messageActivity), Observable.m(scalarSynchronousObservable3, companion.getUsers().observeMeId().Y(new ViewEmbedGameInvite4(longOrNull, queryParameter2))), companion.getGameParty().observeUsersForPartyId(messageActivity.getPartyId()), companion.getApplication().observeApplication(longOrNull), new ViewEmbedGameInvite6(new ViewEmbedGameInvite3(this)));
                Intrinsics3.checkNotNullExpressionValue(observableF, "Observable\n            .…ateForShare\n            )");
                Observable<Model> observableR = ObservableExtensionsKt.computationLatest(observableF).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "Observable\n            .…  .distinctUntilChanged()");
                return observableR;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(MeUser meUser, long j, long j2, Application application, MessageActivity messageActivity, Activity activity, List<CollapsedUser> list) {
            boolean z2;
            ActivityParty party;
            String id2;
            Intrinsics3.checkNotNullParameter(meUser, "meUser");
            Intrinsics3.checkNotNullParameter(application, "application");
            Intrinsics3.checkNotNullParameter(messageActivity, "messageActivity");
            Intrinsics3.checkNotNullParameter(list, "users");
            this.meUser = meUser;
            this.creatorId = j;
            this.creationTime = j2;
            this.application = application;
            this.messageActivity = messageActivity;
            this.activity = activity;
            this.users = list;
            boolean zEquals = false;
            if ((list instanceof Collection) && list.isEmpty()) {
                z2 = false;
            } else {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (((CollapsedUser) it.next()).getUser().getId() == this.meUser.getId()) {
                        z2 = true;
                        break;
                    }
                }
                z2 = false;
            }
            this.isInParty = z2;
            Activity activity2 = this.activity;
            this.canJoin = activity2 != null && ActivityUtils.hasFlag(activity2, 2) && ActivityUtils.isCurrentPlatform(this.activity);
            this.gPlayPackageNames = this.application.d();
            Activity activity3 = this.activity;
            if (activity3 != null && (party = activity3.getParty()) != null && (id2 = party.getId()) != null) {
                zEquals = id2.equals(getPartyId());
            }
            this.isPartyMatch = zEquals;
        }

        public static /* synthetic */ Model copy$default(Model model, MeUser meUser, long j, long j2, Application application, MessageActivity messageActivity, Activity activity, List list, int i, Object obj) {
            return model.copy((i & 1) != 0 ? model.meUser : meUser, (i & 2) != 0 ? model.creatorId : j, (i & 4) != 0 ? model.creationTime : j2, (i & 8) != 0 ? model.application : application, (i & 16) != 0 ? model.messageActivity : messageActivity, (i & 32) != 0 ? model.activity : activity, (i & 64) != 0 ? model.users : list);
        }

        private final String getPartyId() {
            return this.messageActivity.getPartyId();
        }

        /* renamed from: component1, reason: from getter */
        public final MeUser getMeUser() {
            return this.meUser;
        }

        /* renamed from: component2, reason: from getter */
        public final long getCreatorId() {
            return this.creatorId;
        }

        /* renamed from: component3, reason: from getter */
        public final long getCreationTime() {
            return this.creationTime;
        }

        /* renamed from: component4, reason: from getter */
        public final Application getApplication() {
            return this.application;
        }

        /* renamed from: component5, reason: from getter */
        public final MessageActivity getMessageActivity() {
            return this.messageActivity;
        }

        /* renamed from: component6, reason: from getter */
        public final Activity getActivity() {
            return this.activity;
        }

        public final List<CollapsedUser> component7() {
            return this.users;
        }

        public final Model copy(MeUser meUser, long creatorId, long creationTime, Application application, MessageActivity messageActivity, Activity activity, List<CollapsedUser> users) {
            Intrinsics3.checkNotNullParameter(meUser, "meUser");
            Intrinsics3.checkNotNullParameter(application, "application");
            Intrinsics3.checkNotNullParameter(messageActivity, "messageActivity");
            Intrinsics3.checkNotNullParameter(users, "users");
            return new Model(meUser, creatorId, creationTime, application, messageActivity, activity, users);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return Intrinsics3.areEqual(this.meUser, model.meUser) && this.creatorId == model.creatorId && this.creationTime == model.creationTime && Intrinsics3.areEqual(this.application, model.application) && Intrinsics3.areEqual(this.messageActivity, model.messageActivity) && Intrinsics3.areEqual(this.activity, model.activity) && Intrinsics3.areEqual(this.users, model.users);
        }

        public final Activity getActivity() {
            return this.activity;
        }

        public final Application getApplication() {
            return this.application;
        }

        public final boolean getCanJoin() {
            return this.canJoin;
        }

        public final long getCreationTime() {
            return this.creationTime;
        }

        public final long getCreatorId() {
            return this.creatorId;
        }

        public final List<String> getGPlayPackageNames() {
            return this.gPlayPackageNames;
        }

        public final MeUser getMeUser() {
            return this.meUser;
        }

        public final MessageActivity getMessageActivity() {
            return this.messageActivity;
        }

        public final List<CollapsedUser> getUsers() {
            return this.users;
        }

        public int hashCode() {
            MeUser meUser = this.meUser;
            int iA = (b.a(this.creationTime) + ((b.a(this.creatorId) + ((meUser != null ? meUser.hashCode() : 0) * 31)) * 31)) * 31;
            Application application = this.application;
            int iHashCode = (iA + (application != null ? application.hashCode() : 0)) * 31;
            MessageActivity messageActivity = this.messageActivity;
            int iHashCode2 = (iHashCode + (messageActivity != null ? messageActivity.hashCode() : 0)) * 31;
            Activity activity = this.activity;
            int iHashCode3 = (iHashCode2 + (activity != null ? activity.hashCode() : 0)) * 31;
            List<CollapsedUser> list = this.users;
            return iHashCode3 + (list != null ? list.hashCode() : 0);
        }

        public final boolean isDeadInvite(long now) {
            return !this.isPartyMatch || isExpiredInvite(now);
        }

        public final boolean isExpiredInvite(long now) {
            return now > this.creationTime + ViewEmbedGameInvite.EMBED_LIFETIME_MILLIS;
        }

        /* renamed from: isInParty, reason: from getter */
        public final boolean getIsInParty() {
            return this.isInParty;
        }

        /* renamed from: isPartyMatch, reason: from getter */
        public final boolean getIsPartyMatch() {
            return this.isPartyMatch;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(meUser=");
            sbU.append(this.meUser);
            sbU.append(", creatorId=");
            sbU.append(this.creatorId);
            sbU.append(", creationTime=");
            sbU.append(this.creationTime);
            sbU.append(", application=");
            sbU.append(this.application);
            sbU.append(", messageActivity=");
            sbU.append(this.messageActivity);
            sbU.append(", activity=");
            sbU.append(this.activity);
            sbU.append(", users=");
            return outline.L(sbU, this.users, ")");
        }
    }

    /* compiled from: ViewEmbedGameInvite.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.ViewEmbedGameInvite$onConfigureActionButton$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Model $this_onConfigureActionButton;

        public AnonymousClass1(Model model) {
            this.$this_onConfigureActionButton = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function2<View, Model, Unit> onActionButtonClick = ViewEmbedGameInvite.this.getOnActionButtonClick();
            if (onActionButtonClick != null) {
                Intrinsics3.checkNotNullExpressionValue(view, "it");
                onActionButtonClick.invoke(view, this.$this_onConfigureActionButton);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewEmbedGameInvite(Context context) {
        super(context);
        Intrinsics3.checkNotNullParameter(context, "context");
        ViewChatEmbedGameInviteBinding viewChatEmbedGameInviteBindingA = ViewChatEmbedGameInviteBinding.a(LayoutInflater.from(getContext()), this);
        Intrinsics3.checkNotNullExpressionValue(viewChatEmbedGameInviteBindingA, "ViewChatEmbedGameInviteB…ater.from(context), this)");
        this.binding = viewChatEmbedGameInviteBindingA;
        setOrientation(1);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = viewChatEmbedGameInviteBindingA.h;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.itemGameInviteRecycler");
        this.userAdapter = (WidgetCollapsedUsersListAdapter) companion.configure(new WidgetCollapsedUsersListAdapter(recyclerView));
    }

    private final void configureActivityImages(Model model, boolean z2) {
        String smallImage;
        SimpleDraweeView simpleDraweeView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.itemGameInviteAvatarIv");
        String icon = model.getApplication().getIcon();
        MGImages.setImage$default(simpleDraweeView, icon != null ? IconUtils.getApplicationIcon$default(model.getApplication().getId(), icon, 0, 4, (Object) null) : null, 0, 0, false, null, null, 124, null);
        Activity activity = model.getActivity();
        ActivityAssets assets = activity != null ? activity.getAssets() : null;
        SimpleDraweeView simpleDraweeView2 = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.itemGameInviteAvatarStatusIv");
        simpleDraweeView2.setVisibility((assets != null ? assets.getSmallImage() : null) != null ? 0 : 8);
        SimpleDraweeView simpleDraweeView3 = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "binding.itemGameInviteAvatarStatusIv");
        MGImages.setImage$default(simpleDraweeView3, (assets == null || (smallImage = assets.getSmallImage()) == null) ? null : IconUtils.getAssetImage$default(IconUtils.INSTANCE, Long.valueOf(model.getApplication().getId()), smallImage, 0, 4, null), 0, 0, false, null, null, 124, null);
        SimpleDraweeView simpleDraweeView4 = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView4, "binding.itemGameInviteAvatarStatusIv");
        simpleDraweeView4.setContentDescription(assets != null ? assets.getSmallText() : null);
        if (z2) {
            SimpleDraweeView simpleDraweeView5 = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView5, "binding.itemGameInviteCoverIv");
            simpleDraweeView5.setVisibility(8);
            SimpleDraweeView simpleDraweeView6 = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView6, "binding.itemGameInviteCoverIv");
            MGImages.setImage$default(simpleDraweeView6, null, 0, 0, false, null, null, 124, null);
            return;
        }
        SimpleDraweeView simpleDraweeView7 = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView7, "binding.itemGameInviteCoverIv");
        simpleDraweeView7.setVisibility(0);
        String largeImage = assets != null ? assets.getLargeImage() : null;
        if (largeImage != null) {
            SimpleDraweeView simpleDraweeView8 = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView8, "binding.itemGameInviteCoverIv");
            simpleDraweeView8.setContentDescription(assets.getLargeText());
            SimpleDraweeView simpleDraweeView9 = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView9, "binding.itemGameInviteCoverIv");
            simpleDraweeView9.setImportantForAccessibility(1);
            String assetImage = IconUtils.INSTANCE.getAssetImage(Long.valueOf(model.getApplication().getId()), largeImage, IconUtils.getMediaProxySize(getWidth()));
            SimpleDraweeView simpleDraweeView10 = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView10, "binding.itemGameInviteCoverIv");
            MGImages.setImage$default(simpleDraweeView10, assetImage, 0, 0, false, null, null, 124, null);
            return;
        }
        SimpleDraweeView simpleDraweeView11 = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView11, "binding.itemGameInviteCoverIv");
        simpleDraweeView11.setImportantForAccessibility(2);
        SimpleDraweeView simpleDraweeView12 = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView12, "binding.itemGameInviteCoverIv");
        simpleDraweeView12.setContentDescription(null);
        String coverImage = model.getApplication().getCoverImage();
        String applicationIcon$default = coverImage != null ? IconUtils.getApplicationIcon$default(model.getApplication().getId(), coverImage, 0, 4, (Object) null) : null;
        SimpleDraweeView simpleDraweeView13 = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView13, "binding.itemGameInviteCoverIv");
        MGImages.setImage$default(simpleDraweeView13, applicationIcon$default, 0, 0, false, null, null, 124, null);
    }

    private final void configureUI(Model model, Clock clock) {
        Activity activity;
        ActivityParty party;
        boolean zIsDeadInvite = model.isDeadInvite(clock.currentTimeMillis());
        TextView textView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.itemGameInviteApplicationNameTv");
        textView.setText(model.getApplication().getName());
        TextView textView2 = this.binding.g;
        int i = R.string.invite_embed_game_has_ended;
        if (!zIsDeadInvite && model.getMessageActivity().getType() != MessageActivityType.SPECTATE) {
            i = R.string.invite_embed_invite_to_join_group;
        }
        textView2.setText(i);
        boolean z2 = ((!zIsDeadInvite && (activity = model.getActivity()) != null && (party = activity.getParty()) != null) ? PresenceUtils.INSTANCE.getNumOpenSlots(party) : 0L) <= 0;
        TextView textView3 = this.binding.i;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.itemGameInviteSubtext");
        String state = null;
        if (z2) {
            Activity activity2 = model.getActivity();
            if (activity2 != null) {
                state = activity2.getDetails();
            }
        } else {
            Activity activity3 = model.getActivity();
            if (activity3 != null) {
                state = activity3.getState();
            }
        }
        ViewExtensions.setTextAndVisibilityBy(textView3, state);
        configureActivityImages(model, zIsDeadInvite);
        onConfigureActionButton(model, zIsDeadInvite, z2);
        RecyclerView recyclerView = this.binding.h;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.itemGameInviteRecycler");
        recyclerView.setVisibility(zIsDeadInvite ^ true ? 0 : 8);
        if (zIsDeadInvite) {
            return;
        }
        this.userAdapter.setData(model.getUsers());
    }

    private final void onConfigureActionButton(Model model, boolean z2, boolean z3) {
        MaterialButton materialButton = this.binding.f2177b;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.itemGameInviteActionBtn");
        boolean z4 = false;
        materialButton.setVisibility(0);
        int i = R.string.join;
        if (z2 || !model.getCanJoin()) {
            MaterialButton materialButton2 = this.binding.f2177b;
            Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.itemGameInviteActionBtn");
            materialButton2.setEnabled(false);
            this.binding.f2177b.setText(R.string.join);
            return;
        }
        MaterialButton materialButton3 = this.binding.f2177b;
        Intrinsics3.checkNotNullExpressionValue(materialButton3, "binding.itemGameInviteActionBtn");
        if (!model.getIsInParty() && !z3 && model.getCreatorId() != model.getMeUser().getId()) {
            z4 = true;
        }
        materialButton3.setEnabled(z4);
        MaterialButton materialButton4 = this.binding.f2177b;
        if (z3) {
            i = R.string.invite_embed_full_group;
        } else if (model.getIsInParty()) {
            i = R.string.invite_embed_joined;
        }
        materialButton4.setText(i);
        this.binding.f2177b.setOnClickListener(new AnonymousClass1(model));
    }

    public final void bind(Model model, Clock clock) {
        Intrinsics3.checkNotNullParameter(model, "model");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        configureUI(model, clock);
    }

    public final Function2<View, Model, Unit> getOnActionButtonClick() {
        return this.onActionButtonClick;
    }

    public final void setOnActionButtonClick(Function2<? super View, ? super Model, Unit> function2) {
        this.onActionButtonClick = function2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewEmbedGameInvite(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        ViewChatEmbedGameInviteBinding viewChatEmbedGameInviteBindingA = ViewChatEmbedGameInviteBinding.a(LayoutInflater.from(getContext()), this);
        Intrinsics3.checkNotNullExpressionValue(viewChatEmbedGameInviteBindingA, "ViewChatEmbedGameInviteB…ater.from(context), this)");
        this.binding = viewChatEmbedGameInviteBindingA;
        setOrientation(1);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = viewChatEmbedGameInviteBindingA.h;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.itemGameInviteRecycler");
        this.userAdapter = (WidgetCollapsedUsersListAdapter) companion.configure(new WidgetCollapsedUsersListAdapter(recyclerView));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewEmbedGameInvite(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        ViewChatEmbedGameInviteBinding viewChatEmbedGameInviteBindingA = ViewChatEmbedGameInviteBinding.a(LayoutInflater.from(getContext()), this);
        Intrinsics3.checkNotNullExpressionValue(viewChatEmbedGameInviteBindingA, "ViewChatEmbedGameInviteB…ater.from(context), this)");
        this.binding = viewChatEmbedGameInviteBindingA;
        setOrientation(1);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = viewChatEmbedGameInviteBindingA.h;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.itemGameInviteRecycler");
        this.userAdapter = (WidgetCollapsedUsersListAdapter) companion.configure(new WidgetCollapsedUsersListAdapter(recyclerView));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewEmbedGameInvite(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics3.checkNotNullParameter(context, "context");
        ViewChatEmbedGameInviteBinding viewChatEmbedGameInviteBindingA = ViewChatEmbedGameInviteBinding.a(LayoutInflater.from(getContext()), this);
        Intrinsics3.checkNotNullExpressionValue(viewChatEmbedGameInviteBindingA, "ViewChatEmbedGameInviteB…ater.from(context), this)");
        this.binding = viewChatEmbedGameInviteBindingA;
        setOrientation(1);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = viewChatEmbedGameInviteBindingA.h;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.itemGameInviteRecycler");
        this.userAdapter = (WidgetCollapsedUsersListAdapter) companion.configure(new WidgetCollapsedUsersListAdapter(recyclerView));
    }
}
