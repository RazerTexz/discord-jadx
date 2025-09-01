package com.discord.stores;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import b.a.d.o;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.api.guildmember.GuildMember;
import com.discord.api.guildmember.GuildMembersChunk;
import com.discord.api.guildscheduledevent.ApiGuildScheduledEventUser;
import com.discord.api.role.GuildRole;
import com.discord.api.thread.AugmentedThreadMember;
import com.discord.api.thread.ThreadListMember;
import com.discord.api.thread.ThreadMemberListUpdate;
import com.discord.api.thread.ThreadMembersUpdate;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.app.AppComponent;
import com.discord.models.domain.ModelPayload;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.collections.CollectionExtensions;
import com.discord.utilities.collections.SnowflakePartitionMap;
import com.discord.utilities.guildmember.GuildMemberUtils;
import com.discord.utilities.guilds.GuildUtils;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.CollectionsJVM;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.t.Sets5;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Func2;

/* compiled from: StoreGuilds.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 ¨\u00012\u00020\u0001:\u0004©\u0001¨\u0001B)\u0012\b\u0010\u0096\u0001\u001a\u00030\u0095\u0001\u0012\b\u0010\u008f\u0001\u001a\u00030\u008e\u0001\u0012\n\b\u0002\u0010\u0099\u0001\u001a\u00030\u0098\u0001¢\u0006\u0006\b¦\u0001\u0010§\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\f\u001a\u00020\u00042\n\u0010\t\u001a\u00060\u0007j\u0002`\b2\n\u0010\u000b\u001a\u00060\u0007j\u0002`\nH\u0003¢\u0006\u0004\b\f\u0010\rJ1\u0010\u0012\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00072\u0018\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\b\u0012\u00060\u000fj\u0002`\u0010\u0018\u00010\u000eH\u0003¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0019\u001a\u00020\u00042\n\u0010\u0016\u001a\u00060\u0014j\u0002`\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\u001c\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ7\u0010\"\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f2\u0006\u0010\u0018\u001a\u00020\u0017H\u0003¢\u0006\u0004\b\"\u0010#J1\u0010$\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00072\u0018\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\b\u0012\u00060\u000fj\u0002`\u0010\u0018\u00010\u000eH\u0003¢\u0006\u0004\b$\u0010\u0013J;\u0010'\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\u0012\u0010\u0011\u001a\u000e\u0012\b\u0012\u00060\u000fj\u0002`\u0010\u0018\u00010&2\u0006\u0010\u0018\u001a\u00020\u0017H\u0003¢\u0006\u0004\b'\u0010(J\u001d\u0010*\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020)0\u000e¢\u0006\u0004\b*\u0010+J\u001b\u0010,\u001a\u0004\u0018\u00010)2\n\u0010\t\u001a\u00060\u0007j\u0002`\b¢\u0006\u0004\b,\u0010-J-\u0010/\u001a\"\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0007j\u0002`.\u0012\u0004\u0012\u00020 0\u000e0\u000e¢\u0006\u0004\b/\u0010+J1\u00102\u001a&\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0007j\u0002`\n\u0012\b\u0012\u000600j\u0002`10\u000e0\u000e¢\u0006\u0004\b2\u0010+J\u0017\u00104\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\b03¢\u0006\u0004\b4\u00105J!\u00107\u001a\u0016\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\b\u0012\u00060\u0007j\u0002`60\u000e¢\u0006\u0004\b7\u0010+J-\u00108\u001a\n\u0018\u000100j\u0004\u0018\u0001`12\n\u0010\t\u001a\u00060\u0007j\u0002`\b2\n\u0010\u000b\u001a\u00060\u0007j\u0002`\n¢\u0006\u0004\b8\u00109J\u001f\u0010;\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020)0\u000eH\u0001¢\u0006\u0004\b:\u0010+J/\u0010=\u001a\"\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0007j\u0002`.\u0012\u0004\u0012\u00020 0\u000e0\u000eH\u0001¢\u0006\u0004\b<\u0010+J3\u0010?\u001a&\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0007j\u0002`\n\u0012\b\u0012\u000600j\u0002`10\u000e0\u000eH\u0001¢\u0006\u0004\b>\u0010+J\u0019\u0010A\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\b03H\u0001¢\u0006\u0004\b@\u00105J#\u0010C\u001a\u0016\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\b\u0012\u00060\u0007j\u0002`60\u000eH\u0001¢\u0006\u0004\bB\u0010+J\u0017\u0010E\u001a\u00020\u00042\u0006\u0010D\u001a\u00020\u0002H\u0016¢\u0006\u0004\bE\u0010\u0006J#\u0010G\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020)0\u000e0F¢\u0006\u0004\bG\u0010HJ\u001d\u0010I\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0007j\u0002`\b030F¢\u0006\u0004\bI\u0010HJ!\u0010J\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010)0F2\n\u0010\t\u001a\u00060\u0007j\u0002`\b¢\u0006\u0004\bJ\u0010KJ!\u0010N\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010)0F2\n\u0010M\u001a\u00060\u0007j\u0002`L¢\u0006\u0004\bN\u0010KJ\u001f\u0010P\u001a\b\u0012\u0004\u0012\u00020O0F2\n\u0010\t\u001a\u00060\u0007j\u0002`\b¢\u0006\u0004\bP\u0010KJ7\u0010Q\u001a,\u0012(\u0012&\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0007j\u0002`\n\u0012\b\u0012\u000600j\u0002`10\u000e0\u000e0F¢\u0006\u0004\bQ\u0010HJ3\u0010Q\u001a\u001c\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0007j\u0002`\n\u0012\b\u0012\u000600j\u0002`10\u000e0F2\n\u0010\t\u001a\u00060\u0007j\u0002`\b¢\u0006\u0004\bQ\u0010KJE\u0010Q\u001a\u001c\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0007j\u0002`\n\u0012\b\u0012\u000600j\u0002`10\u000e0F2\n\u0010\t\u001a\u00060\u0007j\u0002`\b2\u0010\u0010R\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\n0&¢\u0006\u0004\bQ\u0010SJ3\u0010T\u001a\u0010\u0012\f\u0012\n\u0018\u000100j\u0004\u0018\u0001`10F2\n\u0010\t\u001a\u00060\u0007j\u0002`\b2\n\u0010\u000b\u001a\u00060\u0007j\u0002`\n¢\u0006\u0004\bT\u0010UJ3\u0010V\u001a(\u0012$\u0012\"\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0007j\u0002`.\u0012\u0004\u0012\u00020 0\u000e0\u000e0F¢\u0006\u0004\bV\u0010HJ/\u0010V\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0007j\u0002`.\u0012\u0004\u0012\u00020 0\u000e0F2\n\u0010\t\u001a\u00060\u0007j\u0002`\b¢\u0006\u0004\bV\u0010KJ%\u0010W\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0F2\n\u0010\t\u001a\u00060\u0007j\u0002`\b¢\u0006\u0004\bW\u0010KJA\u0010V\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0007j\u0002`.\u0012\u0004\u0012\u00020 0\u000e0F2\n\u0010\t\u001a\u00060\u0007j\u0002`\b2\u0010\u0010X\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`.0&¢\u0006\u0004\bV\u0010SJ'\u0010Y\u001a\u001c\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\b\u0012\u00060\u0007j\u0002`60\u000e0F¢\u0006\u0004\bY\u0010HJ#\u0010Y\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`60F2\n\u0010\t\u001a\u00060\u0007j\u0002`\b¢\u0006\u0004\bY\u0010KJ\u001d\u0010Z\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0007j\u0002`\b030F¢\u0006\u0004\bZ\u0010HJ\u008d\u0001\u0010\\\u001av\u00124\u00122\u0012\b\u0012\u00060\u0007j\u0002`\n\u0012\b\u0012\u000600j\u0002`1 [*\u0018\u0012\b\u0012\u00060\u0007j\u0002`\n\u0012\b\u0012\u000600j\u0002`1\u0018\u00010\u000e0\u000e [*:\u00124\u00122\u0012\b\u0012\u00060\u0007j\u0002`\n\u0012\b\u0012\u000600j\u0002`1 [*\u0018\u0012\b\u0012\u00060\u0007j\u0002`\n\u0012\b\u0012\u000600j\u0002`1\u0018\u00010\u000e0\u000e\u0018\u00010F0F2\n\u0010\t\u001a\u00060\u0007j\u0002`\b¢\u0006\u0004\b\\\u0010KJI\u0010]\u001a&\u0012\f\u0012\n\u0018\u000100j\u0004\u0018\u0001`1 [*\u0012\u0012\f\u0012\n\u0018\u000100j\u0004\u0018\u0001`1\u0018\u00010F0F2\n\u0010\t\u001a\u00060\u0007j\u0002`\b2\n\u0010\u000b\u001a\u00060\u0007j\u0002`\n¢\u0006\u0004\b]\u0010UJ\u001d\u0010^\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u000600j\u0002`10\u001f0F¢\u0006\u0004\b^\u0010HJ%\u0010_\u001a\u00020\u00042\n\u0010\t\u001a\u00060\u0007j\u0002`\b2\n\u0010\u000b\u001a\u00060\u0007j\u0002`\n¢\u0006\u0004\b_\u0010\rJ\u0017\u0010b\u001a\u00020\u00042\u0006\u0010a\u001a\u00020`H\u0007¢\u0006\u0004\bb\u0010cJ\u0017\u0010d\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0014H\u0007¢\u0006\u0004\bd\u0010eJ#\u0010g\u001a\u00020\u00042\n\u0010\t\u001a\u00060\u0007j\u0002`\b2\u0006\u0010f\u001a\u00020 H\u0007¢\u0006\u0004\bg\u0010hJ'\u0010j\u001a\u00020\u00042\n\u0010i\u001a\u00060\u0007j\u0002`.2\n\u0010\t\u001a\u00060\u0007j\u0002`\bH\u0007¢\u0006\u0004\bj\u0010\rJ\u001b\u0010k\u001a\u00020\u00042\n\u0010\u0016\u001a\u00060\u0014j\u0002`\u0015H\u0007¢\u0006\u0004\bk\u0010eJ\u001b\u0010m\u001a\u00020\u00042\n\u0010l\u001a\u00060\u000fj\u0002`\u0010H\u0007¢\u0006\u0004\bm\u0010nJ\u0017\u0010q\u001a\u00020\u00042\u0006\u0010p\u001a\u00020oH\u0007¢\u0006\u0004\bq\u0010rJ\u0017\u0010u\u001a\u00020\u00042\u0006\u0010t\u001a\u00020sH\u0007¢\u0006\u0004\bu\u0010vJ\u0017\u0010y\u001a\u00020\u00042\u0006\u0010x\u001a\u00020wH\u0007¢\u0006\u0004\by\u0010zJ)\u0010}\u001a\u00020\u00042\f\u0010|\u001a\b\u0012\u0004\u0012\u00020{0\u001f2\n\u0010\t\u001a\u00060\u0007j\u0002`\bH\u0007¢\u0006\u0004\b}\u0010~J'\u0010\u007f\u001a\u00020\u00042\n\u0010\t\u001a\u00060\u0007j\u0002`\b2\n\u0010\u000b\u001a\u00060\u0007j\u0002`\nH\u0007¢\u0006\u0004\b\u007f\u0010\rJ5\u0010\u0081\u0001\u001a\u00020\u00042\n\u0010l\u001a\u00060\u000fj\u0002`\u00102\n\u0010\t\u001a\u00060\u0007j\u0002`\b2\t\b\u0002\u0010\u0080\u0001\u001a\u00020\u0017H\u0007¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J\u0012\u0010\u0083\u0001\u001a\u00020\u0004H\u0017¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001R;\u0010\u0086\u0001\u001a$\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0015\u0012\u0013\u0012\b\u0012\u00060\u0007j\u0002`.\u0012\u0004\u0012\u00020 0\u0085\u00010\u0085\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R$\u0010\u0089\u0001\u001a\r\u0012\b\u0012\u00060\u0007j\u0002`\b0\u0088\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R,\u0010\u008c\u0001\u001a\u0015\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020)0\u000e0\u008b\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R\u001a\u0010\u008f\u0001\u001a\u00030\u008e\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R=\u0010\u0091\u0001\u001a&\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0007j\u0002`\n\u0012\b\u0012\u000600j\u0002`10\u000e0\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0091\u0001\u0010\u0087\u0001R-\u0010\u0092\u0001\u001a\u0016\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\b\u0012\u00060\u0007j\u0002`60\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0092\u0001\u0010\u0087\u0001R&\u0010\u0093\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0085\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u0087\u0001R*\u0010\u0094\u0001\u001a\u0013\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020)0\u0085\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0094\u0001\u0010\u0087\u0001R\u001a\u0010\u0096\u0001\u001a\u00030\u0095\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0096\u0001\u0010\u0097\u0001R\u001a\u0010\u0099\u0001\u001a\u00030\u0098\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u009a\u0001R\u001d\u0010\u009d\u0001\u001a\u00060\u0007j\u0002`\n8B@\u0002X\u0082\u0004¢\u0006\b\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001R.\u0010\u009f\u0001\u001a\u0017\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\t\u0012\u00070)j\u0003`\u009e\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009f\u0001\u0010\u0087\u0001R?\u0010 \u0001\u001a(\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0019\u0012\u0017\u0012\b\u0012\u00060\u0007j\u0002`\n\u0012\b\u0012\u00060\u000fj\u0002`\u00100\u0085\u00010\u0085\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b \u0001\u0010\u0087\u0001R9\u0010¡\u0001\u001a\"\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0007j\u0002`.\u0012\u0004\u0012\u00020 0\u000e0\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¡\u0001\u0010\u0087\u0001R8\u0010¢\u0001\u001a!\u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020 0\u000e0\u000e0\u008b\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¢\u0001\u0010\u008d\u0001R#\u0010£\u0001\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\b038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b£\u0001\u0010\u008a\u0001R?\u0010¤\u0001\u001a(\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0019\u0012\u0017\u0012\b\u0012\u00060\u0007j\u0002`\n\u0012\b\u0012\u000600j\u0002`10\u0085\u00010\u0085\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¤\u0001\u0010\u0087\u0001R,\u0010¥\u0001\u001a\u0015\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000e0\u008b\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¥\u0001\u0010\u008d\u0001¨\u0006ª\u0001"}, d2 = {"Lcom/discord/stores/StoreGuilds;", "Lcom/discord/stores/StoreV2;", "Landroid/content/Context;", "ctx", "", "initClearCommunicationDisabledObserver", "(Landroid/content/Context;)V", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/primitives/UserId;", "userId", "handleGuildMemberCommunicationEnabledInternal", "(JJ)V", "", "Lcom/discord/api/guildmember/GuildMember;", "Lcom/discord/stores/ApiGuildMember;", "members", "handleHasRoleAndJoinedAt", "(JLjava/util/Map;)V", "Lcom/discord/api/guild/Guild;", "Lcom/discord/stores/ApiGuild;", "guild", "", "remove", "handleGuild", "(Lcom/discord/api/guild/Guild;Z)V", "unavailable", "handleGuildUnavailable", "(JZZ)V", "deletedRoleId", "", "Lcom/discord/api/role/GuildRole;", "roles", "handleGuildRoles", "(JJLjava/util/List;Z)V", "handleGuildMembersMap", "removedGuildMemberUserId", "", "handleGuildMembers", "(JJLjava/util/Collection;Z)V", "Lcom/discord/models/guild/Guild;", "getGuilds", "()Ljava/util/Map;", "getGuild", "(J)Lcom/discord/models/guild/Guild;", "Lcom/discord/primitives/RoleId;", "getRoles", "Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/ClientGuildMember;", "getMembers", "", "getUnavailableGuilds", "()Ljava/util/Set;", "Lcom/discord/primitives/Timestamp;", "getGuildsJoinedAt", "getMember", "(JJ)Lcom/discord/models/member/GuildMember;", "getGuildsInternal$app_productionGoogleRelease", "getGuildsInternal", "getGuildRolesInternal$app_productionGoogleRelease", "getGuildRolesInternal", "getGuildMembersComputedInternal$app_productionGoogleRelease", "getGuildMembersComputedInternal", "getUnavailableGuildsInternal$app_productionGoogleRelease", "getUnavailableGuildsInternal", "getGuildsJoinedAtInternal$app_productionGoogleRelease", "getGuildsJoinedAtInternal", "context", "init", "Lrx/Observable;", "observeGuilds", "()Lrx/Observable;", "observeGuildIds", "observeGuild", "(J)Lrx/Observable;", "Lcom/discord/primitives/ChannelId;", "channelId", "observeFromChannelId", "Lcom/discord/api/guild/GuildVerificationLevel;", "observeVerificationLevel", "observeComputed", "userIds", "(JLjava/util/Collection;)Lrx/Observable;", "observeComputedMember", "(JJ)Lrx/Observable;", "observeRoles", "observeSortedRoles", "roleIds", "observeJoinedAt", "observeUnavailableGuilds", "kotlin.jvm.PlatformType", "observeGuildMembers", "observeGuildMember", "observeCommunicationDisabledGuildMembers", "handleGuildMemberCommunicationEnabled", "Lcom/discord/models/domain/ModelPayload;", "payload", "handleConnectionOpen", "(Lcom/discord/models/domain/ModelPayload;)V", "handleGuildAdd", "(Lcom/discord/api/guild/Guild;)V", "role", "handleGuildRoleCreateOrUpdate", "(JLcom/discord/api/role/GuildRole;)V", "roleId", "handleGuildRoleRemove", "handleGuildRemove", "member", "handleGuildMemberAdd", "(Lcom/discord/api/guildmember/GuildMember;)V", "Lcom/discord/api/guildmember/GuildMembersChunk;", "chunk", "handleGuildMembersChunk", "(Lcom/discord/api/guildmember/GuildMembersChunk;)V", "Lcom/discord/api/thread/ThreadMemberListUpdate;", "threadMemberListUpdate", "handleThreadMemberListUpdate", "(Lcom/discord/api/thread/ThreadMemberListUpdate;)V", "Lcom/discord/api/thread/ThreadMembersUpdate;", "threadMembersUpdate", "handleThreadMembersUpdate", "(Lcom/discord/api/thread/ThreadMembersUpdate;)V", "Lcom/discord/api/guildscheduledevent/ApiGuildScheduledEventUser;", "apiGuildScheduledEventUsers", "handleGuildScheduledEventUsersFetch", "(Ljava/util/List;J)V", "handleGuildMemberRemove", "isFullGuildMember", "handleGuildMember", "(Lcom/discord/api/guildmember/GuildMember;JZ)V", "snapshotData", "()V", "", "guildRoles", "Ljava/util/Map;", "", "guildsUnavailable", "Ljava/util/Set;", "Lcom/discord/utilities/persister/Persister;", "guildsCache", "Lcom/discord/utilities/persister/Persister;", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "guildMembersComputedSnapshot", "guildsJoinedAtSnapshot", "guildsJoinedAt", "guilds", "Lcom/discord/stores/StoreUser;", "userStore", "Lcom/discord/stores/StoreUser;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "getMeId", "()J", "meId", "Lcom/discord/stores/ClientGuild;", "guildsSnapshot", "guildMembers", "guildRolesSnapshot", "guildRolesCache", "guildsUnavailableSnapshot", "guildMembersComputed", "guildsJoinedAtCache", "<init>", "(Lcom/discord/stores/StoreUser;Lcom/discord/stores/Dispatcher;Lcom/discord/stores/updates/ObservationDeck;)V", "Companion", "Actions", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreGuilds extends StoreV2 {
    private static final int HUGE_GUILD_SIZE = 2000;
    private final Dispatcher dispatcher;
    private final Map<Long, Map<Long, GuildMember>> guildMembers;
    private final Map<Long, Map<Long, com.discord.models.member.GuildMember>> guildMembersComputed;
    private Map<Long, ? extends Map<Long, com.discord.models.member.GuildMember>> guildMembersComputedSnapshot;
    private final Map<Long, Map<Long, GuildRole>> guildRoles;
    private final Persister<Map<Long, Map<Long, GuildRole>>> guildRolesCache;
    private Map<Long, ? extends Map<Long, GuildRole>> guildRolesSnapshot;
    private final Map<Long, Guild> guilds;
    private final Persister<Map<Long, Guild>> guildsCache;
    private final Map<Long, Long> guildsJoinedAt;
    private final Persister<Map<Long, Long>> guildsJoinedAtCache;
    private Map<Long, Long> guildsJoinedAtSnapshot;
    private Map<Long, Guild> guildsSnapshot;
    private final Set<Long> guildsUnavailable;
    private Set<Long> guildsUnavailableSnapshot;
    private final ObservationDeck observationDeck;
    private final StoreUser userStore;
    private static final Map<Long, com.discord.models.member.GuildMember> emptyComputedMap = new HashMap();
    private static final Map<Long, GuildRole> emptyRoles = new HashMap();
    private static final StoreGuilds8 GuildsUpdate = new StoreGuilds8();
    private static final StoreGuilds7 ComputedMembersUpdate = new StoreGuilds7();

    /* compiled from: StoreGuilds.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J/\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000bJ?\u0010\u0016\u001a\u00020\t2\n\u0010\u000e\u001a\u00060\fj\u0002`\r2\n\u0010\u0010\u001a\u00060\fj\u0002`\u000f2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/discord/stores/StoreGuilds$Actions;", "", "Lcom/discord/app/AppComponent;", "fragment", "Lrx/Observable;", "", "partialUserNameTokenEmitted", "", "autocomplete", "", "requestMembers", "(Lcom/discord/app/AppComponent;Lrx/Observable;Z)V", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/primitives/RoleId;", "roleId", "appComponent", "Lcom/discord/utilities/rest/RestAPI;", "restApi", "Lcom/discord/stores/StoreGatewayConnection;", "storeGatewayConnection", "requestRoleMembers", "(JJLcom/discord/app/AppComponent;Lcom/discord/utilities/rest/RestAPI;Lcom/discord/stores/StoreGatewayConnection;)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Actions {
        public static final Actions INSTANCE = new Actions();

        private Actions() {
        }

        public static final void requestMembers(AppComponent fragment, Observable<String> partialUserNameTokenEmitted, boolean autocomplete) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(partialUserNameTokenEmitted, "partialUserNameTokenEmitted");
            Observable observableY = partialUserNameTokenEmitted.p(1000L, TimeUnit.MILLISECONDS).G(new StoreGuilds2(autocomplete)).y(StoreGuilds3.INSTANCE).r().Y(StoreGuilds4.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableY, "partialUserNameTokenEmit…            }\n          }");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableY), fragment, null, 2, null), (Context) null, "requestGuildMembers", (Function1) null, StoreGuilds5.INSTANCE, (Function1) null, (Function0) null, (Function0) null, 117, (Object) null);
        }

        public static final void requestRoleMembers(long guildId, long roleId, AppComponent appComponent, RestAPI restApi, StoreGatewayConnection storeGatewayConnection) {
            Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
            Intrinsics3.checkNotNullParameter(restApi, "restApi");
            Intrinsics3.checkNotNullParameter(storeGatewayConnection, "storeGatewayConnection");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(restApi.getGuildRoleMemberIds(guildId, roleId)), appComponent, null, 2, null), INSTANCE.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreGuilds6(storeGatewayConnection, guildId), 62, (Object) null);
        }
    }

    /* compiled from: StoreGuilds.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuilds$handleGuildMemberCommunicationEnabled$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2) {
            super(0);
            this.$guildId = j;
            this.$userId = j2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGuilds.access$handleGuildMemberCommunicationEnabledInternal(StoreGuilds.this, this.$guildId, this.$userId);
        }
    }

    /* compiled from: StoreGuilds.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\u0010\t\u001a\u001e\u0012\b\u0012\u00060\u0001j\u0002`\u0002 \u0003*\u000e\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0018\u00010\u00000\u00002\"\u0010\u0004\u001a\u001e\u0012\b\u0012\u00060\u0001j\u0002`\u0002 \u0003*\u000e\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0018\u00010\u00000\u00002\u000e\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/ClientGuildMember;", "kotlin.jvm.PlatformType", "members", "", "<anonymous parameter 1>", NotificationCompat.CATEGORY_CALL, "(Ljava/util/List;Ljava/lang/Long;)Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuilds$initClearCommunicationDisabledObserver$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, R> implements Func2<List<? extends com.discord.models.member.GuildMember>, Long, List<? extends com.discord.models.member.GuildMember>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ List<? extends com.discord.models.member.GuildMember> call(List<? extends com.discord.models.member.GuildMember> list, Long l) {
            return call2((List<com.discord.models.member.GuildMember>) list, l);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final List<com.discord.models.member.GuildMember> call2(List<com.discord.models.member.GuildMember> list, Long l) {
            ArrayList arrayListA0 = outline.a0(list, "members");
            for (Object obj : list) {
                if (!((com.discord.models.member.GuildMember) obj).isCommunicationDisabled()) {
                    arrayListA0.add(obj);
                }
            }
            return arrayListA0;
        }
    }

    /* compiled from: StoreGuilds.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\"\u0010\u0004\u001a\u001e\u0012\b\u0012\u00060\u0001j\u0002`\u0002 \u0003*\u000e\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/ClientGuildMember;", "kotlin.jvm.PlatformType", "members", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuilds$initClearCommunicationDisabledObserver$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<List<? extends com.discord.models.member.GuildMember>, Unit> {

        /* compiled from: StoreGuilds.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreGuilds$initClearCommunicationDisabledObserver$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ List $members;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(List list) {
                super(0);
                this.$members = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                List<com.discord.models.member.GuildMember> list = this.$members;
                Intrinsics3.checkNotNullExpressionValue(list, "members");
                for (com.discord.models.member.GuildMember guildMember : list) {
                    StoreGuilds.access$handleGuildMemberCommunicationEnabledInternal(StoreGuilds.this, guildMember.getGuildId(), guildMember.getUserId());
                }
            }
        }

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends com.discord.models.member.GuildMember> list) {
            invoke2((List<com.discord.models.member.GuildMember>) list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<com.discord.models.member.GuildMember> list) {
            StoreGuilds.access$getDispatcher$p(StoreGuilds.this).schedule(new AnonymousClass1(list));
        }
    }

    /* compiled from: StoreGuilds.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\u0010\r\u001a\u001e\u0012\b\u0012\u00060\u0007j\u0002`\b \u0003*\u000e\u0012\b\u0012\u00060\u0007j\u0002`\b\u0018\u00010\n0\n2\"\u0010\u0004\u001a\u001e\u0012\b\u0012\u00060\u0001j\u0002`\u0002 \u0003*\u000e\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0018\u00010\u00000\u00002V\u0010\t\u001aR\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0001j\u0002`\u0006\u0012\b\u0012\u00060\u0007j\u0002`\b0\u0005 \u0003*(\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0001j\u0002`\u0006\u0012\b\u0012\u00060\u0007j\u0002`\b0\u0005\u0018\u00010\u00050\u0005H\n¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"", "", "Lcom/discord/primitives/GuildId;", "kotlin.jvm.PlatformType", "guildIds", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/ClientGuildMember;", "members", "", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Set;Ljava/util/Map;)Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuilds$observeCommunicationDisabledGuildMembers$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, R> implements Func2<Set<? extends Long>, Map<Long, ? extends Map<Long, ? extends com.discord.models.member.GuildMember>>, List<? extends com.discord.models.member.GuildMember>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ List<? extends com.discord.models.member.GuildMember> call(Set<? extends Long> set, Map<Long, ? extends Map<Long, ? extends com.discord.models.member.GuildMember>> map) {
            return call2((Set<Long>) set, (Map<Long, ? extends Map<Long, com.discord.models.member.GuildMember>>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final List<com.discord.models.member.GuildMember> call2(Set<Long> set, Map<Long, ? extends Map<Long, com.discord.models.member.GuildMember>> map) {
            ArrayList arrayList;
            Collection<com.discord.models.member.GuildMember> collectionValues;
            Intrinsics3.checkNotNullExpressionValue(set, "guildIds");
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                Map<Long, com.discord.models.member.GuildMember> map2 = map.get(Long.valueOf(((Number) it.next()).longValue()));
                if (map2 == null || (collectionValues = map2.values()) == null) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList();
                    for (Object obj : collectionValues) {
                        if (((com.discord.models.member.GuildMember) obj).isCommunicationDisabled()) {
                            arrayList.add(obj);
                        }
                    }
                }
                if (arrayList != null) {
                    arrayList2.add(arrayList);
                }
            }
            return Iterables2.flatten(arrayList2);
        }
    }

    /* compiled from: StoreGuilds.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a&\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0001j\u0002`\u0003\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u00000\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "", "Lcom/discord/primitives/GuildId;", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/ClientGuildMember;", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuilds$observeComputed$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends Map<Long, ? extends com.discord.models.member.GuildMember>>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends Map<Long, ? extends com.discord.models.member.GuildMember>> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends Map<Long, ? extends com.discord.models.member.GuildMember>> invoke2() {
            return StoreGuilds.this.getMembers();
        }
    }

    /* compiled from: StoreGuilds.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\n\u001a2\u0012\b\u0012\u00060\u0001j\u0002`\u0003\u0012\b\u0012\u00060\u0004j\u0002`\u0005 \u0006*\u0018\u0012\b\u0012\u00060\u0001j\u0002`\u0003\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0018\u00010\u00000\u00002V\u0010\u0007\u001aR\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0001j\u0002`\u0003\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u0000 \u0006*(\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0001j\u0002`\u0003\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u0000\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"", "", "Lcom/discord/primitives/GuildId;", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/ClientGuildMember;", "kotlin.jvm.PlatformType", "computed", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuilds$observeComputed$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements Func1<Map<Long, ? extends Map<Long, ? extends com.discord.models.member.GuildMember>>, Map<Long, ? extends com.discord.models.member.GuildMember>> {
        public final /* synthetic */ long $guildId;

        public AnonymousClass2(long j) {
            this.$guildId = j;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Map<Long, ? extends com.discord.models.member.GuildMember> call(Map<Long, ? extends Map<Long, ? extends com.discord.models.member.GuildMember>> map) {
            return call2((Map<Long, ? extends Map<Long, com.discord.models.member.GuildMember>>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Map<Long, com.discord.models.member.GuildMember> call2(Map<Long, ? extends Map<Long, com.discord.models.member.GuildMember>> map) {
            Map<Long, com.discord.models.member.GuildMember> map2 = map.get(Long.valueOf(this.$guildId));
            return map2 != null ? map2 : StoreGuilds.access$getEmptyComputedMap$cp();
        }
    }

    /* compiled from: StoreGuilds.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/ClientGuildMember;", "invoke", "()Lcom/discord/models/member/GuildMember;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuilds$observeComputedMember$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<com.discord.models.member.GuildMember> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2) {
            super(0);
            this.$guildId = j;
            this.$userId = j2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ com.discord.models.member.GuildMember invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final com.discord.models.member.GuildMember invoke() {
            return StoreGuilds.this.getMember(this.$guildId, this.$userId);
        }
    }

    /* compiled from: StoreGuilds.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u001e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0003 \u0004*\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/api/channel/Channel;", "channel", "Lrx/Observable;", "Lcom/discord/models/guild/Guild;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/channel/Channel;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuilds$observeFromChannelId$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Channel, Observable<? extends Guild>> {
        public AnonymousClass1() {
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Guild> call(Channel channel) {
            return call2(channel);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Guild> call2(Channel channel) {
            return channel != null ? StoreGuilds.this.observeGuild(channel.getGuildId()) : new ScalarSynchronousObservable(null);
        }
    }

    /* compiled from: StoreGuilds.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\b\u001a\u0004\u0018\u00010\u00032.\u0010\u0005\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003 \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "", "Lcom/discord/primitives/GuildId;", "Lcom/discord/models/guild/Guild;", "kotlin.jvm.PlatformType", "guilds", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Lcom/discord/models/guild/Guild;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuilds$observeGuild$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Map<Long, ? extends Guild>, Guild> {
        public final /* synthetic */ long $guildId;

        public AnonymousClass1(long j) {
            this.$guildId = j;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Guild call(Map<Long, ? extends Guild> map) {
            return call2((Map<Long, Guild>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Guild call2(Map<Long, Guild> map) {
            return map.get(Long.valueOf(this.$guildId));
        }
    }

    /* compiled from: StoreGuilds.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u0003\u0010\n\u001aR\u0012\"\b\u0001\u0012\u001e\u0012\b\u0012\u00060\u0001j\u0002`\u0002 \u0004*\u000e\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0018\u00010\u00070\u0007 \u0004*(\u0012\"\b\u0001\u0012\u001e\u0012\b\u0012\u00060\u0001j\u0002`\u0002 \u0004*\u000e\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0018\u00010\u00070\u0007\u0018\u00010\u00060\u00062.\u0010\u0005\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003 \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"", "", "Lcom/discord/primitives/GuildId;", "Lcom/discord/models/guild/Guild;", "kotlin.jvm.PlatformType", "guilds", "Lrx/Observable;", "", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuilds$observeGuildIds$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Map<Long, ? extends Guild>, Observable<? extends Set<? extends Long>>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Set<? extends Long>> call(Map<Long, ? extends Guild> map) {
            return call2((Map<Long, Guild>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Set<Long>> call2(Map<Long, Guild> map) {
            return new ScalarSynchronousObservable(map.keySet());
        }
    }

    /* compiled from: StoreGuilds.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\n\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00052V\u0010\u0007\u001aR\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0001j\u0002`\u0003\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u0000 \u0006*(\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0001j\u0002`\u0003\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u0000\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"", "", "Lcom/discord/primitives/GuildId;", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/ClientGuildMember;", "kotlin.jvm.PlatformType", "members", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Lcom/discord/models/member/GuildMember;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuilds$observeGuildMember$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Map<Long, ? extends Map<Long, ? extends com.discord.models.member.GuildMember>>, com.discord.models.member.GuildMember> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ long $userId;

        public AnonymousClass1(long j, long j2) {
            this.$guildId = j;
            this.$userId = j2;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ com.discord.models.member.GuildMember call(Map<Long, ? extends Map<Long, ? extends com.discord.models.member.GuildMember>> map) {
            return call2((Map<Long, ? extends Map<Long, com.discord.models.member.GuildMember>>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final com.discord.models.member.GuildMember call2(Map<Long, ? extends Map<Long, com.discord.models.member.GuildMember>> map) {
            Map<Long, com.discord.models.member.GuildMember> map2 = map.get(Long.valueOf(this.$guildId));
            if (map2 != null) {
                return map2.get(Long.valueOf(this.$userId));
            }
            return null;
        }
    }

    /* compiled from: StoreGuilds.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\n\u001a2\u0012\b\u0012\u00060\u0001j\u0002`\u0003\u0012\b\u0012\u00060\u0004j\u0002`\u0005 \u0006*\u0018\u0012\b\u0012\u00060\u0001j\u0002`\u0003\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0018\u00010\u00000\u00002V\u0010\u0007\u001aR\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0001j\u0002`\u0003\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u0000 \u0006*(\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0001j\u0002`\u0003\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u0000\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"", "", "Lcom/discord/primitives/GuildId;", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/ClientGuildMember;", "kotlin.jvm.PlatformType", "members", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuilds$observeGuildMembers$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Map<Long, ? extends Map<Long, ? extends com.discord.models.member.GuildMember>>, Map<Long, ? extends com.discord.models.member.GuildMember>> {
        public final /* synthetic */ long $guildId;

        public AnonymousClass1(long j) {
            this.$guildId = j;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Map<Long, ? extends com.discord.models.member.GuildMember> call(Map<Long, ? extends Map<Long, ? extends com.discord.models.member.GuildMember>> map) {
            return call2((Map<Long, ? extends Map<Long, com.discord.models.member.GuildMember>>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Map<Long, com.discord.models.member.GuildMember> call2(Map<Long, ? extends Map<Long, com.discord.models.member.GuildMember>> map) {
            Map<Long, com.discord.models.member.GuildMember> map2 = map.get(Long.valueOf(this.$guildId));
            return map2 != null ? map2 : Maps6.emptyMap();
        }
    }

    /* compiled from: StoreGuilds.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u00030\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "", "Lcom/discord/primitives/GuildId;", "Lcom/discord/models/guild/Guild;", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuilds$observeGuilds$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends Guild>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends Guild> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends Guild> invoke2() {
            return StoreGuilds.this.getGuilds();
        }
    }

    /* compiled from: StoreGuilds.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u0016\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0001j\u0002`\u00030\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "", "Lcom/discord/primitives/GuildId;", "Lcom/discord/primitives/Timestamp;", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuilds$observeJoinedAt$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends Long>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends Long> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends Long> invoke2() {
            return StoreGuilds.this.getGuildsJoinedAt();
        }
    }

    /* compiled from: StoreGuilds.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\b\u001a\n \u0004*\u0004\u0018\u00010\u00010\u000126\u0010\u0005\u001a2\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0001j\u0002`\u0003 \u0004*\u0018\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0001j\u0002`\u0003\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "", "Lcom/discord/primitives/GuildId;", "Lcom/discord/primitives/Timestamp;", "kotlin.jvm.PlatformType", "joinedAt", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Ljava/lang/Long;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuilds$observeJoinedAt$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements Func1<Map<Long, ? extends Long>, Long> {
        public final /* synthetic */ long $guildId;

        public AnonymousClass2(long j) {
            this.$guildId = j;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Long call(Map<Long, ? extends Long> map) {
            return call2((Map<Long, Long>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Long call2(Map<Long, Long> map) {
            return Long.valueOf(GuildMemberUtils.getJoinedAtOrNow(map.get(Long.valueOf(this.$guildId))));
        }
    }

    /* compiled from: StoreGuilds.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\"\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0003\u0012\u0004\u0012\u00020\u00040\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "", "Lcom/discord/primitives/GuildId;", "Lcom/discord/primitives/RoleId;", "Lcom/discord/api/role/GuildRole;", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuilds$observeRoles$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends Map<Long, ? extends GuildRole>>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends Map<Long, ? extends GuildRole>> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends Map<Long, ? extends GuildRole>> invoke2() {
            return StoreGuilds.this.getRoles();
        }
    }

    /* compiled from: StoreGuilds.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\t\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0003\u0012\u0004\u0012\u00020\u0004 \u0005*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00000\u00002N\u0010\u0006\u001aJ\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0003\u0012\u0004\u0012\u00020\u00040\u0000 \u0005*$\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0003\u0012\u0004\u0012\u00020\u00040\u0000\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "", "Lcom/discord/primitives/GuildId;", "Lcom/discord/primitives/RoleId;", "Lcom/discord/api/role/GuildRole;", "kotlin.jvm.PlatformType", "roles", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuilds$observeRoles$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements Func1<Map<Long, ? extends Map<Long, ? extends GuildRole>>, Map<Long, ? extends GuildRole>> {
        public final /* synthetic */ long $guildId;

        public AnonymousClass2(long j) {
            this.$guildId = j;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Map<Long, ? extends GuildRole> call(Map<Long, ? extends Map<Long, ? extends GuildRole>> map) {
            return call2((Map<Long, ? extends Map<Long, GuildRole>>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Map<Long, GuildRole> call2(Map<Long, ? extends Map<Long, GuildRole>> map) {
            Map<Long, GuildRole> map2 = map.get(Long.valueOf(this.$guildId));
            return map2 != null ? map2 : StoreGuilds.access$getEmptyRoles$cp();
        }
    }

    /* compiled from: StoreGuilds.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\u0010\n\u001aB\u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00070\u0007 \u0004* \u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00070\u0007\u0018\u00010\u00060\u00062.\u0010\u0005\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003 \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"", "", "Lcom/discord/primitives/RoleId;", "Lcom/discord/api/role/GuildRole;", "kotlin.jvm.PlatformType", "roles", "Lrx/Observable;", "", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuilds$observeSortedRoles$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Map<Long, ? extends GuildRole>, Observable<? extends List<? extends GuildRole>>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends List<? extends GuildRole>> call(Map<Long, ? extends GuildRole> map) {
            return call2((Map<Long, GuildRole>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends List<GuildRole>> call2(Map<Long, GuildRole> map) {
            return new ScalarSynchronousObservable(_Collections.sortedWith(map.values(), RoleUtils.getROLE_COMPARATOR()));
        }
    }

    /* compiled from: StoreGuilds.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0001j\u0002`\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "", "Lcom/discord/primitives/GuildId;", "invoke", "()Ljava/util/Set;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuilds$observeUnavailableGuilds$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Set<? extends Long>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Set<? extends Long> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Set<? extends Long> invoke2() {
            return StoreGuilds.this.getUnavailableGuilds();
        }
    }

    /* compiled from: StoreGuilds.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/api/guild/GuildVerificationLevel;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/guild/Guild;)Lcom/discord/api/guild/GuildVerificationLevel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuilds$observeVerificationLevel$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Guild, GuildVerificationLevel> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ GuildVerificationLevel call(Guild guild) {
            return call2(guild);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final GuildVerificationLevel call2(Guild guild) {
            GuildVerificationLevel verificationLevel;
            return (guild == null || (verificationLevel = guild.getVerificationLevel()) == null) ? GuildVerificationLevel.NONE : verificationLevel;
        }
    }

    public /* synthetic */ StoreGuilds(StoreUser storeUser, Dispatcher dispatcher, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeUser, dispatcher, (i & 4) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreGuilds storeGuilds) {
        return storeGuilds.dispatcher;
    }

    public static final /* synthetic */ Map access$getEmptyComputedMap$cp() {
        return emptyComputedMap;
    }

    public static final /* synthetic */ Map access$getEmptyRoles$cp() {
        return emptyRoles;
    }

    public static final /* synthetic */ void access$handleGuildMemberCommunicationEnabledInternal(StoreGuilds storeGuilds, long j, long j2) {
        storeGuilds.handleGuildMemberCommunicationEnabledInternal(j, j2);
    }

    private final long getMeId() {
        return this.userStore.getMe().getId();
    }

    @Store3
    private final void handleGuild(com.discord.api.guild.Guild guild, boolean remove) {
        long id2 = guild.getId();
        if (remove) {
            if (this.guilds.containsKey(Long.valueOf(id2))) {
                this.guilds.remove(Long.valueOf(id2));
                markChanged(GuildsUpdate);
                return;
            }
            return;
        }
        Guild guild2 = this.guilds.get(Long.valueOf(id2));
        if (guild2 == null) {
            guild2 = new Guild(null, null, null, null, null, 0, 0L, null, 0L, null, null, null, false, 0, 0, null, null, null, 0, null, null, 0, 0, 0, null, null, null, null, null, null, null, 0, false, null, -1, 3, null);
        }
        Guild guildMerge = guild2.merge(guild);
        if (!Intrinsics3.areEqual(guildMerge, this.guilds.get(Long.valueOf(id2)))) {
            this.guilds.put(Long.valueOf(id2), guildMerge);
            markChanged(GuildsUpdate);
        }
    }

    public static /* synthetic */ void handleGuildMember$default(StoreGuilds storeGuilds, GuildMember guildMember, long j, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        storeGuilds.handleGuildMember(guildMember, j, z2);
    }

    @Store3
    private final void handleGuildMemberCommunicationEnabledInternal(long guildId, long userId) {
        Map<Long, GuildMember> map = this.guildMembers.get(Long.valueOf(guildId));
        GuildMember guildMember = map != null ? map.get(Long.valueOf(userId)) : null;
        if ((guildMember != null ? guildMember.getCommunicationDisabledUntil() : null) == null) {
            return;
        }
        GuildMember guildMemberA = GuildMember.a(guildMember, 0L, null, null, null, null, null, false, null, null, null, null, null, null, 4095);
        handleGuildMember$default(this, guildMemberA, guildId, false, 4, null);
        if (userId == getMeId()) {
            StoreStream.INSTANCE.getPermissions().handleGuildMemberAdd(guildMemberA);
        }
    }

    @Store3
    private final void handleGuildMembers(long guildId, long removedGuildMemberUserId, Collection<GuildMember> members, boolean remove) {
        if (!remove) {
            if (members != null) {
                Iterator<T> it = members.iterator();
                while (it.hasNext()) {
                    handleGuildMember$default(this, (GuildMember) it.next(), guildId, false, 4, null);
                }
                return;
            }
            return;
        }
        if (removedGuildMemberUserId <= 0) {
            if (this.guildMembers.remove(Long.valueOf(guildId)) != null) {
                markChanged(GuildsUpdate);
            }
            if (this.guildMembersComputed.remove(Long.valueOf(guildId)) != null) {
                markChanged(ComputedMembersUpdate);
                return;
            }
            return;
        }
        Map<Long, GuildMember> map = this.guildMembers.get(Long.valueOf(guildId));
        if ((map != null ? map.remove(Long.valueOf(removedGuildMemberUserId)) : null) != null) {
            markChanged(GuildsUpdate);
        }
        Map<Long, com.discord.models.member.GuildMember> map2 = this.guildMembersComputed.get(Long.valueOf(guildId));
        if ((map2 != null ? map2.remove(Long.valueOf(removedGuildMemberUserId)) : null) != null) {
            markChanged(ComputedMembersUpdate);
        }
    }

    @Store3
    private final void handleGuildMembersMap(long guildId, Map<Long, GuildMember> members) {
        handleGuildMembers(guildId, 0L, members != null ? members.values() : null, false);
    }

    @Store3
    private final void handleGuildRoles(long guildId, long deletedRoleId, List<GuildRole> roles, boolean remove) {
        if (remove) {
            if (deletedRoleId > 0) {
                Map<Long, GuildRole> map = this.guildRoles.get(Long.valueOf(guildId));
                if ((map != null ? map.remove(Long.valueOf(deletedRoleId)) : null) != null) {
                    markChanged(GuildsUpdate);
                    return;
                }
                return;
            }
            if (this.guildRoles.containsKey(Long.valueOf(guildId))) {
                this.guildRoles.remove(Long.valueOf(guildId));
                markChanged(GuildsUpdate);
                return;
            }
            return;
        }
        Map<Long, Map<Long, GuildRole>> map2 = this.guildRoles;
        Long lValueOf = Long.valueOf(guildId);
        Map<Long, GuildRole> map3 = map2.get(lValueOf);
        if (map3 == null) {
            map3 = new HashMap<>();
            map2.put(lValueOf, map3);
        }
        Map<Long, GuildRole> map4 = map3;
        if (roles != null) {
            for (GuildRole guildRole : roles) {
                if (!Intrinsics3.areEqual(map4.get(Long.valueOf(guildRole.getId())), guildRole)) {
                    map4.put(Long.valueOf(guildRole.getId()), guildRole);
                    markChanged(GuildsUpdate);
                }
            }
        }
    }

    @Store3
    private final void handleGuildUnavailable(long guildId, boolean unavailable, boolean remove) {
        if (remove) {
            if (!unavailable || this.guildsUnavailable.contains(Long.valueOf(guildId))) {
                return;
            }
            this.guildsUnavailable.add(Long.valueOf(guildId));
            markChanged(GuildsUpdate);
            return;
        }
        if (unavailable || !this.guildsUnavailable.contains(Long.valueOf(guildId))) {
            return;
        }
        this.guildsUnavailable.remove(Long.valueOf(guildId));
        markChanged(GuildsUpdate);
    }

    @Store3
    private final void handleHasRoleAndJoinedAt(long guildId, Map<Long, GuildMember> members) {
        GuildMember guildMember;
        Long l;
        MeUser meInternal$app_productionGoogleRelease = this.userStore.getMe();
        if (members == null || (guildMember = members.get(Long.valueOf(meInternal$app_productionGoogleRelease.getId()))) == null) {
            return;
        }
        UtcDateTime joinedAt = guildMember.getJoinedAt();
        long dateTimeMillis = joinedAt != null ? joinedAt.getDateTimeMillis() : 0L;
        if (this.guildsJoinedAt.containsKey(Long.valueOf(guildId)) && (l = this.guildsJoinedAt.get(Long.valueOf(guildId))) != null && l.longValue() == dateTimeMillis) {
            return;
        }
        this.guildsJoinedAt.put(Long.valueOf(guildId), Long.valueOf(dateTimeMillis));
        markChanged(GuildsUpdate);
    }

    private final void initClearCommunicationDisabledObserver(Context ctx) {
        Observable observableR = Observable.j(observeCommunicationDisabledGuildMembers(), Observable.E(0L, 10L, TimeUnit.SECONDS), AnonymousClass1.INSTANCE).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "Observable.combineLatest…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationLatest(observableR), StoreGuilds.class, ctx, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 60, (Object) null);
    }

    public final Guild getGuild(long guildId) {
        return this.guildsSnapshot.get(Long.valueOf(guildId));
    }

    @Store3
    public final Map<Long, Map<Long, com.discord.models.member.GuildMember>> getGuildMembersComputedInternal$app_productionGoogleRelease() {
        return this.guildMembersComputed;
    }

    @Store3
    public final Map<Long, Map<Long, GuildRole>> getGuildRolesInternal$app_productionGoogleRelease() {
        return this.guildRoles;
    }

    public final Map<Long, Guild> getGuilds() {
        return this.guildsSnapshot;
    }

    @Store3
    public final Map<Long, Guild> getGuildsInternal$app_productionGoogleRelease() {
        return this.guilds;
    }

    public final Map<Long, Long> getGuildsJoinedAt() {
        return this.guildsJoinedAtSnapshot;
    }

    @Store3
    public final Map<Long, Long> getGuildsJoinedAtInternal$app_productionGoogleRelease() {
        return this.guildsJoinedAt;
    }

    public final com.discord.models.member.GuildMember getMember(long guildId, long userId) {
        Map<Long, com.discord.models.member.GuildMember> map = this.guildMembersComputedSnapshot.get(Long.valueOf(guildId));
        if (map != null) {
            return map.get(Long.valueOf(userId));
        }
        return null;
    }

    public final Map<Long, Map<Long, com.discord.models.member.GuildMember>> getMembers() {
        return this.guildMembersComputedSnapshot;
    }

    public final Map<Long, Map<Long, GuildRole>> getRoles() {
        return this.guildRolesSnapshot;
    }

    public final Set<Long> getUnavailableGuilds() {
        return this.guildsUnavailableSnapshot;
    }

    @Store3
    public final Set<Long> getUnavailableGuildsInternal$app_productionGoogleRelease() {
        return this.guildsUnavailable;
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Map<Long, GuildMember> mapEmptyMap;
        Intrinsics3.checkNotNullParameter(payload, "payload");
        this.guilds.clear();
        this.guildMembers.clear();
        this.guildMembersComputed.clear();
        this.guildRoles.clear();
        this.guildsUnavailable.clear();
        for (com.discord.api.guild.Guild guild : payload.getGuilds()) {
            long id2 = guild.getId();
            if (guild.getUnavailable()) {
                this.guildsUnavailable.add(Long.valueOf(id2));
            } else {
                handleGuildRoles(id2, 0L, guild.G(), false);
                Intrinsics3.checkNotNullExpressionValue(guild, "guild");
                handleGuild(guild, false);
                List<GuildMember> listV = guild.v();
                if (listV == null || (mapEmptyMap = GuildUtils.asMap(listV)) == null) {
                    mapEmptyMap = Maps6.emptyMap();
                }
                handleGuildMembersMap(id2, mapEmptyMap);
                handleHasRoleAndJoinedAt(id2, mapEmptyMap);
            }
        }
        markChanged(GuildsUpdate, ComputedMembersUpdate);
    }

    @Store3
    public final void handleGuildAdd(com.discord.api.guild.Guild guild) {
        Map<Long, GuildMember> mapEmptyMap;
        Intrinsics3.checkNotNullParameter(guild, "guild");
        handleGuildUnavailable(guild.getId(), guild.getUnavailable(), false);
        if (guild.getUnavailable()) {
            return;
        }
        handleGuildRoles(guild.getId(), 0L, guild.G(), false);
        handleGuild(guild, false);
        List<GuildMember> listV = guild.v();
        if (listV == null || (mapEmptyMap = GuildUtils.asMap(listV)) == null) {
            mapEmptyMap = Maps6.emptyMap();
        }
        handleGuildMembersMap(guild.getId(), mapEmptyMap);
        handleHasRoleAndJoinedAt(guild.getId(), mapEmptyMap);
    }

    @Store3
    public final void handleGuildMember(GuildMember member, long guildId, boolean isFullGuildMember) {
        GuildMember guildMemberA = member;
        Intrinsics3.checkNotNullParameter(guildMemberA, "member");
        long id2 = member.getUser().getId();
        if (!this.guildMembers.containsKey(Long.valueOf(guildId))) {
            this.guildMembers.put(Long.valueOf(guildId), new HashMap());
        }
        if (!this.guildMembersComputed.containsKey(Long.valueOf(guildId))) {
            this.guildMembersComputed.put(Long.valueOf(guildId), new HashMap());
        }
        Map<Long, GuildMember> map = this.guildMembers.get(Long.valueOf(guildId));
        Intrinsics3.checkNotNull(map);
        GuildMember guildMember = map.get(Long.valueOf(id2));
        if (!isFullGuildMember && guildMember != null) {
            guildMemberA = GuildMember.a(member, 0L, null, null, null, null, null, false, null, null, null, guildMember.getBio(), guildMember.getBanner(), null, 5119);
        }
        GuildMember guildMember2 = guildMemberA;
        if (!Intrinsics3.areEqual(guildMember2, guildMember)) {
            Map<Long, GuildMember> map2 = this.guildMembers.get(Long.valueOf(guildId));
            Intrinsics3.checkNotNull(map2);
            map2.put(Long.valueOf(id2), guildMember2);
        }
        com.discord.models.member.GuildMember guildMemberFrom$default = GuildMember.Companion.from$default(com.discord.models.member.GuildMember.INSTANCE, guildMember2, guildId, this.guildRoles.get(Long.valueOf(guildId)), null, 8, null);
        Intrinsics3.checkNotNull(this.guildMembersComputed.get(Long.valueOf(guildId)));
        if (!Intrinsics3.areEqual(guildMemberFrom$default, r3.get(Long.valueOf(id2)))) {
            Map<Long, com.discord.models.member.GuildMember> map3 = this.guildMembersComputed.get(Long.valueOf(guildId));
            Intrinsics3.checkNotNull(map3);
            map3.put(Long.valueOf(id2), guildMemberFrom$default);
            markChanged(ComputedMembersUpdate);
        }
    }

    @Store3
    public final void handleGuildMemberAdd(com.discord.api.guildmember.GuildMember member) {
        Intrinsics3.checkNotNullParameter(member, "member");
        handleGuildMember$default(this, member, member.getGuildId(), false, 4, null);
    }

    public final void handleGuildMemberCommunicationEnabled(long guildId, long userId) {
        this.dispatcher.schedule(new AnonymousClass1(guildId, userId));
    }

    @Store3
    public final void handleGuildMemberRemove(long guildId, long userId) {
        handleGuildMembers(guildId, userId, null, true);
    }

    @Store3
    public final void handleGuildMembersChunk(GuildMembersChunk chunk) {
        Intrinsics3.checkNotNullParameter(chunk, "chunk");
        handleGuildMembers(chunk.getGuildId(), 0L, chunk.b(), false);
    }

    @Store3
    public final void handleGuildRemove(com.discord.api.guild.Guild guild) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        handleGuildUnavailable(guild.getId(), guild.getUnavailable(), true);
        handleGuild(guild, true);
        handleGuildRoles(guild.getId(), 0L, null, true);
        handleGuildMembers(guild.getId(), 0L, null, true);
    }

    @Store3
    public final void handleGuildRoleCreateOrUpdate(long guildId, GuildRole role) {
        Intrinsics3.checkNotNullParameter(role, "role");
        handleGuildRoles(guildId, 0L, CollectionsJVM.listOf(role), false);
        handleGuildMembersMap(guildId, this.guildMembers.get(Long.valueOf(guildId)));
        handleHasRoleAndJoinedAt(guildId, this.guildMembers.get(Long.valueOf(guildId)));
    }

    @Store3
    public final void handleGuildRoleRemove(long roleId, long guildId) {
        handleGuildRoles(guildId, roleId, null, true);
        handleGuildMembersMap(guildId, this.guildMembers.get(Long.valueOf(guildId)));
        handleHasRoleAndJoinedAt(guildId, this.guildMembers.get(Long.valueOf(guildId)));
    }

    @Store3
    public final void handleGuildScheduledEventUsersFetch(List<ApiGuildScheduledEventUser> apiGuildScheduledEventUsers, long guildId) {
        Intrinsics3.checkNotNullParameter(apiGuildScheduledEventUsers, "apiGuildScheduledEventUsers");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = apiGuildScheduledEventUsers.iterator();
        while (it.hasNext()) {
            com.discord.api.guildmember.GuildMember guildMemberA = ((ApiGuildScheduledEventUser) it.next()).a(guildId);
            if (guildMemberA != null) {
                arrayList.add(guildMemberA);
            }
        }
        handleGuildMembers(guildId, 0L, arrayList, false);
    }

    @Store3
    public final void handleThreadMemberListUpdate(ThreadMemberListUpdate threadMemberListUpdate) {
        ArrayList arrayList;
        Intrinsics3.checkNotNullParameter(threadMemberListUpdate, "threadMemberListUpdate");
        long jA = threadMemberListUpdate.getGuildId();
        List<ThreadListMember> listB = threadMemberListUpdate.b();
        if (listB != null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it = listB.iterator();
            while (it.hasNext()) {
                com.discord.api.guildmember.GuildMember guildMemberA = ((ThreadListMember) it.next()).getMember();
                if (guildMemberA != null) {
                    arrayList2.add(guildMemberA);
                }
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        handleGuildMembers(jA, 0L, arrayList, false);
    }

    @Store3
    public final void handleThreadMembersUpdate(ThreadMembersUpdate threadMembersUpdate) {
        ArrayList arrayList;
        Intrinsics3.checkNotNullParameter(threadMembersUpdate, "threadMembersUpdate");
        long jB = threadMembersUpdate.getGuildId();
        List<AugmentedThreadMember> listA = threadMembersUpdate.a();
        if (listA != null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it = listA.iterator();
            while (it.hasNext()) {
                com.discord.api.guildmember.GuildMember guildMemberC = ((AugmentedThreadMember) it.next()).getMember();
                if (guildMemberC != null) {
                    arrayList2.add(guildMemberC);
                }
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        handleGuildMembers(jB, 0L, arrayList, false);
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        this.guilds.putAll(CollectionExtensions.filterNonNullValues(this.guildsCache.get()));
        Map<Long, Map<Long, GuildRole>> map = this.guildRolesCache.get();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Map.Entry<Long, Map<Long, GuildRole>>> it = map.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<Long, Map<Long, GuildRole>> next = it.next();
            if (next.getKey() != null) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            this.guildRoles.put(Long.valueOf(((Number) entry.getKey()).longValue()), Maps6.toMutableMap((Map) entry.getValue()));
        }
        this.guildsJoinedAt.putAll(this.guildsJoinedAtCache.get());
        markChanged(GuildsUpdate, ComputedMembersUpdate);
        initClearCommunicationDisabledObserver(context);
    }

    public final Observable<List<com.discord.models.member.GuildMember>> observeCommunicationDisabledGuildMembers() {
        Observable<List<com.discord.models.member.GuildMember>> observableR = Observable.j(observeGuildIds(), observeComputed(), AnonymousClass1.INSTANCE).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "Observable.combineLatest…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, Map<Long, com.discord.models.member.GuildMember>>> observeComputed() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{ComputedMembersUpdate}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final Observable<com.discord.models.member.GuildMember> observeComputedMember(long guildId, long userId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{ComputedMembersUpdate}, false, null, null, new AnonymousClass1(guildId, userId), 14, null);
    }

    public final Observable<Guild> observeFromChannelId(long channelId) {
        Observable observableY = StoreStream.INSTANCE.getChannels().observeChannel(channelId).Y(new AnonymousClass1());
        Intrinsics3.checkNotNullExpressionValue(observableY, "StoreStream\n        .get…ll)\n          }\n        }");
        return observableY;
    }

    public final Observable<Guild> observeGuild(long guildId) {
        Observable<Guild> observableR = observeGuilds().G(new AnonymousClass1(guildId)).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observeGuilds()\n        …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Set<Long>> observeGuildIds() {
        Observable<Set<Long>> observableR = observeGuilds().Y(AnonymousClass1.INSTANCE).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observeGuilds()\n        …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<com.discord.models.member.GuildMember> observeGuildMember(long guildId, long userId) {
        return observeComputed().G(new AnonymousClass1(guildId, userId)).r();
    }

    public final Observable<Map<Long, com.discord.models.member.GuildMember>> observeGuildMembers(long guildId) {
        return observeComputed().G(new AnonymousClass1(guildId)).r();
    }

    public final Observable<Map<Long, Guild>> observeGuilds() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{GuildsUpdate}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final Observable<Map<Long, Long>> observeJoinedAt() {
        Observable<Map<Long, Long>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{GuildsUpdate}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck\n        …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, Map<Long, GuildRole>>> observeRoles() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{GuildsUpdate}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final Observable<List<GuildRole>> observeSortedRoles(long guildId) {
        Observable<List<GuildRole>> observableR = observeRoles(guildId).Y(AnonymousClass1.INSTANCE).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observeRoles(guildId)\n  …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Set<Long>> observeUnavailableGuilds() {
        Observable<Set<Long>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{GuildsUpdate}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck\n        …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<GuildVerificationLevel> observeVerificationLevel(long guildId) {
        Observable<GuildVerificationLevel> observableR = observeGuild(guildId).G(AnonymousClass1.INSTANCE).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observeGuild(guildId)\n  …  .distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        SnowflakePartitionMap.CopiablePartitionMap copiablePartitionMap;
        super.snapshotData();
        if (getUpdateSources().contains(GuildsUpdate)) {
            HashMap map = new HashMap(this.guildsJoinedAt);
            this.guildsJoinedAtSnapshot = map;
            Persister.set$default(this.guildsJoinedAtCache, map, false, 2, null);
            this.guildsSnapshot = new HashMap(this.guilds);
            Persister.set$default(this.guildsCache, Maps6.minus((Map) this.guilds, (Iterable) StoreStream.INSTANCE.getLurking().getLurkingGuildIdsSync()), false, 2, null);
            this.guildsUnavailableSnapshot = new HashSet(this.guildsUnavailable);
            Map<Long, Map<Long, GuildRole>> map2 = this.guildRoles;
            LinkedHashMap linkedHashMap = new LinkedHashMap(MapsJVM.mapCapacity(map2.size()));
            Iterator<T> it = map2.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                linkedHashMap.put(entry.getKey(), new HashMap((Map) entry.getValue()));
            }
            this.guildRolesSnapshot = linkedHashMap;
            Persister.set$default(this.guildRolesCache, linkedHashMap, false, 2, null);
        }
        if (getUpdateSources().contains(ComputedMembersUpdate)) {
            HashMap map3 = new HashMap();
            for (Map.Entry<Long, Map<Long, com.discord.models.member.GuildMember>> entry2 : this.guildMembersComputed.entrySet()) {
                Map<Long, com.discord.models.member.GuildMember> value = entry2.getValue();
                if (value.size() < 2000) {
                    map3.put(entry2.getKey(), new HashMap(value));
                } else {
                    if (value instanceof SnowflakePartitionMap.CopiablePartitionMap) {
                        copiablePartitionMap = (SnowflakePartitionMap.CopiablePartitionMap) value;
                    } else {
                        SnowflakePartitionMap.CopiablePartitionMap copiablePartitionMap2 = new SnowflakePartitionMap.CopiablePartitionMap(0, 1, null);
                        copiablePartitionMap2.putAll(value);
                        entry2.setValue(copiablePartitionMap2);
                        copiablePartitionMap = copiablePartitionMap2;
                    }
                    map3.put(entry2.getKey(), copiablePartitionMap.fastCopy());
                }
            }
            this.guildMembersComputedSnapshot = map3;
        }
    }

    public StoreGuilds(StoreUser storeUser, Dispatcher dispatcher, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(storeUser, "userStore");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.userStore = storeUser;
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.guildsSnapshot = Maps6.emptyMap();
        this.guildMembersComputedSnapshot = Maps6.emptyMap();
        this.guildRolesSnapshot = Maps6.emptyMap();
        this.guildsUnavailableSnapshot = Sets5.emptySet();
        this.guildsJoinedAtSnapshot = Maps6.emptyMap();
        this.guilds = new HashMap();
        this.guildMembersComputed = new HashMap();
        this.guildMembers = new HashMap();
        this.guildRoles = new HashMap();
        this.guildsUnavailable = new HashSet();
        this.guildsJoinedAt = new HashMap();
        this.guildsCache = new Persister<>("STORE_GUILDS_V34", new HashMap());
        this.guildRolesCache = new Persister<>("STORE_GUILD_ROLES_V7", new HashMap());
        this.guildsJoinedAtCache = new Persister<>("STORE_GUILD_JOINED_AT_V6", new HashMap());
    }

    public final Observable<Map<Long, com.discord.models.member.GuildMember>> observeComputed(long guildId) {
        Observable<Map<Long, com.discord.models.member.GuildMember>> observableR = observeComputed().G(new AnonymousClass2(guildId)).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observeComputed()\n      …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, GuildRole>> observeRoles(long guildId) {
        Observable<Map<Long, GuildRole>> observableR = observeRoles().G(new AnonymousClass2(guildId)).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observeRoles()\n        .…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Long> observeJoinedAt(long guildId) {
        Observable<Long> observableR = observeJoinedAt().G(new AnonymousClass2(guildId)).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observeJoinedAt()\n      …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, com.discord.models.member.GuildMember>> observeComputed(long guildId, Collection<Long> userIds) {
        Intrinsics3.checkNotNullParameter(userIds, "userIds");
        Observable observableK = observeComputed(guildId).k(o.a(userIds));
        Intrinsics3.checkNotNullExpressionValue(observableK, "observeComputed(guildId)…mpose(filterMap(userIds))");
        return observableK;
    }

    public final Observable<Map<Long, GuildRole>> observeRoles(long guildId, Collection<Long> roleIds) {
        Intrinsics3.checkNotNullParameter(roleIds, "roleIds");
        Observable observableK = observeRoles(guildId).k(o.a(roleIds));
        Intrinsics3.checkNotNullExpressionValue(observableK, "observeRoles(guildId)\n  …mpose(filterMap(roleIds))");
        return observableK;
    }
}
