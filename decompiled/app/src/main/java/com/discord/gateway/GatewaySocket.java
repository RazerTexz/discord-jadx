package com.discord.gateway;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import b.i.d.FieldNamingPolicy;
import b.i.d.GsonBuilder;
import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityType;
import com.discord.api.activity.ActivityType2;
import com.discord.api.channel.Channel;
import com.discord.api.guild.Guild;
import com.discord.api.presence.ClientStatus;
import com.discord.gateway.GatewaySocketLogger;
import com.discord.gateway.io.Incoming;
import com.discord.gateway.io.Incoming2;
import com.discord.gateway.io.Outgoing;
import com.discord.gateway.io.Outgoing2;
import com.discord.gateway.opcodes.Opcode;
import com.discord.gateway.rest.RestClient;
import com.discord.gateway.rest.RestConfig;
import com.discord.models.domain.Model;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelPayload;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.collections.ListenerCollection;
import com.discord.utilities.collections.ListenerCollection2;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.networking.Backoff;
import com.discord.utilities.networking.NetworkMonitor;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.websocket.WebSocket;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.stream.JsonReader;
import d0.Tuples;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.t.Maps6;
import d0.t.Sets5;
import d0.t._Collections;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.TypeIntrinsics;
import j0.k.Func1;
import j0.l.a.OnSubscribeLift;
import j0.l.a.OperatorSkipWhile2;
import j0.l.a.OperatorSkipWhile3;
import j0.l.e.ScalarSynchronousObservable;
import j0.p.Schedulers2;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action1;

/* compiled from: GatewaySocket.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ò\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 á\u00012\u00020\u0001:\fá\u0001â\u0001ã\u0001ä\u0001å\u0001æ\u0001B¿\u0001\u0012\u0010\u0010Ñ\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010Ð\u00010\u0002\u0012\u001e\u00102\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\\\u0012\u0004\u0012\u00020\u00030E\u0012\b\u0010Í\u0001\u001a\u00030Ì\u0001\u0012\b\u0010¦\u0001\u001a\u00030¥\u0001\u0012\b\u0010¬\u0001\u001a\u00030«\u0001\u0012\b\u0010Ú\u0001\u001a\u00030Ù\u0001\u0012\b\u0010Ü\u0001\u001a\u00030Û\u0001\u0012\b\u0010Þ\u0001\u001a\u00030Ý\u0001\u0012\u0017\b\u0002\u0010¢\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010E\u0012\f\b\u0002\u0010¶\u0001\u001a\u0005\u0018\u00010µ\u0001\u0012\u0015\b\u0002\u0010Ö\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\\\u0012\b\u0010Ê\u0001\u001a\u00030É\u0001¢\u0006\u0006\bß\u0001\u0010à\u0001J\u001d\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u001f\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0018\u0010\fJ\u000f\u0010\u0019\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0019\u0010\fJ\u0017\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!J#\u0010%\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b%\u0010&J\u0017\u0010(\u001a\u00020\u00032\u0006\u0010'\u001a\u00020#H\u0002¢\u0006\u0004\b(\u0010)J;\u0010.\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u00012\b\u0010*\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u00072\u0006\u0010-\u001a\u00020,H\u0002¢\u0006\u0004\b.\u0010/J/\u00102\u001a\u00020\u00032\u0006\u00101\u001a\u0002002\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u00072\u0006\u0010-\u001a\u00020,H\u0002¢\u0006\u0004\b2\u00103JI\u00109\u001a\u00020\u00032\b\u00104\u001a\u0004\u0018\u00010\u00012.\u00108\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00070605j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000706`7H\u0002¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u00020\u0003H\u0002¢\u0006\u0004\b;\u0010\fJ\u000f\u0010<\u001a\u00020\u0003H\u0002¢\u0006\u0004\b<\u0010\fJ'\u0010?\u001a\u00020\u00032\u0006\u0010=\u001a\u00020#2\u0006\u0010>\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u000eH\u0002¢\u0006\u0004\b?\u0010@J'\u0010A\u001a\u00020\u00032\u0006\u0010=\u001a\u00020#2\u0006\u0010>\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u000eH\u0002¢\u0006\u0004\bA\u0010@J\u000f\u0010B\u001a\u00020\u0003H\u0002¢\u0006\u0004\bB\u0010\fJ\u000f\u0010C\u001a\u00020\u0003H\u0002¢\u0006\u0004\bC\u0010\fJ\u000f\u0010D\u001a\u00020\u0003H\u0002¢\u0006\u0004\bD\u0010\fJ'\u0010G\u001a\u00020\u00032\u0016\u0010\u0004\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010F\u0012\u0004\u0012\u00020\u0003\u0018\u00010EH\u0002¢\u0006\u0004\bG\u0010HJ\u0013\u0010I\u001a\u00020\u000e*\u00020\u001eH\u0002¢\u0006\u0004\bI\u0010JJ\u000f\u0010K\u001a\u00020\u0003H\u0002¢\u0006\u0004\bK\u0010\fJ\u000f\u0010L\u001a\u00020\u0003H\u0002¢\u0006\u0004\bL\u0010\fJ\u000f\u0010M\u001a\u00020\u0003H\u0002¢\u0006\u0004\bM\u0010\fJ+\u0010R\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020N2\b\b\u0002\u0010O\u001a\u00020#2\b\b\u0002\u0010Q\u001a\u00020PH\u0002¢\u0006\u0004\bR\u0010SJ'\u0010V\u001a\u00020\u00032\n\b\u0002\u0010T\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010U\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0004\bV\u0010WJ9\u0010^\u001a\u00020\u00032\u0006\u0010X\u001a\u00020\u000e2\n\u0010[\u001a\u00060Yj\u0002`Z2\u0014\u0010]\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\\H\u0002¢\u0006\u0004\b^\u0010_J\u0017\u0010a\u001a\u00020\u00032\u0006\u0010`\u001a\u00020#H\u0002¢\u0006\u0004\ba\u0010)J\r\u0010b\u001a\u00020#¢\u0006\u0004\bb\u0010cJ\r\u0010\u0010\u001a\u00020\u0003¢\u0006\u0004\b\u0010\u0010\fJ\u0017\u0010e\u001a\u00020\u00032\b\b\u0002\u0010d\u001a\u00020#¢\u0006\u0004\be\u0010)J\r\u0010f\u001a\u00020\u0003¢\u0006\u0004\bf\u0010\fJ+\u0010i\u001a\u00020\u00032\u0006\u0010g\u001a\u00020,2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010h\u001a\u00020#¢\u0006\u0004\bi\u0010jJA\u0010r\u001a\u00020\u00032\b\u0010l\u001a\u0004\u0018\u00010k2\n\b\u0002\u0010m\u001a\u0004\u0018\u00010,2\u0010\b\u0002\u0010p\u001a\n\u0012\u0004\u0012\u00020o\u0018\u00010n2\n\b\u0002\u0010q\u001a\u0004\u0018\u00010#¢\u0006\u0004\br\u0010sJW\u0010}\u001a\u00020\u00032\u000e\u0010u\u001a\n\u0018\u00010,j\u0004\u0018\u0001`t2\u000e\u0010w\u001a\n\u0018\u00010,j\u0004\u0018\u0001`v2\u0006\u0010x\u001a\u00020#2\u0006\u0010y\u001a\u00020#2\u0006\u0010z\u001a\u00020#2\b\u0010{\u001a\u0004\u0018\u00010\u000e2\u0006\u0010|\u001a\u00020#¢\u0006\u0004\b}\u0010~J\r\u0010\u007f\u001a\u00020\u0003¢\u0006\u0004\b\u007f\u0010\fJ?\u0010\u0081\u0001\u001a\u00020\u00032\u0007\u0010\u0080\u0001\u001a\u00020\u000e2\n\u0010w\u001a\u00060,j\u0002`v2\u000e\u0010u\u001a\n\u0018\u00010,j\u0004\u0018\u0001`t2\b\u0010{\u001a\u0004\u0018\u00010\u000e¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J\u001d\u0010\u0085\u0001\u001a\u00020\u00032\f\u0010\u0084\u0001\u001a\u00070\u000ej\u0003`\u0083\u0001¢\u0006\u0005\b\u0085\u0001\u0010\u0011J\u001d\u0010\u0086\u0001\u001a\u00020\u00032\f\u0010\u0084\u0001\u001a\u00070\u000ej\u0003`\u0083\u0001¢\u0006\u0005\b\u0086\u0001\u0010\u0011J\u0018\u0010\u0087\u0001\u001a\u00020\u00032\u0007\u0010\u0084\u0001\u001a\u00020\u000e¢\u0006\u0005\b\u0087\u0001\u0010\u0011JS\u0010\u008d\u0001\u001a\u00020\u00032\r\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020,0n2\u000b\b\u0002\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u000e2\u0016\b\u0002\u0010\u008b\u0001\u001a\u000f\u0012\t\u0012\u00070,j\u0003`\u008a\u0001\u0018\u00010n2\u000b\b\u0002\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001J\u001c\u0010\u008f\u0001\u001a\u00020\u00032\n\u0010w\u001a\u00060,j\u0002`v¢\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001J&\u0010\u0093\u0001\u001a\u00020\u00032\n\u0010u\u001a\u00060,j\u0002`t2\b\u0010\u0092\u0001\u001a\u00030\u0091\u0001¢\u0006\u0006\b\u0093\u0001\u0010\u0094\u0001J\u001a\u0010\u0097\u0001\u001a\u00020\u00032\b\u0010\u0096\u0001\u001a\u00030\u0095\u0001¢\u0006\u0006\b\u0097\u0001\u0010\u0098\u0001J\u001a\u0010\u009a\u0001\u001a\u00020\u00032\b\u0010\u0096\u0001\u001a\u00030\u0099\u0001¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J\u000f\u0010\u009c\u0001\u001a\u00020\u0003¢\u0006\u0005\b\u009c\u0001\u0010\fR\u001a\u0010\u009e\u0001\u001a\u00030\u009d\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009e\u0001\u0010\u009f\u0001R\u0019\u0010 \u0001\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b \u0001\u0010¡\u0001R'\u0010¢\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010E8\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¢\u0001\u0010£\u0001R\u0019\u0010¤\u0001\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¤\u0001\u0010¡\u0001R\u001a\u0010¦\u0001\u001a\u00030¥\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¦\u0001\u0010§\u0001R\u001a\u0010©\u0001\u001a\u00030¨\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b©\u0001\u0010ª\u0001R\u001a\u0010¬\u0001\u001a\u00030«\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¬\u0001\u0010\u00ad\u0001R&\u0010°\u0001\u001a\n\u0012\u0005\u0012\u00030¯\u00010®\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\b°\u0001\u0010±\u0001\u001a\u0006\b²\u0001\u0010³\u0001R\u0017\u0010U\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bU\u0010¡\u0001R\u001a\u0010´\u0001\u001a\u00030¨\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b´\u0001\u0010ª\u0001R/\u00102\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\\\u0012\u0004\u0012\u00020\u00030E8\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b2\u0010£\u0001R\u001c\u0010¶\u0001\u001a\u0005\u0018\u00010µ\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¶\u0001\u0010·\u0001R\u0019\u0010¸\u0001\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¸\u0001\u0010¹\u0001R\u0019\u0010º\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bº\u0001\u0010»\u0001R\u0019\u0010¼\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¼\u0001\u0010»\u0001R\u0019\u0010½\u0001\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b½\u0001\u0010¹\u0001R\u001a\u0010¿\u0001\u001a\u00030¾\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¿\u0001\u0010À\u0001R\"\u0010Â\u0001\u001a\u000b\u0018\u00010\u000ej\u0005\u0018\u0001`Á\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÂ\u0001\u0010Ã\u0001R\u0019\u0010Ä\u0001\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÄ\u0001\u0010¡\u0001R\u001a\u0010Å\u0001\u001a\u00030¨\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÅ\u0001\u0010ª\u0001R\u0017\u0010T\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bT\u0010¡\u0001R!\u0010Ç\u0001\u001a\n\u0012\u0005\u0012\u00030¯\u00010Æ\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÇ\u0001\u0010È\u0001R\u001a\u0010Ê\u0001\u001a\u00030É\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÊ\u0001\u0010Ë\u0001R\u001a\u0010Í\u0001\u001a\u00030Ì\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÍ\u0001\u0010Î\u0001R\u001b\u0010Ï\u0001\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÏ\u0001\u0010Ã\u0001R\"\u0010Ñ\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010Ð\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÑ\u0001\u0010Ò\u0001R\u0019\u0010Ó\u0001\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÓ\u0001\u0010¹\u0001R\u001b\u0010Ô\u0001\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÔ\u0001\u0010Õ\u0001R\u0017\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\b\u0010»\u0001R%\u0010Ö\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\\8\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÖ\u0001\u0010×\u0001R\u0019\u0010Ø\u0001\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bØ\u0001\u0010¹\u0001¨\u0006ç\u0001"}, d2 = {"Lcom/discord/gateway/GatewaySocket;", "", "Lkotlin/Function0;", "", "callback", "schedule", "(Lkotlin/jvm/functions/Function0;)V", "", "seq", "heartbeat", "(I)V", "discoveryFailed", "()V", "discover", "", "gatewayUrl", "connect", "(Ljava/lang/String;)V", "handleWebSocketOpened", "Ljava/io/InputStreamReader;", "reader", "compressedByteSize", "handleWebSocketMessage", "(Ljava/io/InputStreamReader;I)V", "handleHeartbeat", "handleWebSocketError", "Lcom/discord/utilities/websocket/WebSocket$Closed;", "closed", "handleWebSocketClose", "(Lcom/discord/utilities/websocket/WebSocket$Closed;)V", "Lcom/discord/models/domain/ModelPayload$Hello;", "data", "handleHello", "(Lcom/discord/models/domain/ModelPayload$Hello;)V", ModelAuditLogEntry.CHANGE_KEY_REASON, "", "resetSession", "handleReconnect", "(Ljava/lang/String;Z)V", "canResume", "handleInvalidSession", "(Z)V", "type", "uncompressedByteSize", "", "unpackDurationMs", "handleDispatch", "(Ljava/lang/Object;Ljava/lang/String;IIJ)V", "Lcom/discord/models/domain/ModelPayload;", "payload", "trackReadyPayload", "(Lcom/discord/models/domain/ModelPayload;IIJ)V", "trace", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "Lkotlin/collections/ArrayList;", "result", "flattenTraces", "(Ljava/lang/Object;Ljava/util/ArrayList;)V", "handleHeartbeatAck", "handleHeartbeatTimeout", "wasClean", ModelAuditLogEntry.CHANGE_KEY_CODE, "handleClose", "(ZILjava/lang/String;)V", ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_RESET, "startHeartbeater", "stopHeartbeater", "clearHelloTimeout", "Lkotlin/Function1;", "Lcom/discord/utilities/websocket/WebSocket;", "cleanup", "(Lkotlin/jvm/functions/Function1;)V", "getConnectionPath", "(Lcom/discord/models/domain/ModelPayload$Hello;)Ljava/lang/String;", "doResume", "doIdentify", "doResumeOrIdentify", "Lcom/discord/gateway/io/Outgoing;", "checkSessionEstablished", "Lcom/google/gson/Gson;", "gson", "send", "(Lcom/discord/gateway/io/Outgoing;ZLcom/google/gson/Gson;)V", "connected", "connectionReady", "handleConnected", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "message", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exception", "", "metadata", "logError", "(Ljava/lang/String;Ljava/lang/Exception;Ljava/util/Map;)V", "isConnected", "handleDeviceConnectivityChange", "isSessionEstablished", "()Z", "clean", "close", "resetOnError", "timeout", "shouldResetBackoff", "expeditedHeartbeat", "(JLjava/lang/String;Z)V", "Lcom/discord/api/presence/ClientStatus;", "status", "since", "", "Lcom/discord/api/activity/Activity;", "activities", "afk", "presenceUpdate", "(Lcom/discord/api/presence/ClientStatus;Ljava/lang/Long;Ljava/util/List;Ljava/lang/Boolean;)V", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/primitives/ChannelId;", "channelId", "selfMute", "selfDeaf", "selfVideo", "preferredRegion", "shouldIncludePreferredRegion", "voiceStateUpdate", "(Ljava/lang/Long;Ljava/lang/Long;ZZZLjava/lang/String;Z)V", "voiceServerPing", "streamType", "streamCreate", "(Ljava/lang/String;JLjava/lang/Long;Ljava/lang/String;)V", "Lcom/discord/primitives/StreamKey;", "streamKey", "streamWatch", "streamDelete", "streamPing", "guildIds", "query", "Lcom/discord/primitives/UserId;", "userIds", "limit", "requestGuildMembers", "(Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;)V", "callConnect", "(J)V", "Lcom/discord/gateway/io/OutgoingPayload$GuildSubscriptions;", "guildSubscriptions", "updateGuildSubscriptions", "(JLcom/discord/gateway/io/OutgoingPayload$GuildSubscriptions;)V", "Lcom/discord/gateway/io/OutgoingPayload$ApplicationCommandRequest;", "request", "requestApplicationCommands", "(Lcom/discord/gateway/io/OutgoingPayload$ApplicationCommandRequest;)V", "Lcom/discord/gateway/io/OutgoingPayload$ForumUnreadsRequest;", "requestForumUnreads", "(Lcom/discord/gateway/io/OutgoingPayload$ForumUnreadsRequest;)V", "simulateReconnectForTesting", "Lcom/discord/gateway/GatewayDiscovery;", "gatewayDiscovery", "Lcom/discord/gateway/GatewayDiscovery;", "hasConnectedOnce", "Z", "gatewayUrlTransform", "Lkotlin/jvm/functions/Function1;", "heartbeatAck", "Lrx/Scheduler;", "scheduler", "Lrx/Scheduler;", "Lcom/discord/gateway/GatewaySocket$Timer;", "helloTimeout", "Lcom/discord/gateway/GatewaySocket$Timer;", "Lcom/discord/utilities/logging/Logger;", "logger", "Lcom/discord/utilities/logging/Logger;", "Lcom/discord/utilities/collections/ListenerCollection;", "Lcom/discord/gateway/GatewaySocket$Listener;", "listeners", "Lcom/discord/utilities/collections/ListenerCollection;", "getListeners", "()Lcom/discord/utilities/collections/ListenerCollection;", "heartbeatExpeditedTimeout", "Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "heartbeatInterval", "J", "connectionState", "I", "replayedEvents", "connectionStartTime", "Lcom/discord/utilities/networking/Backoff;", "gatewayBackoff", "Lcom/discord/utilities/networking/Backoff;", "Lcom/discord/primitives/SessionId;", "sessionId", "Ljava/lang/String;", "nextReconnectIsImmediate", "heartbeater", "Lcom/discord/utilities/collections/ListenerCollectionSubject;", "listenerSubject", "Lcom/discord/utilities/collections/ListenerCollectionSubject;", "Lcom/discord/gateway/GatewaySocketLogger;", "gatewaySocketLogger", "Lcom/discord/gateway/GatewaySocketLogger;", "Lcom/discord/gateway/GatewayEventHandler;", "eventHandler", "Lcom/discord/gateway/GatewayEventHandler;", "token", "Lcom/discord/gateway/GatewaySocket$IdentifyData;", "identifyDataProvider", "Lkotlin/jvm/functions/Function0;", "heartbeatAckTimeMostRecent", "webSocket", "Lcom/discord/utilities/websocket/WebSocket;", "identifyProperties", "Ljava/util/Map;", "identifyStartTime", "Lcom/discord/utilities/networking/NetworkMonitor;", "networkMonitor", "Lcom/discord/gateway/rest/RestConfig;", "restConfig", "Landroid/content/Context;", "context", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lcom/discord/gateway/GatewayEventHandler;Lrx/Scheduler;Lcom/discord/utilities/logging/Logger;Lcom/discord/utilities/networking/NetworkMonitor;Lcom/discord/gateway/rest/RestConfig;Landroid/content/Context;Lkotlin/jvm/functions/Function1;Ljavax/net/ssl/SSLSocketFactory;Ljava/util/Map;Lcom/discord/gateway/GatewaySocketLogger;)V", "Companion", "DefaultListener", "IdentifyData", "Listener", "SizeRecordingInputStreamReader", "Timer", "gateway_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class GatewaySocket {
    private static final long AUTH_TOKEN_REFRESH = 256;
    private static final long CLIENT_CAPABILITIES = 351;
    private static final int CLOSE_CODE_CLEAN = 1000;
    private static final int CLOSE_CODE_DIRTY = 4000;
    private static final int CLOSE_CODE_UNAUTHORIZED = 4004;
    private static final boolean COMPRESS_DATA = true;
    private static final int CONNECTED = 5;
    private static final int CONNECTING = 2;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long DEDUPE_USER_OBJECTS = 16;
    private static final int DISCONNECTED = 0;
    private static final int DISCOVERING = 1;
    private static final Set<String> EXPECTED_NULL_DATA_EVENTS;
    private static final String GATEWAY_COMPRESSION = "zlib-stream";
    private static final String GATEWAY_ENCODING = "json";
    private static final int GATEWAY_URL_RESET_THRESHOLD = 4;
    private static final int GATEWAY_VERSION = 9;
    private static final int HEARTBEAT_MAX_RESUME_THRESHOLD = 180000;
    private static final long HELLO_TIMEOUT = 20000;
    private static final int IDENTIFYING = 3;
    private static final int LARGE_GUILD_THRESHOLD = 100;
    private static final long LAZY_USER_NOTES = 1;
    private static final long MULTIPLE_GUILD_EXPERIMENT_POPULATIONS = 64;
    private static final long NO_AFFINE_USER_IDS = 2;
    private static final int RESUMING = 4;
    private static final long VERSIONED_READ_STATES = 4;
    private static final long VERSIONED_USER_GUILD_SETTINGS = 8;
    private static final Clock clock;
    private static final Gson gsonIncludeNulls;
    private static final Gson gsonOmitNulls;
    private boolean connected;
    private boolean connectionReady;
    private long connectionStartTime;
    private int connectionState;
    private final GatewayEventHandler eventHandler;
    private final Backoff gatewayBackoff;
    private final GatewayDiscovery gatewayDiscovery;
    private final GatewaySocketLogger gatewaySocketLogger;
    private final Function1<String, String> gatewayUrlTransform;
    private boolean hasConnectedOnce;
    private boolean heartbeatAck;
    private long heartbeatAckTimeMostRecent;
    private Timer heartbeatExpeditedTimeout;
    private long heartbeatInterval;
    private Timer heartbeater;
    private Timer helloTimeout;
    private final Function0<IdentifyData> identifyDataProvider;
    private final Map<String, Object> identifyProperties;
    private long identifyStartTime;
    private final ListenerCollection2<Listener> listenerSubject;
    private final ListenerCollection<Listener> listeners;
    private final Logger logger;
    private boolean nextReconnectIsImmediate;
    private int replayedEvents;
    private final Scheduler scheduler;
    private int seq;
    private String sessionId;
    private final SSLSocketFactory sslSocketFactory;
    private String token;
    private final Function1<Map<String, ? extends Object>, Unit> trackReadyPayload;
    private WebSocket webSocket;

    /* compiled from: GatewaySocket.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "message", "", "invoke", "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.gateway.GatewaySocket$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<String, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "message");
            Companion.log$default(GatewaySocket.INSTANCE, GatewaySocket.access$getLogger$p(GatewaySocket.this), str, false, 2, null);
        }
    }

    /* compiled from: GatewaySocket.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0005\u0010\u0005\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "kotlin.jvm.PlatformType", "isConnected", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Boolean;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.gateway.GatewaySocket$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements Func1<Boolean, Boolean> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(Boolean bool) {
            return bool;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Boolean call(Boolean bool) {
            return call2(bool);
        }
    }

    /* compiled from: GatewaySocket.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "isConnected", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Boolean;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.gateway.GatewaySocket$3, reason: invalid class name */
    public static final class AnonymousClass3<T> implements Action1<Boolean> {
        public AnonymousClass3() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            GatewaySocket gatewaySocket = GatewaySocket.this;
            Intrinsics3.checkNotNullExpressionValue(bool, "isConnected");
            GatewaySocket.access$handleDeviceConnectivityChange(gatewaySocket, bool.booleanValue());
        }
    }

    /* compiled from: GatewaySocket.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "throwable", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Throwable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.gateway.GatewaySocket$4, reason: invalid class name */
    public static final class AnonymousClass4<T> implements Action1<Throwable> {
        public AnonymousClass4() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Throwable th) {
            call2(th);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Throwable th) {
            Logger loggerAccess$getLogger$p = GatewaySocket.access$getLogger$p(GatewaySocket.this);
            StringBuilder sbU = outline.U("failed to handle connectivity change in ");
            sbU.append(GatewaySocket.this.getClass().getSimpleName());
            Logger.e$default(loggerAccess$getLogger$p, sbU.toString(), th, null, 4, null);
        }
    }

    /* compiled from: GatewaySocket.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\"\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b8\u00109J#\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\r\u001a\u00020\f*\u00020\u00072\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00128\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\n8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\u00128\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0014R\u0016\u0010\u001a\u001a\u00020\u00128\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0014R\u0016\u0010\u001b\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0010R\u0016\u0010\u001c\u001a\u00020\u00128\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0014R\u0016\u0010\u001d\u001a\u00020\u00128\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0014R\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\b0\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\b8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020\b8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010\"R\u0016\u0010$\u001a\u00020\u00128\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010\u0014R\u0016\u0010%\u001a\u00020\u00128\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010\u0014R\u0016\u0010&\u001a\u00020\u00128\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b&\u0010\u0014R\u0016\u0010'\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010\u0010R\u0016\u0010(\u001a\u00020\u00128\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010\u0014R\u0016\u0010)\u001a\u00020\u00128\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b)\u0010\u0014R\u0016\u0010*\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b*\u0010\u0010R\u0016\u0010+\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b+\u0010\u0010R\u0016\u0010,\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b,\u0010\u0010R\u0016\u0010-\u001a\u00020\u00128\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b-\u0010\u0014R\u0016\u0010.\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b.\u0010\u0010R\u0016\u0010/\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b/\u0010\u0010R\u0016\u00101\u001a\u0002008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u001e\u00105\u001a\n 4*\u0004\u0018\u000103038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u001e\u00107\u001a\n 4*\u0004\u0018\u000103038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00106¨\u0006:"}, d2 = {"Lcom/discord/gateway/GatewaySocket$Companion;", "", "", "startTime", "currentTime", "getDelay", "(JLjava/lang/Long;)J", "Lcom/discord/utilities/logging/Logger;", "", "message", "", "breadcrumb", "", "log", "(Lcom/discord/utilities/logging/Logger;Ljava/lang/String;Z)V", "AUTH_TOKEN_REFRESH", "J", "CLIENT_CAPABILITIES", "", "CLOSE_CODE_CLEAN", "I", "CLOSE_CODE_DIRTY", "CLOSE_CODE_UNAUTHORIZED", "COMPRESS_DATA", "Z", "CONNECTED", "CONNECTING", "DEDUPE_USER_OBJECTS", "DISCONNECTED", "DISCOVERING", "", "EXPECTED_NULL_DATA_EVENTS", "Ljava/util/Set;", "GATEWAY_COMPRESSION", "Ljava/lang/String;", "GATEWAY_ENCODING", "GATEWAY_URL_RESET_THRESHOLD", "GATEWAY_VERSION", "HEARTBEAT_MAX_RESUME_THRESHOLD", "HELLO_TIMEOUT", "IDENTIFYING", "LARGE_GUILD_THRESHOLD", "LAZY_USER_NOTES", "MULTIPLE_GUILD_EXPERIMENT_POPULATIONS", "NO_AFFINE_USER_IDS", "RESUMING", "VERSIONED_READ_STATES", "VERSIONED_USER_GUILD_SETTINGS", "Lcom/discord/utilities/time/Clock;", "clock", "Lcom/discord/utilities/time/Clock;", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "gsonIncludeNulls", "Lcom/google/gson/Gson;", "gsonOmitNulls", "<init>", "()V", "gateway_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ void access$log(Companion companion, Logger logger, String str, boolean z2) {
            companion.log(logger, str, z2);
        }

        private final long getDelay(long startTime, Long currentTime) {
            return (currentTime != null ? currentTime.longValue() : ClockFactory.get().currentTimeMillis()) - startTime;
        }

        public static /* synthetic */ long getDelay$default(Companion companion, long j, Long l, int i, Object obj) {
            if ((i & 2) != 0) {
                l = null;
            }
            return companion.getDelay(j, l);
        }

        private final void log(Logger logger, String str, boolean z2) {
            Logger.v$default(logger, outline.w("[GatewaySocket] ", str), null, 2, null);
            if (z2) {
                logger.recordBreadcrumb("Gateway [" + str + ']', "log");
            }
        }

        public static /* synthetic */ void log$default(Companion companion, Logger logger, String str, boolean z2, int i, Object obj) {
            if ((i & 2) != 0) {
                z2 = true;
            }
            companion.log(logger, str, z2);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: GatewaySocket.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/discord/gateway/GatewaySocket$DefaultListener;", "Lcom/discord/gateway/GatewaySocket$Listener;", "Lcom/discord/gateway/GatewaySocket;", "gatewaySocket", "", "onConnecting", "(Lcom/discord/gateway/GatewaySocket;)V", "onConnected", "onHello", "onDisconnected", "<init>", "()V", "gateway_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class DefaultListener implements Listener {
        @Override // com.discord.gateway.GatewaySocket.Listener
        public void onConnected(GatewaySocket gatewaySocket) {
            Intrinsics3.checkNotNullParameter(gatewaySocket, "gatewaySocket");
        }

        @Override // com.discord.gateway.GatewaySocket.Listener
        public void onConnecting(GatewaySocket gatewaySocket) {
            Intrinsics3.checkNotNullParameter(gatewaySocket, "gatewaySocket");
        }

        @Override // com.discord.gateway.GatewaySocket.Listener
        public void onDisconnected(GatewaySocket gatewaySocket) {
            Intrinsics3.checkNotNullParameter(gatewaySocket, "gatewaySocket");
        }

        @Override // com.discord.gateway.GatewaySocket.Listener
        public void onHello(GatewaySocket gatewaySocket) {
            Intrinsics3.checkNotNullParameter(gatewaySocket, "gatewaySocket");
        }
    }

    /* compiled from: GatewaySocket.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/gateway/GatewaySocket$IdentifyData;", "", "Lcom/discord/gateway/io/OutgoingPayload$IdentifyClientState;", "clientState", "Lcom/discord/gateway/io/OutgoingPayload$IdentifyClientState;", "getClientState", "()Lcom/discord/gateway/io/OutgoingPayload$IdentifyClientState;", "", "token", "Ljava/lang/String;", "getToken", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;Lcom/discord/gateway/io/OutgoingPayload$IdentifyClientState;)V", "gateway_release"}, k = 1, mv = {1, 4, 2})
    public static final class IdentifyData {
        private final Outgoing2.IdentifyClientState clientState;
        private final String token;

        public IdentifyData(String str, Outgoing2.IdentifyClientState identifyClientState) {
            Intrinsics3.checkNotNullParameter(str, "token");
            this.token = str;
            this.clientState = identifyClientState;
        }

        public final Outgoing2.IdentifyClientState getClientState() {
            return this.clientState;
        }

        public final String getToken() {
            return this.token;
        }
    }

    /* compiled from: GatewaySocket.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/discord/gateway/GatewaySocket$Listener;", "", "Lcom/discord/gateway/GatewaySocket;", "gatewaySocket", "", "onConnecting", "(Lcom/discord/gateway/GatewaySocket;)V", "onConnected", "onHello", "onDisconnected", "gateway_release"}, k = 1, mv = {1, 4, 2})
    public interface Listener {
        void onConnected(GatewaySocket gatewaySocket);

        void onConnecting(GatewaySocket gatewaySocket);

        void onDisconnected(GatewaySocket gatewaySocket);

        void onHello(GatewaySocket gatewaySocket);
    }

    /* compiled from: GatewaySocket.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\r\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/discord/gateway/GatewaySocket$SizeRecordingInputStreamReader;", "Ljava/io/Reader;", "", "close", "()V", "", "buffer", "", "offset", "len", "read", "([CII)I", "Ljava/io/InputStreamReader;", "source", "Ljava/io/InputStreamReader;", "getSource", "()Ljava/io/InputStreamReader;", "size", "I", "getSize", "()I", "setSize", "(I)V", "<init>", "(Ljava/io/InputStreamReader;I)V", "gateway_release"}, k = 1, mv = {1, 4, 2})
    public static final class SizeRecordingInputStreamReader extends Reader {
        private int size;
        private final InputStreamReader source;

        public SizeRecordingInputStreamReader(InputStreamReader inputStreamReader, int i) {
            Intrinsics3.checkNotNullParameter(inputStreamReader, "source");
            this.source = inputStreamReader;
            this.size = i;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.source.close();
        }

        public final int getSize() {
            return this.size;
        }

        public final InputStreamReader getSource() {
            return this.source;
        }

        @Override // java.io.Reader
        public int read(char[] buffer, int offset, int len) throws IOException {
            Intrinsics3.checkNotNullParameter(buffer, "buffer");
            int i = this.source.read(buffer, offset, len);
            if (i != -1) {
                this.size += i;
            }
            return i;
        }

        public final void setSize(int i) {
            this.size = i;
        }

        public /* synthetic */ SizeRecordingInputStreamReader(InputStreamReader inputStreamReader, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(inputStreamReader, (i2 & 2) != 0 ? 0 : i);
        }
    }

    /* compiled from: GatewaySocket.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0019\u0010\u001aJ%\u0010\u0007\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u000b\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\bJ\u000f\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\f\u001a\u00020\u00032\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0015\u001a\u00020\u00128F@\u0006¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/discord/gateway/GatewaySocket$Timer;", "Lcom/discord/utilities/networking/Backoff$Scheduler;", "Lkotlin/Function0;", "", "action", "", "delayMs", "schedule", "(Lkotlin/jvm/functions/Function0;J)V", "callback", "delayMillis", "postInterval", "cancel", "()V", "(Lkotlin/jvm/functions/Function0;)V", "Lrx/Scheduler;", "scheduler", "Lrx/Scheduler;", "", "getPending", "()Z", "pending", "Lrx/Subscription;", Traits.Payment.Type.SUBSCRIPTION, "Lrx/Subscription;", "<init>", "(Lrx/Scheduler;)V", "gateway_release"}, k = 1, mv = {1, 4, 2})
    public static final class Timer implements Backoff.Scheduler {
        private final Scheduler scheduler;
        private Subscription subscription;

        public Timer(Scheduler scheduler) {
            Intrinsics3.checkNotNullParameter(scheduler, "scheduler");
            this.scheduler = scheduler;
        }

        public static final /* synthetic */ Subscription access$getSubscription$p(Timer timer) {
            return timer.subscription;
        }

        public static final /* synthetic */ void access$setSubscription$p(Timer timer, Subscription subscription) {
            timer.subscription = subscription;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void cancel$default(Timer timer, Function0 function0, int i, Object obj) {
            if ((i & 1) != 0) {
                function0 = null;
            }
            timer.cancel(function0);
        }

        @Override // com.discord.utilities.networking.Backoff.Scheduler
        public void cancel() {
            cancel(null);
        }

        public final boolean getPending() {
            return this.subscription != null;
        }

        public final void postInterval(Function0<Unit> callback, long delayMillis) {
            Intrinsics3.checkNotNullParameter(callback, "callback");
            cancel();
            this.subscription = Observable.F(delayMillis, delayMillis, TimeUnit.MILLISECONDS, Schedulers2.a()).J(this.scheduler).W(new GatewaySocket$Timer$postInterval$1(callback), GatewaySocket$Timer$postInterval$2.INSTANCE);
        }

        @Override // com.discord.utilities.networking.Backoff.Scheduler
        public void schedule(Function0<Unit> action, long delayMs) {
            Intrinsics3.checkNotNullParameter(action, "action");
            cancel();
            this.subscription = Observable.d0(delayMs, TimeUnit.MILLISECONDS).J(this.scheduler).W(new GatewaySocket$Timer$schedule$1(this, action), GatewaySocket$Timer$schedule$2.INSTANCE);
        }

        public final void cancel(Function0<Unit> callback) {
            Subscription subscription = this.subscription;
            if (subscription != null) {
                if (subscription != null) {
                    subscription.unsubscribe();
                }
                this.subscription = null;
                if (callback != null) {
                    callback.invoke();
                }
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            GatewaySocketLogger.LogLevel.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[GatewaySocketLogger.LogLevel.NONE.ordinal()] = 1;
            iArr[GatewaySocketLogger.LogLevel.VERBOSE.ordinal()] = 2;
            Opcode.values();
            int[] iArr2 = new int[21];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[Opcode.HELLO.ordinal()] = 1;
            iArr2[Opcode.RECONNECT.ordinal()] = 2;
            iArr2[Opcode.INVALID_SESSION.ordinal()] = 3;
            iArr2[Opcode.HEARTBEAT.ordinal()] = 4;
            iArr2[Opcode.HEARTBEAT_ACK.ordinal()] = 5;
            iArr2[Opcode.DISPATCH.ordinal()] = 6;
        }
    }

    /* compiled from: GatewaySocket.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.gateway.GatewaySocket$callConnect$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() throws JsonIOException {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() throws JsonIOException {
            Companion companion = GatewaySocket.INSTANCE;
            Logger loggerAccess$getLogger$p = GatewaySocket.access$getLogger$p(GatewaySocket.this);
            StringBuilder sbU = outline.U("Sending call connect sync on channel id: ");
            sbU.append(this.$channelId);
            sbU.append('.');
            Companion.log$default(companion, loggerAccess$getLogger$p, sbU.toString(), false, 2, null);
            GatewaySocket.send$default(GatewaySocket.this, new Outgoing(Opcode.CALL_CONNECT, new Outgoing2.CallConnect(this.$channelId)), false, null, 6, null);
        }
    }

    /* compiled from: GatewaySocket.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.gateway.GatewaySocket$close$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ boolean $clean;

        /* compiled from: GatewaySocket.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/websocket/WebSocket;", "ws", "", "invoke", "(Lcom/discord/utilities/websocket/WebSocket;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.gateway.GatewaySocket$close$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00651 extends Lambda implements Function1<WebSocket, Unit> {
            public final /* synthetic */ int $code;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00651(int i) {
                super(1);
                this.$code = i;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(WebSocket webSocket) {
                invoke2(webSocket);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(WebSocket webSocket) {
                if (webSocket != null) {
                    WebSocket.disconnect$default(webSocket, this.$code, null, 2, null);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z2) {
            super(0);
            this.$clean = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (GatewaySocket.access$getConnectionState$p(GatewaySocket.this) == 0) {
                return;
            }
            int i = this.$clean ? 1000 : 4000;
            GatewaySocket.access$cleanup(GatewaySocket.this, new C00651(i));
            GatewaySocket.access$setConnectionState$p(GatewaySocket.this, 0);
            GatewaySocket.access$reset(GatewaySocket.this, this.$clean, i, "Disconnect requested by client");
        }
    }

    /* compiled from: GatewaySocket.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.gateway.GatewaySocket$connect$1, reason: invalid class name */
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
            if (GatewaySocket.access$getConnectionState$p(GatewaySocket.this) == 0) {
                GatewaySocket.access$setConnectionState$p(GatewaySocket.this, 1);
                GatewaySocket.access$discover(GatewaySocket.this);
            }
        }
    }

    /* compiled from: GatewaySocket.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/websocket/WebSocket;", "ws", "", "invoke", "(Lcom/discord/utilities/websocket/WebSocket;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.gateway.GatewaySocket$connect$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<WebSocket, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WebSocket webSocket) {
            invoke2(webSocket);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WebSocket webSocket) {
            if (webSocket != null) {
                webSocket.disconnect(4000, "Connect called with an existing web socket.");
            }
        }
    }

    /* compiled from: GatewaySocket.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.gateway.GatewaySocket$connect$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function0<Unit> {
        public AnonymousClass3() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            GatewaySocket gatewaySocket = GatewaySocket.this;
            StringBuilder sbU = outline.U("Connection timed out after ");
            sbU.append(Companion.getDelay$default(GatewaySocket.INSTANCE, GatewaySocket.access$getConnectionStartTime$p(GatewaySocket.this), null, 2, null));
            sbU.append("ms, did not receive hello in time.");
            GatewaySocket.access$handleClose(gatewaySocket, false, 0, sbU.toString());
        }
    }

    /* compiled from: GatewaySocket.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\n\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\t"}, d2 = {"", "p1", "Ljava/lang/Exception;", "Lkotlin/Exception;", "p2", "", "p3", "", "invoke", "(Ljava/lang/String;Ljava/lang/Exception;Ljava/util/Map;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.gateway.GatewaySocket$connect$4, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function3<String, Exception, Map<String, ? extends String>, Unit> {
        public AnonymousClass4(GatewaySocket gatewaySocket) {
            super(3, gatewaySocket, GatewaySocket.class, "logError", "logError(Ljava/lang/String;Ljava/lang/Exception;Ljava/util/Map;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(String str, Exception exc, Map<String, ? extends String> map) {
            invoke2(str, exc, (Map<String, String>) map);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str, Exception exc, Map<String, String> map) {
            Intrinsics3.checkNotNullParameter(str, "p1");
            Intrinsics3.checkNotNullParameter(exc, "p2");
            GatewaySocket.access$logError((GatewaySocket) this.receiver, str, exc, map);
        }
    }

    /* compiled from: GatewaySocket.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/gateway/GatewaySocket$Listener;", "it", "", "invoke", "(Lcom/discord/gateway/GatewaySocket$Listener;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.gateway.GatewaySocket$discover$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Listener, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Listener listener) {
            invoke2(listener);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Listener listener) {
            Intrinsics3.checkNotNullParameter(listener, "it");
            listener.onConnecting(GatewaySocket.this);
        }
    }

    /* compiled from: GatewaySocket.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "gatewayUrl", "", "invoke", "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.gateway.GatewaySocket$discover$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<String, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            String str2;
            Intrinsics3.checkNotNullParameter(str, "gatewayUrl");
            GatewaySocket gatewaySocket = GatewaySocket.this;
            Function1 function1Access$getGatewayUrlTransform$p = GatewaySocket.access$getGatewayUrlTransform$p(gatewaySocket);
            if (function1Access$getGatewayUrlTransform$p != null && (str2 = (String) function1Access$getGatewayUrlTransform$p.invoke(str)) != null) {
                str = str2;
            }
            GatewaySocket.access$connect(gatewaySocket, str);
        }
    }

    /* compiled from: GatewaySocket.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "invoke", "(Ljava/lang/Throwable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.gateway.GatewaySocket$discover$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Throwable, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            Intrinsics3.checkNotNullParameter(th, "it");
            GatewaySocket.access$discoveryFailed(GatewaySocket.this);
        }
    }

    /* compiled from: GatewaySocket.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.gateway.GatewaySocket$expeditedHeartbeat$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $reason;
        public final /* synthetic */ boolean $shouldResetBackoff;
        public final /* synthetic */ long $timeout;

        /* compiled from: GatewaySocket.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", ModelAuditLogEntry.CHANGE_KEY_REASON, "", "invoke", "(Ljava/lang/String;)V", "resetBackoff"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.gateway.GatewaySocket$expeditedHeartbeat$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00661 extends Lambda implements Function1<String, Unit> {
            public C00661() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_REASON);
                Companion.log$default(GatewaySocket.INSTANCE, GatewaySocket.access$getLogger$p(GatewaySocket.this), "Connection backoff reset " + str + '.', false, 2, null);
                GatewaySocket.access$getGatewayBackoff$p(GatewaySocket.this).succeed();
                GatewaySocket.access$setNextReconnectIsImmediate$p(GatewaySocket.this, true);
                if (GatewaySocket.access$getConnectionState$p(GatewaySocket.this) == 1) {
                    GatewaySocket.access$discover(GatewaySocket.this);
                }
            }
        }

        /* compiled from: GatewaySocket.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.gateway.GatewaySocket$expeditedHeartbeat$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
            public AnonymousClass2() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (GatewaySocket.access$getHeartbeatAck$p(GatewaySocket.this)) {
                    return;
                }
                GatewaySocket.access$handleHeartbeatTimeout(GatewaySocket.this);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, long j, boolean z2) {
            super(0);
            this.$reason = str;
            this.$timeout = j;
            this.$shouldResetBackoff = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() throws JsonIOException {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() throws JsonIOException {
            String strH = this.$reason != null ? outline.H(outline.U("with reason '"), this.$reason, '\'') : "";
            C00661 c00661 = new C00661();
            if (GatewaySocket.access$getWebSocket$p(GatewaySocket.this) == null) {
                if (this.$shouldResetBackoff) {
                    c00661.invoke2(strH);
                    return;
                } else {
                    Companion.log$default(GatewaySocket.INSTANCE, GatewaySocket.access$getLogger$p(GatewaySocket.this), outline.y("Expedited heartbeat requested ", strH, ", but disconnected and no reset backoff."), false, 2, null);
                    return;
                }
            }
            Companion.log$default(GatewaySocket.INSTANCE, GatewaySocket.access$getLogger$p(GatewaySocket.this), "Performing an expedited heartbeat " + strH + '.', false, 2, null);
            GatewaySocket gatewaySocket = GatewaySocket.this;
            GatewaySocket.access$heartbeat(gatewaySocket, GatewaySocket.access$getSeq$p(gatewaySocket));
            GatewaySocket.access$setHeartbeatAck$p(GatewaySocket.this, false);
            GatewaySocket.access$getHeartbeatExpeditedTimeout$p(GatewaySocket.this).schedule(new AnonymousClass2(), this.$timeout);
        }
    }

    /* compiled from: GatewaySocket.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/websocket/WebSocket;", "it", "", "invoke", "(Lcom/discord/utilities/websocket/WebSocket;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.gateway.GatewaySocket$handleClose$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<WebSocket, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WebSocket webSocket) {
            invoke2(webSocket);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WebSocket webSocket) {
        }
    }

    /* compiled from: GatewaySocket.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.gateway.GatewaySocket$handleHeartbeatAck$1, reason: invalid class name */
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
            Companion.log$default(GatewaySocket.INSTANCE, GatewaySocket.access$getLogger$p(GatewaySocket.this), "Expedited heartbeat succeeded.", false, 2, null);
        }
    }

    /* compiled from: GatewaySocket.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/websocket/WebSocket;", "ws", "", "invoke", "(Lcom/discord/utilities/websocket/WebSocket;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.gateway.GatewaySocket$handleHeartbeatTimeout$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<WebSocket, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WebSocket webSocket) {
            invoke2(webSocket);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WebSocket webSocket) {
            if (webSocket != null) {
                WebSocket.disconnect$default(webSocket, 4000, null, 2, null);
            }
        }
    }

    /* compiled from: GatewaySocket.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/gateway/GatewaySocket$Listener;", "it", "", "invoke", "(Lcom/discord/gateway/GatewaySocket$Listener;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.gateway.GatewaySocket$handleHello$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Listener, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Listener listener) {
            invoke2(listener);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Listener listener) {
            Intrinsics3.checkNotNullParameter(listener, "it");
            listener.onHello(GatewaySocket.this);
        }
    }

    /* compiled from: GatewaySocket.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/websocket/WebSocket;", "ws", "", "invoke", "(Lcom/discord/utilities/websocket/WebSocket;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.gateway.GatewaySocket$handleReconnect$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<WebSocket, Unit> {
        public final /* synthetic */ String $reason;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(1);
            this.$reason = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WebSocket webSocket) {
            invoke2(webSocket);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WebSocket webSocket) {
            if (webSocket != null) {
                webSocket.disconnect(4000, this.$reason);
            }
        }
    }

    /* compiled from: GatewaySocket.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/gateway/GatewaySocket$Listener;", "it", "", "invoke", "(Lcom/discord/gateway/GatewaySocket$Listener;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.gateway.GatewaySocket$handleWebSocketClose$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Listener, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Listener listener) {
            invoke2(listener);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Listener listener) {
            Intrinsics3.checkNotNullParameter(listener, "it");
            listener.onDisconnected(GatewaySocket.this);
        }
    }

    /* compiled from: GatewaySocket.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/gateway/GatewaySocket$Listener;", "it", "", "invoke", "(Lcom/discord/gateway/GatewaySocket$Listener;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.gateway.GatewaySocket$handleWebSocketOpened$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Listener, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Listener listener) {
            invoke2(listener);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Listener listener) {
            Intrinsics3.checkNotNullParameter(listener, "it");
            listener.onConnected(GatewaySocket.this);
        }
    }

    /* compiled from: GatewaySocket.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.gateway.GatewaySocket$presenceUpdate$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ List $activities;
        public final /* synthetic */ Boolean $afk;
        public final /* synthetic */ Long $since;
        public final /* synthetic */ ClientStatus $status;

        /* compiled from: GatewaySocket.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/activity/Activity;", "it", "", "invoke", "(Lcom/discord/api/activity/Activity;)Ljava/lang/CharSequence;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.gateway.GatewaySocket$presenceUpdate$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00671 extends Lambda implements Function1<Activity, CharSequence> {
            public static final C00671 INSTANCE = new C00671();

            public C00671() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ CharSequence invoke(Activity activity) {
                return invoke2(activity);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final CharSequence invoke2(Activity activity) {
                Intrinsics3.checkNotNullParameter(activity, "it");
                return activity.getName();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ClientStatus clientStatus, List list, Long l, Boolean bool) {
            super(0);
            this.$status = clientStatus;
            this.$activities = list;
            this.$since = l;
            this.$afk = bool;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() throws JsonIOException {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() throws JsonIOException {
            String strName;
            Companion companion = GatewaySocket.INSTANCE;
            Logger loggerAccess$getLogger$p = GatewaySocket.access$getLogger$p(GatewaySocket.this);
            StringBuilder sbU = outline.U("Sending self presence update: ");
            sbU.append(this.$status);
            sbU.append(' ');
            List list = this.$activities;
            String lowerCase = null;
            sbU.append(list != null ? _Collections.joinToString$default(list, null, null, null, 0, null, C00671.INSTANCE, 31, null) : null);
            Companion.log$default(companion, loggerAccess$getLogger$p, sbU.toString(), false, 2, null);
            GatewaySocket gatewaySocket = GatewaySocket.this;
            Opcode opcode = Opcode.PRESENCE_UPDATE;
            ClientStatus clientStatus = this.$status;
            if (clientStatus != null && (strName = clientStatus.name()) != null) {
                Locale locale = Locale.ROOT;
                Intrinsics3.checkNotNullExpressionValue(locale, "Locale.ROOT");
                lowerCase = strName.toLowerCase(locale);
                Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            }
            Long l = this.$since;
            List listEmptyList = this.$activities;
            if (listEmptyList == null) {
                listEmptyList = Collections2.emptyList();
            }
            GatewaySocket.send$default(gatewaySocket, new Outgoing(opcode, new Outgoing2.PresenceUpdate(lowerCase, l, listEmptyList, this.$afk)), false, null, 6, null);
        }
    }

    /* compiled from: GatewaySocket.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.gateway.GatewaySocket$requestGuildMembers$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ List $guildIds;
        public final /* synthetic */ Integer $limit;
        public final /* synthetic */ String $query;
        public final /* synthetic */ List $userIds;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(List list, String str, List list2, Integer num) {
            super(0);
            this.$guildIds = list;
            this.$query = str;
            this.$userIds = list2;
            this.$limit = num;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() throws JsonIOException {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() throws JsonIOException {
            Outgoing2.GuildMembersRequest guildMembersRequest = new Outgoing2.GuildMembersRequest(this.$guildIds, this.$query, this.$userIds, this.$limit, false, 16, null);
            Companion.log$default(GatewaySocket.INSTANCE, GatewaySocket.access$getLogger$p(GatewaySocket.this), "Sending guild member request: " + guildMembersRequest, false, 2, null);
            GatewaySocket gatewaySocket = GatewaySocket.this;
            Outgoing outgoing = new Outgoing(Opcode.REQUEST_GUILD_MEMBERS, guildMembersRequest);
            Gson gsonAccess$getGsonOmitNulls$cp = GatewaySocket.access$getGsonOmitNulls$cp();
            Intrinsics3.checkNotNullExpressionValue(gsonAccess$getGsonOmitNulls$cp, "gsonOmitNulls");
            GatewaySocket.send$default(gatewaySocket, outgoing, false, gsonAccess$getGsonOmitNulls$cp, 2, null);
        }
    }

    /* compiled from: GatewaySocket.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.gateway.GatewaySocket$resetOnError$1, reason: invalid class name */
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
            GatewaySocket.access$setNextReconnectIsImmediate$p(GatewaySocket.this, false);
            GatewaySocket.handleReconnect$default(GatewaySocket.this, "encountered an error", false, 2, null);
        }
    }

    /* compiled from: GatewaySocket.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0006\u001a\u00020\u00012\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlin/Function0;", "", "kotlin.jvm.PlatformType", "it", NotificationCompat.CATEGORY_CALL, "(Lkotlin/jvm/functions/Function0;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.gateway.GatewaySocket$schedule$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<Function0<? extends Unit>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Function0<? extends Unit> function0) {
            call2((Function0<Unit>) function0);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Function0<Unit> function0) {
            function0.invoke();
        }
    }

    /* compiled from: GatewaySocket.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Throwable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.gateway.GatewaySocket$schedule$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Action1<Throwable> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Throwable th) {
            call2(th);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Throwable th) {
        }
    }

    /* compiled from: GatewaySocket.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.gateway.GatewaySocket$simulateReconnectForTesting$1, reason: invalid class name */
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
            GatewaySocket.handleReconnect$default(GatewaySocket.this, null, false, 1, null);
        }
    }

    /* compiled from: GatewaySocket.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.gateway.GatewaySocket$startHeartbeater$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() throws JsonIOException {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() throws JsonIOException {
            if (GatewaySocket.access$getHeartbeatAck$p(GatewaySocket.this)) {
                GatewaySocket.access$setHeartbeatAck$p(GatewaySocket.this, false);
                GatewaySocket gatewaySocket = GatewaySocket.this;
                GatewaySocket.access$heartbeat(gatewaySocket, GatewaySocket.access$getSeq$p(gatewaySocket));
            } else {
                if (GatewaySocket.access$getHeartbeatExpeditedTimeout$p(GatewaySocket.this).getPending()) {
                    return;
                }
                GatewaySocket.access$handleHeartbeatTimeout(GatewaySocket.this);
            }
        }
    }

    /* compiled from: GatewaySocket.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.gateway.GatewaySocket$streamDelete$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $streamKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(0);
            this.$streamKey = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() throws JsonIOException {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() throws JsonIOException {
            Companion companion = GatewaySocket.INSTANCE;
            Logger loggerAccess$getLogger$p = GatewaySocket.access$getLogger$p(GatewaySocket.this);
            StringBuilder sbU = outline.U("Sending STREAM_DELETE: ");
            sbU.append(this.$streamKey);
            Companion.log$default(companion, loggerAccess$getLogger$p, sbU.toString(), false, 2, null);
            GatewaySocket.send$default(GatewaySocket.this, new Outgoing(Opcode.STREAM_DELETE, new Outgoing2.DeleteStream(this.$streamKey)), false, null, 6, null);
        }
    }

    /* compiled from: GatewaySocket.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.gateway.GatewaySocket$streamPing$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $streamKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(0);
            this.$streamKey = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() throws JsonIOException {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() throws JsonIOException {
            Companion companion = GatewaySocket.INSTANCE;
            Logger loggerAccess$getLogger$p = GatewaySocket.access$getLogger$p(GatewaySocket.this);
            StringBuilder sbU = outline.U("Sending OPCODE_STREAM_PING: ");
            sbU.append(this.$streamKey);
            Companion.log$default(companion, loggerAccess$getLogger$p, sbU.toString(), false, 2, null);
            GatewaySocket.send$default(GatewaySocket.this, new Outgoing(Opcode.OPCODE_STREAM_PING, new Outgoing2.StreamPing(this.$streamKey)), false, null, 6, null);
        }
    }

    /* compiled from: GatewaySocket.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.gateway.GatewaySocket$streamWatch$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $streamKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(0);
            this.$streamKey = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() throws JsonIOException {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() throws JsonIOException {
            Companion companion = GatewaySocket.INSTANCE;
            Logger loggerAccess$getLogger$p = GatewaySocket.access$getLogger$p(GatewaySocket.this);
            StringBuilder sbU = outline.U("Sending STREAM_WATCH: ");
            sbU.append(this.$streamKey);
            Companion.log$default(companion, loggerAccess$getLogger$p, sbU.toString(), false, 2, null);
            GatewaySocket.send$default(GatewaySocket.this, new Outgoing(Opcode.STREAM_WATCH, new Outgoing2.WatchStream(this.$streamKey)), false, null, 6, null);
        }
    }

    /* compiled from: GatewaySocket.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.gateway.GatewaySocket$voiceServerPing$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() throws JsonIOException {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() throws JsonIOException {
            Companion.log$default(GatewaySocket.INSTANCE, GatewaySocket.access$getLogger$p(GatewaySocket.this), "Sending ping to voice server.", false, 2, null);
            GatewaySocket.send$default(GatewaySocket.this, new Outgoing(Opcode.VOICE_SERVER_PING, (Object) null), false, null, 6, null);
        }
    }

    /* compiled from: GatewaySocket.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.gateway.GatewaySocket$voiceStateUpdate$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Long $channelId;
        public final /* synthetic */ Long $guildId;
        public final /* synthetic */ String $preferredRegion;
        public final /* synthetic */ boolean $selfDeaf;
        public final /* synthetic */ boolean $selfMute;
        public final /* synthetic */ boolean $selfVideo;
        public final /* synthetic */ boolean $shouldIncludePreferredRegion;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Long l, Long l2, boolean z2, boolean z3, String str, boolean z4, boolean z5) {
            super(0);
            this.$guildId = l;
            this.$channelId = l2;
            this.$selfMute = z2;
            this.$selfDeaf = z3;
            this.$preferredRegion = str;
            this.$shouldIncludePreferredRegion = z4;
            this.$selfVideo = z5;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() throws JsonIOException {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() throws JsonIOException {
            Companion companion = GatewaySocket.INSTANCE;
            Logger loggerAccess$getLogger$p = GatewaySocket.access$getLogger$p(GatewaySocket.this);
            StringBuilder sbU = outline.U("Sending voice state update for guild [");
            sbU.append(this.$guildId);
            sbU.append("] and channel [");
            sbU.append(this.$channelId);
            sbU.append("]. ");
            sbU.append("Muted: ");
            sbU.append(this.$selfMute);
            sbU.append(", deafened: ");
            sbU.append(this.$selfDeaf);
            sbU.append(", preferredRegion: ");
            sbU.append(this.$preferredRegion);
            Companion.log$default(companion, loggerAccess$getLogger$p, sbU.toString(), false, 2, null);
            GatewaySocket.send$default(GatewaySocket.this, new Outgoing(Opcode.VOICE_STATE_UPDATE, this.$shouldIncludePreferredRegion ? new Outgoing2.VoiceStateUpdate(this.$guildId, this.$channelId, this.$selfMute, this.$selfDeaf, this.$selfVideo, this.$preferredRegion) : new Outgoing2.VoiceStateUpdateNoPreferredRegion(this.$guildId, this.$channelId, this.$selfMute, this.$selfDeaf, this.$selfVideo)), false, null, 6, null);
        }
    }

    static {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.g = true;
        FieldNamingPolicy fieldNamingPolicy = FieldNamingPolicy.m;
        gsonBuilder.c = fieldNamingPolicy;
        gsonBuilder.b(ActivityType.class, new ActivityType2());
        gsonIncludeNulls = gsonBuilder.a();
        GsonBuilder gsonBuilder2 = new GsonBuilder();
        gsonBuilder2.c = fieldNamingPolicy;
        gsonOmitNulls = gsonBuilder2.a();
        EXPECTED_NULL_DATA_EVENTS = Sets5.setOf((Object[]) new String[]{"USER_SUBSCRIPTIONS_UPDATE", "USER_PAYMENT_SOURCES_UPDATE"});
        clock = ClockFactory.get();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GatewaySocket(Function0<IdentifyData> function0, Function1<? super Map<String, ? extends Object>, Unit> function1, GatewayEventHandler gatewayEventHandler, Scheduler scheduler, Logger logger, NetworkMonitor networkMonitor, RestConfig restConfig, Context context, Function1<? super String, String> function12, SSLSocketFactory sSLSocketFactory, Map<String, ? extends Object> map, GatewaySocketLogger gatewaySocketLogger) {
        Intrinsics3.checkNotNullParameter(function0, "identifyDataProvider");
        Intrinsics3.checkNotNullParameter(function1, "trackReadyPayload");
        Intrinsics3.checkNotNullParameter(gatewayEventHandler, "eventHandler");
        Intrinsics3.checkNotNullParameter(scheduler, "scheduler");
        Intrinsics3.checkNotNullParameter(logger, "logger");
        Intrinsics3.checkNotNullParameter(networkMonitor, "networkMonitor");
        Intrinsics3.checkNotNullParameter(restConfig, "restConfig");
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(map, "identifyProperties");
        Intrinsics3.checkNotNullParameter(gatewaySocketLogger, "gatewaySocketLogger");
        this.identifyDataProvider = function0;
        this.trackReadyPayload = function1;
        this.eventHandler = gatewayEventHandler;
        this.scheduler = scheduler;
        this.logger = logger;
        this.gatewayUrlTransform = function12;
        this.sslSocketFactory = sSLSocketFactory;
        this.identifyProperties = map;
        this.gatewaySocketLogger = gatewaySocketLogger;
        Backoff backoff = new Backoff(1000L, 10000L, 4, true, new Timer(scheduler));
        this.gatewayBackoff = backoff;
        this.heartbeatExpeditedTimeout = new Timer(scheduler);
        this.heartbeatInterval = RecyclerView.FOREVER_NS;
        this.heartbeater = new Timer(scheduler);
        this.heartbeatAck = true;
        this.helloTimeout = new Timer(scheduler);
        ListenerCollection2<Listener> listenerCollection2 = new ListenerCollection2<>();
        this.listenerSubject = listenerCollection2;
        this.listeners = listenerCollection2;
        RestClient restClient = RestClient.INSTANCE;
        restClient.init(restConfig, context);
        this.gatewayDiscovery = new GatewayDiscovery(context, scheduler, backoff, new AnonymousClass1(), restClient.getGateway());
        Observable<Boolean> observableJ = networkMonitor.observeIsConnected().J(scheduler);
        Observable.h0(new OnSubscribeLift(observableJ.j, new OperatorSkipWhile3(new OperatorSkipWhile2(AnonymousClass2.INSTANCE)))).W(new AnonymousClass3(), new AnonymousClass4());
    }

    public static final /* synthetic */ void access$cleanup(GatewaySocket gatewaySocket, Function1 function1) {
        gatewaySocket.cleanup(function1);
    }

    public static final /* synthetic */ void access$connect(GatewaySocket gatewaySocket, String str) {
        gatewaySocket.connect(str);
    }

    public static final /* synthetic */ void access$discover(GatewaySocket gatewaySocket) {
        gatewaySocket.discover();
    }

    public static final /* synthetic */ void access$discoveryFailed(GatewaySocket gatewaySocket) {
        gatewaySocket.discoveryFailed();
    }

    public static final /* synthetic */ long access$getConnectionStartTime$p(GatewaySocket gatewaySocket) {
        return gatewaySocket.connectionStartTime;
    }

    public static final /* synthetic */ int access$getConnectionState$p(GatewaySocket gatewaySocket) {
        return gatewaySocket.connectionState;
    }

    public static final /* synthetic */ Backoff access$getGatewayBackoff$p(GatewaySocket gatewaySocket) {
        return gatewaySocket.gatewayBackoff;
    }

    public static final /* synthetic */ GatewaySocketLogger access$getGatewaySocketLogger$p(GatewaySocket gatewaySocket) {
        return gatewaySocket.gatewaySocketLogger;
    }

    public static final /* synthetic */ Function1 access$getGatewayUrlTransform$p(GatewaySocket gatewaySocket) {
        return gatewaySocket.gatewayUrlTransform;
    }

    public static final /* synthetic */ Gson access$getGsonOmitNulls$cp() {
        return gsonOmitNulls;
    }

    public static final /* synthetic */ boolean access$getHeartbeatAck$p(GatewaySocket gatewaySocket) {
        return gatewaySocket.heartbeatAck;
    }

    public static final /* synthetic */ Timer access$getHeartbeatExpeditedTimeout$p(GatewaySocket gatewaySocket) {
        return gatewaySocket.heartbeatExpeditedTimeout;
    }

    public static final /* synthetic */ Logger access$getLogger$p(GatewaySocket gatewaySocket) {
        return gatewaySocket.logger;
    }

    public static final /* synthetic */ boolean access$getNextReconnectIsImmediate$p(GatewaySocket gatewaySocket) {
        return gatewaySocket.nextReconnectIsImmediate;
    }

    public static final /* synthetic */ int access$getSeq$p(GatewaySocket gatewaySocket) {
        return gatewaySocket.seq;
    }

    public static final /* synthetic */ WebSocket access$getWebSocket$p(GatewaySocket gatewaySocket) {
        return gatewaySocket.webSocket;
    }

    public static final /* synthetic */ void access$handleClose(GatewaySocket gatewaySocket, boolean z2, int i, String str) {
        gatewaySocket.handleClose(z2, i, str);
    }

    public static final /* synthetic */ void access$handleDeviceConnectivityChange(GatewaySocket gatewaySocket, boolean z2) {
        gatewaySocket.handleDeviceConnectivityChange(z2);
    }

    public static final /* synthetic */ void access$handleHeartbeatTimeout(GatewaySocket gatewaySocket) {
        gatewaySocket.handleHeartbeatTimeout();
    }

    public static final /* synthetic */ void access$handleWebSocketClose(GatewaySocket gatewaySocket, WebSocket.Closed closed) {
        gatewaySocket.handleWebSocketClose(closed);
    }

    public static final /* synthetic */ void access$handleWebSocketError(GatewaySocket gatewaySocket) {
        gatewaySocket.handleWebSocketError();
    }

    public static final /* synthetic */ void access$handleWebSocketMessage(GatewaySocket gatewaySocket, InputStreamReader inputStreamReader, int i) {
        gatewaySocket.handleWebSocketMessage(inputStreamReader, i);
    }

    public static final /* synthetic */ void access$handleWebSocketOpened(GatewaySocket gatewaySocket, String str) {
        gatewaySocket.handleWebSocketOpened(str);
    }

    public static final /* synthetic */ void access$heartbeat(GatewaySocket gatewaySocket, int i) throws JsonIOException {
        gatewaySocket.heartbeat(i);
    }

    public static final /* synthetic */ void access$logError(GatewaySocket gatewaySocket, String str, Exception exc, Map map) {
        gatewaySocket.logError(str, exc, map);
    }

    public static final /* synthetic */ void access$reset(GatewaySocket gatewaySocket, boolean z2, int i, String str) {
        gatewaySocket.reset(z2, i, str);
    }

    public static final /* synthetic */ void access$setConnectionStartTime$p(GatewaySocket gatewaySocket, long j) {
        gatewaySocket.connectionStartTime = j;
    }

    public static final /* synthetic */ void access$setConnectionState$p(GatewaySocket gatewaySocket, int i) {
        gatewaySocket.connectionState = i;
    }

    public static final /* synthetic */ void access$setHeartbeatAck$p(GatewaySocket gatewaySocket, boolean z2) {
        gatewaySocket.heartbeatAck = z2;
    }

    public static final /* synthetic */ void access$setHeartbeatExpeditedTimeout$p(GatewaySocket gatewaySocket, Timer timer) {
        gatewaySocket.heartbeatExpeditedTimeout = timer;
    }

    public static final /* synthetic */ void access$setNextReconnectIsImmediate$p(GatewaySocket gatewaySocket, boolean z2) {
        gatewaySocket.nextReconnectIsImmediate = z2;
    }

    public static final /* synthetic */ void access$setSeq$p(GatewaySocket gatewaySocket, int i) {
        gatewaySocket.seq = i;
    }

    public static final /* synthetic */ void access$setWebSocket$p(GatewaySocket gatewaySocket, WebSocket webSocket) {
        gatewaySocket.webSocket = webSocket;
    }

    private final void cleanup(Function1<? super WebSocket, Unit> callback) {
        stopHeartbeater();
        clearHelloTimeout();
        if (callback != null) {
            callback.invoke(this.webSocket);
        }
        WebSocket webSocket = this.webSocket;
        if (webSocket != null) {
            webSocket.resetListeners();
        }
        this.webSocket = null;
        this.gatewayBackoff.cancel();
    }

    private final void clearHelloTimeout() {
        this.helloTimeout.cancel();
    }

    public static /* synthetic */ void close$default(GatewaySocket gatewaySocket, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        gatewaySocket.close(z2);
    }

    private final void discover() {
        this.nextReconnectIsImmediate = false;
        if (this.connectionState != 1) {
            return;
        }
        this.listenerSubject.notify(new AnonymousClass1());
        this.gatewayDiscovery.discoverGatewayUrl(new AnonymousClass2(), new AnonymousClass3());
    }

    private final void discoveryFailed() {
        long jFail = this.gatewayBackoff.fail(new GatewaySocket$discoveryFailed$delay$1(this));
        Companion.log$default(INSTANCE, this.logger, "Discovery failed, retrying in " + jFail + "ms.", false, 2, null);
        if (this.gatewayBackoff.hasReachedFailureThreshold()) {
            reset(false, 0, "Gateway discovery failed.");
        }
    }

    private final void doIdentify() throws JsonIOException {
        this.seq = 0;
        this.sessionId = null;
        IdentifyData identifyDataInvoke = this.identifyDataProvider.invoke();
        if (identifyDataInvoke == null) {
            handleClose(true, CLOSE_CODE_UNAUTHORIZED, "No connection info provided.");
            return;
        }
        this.connectionState = 3;
        this.identifyStartTime = clock.currentTimeMillis();
        this.token = identifyDataInvoke.getToken();
        Companion.log$default(INSTANCE, this.logger, "Sending identify.", false, 2, null);
        send$default(this, new Outgoing(Opcode.IDENTIFY, new Outgoing2.Identify(identifyDataInvoke.getToken(), 100, true, CLIENT_CAPABILITIES, this.identifyProperties, identifyDataInvoke.getClientState())), false, null, 4, null);
    }

    private final void doResume() throws JsonIOException {
        this.connectionState = 4;
        this.replayedEvents = 0;
        Companion companion = INSTANCE;
        Logger logger = this.logger;
        StringBuilder sbU = outline.U("Resuming session ");
        String str = this.sessionId;
        if (str == null) {
            str = "";
        }
        sbU.append(str);
        sbU.append(" at sequence: ");
        Companion.log$default(companion, logger, outline.A(sbU, this.seq, '.'), false, 2, null);
        send$default(this, new Outgoing(Opcode.RESUME, new Outgoing2.Resume(this.token, this.sessionId, this.seq)), false, null, 4, null);
    }

    private final void doResumeOrIdentify() throws JsonIOException {
        Companion companion = INSTANCE;
        long delay$default = Companion.getDelay$default(companion, this.heartbeatAckTimeMostRecent, null, 2, null);
        float f = this.heartbeatAckTimeMostRecent == 0 ? 0.0f : (delay$default / 1000.0f) / 60.0f;
        if (this.sessionId != null && delay$default <= ((long) HEARTBEAT_MAX_RESUME_THRESHOLD)) {
            Logger logger = this.logger;
            StringBuilder sbU = outline.U("Attempting to resume after elapsed duration of ");
            String str = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(f)}, 1));
            Intrinsics3.checkNotNullExpressionValue(str, "java.lang.String.format(this, *args)");
            sbU.append(str);
            sbU.append(" minutes.");
            Companion.log$default(companion, logger, sbU.toString(), false, 2, null);
            doResume();
        } else {
            handleInvalidSession(false);
        }
        this.heartbeatAckTimeMostRecent = clock.currentTimeMillis();
    }

    public static /* synthetic */ void expeditedHeartbeat$default(GatewaySocket gatewaySocket, long j, String str, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        gatewaySocket.expeditedHeartbeat(j, str, z2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void flattenTraces(Object trace, ArrayList<Tuples2<String, Integer>> result) {
        if (trace == null) {
            return;
        }
        try {
            if (!TypeIntrinsics.isMutableList(trace)) {
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i + 1;
                if (i2 >= ((List) trace).size()) {
                    return;
                }
                Object obj = ((List) trace).get(i);
                Number number = null;
                if (!(obj instanceof String)) {
                    obj = null;
                }
                String str = (String) obj;
                Object obj2 = ((List) trace).get(i2);
                if (!TypeIntrinsics.isMutableMap(obj2)) {
                    obj2 = null;
                }
                Map map = (Map) obj2;
                i += 2;
                if (str != null && map != null) {
                    if (map.containsKey("micros")) {
                        Object obj3 = map.get("micros");
                        if (obj3 instanceof Number) {
                            number = obj3;
                        }
                        number = number;
                    }
                    if (number != null) {
                        result.add(new Tuples2<>(str, Integer.valueOf(number.intValue() / 1000)));
                    }
                    flattenTraces(map.get("calls"), result);
                }
            }
        } catch (Exception e) {
            Logger.e$default(this.logger, "Unable to parse ready payload traces", e, null, 4, null);
        }
    }

    private final String getConnectionPath(ModelPayload.Hello hello) {
        String strJoinToString$default;
        List<String> trace = hello.getTrace();
        return (trace == null || (strJoinToString$default = _Collections.joinToString$default(trace, " -> ", null, null, 0, null, null, 62, null)) == null) ? "???" : strJoinToString$default;
    }

    private final void handleClose(boolean wasClean, int code, String reason) {
        cleanup(AnonymousClass1.INSTANCE);
        handleConnected$default(this, null, Boolean.FALSE, 1, null);
        if (code == CLOSE_CODE_UNAUTHORIZED) {
            this.connectionState = 0;
            reset(wasClean, code, reason);
            return;
        }
        this.connectionState = 1;
        StringBuilder sb = new StringBuilder();
        sb.append("Closed cleanly: ");
        sb.append(wasClean);
        sb.append(", with code: ");
        sb.append(code);
        sb.append(", for reason: '");
        String strJ = outline.J(sb, reason, "'.");
        if (this.nextReconnectIsImmediate) {
            Companion.log$default(INSTANCE, this.logger, outline.w(strJ, " Retrying immediately."), false, 2, null);
            discover();
            return;
        }
        long jFail = this.gatewayBackoff.fail(new GatewaySocket$handleClose$delay$1(this));
        Companion.log$default(INSTANCE, this.logger, strJ + " Retrying in: " + jFail + "ms.", false, 2, null);
        if (this.gatewayBackoff.hasReachedFailureThreshold()) {
            reset(wasClean, code, reason);
        }
    }

    private final void handleConnected(Boolean connected, Boolean connectionReady) {
        if (connected != null) {
            boolean zBooleanValue = connected.booleanValue();
            this.connected = zBooleanValue;
            this.hasConnectedOnce = this.hasConnectedOnce || zBooleanValue;
            this.eventHandler.handleConnected(zBooleanValue);
        }
        if (connectionReady != null) {
            boolean zBooleanValue2 = connectionReady.booleanValue();
            this.connectionReady = zBooleanValue2;
            this.eventHandler.handleConnectionReady(zBooleanValue2);
        }
    }

    public static /* synthetic */ void handleConnected$default(GatewaySocket gatewaySocket, Boolean bool, Boolean bool2, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = null;
        }
        if ((i & 2) != 0) {
            bool2 = null;
        }
        gatewaySocket.handleConnected(bool, bool2);
    }

    private final void handleDeviceConnectivityChange(boolean isConnected) {
        if (isConnected) {
            expeditedHeartbeat$default(this, 4500L, "network detected online", false, 4, null);
        } else {
            expeditedHeartbeat$default(this, 9000L, "network detected offline", false, 4, null);
        }
    }

    private final void handleDispatch(Object data, String type, int compressedByteSize, int uncompressedByteSize, long unpackDurationMs) {
        if (this.connectionState == 4) {
            this.replayedEvents++;
        }
        if (Intrinsics3.areEqual(type, "READY") || Intrinsics3.areEqual(type, "RESUMED")) {
            if (type != null) {
                int iHashCode = type.hashCode();
                if (iHashCode != 77848963) {
                    if (iHashCode == 1815529911 && type.equals("RESUMED")) {
                        StringBuilder sb = new StringBuilder();
                        StringBuilder sbU = outline.U("Resumed session, took ");
                        Companion companion = INSTANCE;
                        sbU.append(Companion.getDelay$default(companion, this.connectionStartTime, null, 2, null));
                        sbU.append("ms, ");
                        sb.append(sbU.toString());
                        sb.append("replayed " + this.replayedEvents + " events, new seq: " + this.seq + '.');
                        String string = sb.toString();
                        Intrinsics3.checkNotNullExpressionValue(string, "StringBuilder()\n        …              .toString()");
                        Companion.log$default(companion, this.logger, string, false, 2, null);
                        this.replayedEvents = 0;
                    }
                } else if (type.equals("READY")) {
                    ModelPayload modelPayload = (ModelPayload) data;
                    if (modelPayload == null) {
                        handleReconnect$default(this, "Reconnect due to invalid ready payload received.", false, 2, null);
                        return;
                    }
                    this.sessionId = modelPayload.getSessionId();
                    trackReadyPayload(modelPayload, compressedByteSize, uncompressedByteSize, unpackDurationMs);
                    Companion companion2 = INSTANCE;
                    Logger logger = this.logger;
                    StringBuilder sbU2 = outline.U("Ready with session id: ");
                    sbU2.append(this.sessionId);
                    sbU2.append(", took ");
                    Companion.log$default(companion2, logger, outline.C(sbU2, Companion.getDelay$default(companion2, this.connectionStartTime, null, 2, null), "ms"), false, 2, null);
                }
            }
            this.gatewayBackoff.succeed();
            this.connectionState = 5;
            Boolean bool = Boolean.TRUE;
            handleConnected(bool, bool);
        }
        if (data != null) {
            this.eventHandler.handleDispatch(type, data);
            return;
        }
        if (_Collections.contains(EXPECTED_NULL_DATA_EVENTS, type)) {
            this.eventHandler.handleDispatch(type, Unit.a);
        } else if ((!Intrinsics3.areEqual(type, "READY")) && (!Intrinsics3.areEqual(type, "RESUMED"))) {
            Logger.w$default(this.logger, outline.y("handleDispatch() ", type, " is unhandled!"), null, 2, null);
        }
    }

    private final void handleHeartbeat() throws JsonIOException {
        heartbeat(this.seq);
    }

    private final void handleHeartbeatAck() {
        Companion.access$log(INSTANCE, this.logger, "Received heartbeat ACK.", false);
        this.heartbeatAckTimeMostRecent = clock.currentTimeMillis();
        this.heartbeatAck = true;
        this.heartbeatExpeditedTimeout.cancel(new AnonymousClass1());
    }

    private final void handleHeartbeatTimeout() {
        cleanup(AnonymousClass1.INSTANCE);
        this.connectionState = 1;
        long jFail = this.gatewayBackoff.fail(new GatewaySocket$handleHeartbeatTimeout$delay$1(this));
        Companion.log$default(INSTANCE, this.logger, "Ack timeout, reconnecting om " + jFail + "ms.", false, 2, null);
    }

    private final void handleHello(ModelPayload.Hello data) {
        this.listenerSubject.notify(new AnonymousClass1());
        clearHelloTimeout();
        this.heartbeatInterval = data.getHeartbeatInterval();
        Companion companion = INSTANCE;
        Logger logger = this.logger;
        StringBuilder sbU = outline.U("Hello via ");
        sbU.append(getConnectionPath(data));
        sbU.append(", at interval ");
        sbU.append(this.heartbeatInterval);
        sbU.append(" took ");
        Companion.log$default(companion, logger, outline.C(sbU, Companion.getDelay$default(companion, this.connectionStartTime, null, 2, null), "ms."), false, 2, null);
        startHeartbeater();
    }

    private final void handleInvalidSession(boolean canResume) throws JsonIOException {
        Companion.log$default(INSTANCE, this.logger, outline.J(outline.U("Invalid session, is "), canResume ? "" : "not", " resumable."), false, 2, null);
        if (canResume) {
            doResumeOrIdentify();
            return;
        }
        Boolean bool = Boolean.FALSE;
        handleConnected(bool, bool);
        doIdentify();
    }

    private final void handleReconnect(String reason, boolean resetSession) {
        cleanup(new AnonymousClass1(reason));
        reset(!resetSession, resetSession ? 1000 : 4000, reason);
        handleClose(!resetSession, 0, reason);
    }

    public static /* synthetic */ void handleReconnect$default(GatewaySocket gatewaySocket, String str, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "Reconnect to gateway requested.";
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        gatewaySocket.handleReconnect(str, z2);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void handleWebSocketClose(WebSocket.Closed closed) {
        String reason = closed.getReason();
        if (reason == null) {
            reason = "unspecified reason";
        } else {
            if (!(reason.length() > 0)) {
            }
        }
        this.listenerSubject.notify(new AnonymousClass1());
        handleClose(true, closed.getCode(), reason);
    }

    private final void handleWebSocketError() {
        handleClose(false, 0, "An error with the web socket occurred.");
    }

    private final void handleWebSocketMessage(InputStreamReader reader, int compressedByteSize) throws JsonIOException {
        long jCurrentTimeMillis = clock.currentTimeMillis();
        SizeRecordingInputStreamReader sizeRecordingInputStreamReader = new SizeRecordingInputStreamReader(reader, 0, 2, null);
        Incoming incomingBuild = ((Incoming2) new Model.JsonReader(new JsonReader(sizeRecordingInputStreamReader)).parse(new Incoming2(new GatewaySocket$handleWebSocketMessage$incomingParser$1(this)))).build();
        Integer seq = incomingBuild.getSeq();
        Companion companion = INSTANCE;
        long delay$default = Companion.getDelay$default(companion, jCurrentTimeMillis, null, 2, null);
        if (seq != null) {
            this.seq = seq.intValue();
        }
        int iOrdinal = incomingBuild.getOpcode().ordinal();
        if (iOrdinal == 1) {
            handleDispatch(incomingBuild.getData(), incomingBuild.getType(), compressedByteSize, sizeRecordingInputStreamReader.getSize(), delay$default);
        }
        if (iOrdinal == 2) {
            handleHeartbeat();
            return;
        }
        if (iOrdinal == 8) {
            handleReconnect$default(this, null, false, 1, null);
            return;
        }
        switch (iOrdinal) {
            case 10:
                Object data = incomingBuild.getData();
                Objects.requireNonNull(data, "null cannot be cast to non-null type kotlin.Boolean");
                handleInvalidSession(((Boolean) data).booleanValue());
                break;
            case 11:
                Object data2 = incomingBuild.getData();
                Objects.requireNonNull(data2, "null cannot be cast to non-null type com.discord.models.domain.ModelPayload.Hello");
                handleHello((ModelPayload.Hello) data2);
                break;
            case 12:
                handleHeartbeatAck();
                break;
            default:
                Logger logger = this.logger;
                StringBuilder sbU = outline.U("Unhandled op code ");
                sbU.append(incomingBuild.getOpcode());
                sbU.append('.');
                Companion.log$default(companion, logger, sbU.toString(), false, 2, null);
                break;
        }
    }

    private final void handleWebSocketOpened(String gatewayUrl) throws JsonIOException {
        Companion companion = INSTANCE;
        Companion.log$default(companion, this.logger, outline.C(outline.Y("Connected to ", gatewayUrl, " in "), Companion.getDelay$default(companion, this.connectionStartTime, null, 2, null), "ms."), false, 2, null);
        this.listenerSubject.notify(new AnonymousClass1());
        doResumeOrIdentify();
    }

    private final void heartbeat(int seq) throws JsonIOException {
        Companion.access$log(INSTANCE, this.logger, "Sending heartbeat at sequence: " + seq + '.', false);
        send$default(this, new Outgoing(Opcode.HEARTBEAT, Integer.valueOf(seq)), false, null, 4, null);
    }

    private final void logError(String message, Exception exception, Map<String, String> metadata) {
        Logger logger = this.logger;
        if (metadata == null) {
            metadata = Maps6.emptyMap();
        }
        logger.e(message, exception, metadata);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void presenceUpdate$default(GatewaySocket gatewaySocket, ClientStatus clientStatus, Long l, List list, Boolean bool, int i, Object obj) {
        if ((i & 2) != 0) {
            l = Long.valueOf(clock.currentTimeMillis());
        }
        if ((i & 4) != 0) {
            list = null;
        }
        if ((i & 8) != 0) {
            bool = Boolean.FALSE;
        }
        gatewaySocket.presenceUpdate(clientStatus, l, list, bool);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void requestGuildMembers$default(GatewaySocket gatewaySocket, List list, String str, List list2, Integer num, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            list2 = null;
        }
        if ((i & 8) != 0) {
            num = null;
        }
        gatewaySocket.requestGuildMembers(list, str, list2, num);
    }

    private final void reset(boolean wasClean, int code, String reason) {
        if (code != 4000) {
            this.sessionId = null;
            this.seq = 0;
        }
        String str = wasClean ? "cleanly" : "dirty";
        Companion.log$default(INSTANCE, this.logger, "Reset " + str + ", with code " + code + ", at sequence " + this.seq + ". Reason: '" + reason + "'.", false, 2, null);
        handleConnected(Boolean.valueOf(code == 4000 && this.connected), Boolean.FALSE);
        this.eventHandler.handleDisconnect(code == CLOSE_CODE_UNAUTHORIZED);
    }

    private final void schedule(Function0<Unit> callback) {
        new ScalarSynchronousObservable(callback).X(this.scheduler).W(AnonymousClass1.INSTANCE, AnonymousClass2.INSTANCE);
    }

    private final void send(Outgoing data, boolean checkSessionEstablished, Gson gson) throws JsonIOException {
        if (checkSessionEstablished && !isSessionEstablished()) {
            Companion companion = INSTANCE;
            Logger logger = this.logger;
            StringBuilder sbU = outline.U("Attempted to send while not being in a connected state, opcode: ");
            sbU.append(data.getOp());
            sbU.append('.');
            Companion.log$default(companion, logger, sbU.toString(), false, 2, null);
            return;
        }
        WebSocket webSocket = this.webSocket;
        if (webSocket != null) {
            String strM = gson.m(data);
            GatewaySocketLogger gatewaySocketLogger = this.gatewaySocketLogger;
            Intrinsics3.checkNotNullExpressionValue(strM, GATEWAY_ENCODING);
            gatewaySocketLogger.logOutboundMessage(strM);
            webSocket.message(strM);
            return;
        }
        Companion companion2 = INSTANCE;
        Logger logger2 = this.logger;
        StringBuilder sbU2 = outline.U("Attempted to send without a web socket that exists, opcode: ");
        sbU2.append(data.getOp());
        sbU2.append('.');
        Companion.log$default(companion2, logger2, sbU2.toString(), false, 2, null);
    }

    public static /* synthetic */ void send$default(GatewaySocket gatewaySocket, Outgoing outgoing, boolean z2, Gson gson, int i, Object obj) throws JsonIOException {
        if ((i & 2) != 0) {
            z2 = true;
        }
        if ((i & 4) != 0) {
            gson = gsonIncludeNulls;
            Intrinsics3.checkNotNullExpressionValue(gson, "gsonIncludeNulls");
        }
        gatewaySocket.send(outgoing, z2, gson);
    }

    private final void startHeartbeater() {
        this.heartbeater.cancel();
        this.heartbeatAck = true;
        this.heartbeater.postInterval(new AnonymousClass1(), this.heartbeatInterval);
    }

    private final void stopHeartbeater() {
        this.heartbeater.cancel();
        this.heartbeatExpeditedTimeout.cancel();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void trackReadyPayload(ModelPayload payload, int compressedByteSize, int uncompressedByteSize, long unpackDurationMs) {
        int iIntValue;
        int size = payload.getGuilds().size();
        Iterator<Guild> it = payload.getGuilds().iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            List<Channel> listG = it.next().g();
            if (listG != null) {
                Iterator<T> it2 = listG.iterator();
                while (it2.hasNext()) {
                    i++;
                    if (((Channel) it2.next()).getType() == 4) {
                        i2++;
                    }
                }
            }
        }
        ArrayList<Tuples2<String, Integer>> arrayList = new ArrayList<>();
        flattenTraces(payload.getTrace(), arrayList);
        if (arrayList.size() > 0) {
            Tuples2<String, Integer> tuples2 = arrayList.get(0);
            String strComponent1 = tuples2.component1();
            iIntValue = tuples2.component2().intValue();
            if (!StringsJVM.startsWith$default(strComponent1, "gateway-", false, 2, null)) {
                iIntValue = 0;
            }
        }
        Iterator<Tuples2<String, Integer>> it3 = arrayList.iterator();
        int i3 = 0;
        int i4 = 0;
        while (it3.hasNext()) {
            Tuples2<String, Integer> next = it3.next();
            String strComponent12 = next.component1();
            int iIntValue2 = next.component2().intValue();
            if (Intrinsics3.areEqual(strComponent12, "start_session")) {
                i3 = iIntValue2;
            } else if (Intrinsics3.areEqual(strComponent12, "guilds_connect")) {
                i4 = iIntValue2;
            }
        }
        Function1<Map<String, ? extends Object>, Unit> function1 = this.trackReadyPayload;
        Companion companion = INSTANCE;
        function1.invoke(Maps6.mapOf(Tuples.to("duration_ms_since_connection_start", Long.valueOf(Companion.getDelay$default(companion, this.connectionStartTime, null, 2, null))), Tuples.to("duration_ms_since_identify_start", Long.valueOf(Companion.getDelay$default(companion, this.identifyStartTime, null, 2, null))), Tuples.to("identify_total_server_duration_ms", Integer.valueOf(iIntValue)), Tuples.to("identify_api_duration_ms", Integer.valueOf(i3)), Tuples.to("identify_guilds_duration_ms", Integer.valueOf(i4)), Tuples.to("compressed_byte_size", Integer.valueOf(compressedByteSize)), Tuples.to("uncompressed_byte_size", Integer.valueOf(uncompressedByteSize)), Tuples.to("compression_algorithm", "zlib"), Tuples.to("packing_algorithm", GATEWAY_ENCODING), Tuples.to("unpack_duration_ms", Long.valueOf(unpackDurationMs)), Tuples.to("is_reconnect", Boolean.valueOf(this.hasConnectedOnce)), Tuples.to("is_fast_connect", Boolean.FALSE), Tuples.to("num_guilds", Integer.valueOf(size)), Tuples.to("num_guild_channels", Integer.valueOf(i)), Tuples.to("num_guild_category_channels", Integer.valueOf(i2))));
    }

    public final void callConnect(long channelId) {
        schedule(new AnonymousClass1(channelId));
    }

    public final void close(boolean clean) {
        schedule(new AnonymousClass1(clean));
    }

    public final void connect() {
        schedule(new AnonymousClass1());
    }

    public final void expeditedHeartbeat(long timeout, String reason, boolean shouldResetBackoff) {
        schedule(new AnonymousClass1(reason, timeout, shouldResetBackoff));
    }

    public final ListenerCollection<Listener> getListeners() {
        return this.listeners;
    }

    public final boolean isSessionEstablished() {
        return this.connectionState == 5;
    }

    public final void presenceUpdate(ClientStatus status, Long since, List<Activity> activities, Boolean afk) {
        schedule(new AnonymousClass1(status, activities, since, afk));
    }

    public final void requestApplicationCommands(Outgoing2.ApplicationCommandRequest request) {
        Intrinsics3.checkNotNullParameter(request, "request");
        Outgoing outgoing = new Outgoing(Opcode.REQUEST_GUILD_APPLICATION_COMMANDS, request);
        Gson gson = gsonOmitNulls;
        Intrinsics3.checkNotNullExpressionValue(gson, "gsonOmitNulls");
        send$default(this, outgoing, false, gson, 2, null);
    }

    public final void requestForumUnreads(Outgoing2.ForumUnreadsRequest request) {
        Intrinsics3.checkNotNullParameter(request, "request");
        Outgoing outgoing = new Outgoing(Opcode.REQUEST_FORUM_UNREADS, request);
        Gson gson = gsonOmitNulls;
        Intrinsics3.checkNotNullExpressionValue(gson, "gsonOmitNulls");
        send$default(this, outgoing, false, gson, 2, null);
    }

    public final void requestGuildMembers(List<Long> list) {
        requestGuildMembers$default(this, list, null, null, null, 14, null);
    }

    public final void requestGuildMembers(List<Long> list, String str) {
        requestGuildMembers$default(this, list, str, null, null, 12, null);
    }

    public final void requestGuildMembers(List<Long> list, String str, List<Long> list2) {
        requestGuildMembers$default(this, list, str, list2, null, 8, null);
    }

    public final void requestGuildMembers(List<Long> guildIds, String query, List<Long> userIds, Integer limit) {
        Intrinsics3.checkNotNullParameter(guildIds, "guildIds");
        schedule(new AnonymousClass1(guildIds, query, userIds, limit));
    }

    public final void resetOnError() {
        schedule(new AnonymousClass1());
    }

    public final void simulateReconnectForTesting() {
        schedule(new AnonymousClass1());
    }

    public final void streamCreate(String streamType, long channelId, Long guildId, String preferredRegion) {
        Intrinsics3.checkNotNullParameter(streamType, "streamType");
        Companion.log$default(INSTANCE, this.logger, "Sending STREAM_CREATE: " + channelId + ' ' + guildId, false, 2, null);
        send$default(this, new Outgoing(Opcode.STREAM_CREATE, new Outgoing2.CreateStream(streamType, channelId, guildId, preferredRegion)), false, null, 6, null);
    }

    public final void streamDelete(String streamKey) {
        Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
        schedule(new AnonymousClass1(streamKey));
    }

    public final void streamPing(String streamKey) {
        Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
        schedule(new AnonymousClass1(streamKey));
    }

    public final void streamWatch(String streamKey) {
        Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
        schedule(new AnonymousClass1(streamKey));
    }

    public final void updateGuildSubscriptions(long guildId, Outgoing2.GuildSubscriptions guildSubscriptions) {
        Intrinsics3.checkNotNullParameter(guildSubscriptions, "guildSubscriptions");
        Companion.log$default(INSTANCE, this.logger, "sending guild subscriptions: " + guildId + " -- " + guildSubscriptions, false, 2, null);
        Opcode opcode = Opcode.GUILD_SUBSCRIPTIONS;
        Boolean typing = guildSubscriptions.getTyping();
        Boolean activities = guildSubscriptions.getActivities();
        List<Long> members = guildSubscriptions.getMembers();
        Outgoing outgoing = new Outgoing(opcode, new Outgoing2.GuildSubscriptionsUpdate(guildId, typing, activities, members != null ? _Collections.toList(members) : null, guildSubscriptions.getChannels(), guildSubscriptions.getThreads(), guildSubscriptions.getThreadMemberLists()));
        Gson gson = gsonOmitNulls;
        Intrinsics3.checkNotNullExpressionValue(gson, "gsonOmitNulls");
        send$default(this, outgoing, false, gson, 2, null);
    }

    public final void voiceServerPing() {
        schedule(new AnonymousClass1());
    }

    public final void voiceStateUpdate(Long guildId, Long channelId, boolean selfMute, boolean selfDeaf, boolean selfVideo, String preferredRegion, boolean shouldIncludePreferredRegion) {
        schedule(new AnonymousClass1(guildId, channelId, selfMute, selfDeaf, preferredRegion, shouldIncludePreferredRegion, selfVideo));
    }

    private final void connect(String gatewayUrl) {
        GatewaySocket$connect$$inlined$apply$lambda$4 gatewaySocket$connect$$inlined$apply$lambda$4;
        if (this.connectionState != 1) {
            return;
        }
        this.connectionState = 2;
        Companion.log$default(INSTANCE, this.logger, outline.y("Connect to: ", gatewayUrl, ", encoding: json, version 9."), false, 2, null);
        cleanup(AnonymousClass2.INSTANCE);
        this.connectionStartTime = clock.currentTimeMillis();
        this.helloTimeout.schedule(new AnonymousClass3(), HELLO_TIMEOUT);
        WebSocket webSocket = new WebSocket(this.scheduler, new AnonymousClass4(this), this.sslSocketFactory);
        webSocket.setOnOpened(new GatewaySocket$connect$$inlined$apply$lambda$1(this, gatewayUrl));
        webSocket.setOnClosed(new GatewaySocket$connect$$inlined$apply$lambda$2(this, gatewayUrl));
        webSocket.setOnMessage(new GatewaySocket$connect$$inlined$apply$lambda$3(this, gatewayUrl));
        int iOrdinal = this.gatewaySocketLogger.getLogLevel().ordinal();
        if (iOrdinal == 0) {
            gatewaySocket$connect$$inlined$apply$lambda$4 = null;
        } else {
            if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            gatewaySocket$connect$$inlined$apply$lambda$4 = new GatewaySocket$connect$$inlined$apply$lambda$4(this, gatewayUrl);
        }
        webSocket.setRawMessageHandler(gatewaySocket$connect$$inlined$apply$lambda$4);
        webSocket.setOnError(new GatewaySocket$connect$$inlined$apply$lambda$5(this, gatewayUrl));
        webSocket.connect(gatewayUrl + "/?encoding=json&v=9&compress=zlib-stream");
        this.webSocket = webSocket;
    }

    public /* synthetic */ GatewaySocket(Function0 function0, Function1 function1, GatewayEventHandler gatewayEventHandler, Scheduler scheduler, Logger logger, NetworkMonitor networkMonitor, RestConfig restConfig, Context context, Function1 function12, SSLSocketFactory sSLSocketFactory, Map map, GatewaySocketLogger gatewaySocketLogger, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, function1, gatewayEventHandler, scheduler, logger, networkMonitor, restConfig, context, (i & 256) != 0 ? null : function12, (i & 512) != 0 ? null : sSLSocketFactory, (i & 1024) != 0 ? Maps6.emptyMap() : map, gatewaySocketLogger);
    }
}
