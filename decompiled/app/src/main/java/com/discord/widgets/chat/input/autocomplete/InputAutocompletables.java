package com.discord.widgets.chat.input.autocomplete;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.input.autocomplete.sources.ApplicationCommandsAutocompletableSource;
import com.discord.widgets.chat.input.autocomplete.sources.ChannelAutocompletableSource;
import com.discord.widgets.chat.input.autocomplete.sources.EmojiAutocompletableSource;
import com.discord.widgets.chat.input.autocomplete.sources.UserMentionableSource;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import kotlin.Lazy;
import kotlin.Metadata;
import rx.Observable;
import rx.functions.Func4;

/* compiled from: InputAutocompletables.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b!\u0010\"J1\u0010\n\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00060\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001d\u0010\u0011\u001a\u00020\f8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0016\u001a\u00020\u00128F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u001b\u001a\u00020\u00178F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010 \u001a\u00020\u001c8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/ChatInputAutocompletables;", "", "", "Lcom/discord/primitives/ChannelId;", "channelId", "Lrx/Observable;", "", "Lcom/discord/widgets/chat/input/autocomplete/LeadingIdentifier;", "", "Lcom/discord/widgets/chat/input/autocomplete/Autocompletable;", "observeChannelAutocompletables", "(J)Lrx/Observable;", "Lcom/discord/widgets/chat/input/autocomplete/sources/EmojiAutocompletableSource;", "EMOJI_SOURCE$delegate", "Lkotlin/Lazy;", "getEMOJI_SOURCE", "()Lcom/discord/widgets/chat/input/autocomplete/sources/EmojiAutocompletableSource;", "EMOJI_SOURCE", "Lcom/discord/widgets/chat/input/autocomplete/sources/ApplicationCommandsAutocompletableSource;", "APPLICATION_COMMANDS_SOURCE$delegate", "getAPPLICATION_COMMANDS_SOURCE", "()Lcom/discord/widgets/chat/input/autocomplete/sources/ApplicationCommandsAutocompletableSource;", "APPLICATION_COMMANDS_SOURCE", "Lcom/discord/widgets/chat/input/autocomplete/sources/ChannelAutocompletableSource;", "CHANNEL_SOURCE$delegate", "getCHANNEL_SOURCE", "()Lcom/discord/widgets/chat/input/autocomplete/sources/ChannelAutocompletableSource;", "CHANNEL_SOURCE", "Lcom/discord/widgets/chat/input/autocomplete/sources/UserAutocompletableSource;", "USERS_SOURCE$delegate", "getUSERS_SOURCE", "()Lcom/discord/widgets/chat/input/autocomplete/sources/UserAutocompletableSource;", "USERS_SOURCE", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.autocomplete.ChatInputAutocompletables, reason: use source file name */
/* loaded from: classes2.dex */
public final class InputAutocompletables {
    public static final InputAutocompletables INSTANCE = new InputAutocompletables();

    /* renamed from: EMOJI_SOURCE$delegate, reason: from kotlin metadata */
    private static final Lazy EMOJI_SOURCE = LazyJVM.lazy(InputAutocompletables4.INSTANCE);

    /* renamed from: CHANNEL_SOURCE$delegate, reason: from kotlin metadata */
    private static final Lazy CHANNEL_SOURCE = LazyJVM.lazy(InputAutocompletables3.INSTANCE);

    /* renamed from: USERS_SOURCE$delegate, reason: from kotlin metadata */
    private static final Lazy USERS_SOURCE = LazyJVM.lazy(InputAutocompletables5.INSTANCE);

    /* renamed from: APPLICATION_COMMANDS_SOURCE$delegate, reason: from kotlin metadata */
    private static final Lazy APPLICATION_COMMANDS_SOURCE = LazyJVM.lazy(InputAutocompletables2.INSTANCE);

    /* compiled from: InputAutocompletables.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\n\u001ar\u00122\b\u0001\u0012.\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006 \u0001*\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u00040\u0004 \u0001*8\u00122\b\u0001\u0012.\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006 \u0001*\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lcom/discord/api/channel/Channel;", "kotlin.jvm.PlatformType", "channel", "Lrx/Observable;", "", "Lcom/discord/widgets/chat/input/autocomplete/LeadingIdentifier;", "", "Lcom/discord/widgets/chat/input/autocomplete/Autocompletable;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/channel/Channel;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.autocomplete.ChatInputAutocompletables$observeChannelAutocompletables$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Channel, Observable<? extends Map<LeadingIdentifier, ? extends Set<? extends Autocompletable>>>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        /* compiled from: InputAutocompletables.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0003\u0010\f\u001a.\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\t \u0004*\u0016\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\t\u0018\u00010\u00000\u000022\u0010\u0005\u001a.\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002 \u0004*\u0016\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u00000\u000022\u0010\u0006\u001a.\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002 \u0004*\u0016\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u00000\u000022\u0010\u0007\u001a.\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002 \u0004*\u0016\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u00000\u000022\u0010\b\u001a.\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002 \u0004*\u0016\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"", "Lcom/discord/widgets/chat/input/autocomplete/LeadingIdentifier;", "Ljava/util/TreeSet;", "Lcom/discord/widgets/chat/input/autocomplete/Autocompletable;", "kotlin.jvm.PlatformType", "commands", "emojis", "channels", "users", "", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.chat.input.autocomplete.ChatInputAutocompletables$observeChannelAutocompletables$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02541<T1, T2, T3, T4, R> implements Func4<Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>>, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>>, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>>, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>>, Map<LeadingIdentifier, ? extends Set<? extends Autocompletable>>> {
            public static final C02541 INSTANCE = new C02541();

            @Override // rx.functions.Func4
            public /* bridge */ /* synthetic */ Map<LeadingIdentifier, ? extends Set<? extends Autocompletable>> call(Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>> map, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>> map2, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>> map3, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>> map4) {
                return call2(map, map2, map3, map4);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Map<LeadingIdentifier, Set<Autocompletable>> call2(Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>> map, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>> map2, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>> map3, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>> map4) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                Intrinsics3.checkNotNullExpressionValue(map, "commands");
                InputAutocompletables6.access$merge(linkedHashMap, map);
                Intrinsics3.checkNotNullExpressionValue(map2, "emojis");
                InputAutocompletables6.access$merge(linkedHashMap, map2);
                Intrinsics3.checkNotNullExpressionValue(map3, "channels");
                InputAutocompletables6.access$merge(linkedHashMap, map3);
                Intrinsics3.checkNotNullExpressionValue(map4, "users");
                InputAutocompletables6.access$merge(linkedHashMap, map4);
                return linkedHashMap;
            }
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Map<LeadingIdentifier, ? extends Set<? extends Autocompletable>>> call(Channel channel) {
            return call2(channel);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Map<LeadingIdentifier, Set<Autocompletable>>> call2(Channel channel) {
            InputAutocompletables inputAutocompletables = InputAutocompletables.INSTANCE;
            ApplicationCommandsAutocompletableSource application_commands_source = inputAutocompletables.getAPPLICATION_COMMANDS_SOURCE();
            Intrinsics3.checkNotNullExpressionValue(channel, "channel");
            return Observable.h(application_commands_source.observeApplicationCommandAutocompletables(channel), inputAutocompletables.getEMOJI_SOURCE().observeEmojiAutocompletables(channel), inputAutocompletables.getCHANNEL_SOURCE().observeChannelAutocompletables(channel.getGuildId()), inputAutocompletables.getUSERS_SOURCE().observeUserAutocompletables(channel), C02541.INSTANCE);
        }
    }

    private InputAutocompletables() {
    }

    public final ApplicationCommandsAutocompletableSource getAPPLICATION_COMMANDS_SOURCE() {
        return (ApplicationCommandsAutocompletableSource) APPLICATION_COMMANDS_SOURCE.getValue();
    }

    public final ChannelAutocompletableSource getCHANNEL_SOURCE() {
        return (ChannelAutocompletableSource) CHANNEL_SOURCE.getValue();
    }

    public final EmojiAutocompletableSource getEMOJI_SOURCE() {
        return (EmojiAutocompletableSource) EMOJI_SOURCE.getValue();
    }

    public final UserMentionableSource getUSERS_SOURCE() {
        return (UserMentionableSource) USERS_SOURCE.getValue();
    }

    public final Observable<Map<LeadingIdentifier, Set<Autocompletable>>> observeChannelAutocompletables(long channelId) {
        Observable<R> observableG = StoreStream.INSTANCE.getChannels().observeChannel(channelId).y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        Observable observableY = observableG.Y(AnonymousClass1.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableY, "StoreStream.getChannels(…e>>\n          }\n        }");
        return ObservableExtensionsKt.computationLatest(observableY);
    }
}
