package com.discord.stores;

import a0.a.a.b;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.collection.LruCache;
import androidx.media.AudioAttributesCompat;
import b.a.b.TypeAdapterRegistrar;
import b.d.b.a.outline;
import b.i.d.GsonBuilder;
import com.discord.api.botuikit.Component6;
import com.discord.api.commands.ApplicationCommandData;
import com.discord.api.interaction.Interaction;
import com.discord.api.interaction.InteractionModalCreate;
import com.discord.api.interaction.InteractionStateUpdate;
import com.discord.api.user.User;
import com.discord.app.AppLog;
import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommandLocalSendData;
import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.NonceGenerator;
import com.discord.models.message.Message;
import com.discord.nullserializable.NullSerializable;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.cache.SharedPreferencesProvider;
import com.discord.utilities.error.Error;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.message.LocalMessageCreators;
import com.discord.utilities.messagesend.MessageQueue4;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.utilities.user.UserUtils;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.lytefast.flexinput.model.Attachment;
import d0.Tuples;
import d0.g0.StringsJVM;
import d0.t.CollectionsJVM;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: StoreApplicationInteractions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ð\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 Ì\u00012\u00020\u0001:\fÌ\u0001Í\u0001Î\u0001Ï\u0001Ð\u0001Ñ\u0001Bu\u0012\b\u0010§\u0001\u001a\u00030¦\u0001\u0012\b\u0010·\u0001\u001a\u00030¶\u0001\u0012\b\u0010³\u0001\u001a\u00030²\u0001\u0012\b\u0010º\u0001\u001a\u00030¹\u0001\u0012\b\u0010À\u0001\u001a\u00030¿\u0001\u0012\b\u0010½\u0001\u001a\u00030¼\u0001\u0012\n\b\u0002\u0010¤\u0001\u001a\u00030£\u0001\u0012\n\b\u0002\u0010\u0095\u0001\u001a\u00030\u0094\u0001\u0012\n\b\u0002\u0010°\u0001\u001a\u00030¯\u0001\u0012\n\b\u0002\u0010Æ\u0001\u001a\u00030Å\u0001¢\u0006\u0006\bÊ\u0001\u0010Ë\u0001J/\u0010\u000b\u001a\u00020\n2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\t\u001a\u00020\bH\u0003¢\u0006\u0004\b\u000b\u0010\fJW\u0010\u0017\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0010\u0018\u00010\u000f2\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00122\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\n\u0018\u00010\u0014H\u0003¢\u0006\u0004\b\u0017\u0010\u0018J3\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u000e\u001a\u00020\r2\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0010\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJI\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u000e\u001a\u00020\r2\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00122\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\n\u0018\u00010\u0014H\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\nH\u0003¢\u0006\u0004\b \u0010!J#\u0010#\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0002H\u0003¢\u0006\u0004\b#\u0010$J#\u0010%\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0002H\u0003¢\u0006\u0004\b%\u0010$J+\u0010*\u001a\u00020)2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010'\u001a\u00020&2\b\b\u0002\u0010(\u001a\u00020&H\u0002¢\u0006\u0004\b*\u0010+J\u0017\u0010.\u001a\u00020\n2\u0006\u0010-\u001a\u00020,H\u0002¢\u0006\u0004\b.\u0010/J\u0017\u00100\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0003¢\u0006\u0004\b0\u00101J\u0017\u00104\u001a\u00020\n2\u0006\u00103\u001a\u000202H\u0003¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\nH\u0003¢\u0006\u0004\b6\u0010!J\u0017\u00107\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u0002H\u0003¢\u0006\u0004\b7\u00108J\u001f\u0010;\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010:\u001a\u000209H\u0003¢\u0006\u0004\b;\u0010<J\u0017\u0010=\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u0002H\u0003¢\u0006\u0004\b=\u00108J\u000f\u0010>\u001a\u00020\nH\u0003¢\u0006\u0004\b>\u0010!J\u000f\u0010?\u001a\u00020\nH\u0002¢\u0006\u0004\b?\u0010!J\u0013\u0010B\u001a\u00020A*\u00020@H\u0002¢\u0006\u0004\bB\u0010CJ\u0017\u0010F\u001a\u00020\n2\u0006\u0010E\u001a\u00020DH\u0017¢\u0006\u0004\bF\u0010GJ\u0017\u0010I\u001a\u00020\n2\u0006\u0010H\u001a\u00020&H\u0007¢\u0006\u0004\bI\u0010JJ\u0017\u0010M\u001a\u00020\n2\u0006\u0010L\u001a\u00020KH\u0007¢\u0006\u0004\bM\u0010NJ\u000f\u0010O\u001a\u00020\nH\u0007¢\u0006\u0004\bO\u0010!Js\u0010W\u001a\u00020\n2\n\u0010Q\u001a\u00060\u0002j\u0002`P2\u000e\u0010S\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`R2\b\u0010T\u001a\u0004\u0018\u0001022\u0006\u0010V\u001a\u00020U2\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0010\u0018\u00010\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u00122\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\n0\u0014¢\u0006\u0004\bW\u0010XJ_\u0010]\u001a\u00020\n2\n\u0010Z\u001a\u00060\u0002j\u0002`Y2\u000e\u0010S\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`R2\n\u0010Q\u001a\u00060\u0002j\u0002`P2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010V\u001a\u00020[2\b\u0010\\\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b]\u0010^JQ\u0010e\u001a\u00020\n2\u0006\u0010`\u001a\u00020_2\u0018\u0010b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u0002020a0\u000f2\u0012\u0010c\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\n0\u00142\f\u0010d\u001a\b\u0012\u0004\u0012\u00020\n0\u0012¢\u0006\u0004\be\u0010fJ\u0017\u0010h\u001a\u00020\n2\u0006\u0010g\u001a\u00020)H\u0007¢\u0006\u0004\bh\u0010iJ\u0015\u0010j\u001a\u00020\n2\u0006\u0010g\u001a\u00020)¢\u0006\u0004\bj\u0010iJ\u0017\u0010m\u001a\u00020\n2\u0006\u0010l\u001a\u00020kH\u0007¢\u0006\u0004\bm\u0010nJ\u0017\u0010o\u001a\u00020\n2\u0006\u0010l\u001a\u00020kH\u0007¢\u0006\u0004\bo\u0010nJ\u0017\u0010#\u001a\u00020\n2\u0006\u0010l\u001a\u00020kH\u0007¢\u0006\u0004\b#\u0010nJ\u0017\u0010q\u001a\u00020\n2\u0006\u0010p\u001a\u00020_H\u0007¢\u0006\u0004\bq\u0010rJ\u0017\u0010t\u001a\u00020\n2\u0006\u0010g\u001a\u00020sH\u0007¢\u0006\u0004\bt\u0010uJ\u001d\u0010w\u001a\u00020\n2\f\u0010v\u001a\b\u0012\u0004\u0012\u00020)0\u000fH\u0007¢\u0006\u0004\bw\u0010xJ\u0017\u0010y\u001a\u00020\n2\u0006\u0010g\u001a\u00020sH\u0007¢\u0006\u0004\by\u0010uJ\u000f\u0010z\u001a\u00020\nH\u0017¢\u0006\u0004\bz\u0010!J\u000f\u0010{\u001a\u00020\nH\u0007¢\u0006\u0004\b{\u0010!J\u0017\u0010}\u001a\u0004\u0018\u00010|2\u0006\u0010\"\u001a\u00020\u0002¢\u0006\u0004\b}\u0010~J\u001e\u0010\u007f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010|0\u00192\u0006\u0010\"\u001a\u00020\u0002¢\u0006\u0005\b\u007f\u0010\u0080\u0001J2\u0010\u0082\u0001\u001a$\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0015\u0012\u0013\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\b0\u0081\u00010\u0081\u0001¢\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001J8\u0010\u0084\u0001\u001a*\u0012&\u0012$\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0015\u0012\u0013\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\b0\u0081\u00010\u0081\u00010\u0019¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\u0016\u0010\u0086\u0001\u001a\b\u0012\u0004\u0012\u00020_0\u0019¢\u0006\u0006\b\u0086\u0001\u0010\u0085\u0001J$\u0010\u0088\u0001\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u000202\u0012\u0005\u0012\u00030\u0087\u00010\u0081\u00010\u0019¢\u0006\u0006\b\u0088\u0001\u0010\u0085\u0001J;\u0010\u008a\u0001\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u00022\n\u0010Q\u001a\u00060\u0002j\u0002`P2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\t\u0010\u0089\u0001\u001a\u0004\u0018\u000102¢\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001R$\u0010\u008e\u0001\u001a\r \u008d\u0001*\u0005\u0018\u00010\u008c\u00010\u008c\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008e\u0001\u0010\u008f\u0001R&\u0010\u0090\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020|0\u0081\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001R@\u0010p\u001a+\u0012\r\u0012\u000b \u008d\u0001*\u0004\u0018\u00010_0_ \u008d\u0001*\u0014\u0012\r\u0012\u000b \u008d\u0001*\u0004\u0018\u00010_0_\u0018\u00010\u0092\u00010\u0092\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bp\u0010\u0093\u0001R\u001a\u0010\u0095\u0001\u001a\u00030\u0094\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001R5\u0010:\u001a \u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020|0\u0097\u0001j\u000f\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020|`\u0098\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b:\u0010\u0099\u0001RK\u0010\u009a\u0001\u001a$\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0015\u0012\u0013\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\b0\u0081\u00010\u0081\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u009a\u0001\u0010\u0091\u0001\u001a\u0006\b\u009b\u0001\u0010\u0083\u0001\"\u0006\b\u009c\u0001\u0010\u009d\u0001R/\u0010\u009f\u0001\u001a\u0010\u0012\u0004\u0012\u000202\u0012\u0005\u0012\u00030\u0087\u00010\u009e\u00018\u0000@\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b\u009f\u0001\u0010 \u0001\u001a\u0006\b¡\u0001\u0010¢\u0001R\u001a\u0010¤\u0001\u001a\u00030£\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¤\u0001\u0010¥\u0001R\u001a\u0010§\u0001\u001a\u00030¦\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b§\u0001\u0010¨\u0001RD\u0010«\u0001\u001a\u000f\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\r0©\u00012\u0014\u0010ª\u0001\u001a\u000f\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\r0©\u00018\u0000@BX\u0080\u000e¢\u0006\u0010\n\u0006\b«\u0001\u0010\u0091\u0001\u001a\u0006\b¬\u0001\u0010\u0083\u0001R+\u0010\u00ad\u0001\u001a\u000f\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020,0©\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\b\u00ad\u0001\u0010\u0091\u0001\u001a\u0006\b®\u0001\u0010\u0083\u0001R\u001a\u0010°\u0001\u001a\u00030¯\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b°\u0001\u0010±\u0001R\u001a\u0010³\u0001\u001a\u00030²\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b³\u0001\u0010´\u0001R&\u0010µ\u0001\u001a\u000f\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\r0©\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bµ\u0001\u0010\u0091\u0001R\u001a\u0010·\u0001\u001a\u00030¶\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b·\u0001\u0010¸\u0001R\u001a\u0010º\u0001\u001a\u00030¹\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bº\u0001\u0010»\u0001R\u001a\u0010½\u0001\u001a\u00030¼\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b½\u0001\u0010¾\u0001R\u001a\u0010À\u0001\u001a\u00030¿\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÀ\u0001\u0010Á\u0001R'\u0010Â\u0001\u001a\u0010\u0012\u0004\u0012\u000202\u0012\u0005\u0012\u00030\u0087\u00010\u0081\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÂ\u0001\u0010\u0091\u0001R\u001b\u0010Ã\u0001\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÃ\u0001\u0010Ä\u0001R\u001a\u0010Æ\u0001\u001a\u00030Å\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÆ\u0001\u0010Ç\u0001R@\u0010È\u0001\u001a$\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0015\u0012\u0013\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\b0\u0081\u00010©\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\bÈ\u0001\u0010\u0091\u0001\u001a\u0006\bÉ\u0001\u0010\u0083\u0001¨\u0006Ò\u0001"}, d2 = {"Lcom/discord/stores/StoreApplicationInteractions;", "Lcom/discord/stores/StoreV2;", "", "Lcom/discord/primitives/MessageId;", "messageId", "", "Lcom/discord/widgets/botuikit/ComponentIndex;", "componentIndex", "Lcom/discord/stores/StoreApplicationInteractions$InteractionSendState;", "sendState", "", "addInteractionStateToComponent", "(JILcom/discord/stores/StoreApplicationInteractions$InteractionSendState;)V", "Lcom/discord/models/commands/ApplicationCommandLocalSendData;", "localSendData", "", "Lcom/lytefast/flexinput/model/Attachment;", "attachments", "Lkotlin/Function0;", "onSuccess", "Lkotlin/Function1;", "Lcom/discord/utilities/error/Error;", "onFail", "handleSendApplicationCommandRequest", "(Lcom/discord/models/commands/ApplicationCommandLocalSendData;Ljava/util/List;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "Lrx/Observable;", "Lcom/discord/utilities/messagesend/MessageResult;", "sendApplicationCommandObservable", "(Lcom/discord/models/commands/ApplicationCommandLocalSendData;Ljava/util/List;)Lrx/Observable;", "result", "handleApplicationCommandResult", "(Lcom/discord/utilities/messagesend/MessageResult;Lcom/discord/models/commands/ApplicationCommandLocalSendData;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "markAllLocalApplicationCommandRequestsAsFailed", "()V", "interactionId", "handleInteractionFailure", "(Lcom/discord/models/commands/ApplicationCommandLocalSendData;Ljava/lang/Long;)V", "handleApplicationCommandRequestStateUpdate", "", "isLoading", "isFailed", "Lcom/discord/models/message/Message;", "buildApplicationCommandLocalMessage", "(Lcom/discord/models/commands/ApplicationCommandLocalSendData;ZZ)Lcom/discord/models/message/Message;", "Lcom/discord/stores/StoreApplicationInteractions$ComponentLocation;", "componentLocation", "handleComponentInteractionMessage", "(Lcom/discord/stores/StoreApplicationInteractions$ComponentLocation;)V", "upsertApplicationCommandSendData", "(Lcom/discord/models/commands/ApplicationCommandLocalSendData;)V", "", "nonce", "removeApplicationCommandSendData", "(Ljava/lang/String;)V", "loadCachedApplicationCommandSendDataSet", "handleInteractionDataFetchStart", "(J)V", "Lcom/discord/api/commands/ApplicationCommandData;", "interactionData", "handleInteractionDataFetchSuccess", "(JLcom/discord/api/commands/ApplicationCommandData;)V", "handleInteractionDataFetchFailure", "clearCache", "clearComponentInteractionSendSuccessAndFailures", "Lcom/discord/models/commands/Application;", "Lcom/discord/api/user/User;", "toUser", "(Lcom/discord/models/commands/Application;)Lcom/discord/api/user/User;", "Landroid/content/Context;", "context", "init", "(Landroid/content/Context;)V", "connectionReady", "handleConnectionReady", "(Z)V", "Lcom/discord/models/domain/ModelPayload;", "payload", "handleConnectionOpen", "(Lcom/discord/models/domain/ModelPayload;)V", "handleChannelSelected", "Lcom/discord/primitives/ChannelId;", "channelId", "Lcom/discord/primitives/GuildId;", "guildId", "version", "Lcom/discord/widgets/chat/input/models/ApplicationCommandData;", "data", "sendApplicationCommand", "(JLjava/lang/Long;Ljava/lang/String;Lcom/discord/widgets/chat/input/models/ApplicationCommandData;Ljava/util/List;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "Lcom/discord/primitives/ApplicationId;", "applicationId", "Lcom/discord/restapi/RestAPIParams$ComponentInteractionData;", "messageFlags", "sendComponentInteraction", "(JLjava/lang/Long;JJILcom/discord/restapi/RestAPIParams$ComponentInteractionData;Ljava/lang/Long;)V", "Lcom/discord/api/interaction/InteractionModalCreate;", "modal", "Lkotlin/Pair;", "components", "onNext", "onError", "sendModalInteraction", "(Lcom/discord/api/interaction/InteractionModalCreate;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "message", "handleLocalMessageDelete", "(Lcom/discord/models/message/Message;)V", "resendApplicationCommand", "Lcom/discord/api/interaction/InteractionStateUpdate;", "interactionStateUpdate", "handleInteractionCreate", "(Lcom/discord/api/interaction/InteractionStateUpdate;)V", "handleInteractionSuccess", "interactionModalCreate", "handleInteractionModalCreate", "(Lcom/discord/api/interaction/InteractionModalCreate;)V", "Lcom/discord/api/message/Message;", "handleMessageCreate", "(Lcom/discord/api/message/Message;)V", "messagesList", "handleMessagesCreateOrLoad", "(Ljava/util/List;)V", "handleMessageUpdate", "snapshotData", "handlePreLogout", "Lcom/discord/stores/StoreApplicationInteractions$State;", "getInteractionData", "(J)Lcom/discord/stores/StoreApplicationInteractions$State;", "observeInteractionData", "(J)Lrx/Observable;", "", "getComponentInteractionData", "()Ljava/util/Map;", "observeComponentInteractionState", "()Lrx/Observable;", "observeModalCreate", "Lcom/discord/stores/StoreApplicationInteractions$SentInteraction;", "observeSentInteractions", "messageNonce", "fetchInteractionDataIfNonExisting", "(JJJLjava/lang/String;)V", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "gson", "Lcom/google/gson/Gson;", "interactionDataSnapshot", "Ljava/util/Map;", "Lrx/subjects/PublishSubject;", "Lrx/subjects/PublishSubject;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "interactionComponentSendStateSnapshot", "getInteractionComponentSendStateSnapshot", "setInteractionComponentSendStateSnapshot", "(Ljava/util/Map;)V", "Landroidx/collection/LruCache;", "sentInteractions", "Landroidx/collection/LruCache;", "getSentInteractions$app_productionGoogleRelease", "()Landroidx/collection/LruCache;", "Landroid/content/SharedPreferences;", "sharedPrefs", "Landroid/content/SharedPreferences;", "Lcom/discord/stores/StoreStream;", "storeStream", "Lcom/discord/stores/StoreStream;", "", "<set-?>", "applicationCommandLocalSendDataSet", "getApplicationCommandLocalSendDataSet$app_productionGoogleRelease", "componentInteractions", "getComponentInteractions", "Lcom/discord/utilities/rest/RestAPI;", "restAPI", "Lcom/discord/utilities/rest/RestAPI;", "Lcom/discord/stores/StoreMessages;", "storeMessages", "Lcom/discord/stores/StoreMessages;", "applicationCommandLocalSendDataSnapshot", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "Lcom/discord/stores/StoreLocalActionComponentState;", "storeLocalActionComponentState", "Lcom/discord/stores/StoreLocalActionComponentState;", "Lcom/discord/utilities/time/Clock;", "clock", "Lcom/discord/utilities/time/Clock;", "Lcom/discord/stores/StoreUser;", "storeUser", "Lcom/discord/stores/StoreUser;", "sentInteractionsSnapshot", "sessionId", "Ljava/lang/String;", "Lcom/discord/models/domain/NonceGenerator;", "nonceGenerator", "Lcom/discord/models/domain/NonceGenerator;", "interactionComponentSendState", "getInteractionComponentSendState", "<init>", "(Lcom/discord/stores/StoreStream;Lcom/discord/stores/Dispatcher;Lcom/discord/stores/StoreMessages;Lcom/discord/stores/StoreLocalActionComponentState;Lcom/discord/stores/StoreUser;Lcom/discord/utilities/time/Clock;Landroid/content/SharedPreferences;Lcom/discord/stores/updates/ObservationDeck;Lcom/discord/utilities/rest/RestAPI;Lcom/discord/models/domain/NonceGenerator;)V", "Companion", "ComponentLocation", "InteractionSendState", "SentInteraction", "SentInteractionState", "State", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreApplicationInteractions extends StoreV2 {
    private static final String CACHE_KEY_APPLICATION_COMMAND_SEND_DATA_SET = "CACHE_KEY_APPLICATION_COMMAND_SEND_DATA_SET";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ObservationDeck.UpdateSource ComponentStateUpdate = new StoreApplicationInteractions3();
    private static final ObservationDeck.UpdateSource SentInteractionsUpdate = new StoreApplicationInteractions4();
    public static final long TYPE_COMPONENT_INTERACTION = 3;
    public static final long TYPE_MODAL_INTERACTION = 5;
    private Map<String, ApplicationCommandLocalSendData> applicationCommandLocalSendDataSet;
    private Map<String, ApplicationCommandLocalSendData> applicationCommandLocalSendDataSnapshot;
    private final Clock clock;
    private final Map<String, ComponentLocation> componentInteractions;
    private final Dispatcher dispatcher;
    private final Gson gson;
    private final Map<Long, Map<Integer, InteractionSendState>> interactionComponentSendState;
    private Map<Long, ? extends Map<Integer, ? extends InteractionSendState>> interactionComponentSendStateSnapshot;
    private final HashMap<Long, State> interactionData;
    private Map<Long, ? extends State> interactionDataSnapshot;
    private final PublishSubject<InteractionModalCreate> interactionModalCreate;
    private final NonceGenerator nonceGenerator;
    private final ObservationDeck observationDeck;
    private final RestAPI restAPI;
    private final LruCache<String, SentInteraction> sentInteractions;
    private Map<String, SentInteraction> sentInteractionsSnapshot;
    private String sessionId;
    private final SharedPreferences sharedPrefs;
    private final StoreLocalActionComponentState storeLocalActionComponentState;
    private final StoreMessages storeMessages;
    private final StoreStream storeStream;
    private final StoreUser storeUser;

    /* compiled from: StoreApplicationInteractions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\f8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/discord/stores/StoreApplicationInteractions$Companion;", "", "Lcom/discord/stores/updates/ObservationDeck$UpdateSource;", "ComponentStateUpdate", "Lcom/discord/stores/updates/ObservationDeck$UpdateSource;", "getComponentStateUpdate", "()Lcom/discord/stores/updates/ObservationDeck$UpdateSource;", "SentInteractionsUpdate", "getSentInteractionsUpdate", "", StoreApplicationInteractions.CACHE_KEY_APPLICATION_COMMAND_SEND_DATA_SET, "Ljava/lang/String;", "", "TYPE_COMPONENT_INTERACTION", "J", "TYPE_MODAL_INTERACTION", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final ObservationDeck.UpdateSource getComponentStateUpdate() {
            return StoreApplicationInteractions.access$getComponentStateUpdate$cp();
        }

        public final ObservationDeck.UpdateSource getSentInteractionsUpdate() {
            return StoreApplicationInteractions.access$getSentInteractionsUpdate$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreApplicationInteractions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\u0010\n\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\u000b\u001a\u00060\u0006j\u0002`\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\b\u001a\u00060\u0006j\u0002`\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ,\u0010\f\u001a\u00020\u00002\f\b\u0002\u0010\n\u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u0010\u000b\u001a\u00060\u0006j\u0002`\u0007HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0011\u0010\tJ\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001d\u0010\u000b\u001a\u00060\u0006j\u0002`\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0017\u0010\tR\u001d\u0010\n\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u0005¨\u0006\u001c"}, d2 = {"Lcom/discord/stores/StoreApplicationInteractions$ComponentLocation;", "", "", "Lcom/discord/primitives/MessageId;", "component1", "()J", "", "Lcom/discord/widgets/botuikit/ComponentIndex;", "component2", "()I", "messageId", "componentIndex", "copy", "(JI)Lcom/discord/stores/StoreApplicationInteractions$ComponentLocation;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getComponentIndex", "J", "getMessageId", "<init>", "(JI)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ComponentLocation {
        private final int componentIndex;
        private final long messageId;

        public ComponentLocation(long j, int i) {
            this.messageId = j;
            this.componentIndex = i;
        }

        public static /* synthetic */ ComponentLocation copy$default(ComponentLocation componentLocation, long j, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                j = componentLocation.messageId;
            }
            if ((i2 & 2) != 0) {
                i = componentLocation.componentIndex;
            }
            return componentLocation.copy(j, i);
        }

        /* renamed from: component1, reason: from getter */
        public final long getMessageId() {
            return this.messageId;
        }

        /* renamed from: component2, reason: from getter */
        public final int getComponentIndex() {
            return this.componentIndex;
        }

        public final ComponentLocation copy(long messageId, int componentIndex) {
            return new ComponentLocation(messageId, componentIndex);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ComponentLocation)) {
                return false;
            }
            ComponentLocation componentLocation = (ComponentLocation) other;
            return this.messageId == componentLocation.messageId && this.componentIndex == componentLocation.componentIndex;
        }

        public final int getComponentIndex() {
            return this.componentIndex;
        }

        public final long getMessageId() {
            return this.messageId;
        }

        public int hashCode() {
            return (b.a(this.messageId) * 31) + this.componentIndex;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ComponentLocation(messageId=");
            sbU.append(this.messageId);
            sbU.append(", componentIndex=");
            return outline.B(sbU, this.componentIndex, ")");
        }
    }

    /* compiled from: StoreApplicationInteractions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/discord/stores/StoreApplicationInteractions$InteractionSendState;", "", "<init>", "()V", "Failed", "Loading", "Success", "Lcom/discord/stores/StoreApplicationInteractions$InteractionSendState$Loading;", "Lcom/discord/stores/StoreApplicationInteractions$InteractionSendState$Failed;", "Lcom/discord/stores/StoreApplicationInteractions$InteractionSendState$Success;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class InteractionSendState {

        /* compiled from: StoreApplicationInteractions.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/stores/StoreApplicationInteractions$InteractionSendState$Failed;", "Lcom/discord/stores/StoreApplicationInteractions$InteractionSendState;", "", "errorMessage", "Ljava/lang/String;", "getErrorMessage", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Failed extends InteractionSendState {
            private final String errorMessage;

            public Failed() {
                this(null, 1, null);
            }

            public Failed(String str) {
                super(null);
                this.errorMessage = str;
            }

            public final String getErrorMessage() {
                return this.errorMessage;
            }

            public /* synthetic */ Failed(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str);
            }
        }

        /* compiled from: StoreApplicationInteractions.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/StoreApplicationInteractions$InteractionSendState$Loading;", "Lcom/discord/stores/StoreApplicationInteractions$InteractionSendState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Loading extends InteractionSendState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        /* compiled from: StoreApplicationInteractions.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/StoreApplicationInteractions$InteractionSendState$Success;", "Lcom/discord/stores/StoreApplicationInteractions$InteractionSendState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Success extends InteractionSendState {
            public static final Success INSTANCE = new Success();

            private Success() {
                super(null);
            }
        }

        private InteractionSendState() {
        }

        public /* synthetic */ InteractionSendState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreApplicationInteractions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\n\u0010\u000e\u001a\u00060\u0002j\u0002`\u0003\u0012\u000e\u0010\u000f\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0006\u0012\u000e\u0010\u0010\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\t\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000b¢\u0006\u0004\b'\u0010(J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0007\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\n\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\tHÆ\u0003¢\u0006\u0004\b\n\u0010\bJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJL\u0010\u0012\u001a\u00020\u00002\f\b\u0002\u0010\u000e\u001a\u00060\u0002j\u0002`\u00032\u0010\b\u0002\u0010\u000f\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00062\u0010\b\u0002\u0010\u0010\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\t2\b\b\u0002\u0010\u0011\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR!\u0010\u000f\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b\u001f\u0010\bR!\u0010\u0010\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b \u0010\bR\u001d\u0010\u000e\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010!\u001a\u0004\b\"\u0010\u0005R\"\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010#\u001a\u0004\b$\u0010\r\"\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lcom/discord/stores/StoreApplicationInteractions$SentInteraction;", "", "", "Lcom/discord/primitives/ChannelId;", "component1", "()J", "Lcom/discord/primitives/MessageId;", "component2", "()Ljava/lang/Long;", "Lcom/discord/primitives/GuildId;", "component3", "Lcom/discord/stores/StoreApplicationInteractions$SentInteractionState;", "component4", "()Lcom/discord/stores/StoreApplicationInteractions$SentInteractionState;", "channelId", "messageId", "guildId", "state", "copy", "(JLjava/lang/Long;Ljava/lang/Long;Lcom/discord/stores/StoreApplicationInteractions$SentInteractionState;)Lcom/discord/stores/StoreApplicationInteractions$SentInteraction;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Long;", "getMessageId", "getGuildId", "J", "getChannelId", "Lcom/discord/stores/StoreApplicationInteractions$SentInteractionState;", "getState", "setState", "(Lcom/discord/stores/StoreApplicationInteractions$SentInteractionState;)V", "<init>", "(JLjava/lang/Long;Ljava/lang/Long;Lcom/discord/stores/StoreApplicationInteractions$SentInteractionState;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class SentInteraction {
        private final long channelId;
        private final Long guildId;
        private final Long messageId;
        private SentInteractionState state;

        public SentInteraction(long j, Long l, Long l2, SentInteractionState sentInteractionState) {
            Intrinsics3.checkNotNullParameter(sentInteractionState, "state");
            this.channelId = j;
            this.messageId = l;
            this.guildId = l2;
            this.state = sentInteractionState;
        }

        public static /* synthetic */ SentInteraction copy$default(SentInteraction sentInteraction, long j, Long l, Long l2, SentInteractionState sentInteractionState, int i, Object obj) {
            if ((i & 1) != 0) {
                j = sentInteraction.channelId;
            }
            long j2 = j;
            if ((i & 2) != 0) {
                l = sentInteraction.messageId;
            }
            Long l3 = l;
            if ((i & 4) != 0) {
                l2 = sentInteraction.guildId;
            }
            Long l4 = l2;
            if ((i & 8) != 0) {
                sentInteractionState = sentInteraction.state;
            }
            return sentInteraction.copy(j2, l3, l4, sentInteractionState);
        }

        /* renamed from: component1, reason: from getter */
        public final long getChannelId() {
            return this.channelId;
        }

        /* renamed from: component2, reason: from getter */
        public final Long getMessageId() {
            return this.messageId;
        }

        /* renamed from: component3, reason: from getter */
        public final Long getGuildId() {
            return this.guildId;
        }

        /* renamed from: component4, reason: from getter */
        public final SentInteractionState getState() {
            return this.state;
        }

        public final SentInteraction copy(long channelId, Long messageId, Long guildId, SentInteractionState state) {
            Intrinsics3.checkNotNullParameter(state, "state");
            return new SentInteraction(channelId, messageId, guildId, state);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SentInteraction)) {
                return false;
            }
            SentInteraction sentInteraction = (SentInteraction) other;
            return this.channelId == sentInteraction.channelId && Intrinsics3.areEqual(this.messageId, sentInteraction.messageId) && Intrinsics3.areEqual(this.guildId, sentInteraction.guildId) && Intrinsics3.areEqual(this.state, sentInteraction.state);
        }

        public final long getChannelId() {
            return this.channelId;
        }

        public final Long getGuildId() {
            return this.guildId;
        }

        public final Long getMessageId() {
            return this.messageId;
        }

        public final SentInteractionState getState() {
            return this.state;
        }

        public int hashCode() {
            int iA = b.a(this.channelId) * 31;
            Long l = this.messageId;
            int iHashCode = (iA + (l != null ? l.hashCode() : 0)) * 31;
            Long l2 = this.guildId;
            int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
            SentInteractionState sentInteractionState = this.state;
            return iHashCode2 + (sentInteractionState != null ? sentInteractionState.hashCode() : 0);
        }

        public final void setState(SentInteractionState sentInteractionState) {
            Intrinsics3.checkNotNullParameter(sentInteractionState, "<set-?>");
            this.state = sentInteractionState;
        }

        public String toString() {
            StringBuilder sbU = outline.U("SentInteraction(channelId=");
            sbU.append(this.channelId);
            sbU.append(", messageId=");
            sbU.append(this.messageId);
            sbU.append(", guildId=");
            sbU.append(this.guildId);
            sbU.append(", state=");
            sbU.append(this.state);
            sbU.append(")");
            return sbU.toString();
        }

        public /* synthetic */ SentInteraction(long j, Long l, Long l2, SentInteractionState sentInteractionState, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, l, l2, (i & 8) != 0 ? SentInteractionState.SENDING : sentInteractionState);
        }
    }

    /* compiled from: StoreApplicationInteractions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/discord/stores/StoreApplicationInteractions$SentInteractionState;", "", "<init>", "(Ljava/lang/String;I)V", "SENDING", "FAILURE", "SUCCESS", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public enum SentInteractionState {
        SENDING,
        FAILURE,
        SUCCESS
    }

    /* compiled from: StoreApplicationInteractions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/discord/stores/StoreApplicationInteractions$State;", "", "<init>", "()V", "Failure", "Fetching", "Loaded", "Lcom/discord/stores/StoreApplicationInteractions$State$Fetching;", "Lcom/discord/stores/StoreApplicationInteractions$State$Loaded;", "Lcom/discord/stores/StoreApplicationInteractions$State$Failure;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class State {

        /* compiled from: StoreApplicationInteractions.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/StoreApplicationInteractions$State$Failure;", "Lcom/discord/stores/StoreApplicationInteractions$State;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Failure extends State {
            public static final Failure INSTANCE = new Failure();

            private Failure() {
                super(null);
            }
        }

        /* compiled from: StoreApplicationInteractions.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/StoreApplicationInteractions$State$Fetching;", "Lcom/discord/stores/StoreApplicationInteractions$State;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Fetching extends State {
            public static final Fetching INSTANCE = new Fetching();

            private Fetching() {
                super(null);
            }
        }

        /* compiled from: StoreApplicationInteractions.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/stores/StoreApplicationInteractions$State$Loaded;", "Lcom/discord/stores/StoreApplicationInteractions$State;", "Lcom/discord/api/commands/ApplicationCommandData;", "component1", "()Lcom/discord/api/commands/ApplicationCommandData;", "commandOptions", "copy", "(Lcom/discord/api/commands/ApplicationCommandData;)Lcom/discord/stores/StoreApplicationInteractions$State$Loaded;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/commands/ApplicationCommandData;", "getCommandOptions", "<init>", "(Lcom/discord/api/commands/ApplicationCommandData;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends State {
            private final ApplicationCommandData commandOptions;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(ApplicationCommandData applicationCommandData) {
                super(null);
                Intrinsics3.checkNotNullParameter(applicationCommandData, "commandOptions");
                this.commandOptions = applicationCommandData;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, ApplicationCommandData applicationCommandData, int i, Object obj) {
                if ((i & 1) != 0) {
                    applicationCommandData = loaded.commandOptions;
                }
                return loaded.copy(applicationCommandData);
            }

            /* renamed from: component1, reason: from getter */
            public final ApplicationCommandData getCommandOptions() {
                return this.commandOptions;
            }

            public final Loaded copy(ApplicationCommandData commandOptions) {
                Intrinsics3.checkNotNullParameter(commandOptions, "commandOptions");
                return new Loaded(commandOptions);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.commandOptions, ((Loaded) other).commandOptions);
                }
                return true;
            }

            public final ApplicationCommandData getCommandOptions() {
                return this.commandOptions;
            }

            public int hashCode() {
                ApplicationCommandData applicationCommandData = this.commandOptions;
                if (applicationCommandData != null) {
                    return applicationCommandData.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(commandOptions=");
                sbU.append(this.commandOptions);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private State() {
        }

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreApplicationInteractions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreApplicationInteractions$clearComponentInteractionSendSuccessAndFailures$1, reason: invalid class name */
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
            LinkedHashMap linkedHashMap;
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            Iterator<T> it = StoreApplicationInteractions.this.getInteractionComponentSendState().keySet().iterator();
            while (it.hasNext()) {
                long jLongValue = ((Number) it.next()).longValue();
                Map<Integer, InteractionSendState> map = StoreApplicationInteractions.this.getInteractionComponentSendState().get(Long.valueOf(jLongValue));
                if (map != null) {
                    linkedHashMap = new LinkedHashMap();
                    for (Map.Entry<Integer, InteractionSendState> entry : map.entrySet()) {
                        if (entry.getValue() instanceof InteractionSendState.Loading) {
                            linkedHashMap.put(entry.getKey(), entry.getValue());
                        }
                    }
                } else {
                    linkedHashMap = null;
                }
                if (linkedHashMap != null) {
                    linkedHashMap2.put(Long.valueOf(jLongValue), linkedHashMap);
                }
            }
            StoreApplicationInteractions.this.getInteractionComponentSendState().clear();
            StoreApplicationInteractions.this.getInteractionComponentSendState().putAll(linkedHashMap2);
            StoreApplicationInteractions.this.markChanged(StoreApplicationInteractions.INSTANCE.getComponentStateUpdate());
        }
    }

    /* compiled from: StoreApplicationInteractions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreApplicationInteractions$fetchInteractionDataIfNonExisting$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $interactionId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(long j) {
            super(0);
            this.$interactionId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreApplicationInteractions.access$handleInteractionDataFetchStart(StoreApplicationInteractions.this, this.$interactionId);
        }
    }

    /* compiled from: StoreApplicationInteractions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/commands/ApplicationCommandData;", "interactionDetail", "", "invoke", "(Lcom/discord/api/commands/ApplicationCommandData;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreApplicationInteractions$fetchInteractionDataIfNonExisting$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<ApplicationCommandData, Unit> {
        public final /* synthetic */ long $interactionId;

        /* compiled from: StoreApplicationInteractions.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreApplicationInteractions$fetchInteractionDataIfNonExisting$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ ApplicationCommandData $interactionDetail;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(ApplicationCommandData applicationCommandData) {
                super(0);
                this.$interactionDetail = applicationCommandData;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                StoreApplicationInteractions.access$handleInteractionDataFetchSuccess(StoreApplicationInteractions.this, anonymousClass3.$interactionId, this.$interactionDetail);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(long j) {
            super(1);
            this.$interactionId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ApplicationCommandData applicationCommandData) {
            invoke2(applicationCommandData);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ApplicationCommandData applicationCommandData) {
            Intrinsics3.checkNotNullParameter(applicationCommandData, "interactionDetail");
            StoreApplicationInteractions.access$getDispatcher$p(StoreApplicationInteractions.this).schedule(new AnonymousClass1(applicationCommandData));
        }
    }

    /* compiled from: StoreApplicationInteractions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreApplicationInteractions$fetchInteractionDataIfNonExisting$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ long $interactionId;

        /* compiled from: StoreApplicationInteractions.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreApplicationInteractions$fetchInteractionDataIfNonExisting$4$1, reason: invalid class name */
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
                AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                StoreApplicationInteractions.access$handleInteractionDataFetchFailure(StoreApplicationInteractions.this, anonymousClass4.$interactionId);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(long j) {
            super(1);
            this.$interactionId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            StoreApplicationInteractions.access$getDispatcher$p(StoreApplicationInteractions.this).schedule(new AnonymousClass1());
        }
    }

    /* compiled from: StoreApplicationInteractions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/messagesend/MessageResult;", "result", "", "invoke", "(Lcom/discord/utilities/messagesend/MessageResult;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreApplicationInteractions$handleSendApplicationCommandRequest$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<MessageQueue4, Unit> {
        public final /* synthetic */ ApplicationCommandLocalSendData $localSendData;
        public final /* synthetic */ Function1 $onFail;
        public final /* synthetic */ Function0 $onSuccess;

        /* compiled from: StoreApplicationInteractions.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreApplicationInteractions$handleSendApplicationCommandRequest$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00851 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ MessageQueue4 $result;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00851(MessageQueue4 messageQueue4) {
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
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                StoreApplicationInteractions.access$handleApplicationCommandResult(StoreApplicationInteractions.this, this.$result, anonymousClass1.$localSendData, anonymousClass1.$onSuccess, anonymousClass1.$onFail);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ApplicationCommandLocalSendData applicationCommandLocalSendData, Function0 function0, Function1 function1) {
            super(1);
            this.$localSendData = applicationCommandLocalSendData;
            this.$onSuccess = function0;
            this.$onFail = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MessageQueue4 messageQueue4) {
            invoke2(messageQueue4);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MessageQueue4 messageQueue4) {
            Intrinsics3.checkNotNullParameter(messageQueue4, "result");
            StoreApplicationInteractions.access$getDispatcher$p(StoreApplicationInteractions.this).schedule(new C00851(messageQueue4));
        }
    }

    /* compiled from: StoreApplicationInteractions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\"\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u00000\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "", "Lcom/discord/primitives/MessageId;", "", "Lcom/discord/widgets/botuikit/ComponentIndex;", "Lcom/discord/stores/StoreApplicationInteractions$InteractionSendState;", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreApplicationInteractions$observeComponentInteractionState$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends Map<Integer, ? extends InteractionSendState>>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends Map<Integer, ? extends InteractionSendState>> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends Map<Integer, ? extends InteractionSendState>> invoke2() {
            return StoreApplicationInteractions.this.getComponentInteractionData();
        }
    }

    /* compiled from: StoreApplicationInteractions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/stores/StoreApplicationInteractions$State;", "invoke", "()Lcom/discord/stores/StoreApplicationInteractions$State;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreApplicationInteractions$observeInteractionData$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<State> {
        public final /* synthetic */ long $interactionId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$interactionId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ State invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final State invoke() {
            return StoreApplicationInteractions.this.getInteractionData(this.$interactionId);
        }
    }

    /* compiled from: StoreApplicationInteractions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "", "Lcom/discord/stores/StoreApplicationInteractions$SentInteraction;", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreApplicationInteractions$observeSentInteractions$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<String, ? extends SentInteraction>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<String, ? extends SentInteraction> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<String, ? extends SentInteraction> invoke2() {
            return StoreApplicationInteractions.access$getSentInteractionsSnapshot$p(StoreApplicationInteractions.this);
        }
    }

    /* compiled from: StoreApplicationInteractions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreApplicationInteractions$resendApplicationCommand$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Message $message;
        public final /* synthetic */ String $nonce;
        public final /* synthetic */ ApplicationCommandLocalSendData $updatedSendData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Message message, String str, ApplicationCommandLocalSendData applicationCommandLocalSendData) {
            super(0);
            this.$message = message;
            this.$nonce = str;
            this.$updatedSendData = applicationCommandLocalSendData;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreApplicationInteractions.access$getStoreMessages$p(StoreApplicationInteractions.this).deleteLocalMessage(this.$message.getChannelId(), this.$nonce);
            StoreApplicationInteractions.handleSendApplicationCommandRequest$default(StoreApplicationInteractions.this, this.$updatedSendData, null, null, null, 14, null);
            StoreApplicationInteractions.access$removeApplicationCommandSendData(StoreApplicationInteractions.this, this.$nonce);
        }
    }

    /* compiled from: StoreApplicationInteractions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreApplicationInteractions$sendApplicationCommand$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ List $attachments;
        public final /* synthetic */ ApplicationCommandLocalSendData $localSendData;
        public final /* synthetic */ Function1 $onFail;
        public final /* synthetic */ Function0 $onSuccess;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ApplicationCommandLocalSendData applicationCommandLocalSendData, List list, Function0 function0, Function1 function1) {
            super(0);
            this.$localSendData = applicationCommandLocalSendData;
            this.$attachments = list;
            this.$onSuccess = function0;
            this.$onFail = function1;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreApplicationInteractions.access$handleSendApplicationCommandRequest(StoreApplicationInteractions.this, this.$localSendData, this.$attachments, this.$onSuccess, this.$onFail);
        }
    }

    /* compiled from: StoreApplicationInteractions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreApplicationInteractions$sendComponentInteraction$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $applicationId;
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ int $componentIndex;
        public final /* synthetic */ RestAPIParams.ComponentInteractionData $data;
        public final /* synthetic */ Long $guildId;
        public final /* synthetic */ Long $messageFlags;
        public final /* synthetic */ long $messageId;
        public final /* synthetic */ String $nonce;

        /* compiled from: StoreApplicationInteractions.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreApplicationInteractions$sendComponentInteraction$1$3, reason: invalid class name */
        public static final class AnonymousClass3 extends Lambda implements Function1<Void, Unit> {
            public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

            public AnonymousClass3() {
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

        /* compiled from: StoreApplicationInteractions.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreApplicationInteractions$sendComponentInteraction$1$4, reason: invalid class name */
        public static final class AnonymousClass4 extends Lambda implements Function1<Error, Unit> {

            /* compiled from: StoreApplicationInteractions.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.stores.StoreApplicationInteractions$sendComponentInteraction$1$4$1, reason: invalid class name and collision with other inner class name */
            public static final class C00861 extends Lambda implements Function0<Unit> {
                public final /* synthetic */ Error $it;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C00861(Error error) {
                    super(0);
                    this.$it = error;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    StoreLocalActionComponentState storeLocalActionComponentStateAccess$getStoreLocalActionComponentState$p = StoreApplicationInteractions.access$getStoreLocalActionComponentState$p(StoreApplicationInteractions.this);
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    storeLocalActionComponentStateAccess$getStoreLocalActionComponentState$p.clearState(anonymousClass1.$messageId, Integer.valueOf(anonymousClass1.$componentIndex));
                    StoreApplicationInteractions.this.getComponentInteractions().remove(AnonymousClass1.this.$nonce);
                    AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                    StoreApplicationInteractions storeApplicationInteractions = StoreApplicationInteractions.this;
                    long j = anonymousClass12.$messageId;
                    int i = anonymousClass12.$componentIndex;
                    Error.Response response = this.$it.getResponse();
                    Intrinsics3.checkNotNullExpressionValue(response, "it.response");
                    StoreApplicationInteractions.access$addInteractionStateToComponent(storeApplicationInteractions, j, i, new InteractionSendState.Failed(response.getMessage()));
                }
            }

            public AnonymousClass4() {
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
                StoreApplicationInteractions.access$getDispatcher$p(StoreApplicationInteractions.this).schedule(new C00861(error));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, int i, String str, long j2, Long l, long j3, Long l2, RestAPIParams.ComponentInteractionData componentInteractionData) {
            super(0);
            this.$messageId = j;
            this.$componentIndex = i;
            this.$nonce = str;
            this.$channelId = j2;
            this.$guildId = l;
            this.$applicationId = j3;
            this.$messageFlags = l2;
            this.$data = componentInteractionData;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            boolean z2;
            boolean z3;
            Collection<ComponentLocation> collectionValues = StoreApplicationInteractions.this.getComponentInteractions().values();
            if ((collectionValues instanceof Collection) && collectionValues.isEmpty()) {
                z2 = false;
            } else {
                Iterator<T> it = collectionValues.iterator();
                while (it.hasNext()) {
                    if (((ComponentLocation) it.next()).getMessageId() == this.$messageId) {
                        z2 = true;
                        break;
                    }
                }
                z2 = false;
            }
            if (!z2) {
                StoreApplicationInteractions.this.getComponentInteractions().put(this.$nonce, new ComponentLocation(this.$messageId, this.$componentIndex));
                StoreApplicationInteractions.access$addInteractionStateToComponent(StoreApplicationInteractions.this, this.$messageId, this.$componentIndex, InteractionSendState.Loading.INSTANCE);
                StoreApplicationInteractions.this.getSentInteractions$app_productionGoogleRelease().put(this.$nonce, new SentInteraction(this.$channelId, Long.valueOf(this.$messageId), this.$guildId, null, 8, null));
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(StoreApplicationInteractions.access$getRestAPI$p(StoreApplicationInteractions.this).sendComponentInteraction(new RestAPIParams.ComponentInteraction(3L, this.$channelId, this.$applicationId, this.$guildId, this.$messageId, this.$messageFlags, this.$data, StoreApplicationInteractions.access$getSessionId$p(StoreApplicationInteractions.this), this.$nonce)), false, 1, null), StoreApplicationInteractions.this.getClass(), (Context) null, (Function1) null, new AnonymousClass4(), (Function0) null, (Function0) null, AnonymousClass3.INSTANCE, 54, (Object) null);
                return;
            }
            Collection<ComponentLocation> collectionValues2 = StoreApplicationInteractions.this.getComponentInteractions().values();
            if ((collectionValues2 instanceof Collection) && collectionValues2.isEmpty()) {
                z3 = true;
            } else {
                for (ComponentLocation componentLocation : collectionValues2) {
                    if (!(componentLocation.getMessageId() == this.$messageId && componentLocation.getComponentIndex() != this.$componentIndex)) {
                        z3 = false;
                        break;
                    }
                }
                z3 = true;
            }
            if (z3) {
                StoreApplicationInteractions.access$getStoreLocalActionComponentState$p(StoreApplicationInteractions.this).clearState(this.$messageId, Integer.valueOf(this.$componentIndex));
            }
        }
    }

    /* compiled from: StoreApplicationInteractions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreApplicationInteractions$sendModalInteraction$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ List $components;
        public final /* synthetic */ SentInteraction $localSendData;
        public final /* synthetic */ InteractionModalCreate $modal;
        public final /* synthetic */ long $nonce;
        public final /* synthetic */ Function0 $onError;
        public final /* synthetic */ Function1 $onNext;

        /* compiled from: StoreApplicationInteractions.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreApplicationInteractions$sendModalInteraction$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends Lambda implements Function1<Void, Unit> {
            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                invoke2(r1);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Void r4) {
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                anonymousClass1.$onNext.invoke(String.valueOf(anonymousClass1.$nonce));
            }
        }

        /* compiled from: StoreApplicationInteractions.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreApplicationInteractions$sendModalInteraction$1$3, reason: invalid class name */
        public static final class AnonymousClass3 extends Lambda implements Function1<Error, Unit> {
            public AnonymousClass3() {
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
                AnonymousClass1.this.$onError.invoke();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(InteractionModalCreate interactionModalCreate, SentInteraction sentInteraction, long j, List list, Function1 function1, Function0 function0) {
            super(0);
            this.$modal = interactionModalCreate;
            this.$localSendData = sentInteraction;
            this.$nonce = j;
            this.$components = list;
            this.$onNext = function1;
            this.$onError = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            RestAPI restAPIAccess$getRestAPI$p = StoreApplicationInteractions.access$getRestAPI$p(StoreApplicationInteractions.this);
            long id2 = this.$modal.getApplication().getId();
            long channelId = this.$localSendData.getChannelId();
            Long guildId = this.$localSendData.getGuildId();
            long j = this.$nonce;
            String strAccess$getSessionId$p = StoreApplicationInteractions.access$getSessionId$p(StoreApplicationInteractions.this);
            long id3 = this.$modal.getId();
            String customId = this.$modal.getCustomId();
            List list = this.$components;
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Tuples2 tuples2 = (Tuples2) it.next();
                arrayList.add(new RestAPIParams.ModalInteractionDataComponent(Component6.ACTION_ROW, CollectionsJVM.listOf(new RestAPIParams.ModalInteractionDataComponent(Component6.TEXT, null, (String) tuples2.getFirst(), (String) tuples2.getSecond())), null, null));
                it = it;
                restAPIAccess$getRestAPI$p = restAPIAccess$getRestAPI$p;
                j = j;
                strAccess$getSessionId$p = strAccess$getSessionId$p;
            }
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(restAPIAccess$getRestAPI$p.sendModalInteraction(new RestAPIParams.ModalInteraction(5L, id2, null, channelId, guildId, strAccess$getSessionId$p, j, new RestAPIParams.ModalInteractionData(id3, customId, arrayList))), false, 1, null), StoreApplicationInteractions.this.getClass(), (Context) null, (Function1) null, new AnonymousClass3(), (Function0) null, (Function0) null, new AnonymousClass2(), 54, (Object) null);
        }
    }

    public /* synthetic */ StoreApplicationInteractions(StoreStream storeStream, Dispatcher dispatcher, StoreMessages storeMessages, StoreLocalActionComponentState storeLocalActionComponentState, StoreUser storeUser, Clock clock, SharedPreferences sharedPreferences, ObservationDeck observationDeck, RestAPI restAPI, NonceGenerator nonceGenerator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeStream, dispatcher, storeMessages, storeLocalActionComponentState, storeUser, clock, (i & 64) != 0 ? SharedPreferencesProvider.INSTANCE.get() : sharedPreferences, (i & 128) != 0 ? ObservationDeck4.get() : observationDeck, (i & 256) != 0 ? RestAPI.INSTANCE.getApi() : restAPI, (i & 512) != 0 ? new NonceGenerator() : nonceGenerator);
    }

    public static final /* synthetic */ void access$addInteractionStateToComponent(StoreApplicationInteractions storeApplicationInteractions, long j, int i, InteractionSendState interactionSendState) {
        storeApplicationInteractions.addInteractionStateToComponent(j, i, interactionSendState);
    }

    public static final /* synthetic */ ObservationDeck.UpdateSource access$getComponentStateUpdate$cp() {
        return ComponentStateUpdate;
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreApplicationInteractions storeApplicationInteractions) {
        return storeApplicationInteractions.dispatcher;
    }

    public static final /* synthetic */ RestAPI access$getRestAPI$p(StoreApplicationInteractions storeApplicationInteractions) {
        return storeApplicationInteractions.restAPI;
    }

    public static final /* synthetic */ Map access$getSentInteractionsSnapshot$p(StoreApplicationInteractions storeApplicationInteractions) {
        return storeApplicationInteractions.sentInteractionsSnapshot;
    }

    public static final /* synthetic */ ObservationDeck.UpdateSource access$getSentInteractionsUpdate$cp() {
        return SentInteractionsUpdate;
    }

    public static final /* synthetic */ String access$getSessionId$p(StoreApplicationInteractions storeApplicationInteractions) {
        return storeApplicationInteractions.sessionId;
    }

    public static final /* synthetic */ StoreLocalActionComponentState access$getStoreLocalActionComponentState$p(StoreApplicationInteractions storeApplicationInteractions) {
        return storeApplicationInteractions.storeLocalActionComponentState;
    }

    public static final /* synthetic */ StoreMessages access$getStoreMessages$p(StoreApplicationInteractions storeApplicationInteractions) {
        return storeApplicationInteractions.storeMessages;
    }

    public static final /* synthetic */ void access$handleApplicationCommandResult(StoreApplicationInteractions storeApplicationInteractions, MessageQueue4 messageQueue4, ApplicationCommandLocalSendData applicationCommandLocalSendData, Function0 function0, Function1 function1) {
        storeApplicationInteractions.handleApplicationCommandResult(messageQueue4, applicationCommandLocalSendData, function0, function1);
    }

    public static final /* synthetic */ void access$handleInteractionDataFetchFailure(StoreApplicationInteractions storeApplicationInteractions, long j) {
        storeApplicationInteractions.handleInteractionDataFetchFailure(j);
    }

    public static final /* synthetic */ void access$handleInteractionDataFetchStart(StoreApplicationInteractions storeApplicationInteractions, long j) {
        storeApplicationInteractions.handleInteractionDataFetchStart(j);
    }

    public static final /* synthetic */ void access$handleInteractionDataFetchSuccess(StoreApplicationInteractions storeApplicationInteractions, long j, ApplicationCommandData applicationCommandData) {
        storeApplicationInteractions.handleInteractionDataFetchSuccess(j, applicationCommandData);
    }

    public static final /* synthetic */ void access$handleSendApplicationCommandRequest(StoreApplicationInteractions storeApplicationInteractions, ApplicationCommandLocalSendData applicationCommandLocalSendData, List list, Function0 function0, Function1 function1) {
        storeApplicationInteractions.handleSendApplicationCommandRequest(applicationCommandLocalSendData, list, function0, function1);
    }

    public static final /* synthetic */ void access$removeApplicationCommandSendData(StoreApplicationInteractions storeApplicationInteractions, String str) {
        storeApplicationInteractions.removeApplicationCommandSendData(str);
    }

    public static final /* synthetic */ void access$setSentInteractionsSnapshot$p(StoreApplicationInteractions storeApplicationInteractions, Map map) {
        storeApplicationInteractions.sentInteractionsSnapshot = map;
    }

    public static final /* synthetic */ void access$setSessionId$p(StoreApplicationInteractions storeApplicationInteractions, String str) {
        storeApplicationInteractions.sessionId = str;
    }

    @Store3
    private final void addInteractionStateToComponent(long messageId, int componentIndex, InteractionSendState sendState) {
        this.interactionComponentSendState.put(Long.valueOf(messageId), MapsJVM.mapOf(Tuples.to(Integer.valueOf(componentIndex), sendState)));
        markChanged(ComponentStateUpdate);
    }

    private final Message buildApplicationCommandLocalMessage(ApplicationCommandLocalSendData localSendData, boolean isLoading, boolean isFailed) {
        return LocalMessageCreators.createLocalApplicationCommandMessage(localSendData.getNonce(), localSendData.getApplicationCommandName(), localSendData.getChannelId(), UserUtils.INSTANCE.synthesizeApiUser(this.storeUser.getMeSnapshot()), toUser(localSendData.getApplication()), isFailed, isLoading, localSendData.getInteractionId(), this.clock);
    }

    public static /* synthetic */ Message buildApplicationCommandLocalMessage$default(StoreApplicationInteractions storeApplicationInteractions, ApplicationCommandLocalSendData applicationCommandLocalSendData, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        if ((i & 4) != 0) {
            z3 = false;
        }
        return storeApplicationInteractions.buildApplicationCommandLocalMessage(applicationCommandLocalSendData, z2, z3);
    }

    @Store3
    private final void clearCache() {
        SharedPreferences.Editor editorEdit = this.sharedPrefs.edit();
        Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
        editorEdit.putString(CACHE_KEY_APPLICATION_COMMAND_SEND_DATA_SET, null);
        editorEdit.apply();
        this.applicationCommandLocalSendDataSet.clear();
        markChanged();
    }

    private final void clearComponentInteractionSendSuccessAndFailures() {
        this.dispatcher.schedule(new AnonymousClass1());
    }

    @Store3
    private final void handleApplicationCommandRequestStateUpdate(ApplicationCommandLocalSendData localSendData, Long interactionId) {
        upsertApplicationCommandSendData(ApplicationCommandLocalSendData.copy$default(localSendData, 0L, 0L, null, null, null, null, null, null, null, null, interactionId, AudioAttributesCompat.FLAG_ALL, null));
    }

    public static /* synthetic */ void handleApplicationCommandRequestStateUpdate$default(StoreApplicationInteractions storeApplicationInteractions, ApplicationCommandLocalSendData applicationCommandLocalSendData, Long l, int i, Object obj) {
        if ((i & 2) != 0) {
            l = null;
        }
        storeApplicationInteractions.handleApplicationCommandRequestStateUpdate(applicationCommandLocalSendData, l);
    }

    @Store3
    private final void handleApplicationCommandResult(MessageQueue4 result, ApplicationCommandLocalSendData localSendData, Function0<Unit> onSuccess, Function1<? super Error, Unit> onFail) {
        ApplicationCommandLocalSendData applicationCommandLocalSendData = this.applicationCommandLocalSendDataSet.get(localSendData.getNonceString());
        boolean z2 = (applicationCommandLocalSendData != null ? applicationCommandLocalSendData.getInteractionId() : null) == null;
        if (result instanceof MessageQueue4.Success) {
            if (onSuccess != null) {
                onSuccess.invoke();
            }
            if (z2) {
                handleApplicationCommandRequestStateUpdate$default(this, localSendData, null, 2, null);
                return;
            }
            return;
        }
        if (!(result instanceof MessageQueue4.UnknownFailure)) {
            if (z2) {
                this.storeStream.handleInteractionFailure(new InteractionStateUpdate(localSendData.getInteractionId(), localSendData.getNonceString()));
            }
        } else {
            if (onFail != null) {
                onFail.invoke(((MessageQueue4.UnknownFailure) result).getError());
            }
            if (z2) {
                this.storeStream.handleInteractionFailure(new InteractionStateUpdate(localSendData.getInteractionId(), localSendData.getNonceString()));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void handleApplicationCommandResult$default(StoreApplicationInteractions storeApplicationInteractions, MessageQueue4 messageQueue4, ApplicationCommandLocalSendData applicationCommandLocalSendData, Function0 function0, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = null;
        }
        if ((i & 8) != 0) {
            function1 = null;
        }
        storeApplicationInteractions.handleApplicationCommandResult(messageQueue4, applicationCommandLocalSendData, function0, function1);
    }

    private final void handleComponentInteractionMessage(ComponentLocation componentLocation) {
        addInteractionStateToComponent(componentLocation.getMessageId(), componentLocation.getComponentIndex(), InteractionSendState.Success.INSTANCE);
    }

    @Store3
    private final void handleInteractionDataFetchFailure(long interactionId) {
        this.interactionData.put(Long.valueOf(interactionId), State.Failure.INSTANCE);
        markChanged();
    }

    @Store3
    private final void handleInteractionDataFetchStart(long interactionId) {
        this.interactionData.put(Long.valueOf(interactionId), State.Fetching.INSTANCE);
        markChanged();
    }

    @Store3
    private final void handleInteractionDataFetchSuccess(long interactionId, ApplicationCommandData interactionData) {
        this.interactionData.put(Long.valueOf(interactionId), new State.Loaded(interactionData));
        markChanged();
    }

    public static /* synthetic */ void handleInteractionFailure$default(StoreApplicationInteractions storeApplicationInteractions, ApplicationCommandLocalSendData applicationCommandLocalSendData, Long l, int i, Object obj) {
        if ((i & 2) != 0) {
            l = null;
        }
        storeApplicationInteractions.handleInteractionFailure(applicationCommandLocalSendData, l);
    }

    @Store3
    private final void handleSendApplicationCommandRequest(ApplicationCommandLocalSendData localSendData, List<? extends Attachment<?>> attachments, Function0<Unit> onSuccess, Function1<? super Error, Unit> onFail) {
        upsertApplicationCommandSendData(localSendData);
        ObservableExtensionsKt.appSubscribe$default(sendApplicationCommandObservable(localSendData, attachments), StoreApplicationInteractions.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(localSendData, onSuccess, onFail), 62, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void handleSendApplicationCommandRequest$default(StoreApplicationInteractions storeApplicationInteractions, ApplicationCommandLocalSendData applicationCommandLocalSendData, List list, Function0 function0, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            list = null;
        }
        if ((i & 4) != 0) {
            function0 = null;
        }
        if ((i & 8) != 0) {
            function1 = null;
        }
        storeApplicationInteractions.handleSendApplicationCommandRequest(applicationCommandLocalSendData, list, function0, function1);
    }

    @Store3
    private final void loadCachedApplicationCommandSendDataSet() {
        Map<String, ApplicationCommandLocalSendData> linkedHashMap;
        try {
            String string = this.sharedPrefs.getString(CACHE_KEY_APPLICATION_COMMAND_SEND_DATA_SET, null);
            if (string == null || StringsJVM.isBlank(string)) {
                linkedHashMap = new LinkedHashMap<>();
            } else {
                Object objG = this.gson.g(string, new StoreApplicationInteractions5().getType());
                Intrinsics3.checkNotNullExpressionValue(objG, "gson.fromJson(cachedDataSet, type)");
                linkedHashMap = (Map) objG;
            }
            this.applicationCommandLocalSendDataSet = linkedHashMap;
        } catch (Exception e) {
            clearCache();
            this.applicationCommandLocalSendDataSet.clear();
            Logger.e$default(AppLog.g, "Error restoring cached command send data", e, null, 4, null);
        }
        markChanged();
    }

    @Store3
    private final void markAllLocalApplicationCommandRequestsAsFailed() {
        for (ApplicationCommandLocalSendData applicationCommandLocalSendData : this.applicationCommandLocalSendDataSet.values()) {
            this.storeStream.handleInteractionFailure(new InteractionStateUpdate(applicationCommandLocalSendData.getInteractionId(), applicationCommandLocalSendData.getNonceString()));
        }
    }

    @Store3
    private final void removeApplicationCommandSendData(String nonce) {
        if (this.applicationCommandLocalSendDataSet.remove(nonce) != null) {
            markChanged();
        }
    }

    public static /* synthetic */ void sendApplicationCommand$default(StoreApplicationInteractions storeApplicationInteractions, long j, Long l, String str, com.discord.widgets.chat.input.models.ApplicationCommandData applicationCommandData, List list, Function0 function0, Function1 function1, int i, Object obj) {
        storeApplicationInteractions.sendApplicationCommand(j, l, str, applicationCommandData, (i & 16) != 0 ? null : list, function0, function1);
    }

    private final Observable<MessageQueue4> sendApplicationCommandObservable(ApplicationCommandLocalSendData localSendData, List<? extends Attachment<?>> attachments) {
        Message messageBuildApplicationCommandLocalMessage$default = buildApplicationCommandLocalMessage$default(this, localSendData, false, false, 6, null);
        this.sentInteractions.put(localSendData.getNonceString(), new SentInteraction(localSendData.getChannelId(), null, localSendData.getGuildId(), null, 8, null));
        return this.storeMessages.sendMessage(messageBuildApplicationCommandLocalMessage$default, localSendData, attachments);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Observable sendApplicationCommandObservable$default(StoreApplicationInteractions storeApplicationInteractions, ApplicationCommandLocalSendData applicationCommandLocalSendData, List list, int i, Object obj) {
        if ((i & 2) != 0) {
            list = null;
        }
        return storeApplicationInteractions.sendApplicationCommandObservable(applicationCommandLocalSendData, list);
    }

    private final User toUser(Application application) {
        User bot = application.getBot();
        if (bot != null) {
            return bot;
        }
        long id2 = application.getId();
        String name = application.getName();
        String icon = application.getIcon();
        return new User(id2, name, icon != null ? new NullSerializable.b(icon) : new NullSerializable.a(null, 1), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 4194296);
    }

    @Store3
    private final void upsertApplicationCommandSendData(ApplicationCommandLocalSendData localSendData) {
        this.applicationCommandLocalSendDataSet.put(localSendData.getNonceString(), localSendData);
        markChanged();
    }

    public final void fetchInteractionDataIfNonExisting(long interactionId, long channelId, long messageId, String messageNonce) {
        ApplicationCommandLocalSendData applicationCommandLocalSendData;
        State state = this.interactionData.get(Long.valueOf(interactionId));
        if ((state instanceof State.Fetching) || (state instanceof State.Loaded)) {
            return;
        }
        if (!(messageNonce == null || StringsJVM.isBlank(messageNonce)) && this.applicationCommandLocalSendDataSnapshot.containsKey(messageNonce) && (applicationCommandLocalSendData = this.applicationCommandLocalSendDataSnapshot.get(messageNonce)) != null) {
            this.dispatcher.schedule(new StoreApplicationInteractions2(applicationCommandLocalSendData, this, interactionId));
        } else {
            this.dispatcher.schedule(new AnonymousClass2(interactionId));
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.getInteractionData(channelId, messageId), false, 1, null), StoreApplicationInteractions.class, (Context) null, (Function1) null, new AnonymousClass4(interactionId), (Function0) null, (Function0) null, new AnonymousClass3(interactionId), 54, (Object) null);
        }
    }

    public final Map<String, ApplicationCommandLocalSendData> getApplicationCommandLocalSendDataSet$app_productionGoogleRelease() {
        return this.applicationCommandLocalSendDataSet;
    }

    public final Map<Long, Map<Integer, InteractionSendState>> getComponentInteractionData() {
        return this.interactionComponentSendStateSnapshot;
    }

    public final Map<String, ComponentLocation> getComponentInteractions() {
        return this.componentInteractions;
    }

    public final Map<Long, Map<Integer, InteractionSendState>> getInteractionComponentSendState() {
        return this.interactionComponentSendState;
    }

    public final Map<Long, Map<Integer, InteractionSendState>> getInteractionComponentSendStateSnapshot() {
        return this.interactionComponentSendStateSnapshot;
    }

    public final State getInteractionData(long interactionId) {
        return this.interactionDataSnapshot.get(Long.valueOf(interactionId));
    }

    public final LruCache<String, SentInteraction> getSentInteractions$app_productionGoogleRelease() {
        return this.sentInteractions;
    }

    @Store3
    public final void handleChannelSelected() {
        clearComponentInteractionSendSuccessAndFailures();
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        this.sessionId = payload.getSessionId();
    }

    @Store3
    public final void handleConnectionReady(boolean connectionReady) {
        if (connectionReady) {
            markAllLocalApplicationCommandRequestsAsFailed();
        }
    }

    @Store3
    public final void handleInteractionCreate(InteractionStateUpdate interactionStateUpdate) {
        Intrinsics3.checkNotNullParameter(interactionStateUpdate, "interactionStateUpdate");
        ApplicationCommandLocalSendData applicationCommandLocalSendData = this.applicationCommandLocalSendDataSet.get(interactionStateUpdate.getNonce());
        if (applicationCommandLocalSendData != null) {
            handleApplicationCommandRequestStateUpdate(applicationCommandLocalSendData, interactionStateUpdate.getId());
        }
    }

    @Store3
    public final void handleInteractionFailure(InteractionStateUpdate interactionStateUpdate) {
        ApplicationCommandLocalSendData applicationCommandLocalSendData;
        Intrinsics3.checkNotNullParameter(interactionStateUpdate, "interactionStateUpdate");
        SentInteraction sentInteraction = this.sentInteractions.get(interactionStateUpdate.getNonce());
        if (sentInteraction != null) {
            sentInteraction.setState(SentInteractionState.FAILURE);
            markChanged(SentInteractionsUpdate);
        }
        if (!this.componentInteractions.containsKey(interactionStateUpdate.getNonce())) {
            if (!this.applicationCommandLocalSendDataSet.containsKey(interactionStateUpdate.getNonce()) || (applicationCommandLocalSendData = this.applicationCommandLocalSendDataSet.get(interactionStateUpdate.getNonce())) == null) {
                return;
            }
            handleInteractionFailure(applicationCommandLocalSendData, interactionStateUpdate.getId());
            return;
        }
        ComponentLocation componentLocation = this.componentInteractions.get(interactionStateUpdate.getNonce());
        if (componentLocation != null) {
            this.storeLocalActionComponentState.clearState(componentLocation.getMessageId(), Integer.valueOf(componentLocation.getComponentIndex()));
            this.componentInteractions.remove(interactionStateUpdate.getNonce());
            addInteractionStateToComponent(componentLocation.getMessageId(), componentLocation.getComponentIndex(), new InteractionSendState.Failed(null, 1, null));
        }
    }

    @Store3
    public final void handleInteractionModalCreate(InteractionModalCreate interactionModalCreate) {
        Intrinsics3.checkNotNullParameter(interactionModalCreate, "interactionModalCreate");
        this.interactionModalCreate.k.onNext(interactionModalCreate);
    }

    @Store3
    public final void handleInteractionSuccess(InteractionStateUpdate interactionStateUpdate) {
        ComponentLocation componentLocation;
        Intrinsics3.checkNotNullParameter(interactionStateUpdate, "interactionStateUpdate");
        SentInteraction sentInteraction = this.sentInteractions.get(interactionStateUpdate.getNonce());
        if (sentInteraction != null) {
            sentInteraction.setState(SentInteractionState.SUCCESS);
            markChanged(SentInteractionsUpdate);
        }
        if (!this.componentInteractions.containsKey(interactionStateUpdate.getNonce()) || (componentLocation = this.componentInteractions.get(interactionStateUpdate.getNonce())) == null) {
            return;
        }
        this.interactionComponentSendState.remove(Long.valueOf(componentLocation.getMessageId()));
        this.componentInteractions.remove(interactionStateUpdate.getNonce());
        markChanged(ComponentStateUpdate);
    }

    @Store3
    public final void handleLocalMessageDelete(Message message) {
        Intrinsics3.checkNotNullParameter(message, "message");
        String nonce = message.getNonce();
        if (nonce != null) {
            removeApplicationCommandSendData(nonce);
        }
    }

    @Store3
    public final void handleMessageCreate(com.discord.api.message.Message message) {
        Intrinsics3.checkNotNullParameter(message, "message");
        handleMessagesCreateOrLoad(CollectionsJVM.listOf(new Message(message)));
    }

    @Store3
    public final void handleMessageUpdate(com.discord.api.message.Message message) {
        boolean z2;
        Intrinsics3.checkNotNullParameter(message, "message");
        Map<String, ComponentLocation> map = this.componentInteractions;
        if (map.isEmpty()) {
            z2 = false;
        } else {
            Iterator<Map.Entry<String, ComponentLocation>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                if (it.next().getValue().getMessageId() == message.getId()) {
                    z2 = true;
                    break;
                }
            }
            z2 = false;
        }
        if (z2) {
            this.storeLocalActionComponentState.clearState(message.getId(), null);
            Map<String, ComponentLocation> map2 = this.componentInteractions;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, ComponentLocation> entry : map2.entrySet()) {
                if (entry.getValue().getMessageId() == message.getId()) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            Iterator it2 = linkedHashMap.keySet().iterator();
            while (it2.hasNext()) {
                this.componentInteractions.remove((String) it2.next());
            }
            markChanged(ComponentStateUpdate);
        }
        if (this.interactionComponentSendState.containsKey(Long.valueOf(message.getId()))) {
            this.interactionComponentSendState.remove(Long.valueOf(message.getId()));
            markChanged(ComponentStateUpdate);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Store3
    public final void handleMessagesCreateOrLoad(List<Message> messagesList) {
        Intrinsics3.checkNotNullParameter(messagesList, "messagesList");
        for (Message message : messagesList) {
            String nonce = message.getNonce();
            if (nonce == null || !this.componentInteractions.containsKey(nonce)) {
                Interaction interaction = message.getInteraction();
                ApplicationCommandLocalSendData applicationCommandLocalSendData = null;
                Long id2 = interaction != null ? interaction.getId() : null;
                if (!(nonce == null || StringsJVM.isBlank(nonce)) && this.applicationCommandLocalSendDataSet.containsKey(nonce)) {
                    applicationCommandLocalSendData = this.applicationCommandLocalSendDataSet.get(nonce);
                } else if (id2 != null) {
                    Iterator<T> it = this.applicationCommandLocalSendDataSet.values().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        if (Intrinsics3.areEqual(((ApplicationCommandLocalSendData) next).getInteractionId(), id2)) {
                            applicationCommandLocalSendData = next;
                            break;
                        }
                    }
                    applicationCommandLocalSendData = applicationCommandLocalSendData;
                }
                if (applicationCommandLocalSendData != null) {
                    removeApplicationCommandSendData(applicationCommandLocalSendData.getNonceString());
                    this.storeMessages.deleteLocalMessage(applicationCommandLocalSendData.getChannelId(), applicationCommandLocalSendData.getNonceString());
                }
            } else {
                ComponentLocation componentLocation = this.componentInteractions.get(nonce);
                if (componentLocation == null) {
                    return;
                }
                handleComponentInteractionMessage(componentLocation);
                this.componentInteractions.remove(nonce);
            }
        }
    }

    @Store3
    public final void handlePreLogout() {
        this.applicationCommandLocalSendDataSet.clear();
        markChanged();
    }

    @Override // com.discord.stores.Store
    @Store3
    public void init(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        super.init(context);
        loadCachedApplicationCommandSendDataSet();
    }

    public final Observable<Map<Long, Map<Integer, InteractionSendState>>> observeComponentInteractionState() {
        Observable<Map<Long, Map<Integer, InteractionSendState>>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{ComponentStateUpdate}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final Observable<State> observeInteractionData(long interactionId) {
        Observable<State> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(interactionId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final Observable<InteractionModalCreate> observeModalCreate() {
        PublishSubject<InteractionModalCreate> publishSubject = this.interactionModalCreate;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "interactionModalCreate");
        return publishSubject;
    }

    public final Observable<Map<String, SentInteraction>> observeSentInteractions() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{SentInteractionsUpdate}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final void resendApplicationCommand(Message message) {
        String nonce;
        ApplicationCommandLocalSendData applicationCommandLocalSendData;
        Intrinsics3.checkNotNullParameter(message, "message");
        Integer type = message.getType();
        if (type == null || type.intValue() != -4 || (nonce = message.getNonce()) == null || (applicationCommandLocalSendData = this.applicationCommandLocalSendDataSnapshot.get(nonce)) == null) {
            return;
        }
        this.dispatcher.schedule(new AnonymousClass1(message, nonce, ApplicationCommandLocalSendData.copy$default(applicationCommandLocalSendData, NonceGenerator.Companion.computeNonce$default(NonceGenerator.INSTANCE, null, 1, null), 0L, null, null, null, null, null, null, null, null, null, 1022, null)));
    }

    public final void sendApplicationCommand(long channelId, Long guildId, String version, com.discord.widgets.chat.input.models.ApplicationCommandData data, List<? extends Attachment<?>> attachments, Function0<Unit> onSuccess, Function1<? super Error, Unit> onFail) {
        Intrinsics3.checkNotNullParameter(data, "data");
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics3.checkNotNullParameter(onFail, "onFail");
        this.dispatcher.schedule(new AnonymousClass1(new ApplicationCommandLocalSendData(this.nonceGenerator.nonce(), channelId, guildId, data.getApplicationCommand().getGuildId(), data.getApplication(), this.sessionId, data.getApplicationCommand().getName(), data.getApplicationCommand().getId(), data.getValues(), version, null, 1024, null), attachments, onSuccess, onFail));
    }

    public final void sendComponentInteraction(long applicationId, Long guildId, long channelId, long messageId, int componentIndex, RestAPIParams.ComponentInteractionData data, Long messageFlags) {
        Intrinsics3.checkNotNullParameter(data, "data");
        this.dispatcher.schedule(new AnonymousClass1(messageId, componentIndex, String.valueOf(this.nonceGenerator.nonce()), channelId, guildId, applicationId, messageFlags, data));
    }

    public final void sendModalInteraction(InteractionModalCreate modal, List<Tuples2<String, String>> components, Function1<? super String, Unit> onNext, Function0<Unit> onError) {
        Intrinsics3.checkNotNullParameter(modal, "modal");
        Intrinsics3.checkNotNullParameter(components, "components");
        Intrinsics3.checkNotNullParameter(onNext, "onNext");
        Intrinsics3.checkNotNullParameter(onError, "onError");
        SentInteraction sentInteraction = this.sentInteractions.get(modal.getNonce());
        if (sentInteraction != null) {
            Intrinsics3.checkNotNullExpressionValue(sentInteraction, "sentInteractions[modal.nonce] ?: return");
            long jNonce = this.nonceGenerator.nonce();
            this.sentInteractions.put(String.valueOf(jNonce), sentInteraction);
            this.dispatcher.schedule(new AnonymousClass1(modal, sentInteraction, jNonce, components, onNext, onError));
        }
    }

    public final void setInteractionComponentSendStateSnapshot(Map<Long, ? extends Map<Integer, ? extends InteractionSendState>> map) {
        Intrinsics3.checkNotNullParameter(map, "<set-?>");
        this.interactionComponentSendStateSnapshot = map;
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() throws JsonIOException {
        super.snapshotData();
        this.interactionDataSnapshot = new HashMap(this.interactionData);
        this.interactionComponentSendStateSnapshot = new HashMap(this.interactionComponentSendState);
        Map<String, SentInteraction> mapSnapshot = this.sentInteractions.snapshot();
        Intrinsics3.checkNotNullExpressionValue(mapSnapshot, "sentInteractions.snapshot()");
        this.sentInteractionsSnapshot = mapSnapshot;
        HashMap map = new HashMap(this.applicationCommandLocalSendDataSet);
        this.applicationCommandLocalSendDataSnapshot = map;
        String strM = this.gson.m(map);
        SharedPreferences.Editor editorEdit = this.sharedPrefs.edit();
        Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
        editorEdit.putString(CACHE_KEY_APPLICATION_COMMAND_SEND_DATA_SET, strM);
        editorEdit.apply();
    }

    public StoreApplicationInteractions(StoreStream storeStream, Dispatcher dispatcher, StoreMessages storeMessages, StoreLocalActionComponentState storeLocalActionComponentState, StoreUser storeUser, Clock clock, SharedPreferences sharedPreferences, ObservationDeck observationDeck, RestAPI restAPI, NonceGenerator nonceGenerator) {
        Intrinsics3.checkNotNullParameter(storeStream, "storeStream");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(storeMessages, "storeMessages");
        Intrinsics3.checkNotNullParameter(storeLocalActionComponentState, "storeLocalActionComponentState");
        Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Intrinsics3.checkNotNullParameter(sharedPreferences, "sharedPrefs");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        Intrinsics3.checkNotNullParameter(nonceGenerator, "nonceGenerator");
        this.storeStream = storeStream;
        this.dispatcher = dispatcher;
        this.storeMessages = storeMessages;
        this.storeLocalActionComponentState = storeLocalActionComponentState;
        this.storeUser = storeUser;
        this.clock = clock;
        this.sharedPrefs = sharedPreferences;
        this.observationDeck = observationDeck;
        this.restAPI = restAPI;
        this.nonceGenerator = nonceGenerator;
        this.componentInteractions = new LinkedHashMap();
        this.interactionComponentSendState = new LinkedHashMap();
        this.interactionComponentSendStateSnapshot = Maps6.emptyMap();
        this.applicationCommandLocalSendDataSnapshot = new LinkedHashMap();
        this.applicationCommandLocalSendDataSet = new LinkedHashMap();
        this.interactionDataSnapshot = Maps6.emptyMap();
        this.interactionData = new HashMap<>();
        this.sentInteractions = new LruCache<>(5);
        this.sentInteractionsSnapshot = Maps6.emptyMap();
        GsonBuilder gsonBuilder = new GsonBuilder();
        TypeAdapterRegistrar.a(gsonBuilder);
        this.gson = gsonBuilder.a();
        this.interactionModalCreate = PublishSubject.k0();
    }

    @Store3
    private final void handleInteractionFailure(ApplicationCommandLocalSendData localSendData, Long interactionId) {
        handleApplicationCommandRequestStateUpdate(localSendData, interactionId);
    }
}
