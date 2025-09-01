package com.discord.stores;

import com.discord.api.emoji.GuildEmoji;
import com.discord.api.emoji.GuildEmojisUpdate;
import com.discord.api.guild.Guild;
import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import com.discord.models.member.GuildMember;
import com.discord.utilities.persister.Persister;
import d0.d0._Ranges;
import d0.t.Collections2;
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
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import rx.Observable;

/* compiled from: StoreEmojiCustom.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 B2\u00020\u0001:\u0001BB\u000f\u0012\u0006\u00105\u001a\u000204¢\u0006\u0004\b@\u0010AJ)\u0010\t\u001a\u00020\b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002¢\u0006\u0004\b\t\u0010\nJ;\u0010\u000f\u001a\u00020\b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0010\u0010\r\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\f0\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J1\u0010\u0014\u001a&\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0002j\u0002`\u0012\u0012\u0004\u0012\u00020\u00060\u0011j\u0002`\u00130\u0011¢\u0006\u0004\b\u0014\u0010\u0015J-\u0010\u0016\u001a\u0016\u0012\b\u0012\u00060\u0002j\u0002`\u0012\u0012\u0004\u0012\u00020\u00060\u0011j\u0002`\u00132\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0016\u0010\u0017J7\u0010\u0019\u001a,\u0012(\u0012&\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0002j\u0002`\u0012\u0012\u0004\u0012\u00020\u00060\u0011j\u0002`\u00130\u00110\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ3\u0010\u001b\u001a&\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0002j\u0002`\u0012\u0012\u0004\u0012\u00020\u00060\u0011j\u0002`\u00130\u0011H\u0007¢\u0006\u0004\b\u001b\u0010\u0015J3\u0010\u001c\u001a\u001a\u0012\b\u0012\u00060\u0002j\u0002`\u0012\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0011j\u0004\u0018\u0001`\u00132\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0007¢\u0006\u0004\b\u001c\u0010\u0017J\u0017\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0007¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010#\u001a\u0004\u0018\u00010\b2\u0006\u0010\"\u001a\u00020!H\u0007¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\b2\u0006\u0010\"\u001a\u00020!H\u0007¢\u0006\u0004\b%\u0010&J\u0017\u0010)\u001a\u00020\b2\u0006\u0010(\u001a\u00020'H\u0007¢\u0006\u0004\b)\u0010*J\u0017\u0010-\u001a\u00020\b2\u0006\u0010,\u001a\u00020+H\u0007¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\bH\u0016¢\u0006\u0004\b/\u00100R@\u00102\u001a,\u0012(\u0012&\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0002j\u0002`\u0012\u0012\u0004\u0012\u00020\u00060\u0011j\u0002`\u00130\u0011018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00105\u001a\u0002048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R:\u00108\u001a&\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0002j\u0002`\u0012\u0012\u0004\u0012\u00020\u00060\u0011j\u0002`\u0013078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u001a\u0010;\u001a\u00060\u0002j\u0002`:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R:\u0010=\u001a&\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0002j\u0002`\u0012\u0012\u0004\u0012\u00020\u00060\u0011j\u0002`\u00130\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u00109RJ\u0010?\u001a6\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012(\u0012&\u0012\b\u0012\u00060\u0002j\u0002`\f\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0002j\u0002`\u0012\u0012\u0004\u0012\u00020\u000607j\u0002`>07078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u00109¨\u0006C"}, d2 = {"Lcom/discord/stores/StoreEmojiCustom;", "Lcom/discord/stores/StoreV2;", "", "Lcom/discord/primitives/GuildId;", "guildId", "", "Lcom/discord/models/domain/emoji/ModelEmojiCustom;", "emojis", "", "updateGlobalEmojis", "(JLjava/util/Collection;)V", "", "Lcom/discord/primitives/RoleId;", "myRoles", "guildEmojis", "updateAllowedGuildEmojis", "(JLjava/util/List;Ljava/util/Collection;)V", "", "Lcom/discord/primitives/EmojiId;", "Lcom/discord/stores/EmojiMap;", "getAllGuildEmoji", "()Ljava/util/Map;", "getEmojiForGuild", "(J)Ljava/util/Map;", "Lrx/Observable;", "observeAllowedGuildEmoji", "()Lrx/Observable;", "getAllGuildEmojiInternal", "getEmojiForGuildInternal", "Lcom/discord/models/domain/ModelPayload;", "payload", "handleConnectionOpen", "(Lcom/discord/models/domain/ModelPayload;)V", "Lcom/discord/api/guild/Guild;", "guild", "handleGuildAdd", "(Lcom/discord/api/guild/Guild;)Lkotlin/Unit;", "handleGuildRemove", "(Lcom/discord/api/guild/Guild;)V", "Lcom/discord/api/guildmember/GuildMember;", "member", "handleGuildMemberAdd", "(Lcom/discord/api/guildmember/GuildMember;)V", "Lcom/discord/api/emoji/GuildEmojisUpdate;", "emojiUpdate", "handleEmojiUpdate", "(Lcom/discord/api/emoji/GuildEmojisUpdate;)V", "snapshotData", "()V", "Lcom/discord/utilities/persister/Persister;", "allowedGuildEmojiPersister", "Lcom/discord/utilities/persister/Persister;", "Lcom/discord/stores/StoreStream;", "stream", "Lcom/discord/stores/StoreStream;", "", "allGuildEmoji", "Ljava/util/Map;", "Lcom/discord/primitives/UserId;", "me", "J", "allGuildEmojiSnapshot", "Lcom/discord/stores/EmojiMutableMap;", "allowedGuildEmojis", "<init>", "(Lcom/discord/stores/StoreStream;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreEmojiCustom extends StoreV2 {
    private static final long NO_ROLE = 0;
    private final Map<Long, Map<Long, ModelEmojiCustom>> allGuildEmoji;
    private Map<Long, ? extends Map<Long, ? extends ModelEmojiCustom>> allGuildEmojiSnapshot;
    private final Persister<Map<Long, Map<Long, ModelEmojiCustom>>> allowedGuildEmojiPersister;
    private final Map<Long, Map<Long, Map<Long, ModelEmojiCustom>>> allowedGuildEmojis;
    private long me;
    private final StoreStream stream;

    /* compiled from: StoreEmojiCustom.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/discord/primitives/RoleId;", "roleId", "Lcom/discord/models/domain/emoji/ModelEmojiCustom;", "emoji", "", "invoke", "(JLcom/discord/models/domain/emoji/ModelEmojiCustom;)V", "mergeEmoji"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreEmojiCustom$updateAllowedGuildEmojis$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function2<Long, ModelEmojiCustom, Unit> {
        public final /* synthetic */ Map $allowed;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Map map) {
            super(2);
            this.$allowed = map;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, ModelEmojiCustom modelEmojiCustom) {
            invoke(l.longValue(), modelEmojiCustom);
            return Unit.a;
        }

        public final void invoke(long j, ModelEmojiCustom modelEmojiCustom) {
            Intrinsics3.checkNotNullParameter(modelEmojiCustom, "emoji");
            Map map = this.$allowed;
            Long lValueOf = Long.valueOf(j);
            Object map2 = map.get(lValueOf);
            if (map2 == null) {
                map2 = new HashMap();
                map.put(lValueOf, map2);
            }
            Map map3 = (Map) map2;
            long id2 = modelEmojiCustom.getId();
            if (!Intrinsics3.areEqual(modelEmojiCustom, (ModelEmojiCustom) map3.get(Long.valueOf(id2)))) {
                map3.put(Long.valueOf(id2), modelEmojiCustom);
                StoreEmojiCustom.this.markChanged();
            }
        }
    }

    public StoreEmojiCustom(StoreStream storeStream) {
        Intrinsics3.checkNotNullParameter(storeStream, "stream");
        this.stream = storeStream;
        this.allGuildEmoji = new LinkedHashMap();
        this.allGuildEmojiSnapshot = Maps6.emptyMap();
        this.allowedGuildEmojis = new LinkedHashMap();
        this.allowedGuildEmojiPersister = new Persister<>("STORE_EMOJI_AVAILABLE_V5", new HashMap());
    }

    private final void updateAllowedGuildEmojis(long guildId, List<Long> myRoles, Collection<? extends ModelEmojiCustom> guildEmojis) {
        Object next;
        Map<Long, Map<Long, Map<Long, ModelEmojiCustom>>> map = this.allowedGuildEmojis;
        Long lValueOf = Long.valueOf(guildId);
        Map<Long, Map<Long, ModelEmojiCustom>> map2 = map.get(lValueOf);
        if (map2 == null) {
            map2 = new HashMap<>();
            map.put(lValueOf, map2);
        }
        Map<Long, Map<Long, ModelEmojiCustom>> map3 = map2;
        map3.clear();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(map3);
        for (ModelEmojiCustom modelEmojiCustom : guildEmojis) {
            List<Long> roles = modelEmojiCustom.getRoles();
            if (roles.isEmpty()) {
                anonymousClass1.invoke(0L, modelEmojiCustom);
            } else {
                Iterator<T> it = myRoles.iterator();
                while (true) {
                    if (it.hasNext()) {
                        next = it.next();
                        if (roles.contains(Long.valueOf(((Number) next).longValue()))) {
                            break;
                        }
                    } else {
                        next = null;
                        break;
                    }
                }
                Long l = (Long) next;
                if (l != null) {
                    anonymousClass1.invoke(l.longValue(), modelEmojiCustom);
                }
            }
        }
    }

    private final void updateGlobalEmojis(long guildId, Collection<? extends ModelEmojiCustom> emojis) {
        if (emojis.isEmpty()) {
            this.allGuildEmoji.remove(Long.valueOf(guildId));
        } else {
            Map<Long, Map<Long, ModelEmojiCustom>> map = this.allGuildEmoji;
            Long lValueOf = Long.valueOf(guildId);
            LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(emojis, 10)), 16));
            for (Object obj : emojis) {
                linkedHashMap.put(Long.valueOf(((ModelEmojiCustom) obj).getId()), obj);
            }
            map.put(lValueOf, linkedHashMap);
        }
        markChanged();
    }

    public final Map<Long, Map<Long, ModelEmojiCustom>> getAllGuildEmoji() {
        return this.allGuildEmojiSnapshot;
    }

    @Store3
    public final Map<Long, Map<Long, ModelEmojiCustom>> getAllGuildEmojiInternal() {
        return this.allGuildEmoji;
    }

    public final Map<Long, ModelEmojiCustom> getEmojiForGuild(long guildId) {
        Map<Long, ModelEmojiCustom> map = getAllGuildEmoji().get(Long.valueOf(guildId));
        return map != null ? map : Maps6.emptyMap();
    }

    @Store3
    public final Map<Long, ModelEmojiCustom> getEmojiForGuildInternal(long guildId) {
        return this.allGuildEmoji.get(Long.valueOf(guildId));
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        this.me = payload.getMe().getId();
        for (Guild guild : payload.getGuilds()) {
            Intrinsics3.checkNotNullExpressionValue(guild, "guild");
            handleGuildAdd(guild);
        }
    }

    @Store3
    public final void handleEmojiUpdate(GuildEmojisUpdate emojiUpdate) {
        GuildMember guildMember;
        Intrinsics3.checkNotNullParameter(emojiUpdate, "emojiUpdate");
        long guildId = emojiUpdate.getGuildId();
        Map<Long, GuildMember> map = this.stream.getGuilds().getGuildMembersComputedInternal$app_productionGoogleRelease().get(Long.valueOf(guildId));
        List<GuildEmoji> listA = emojiUpdate.a();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listA, 10));
        Iterator<T> it = listA.iterator();
        while (it.hasNext()) {
            arrayList.add(new ModelEmojiCustom((GuildEmoji) it.next(), guildId));
        }
        if (map == null || (guildMember = map.get(Long.valueOf(this.me))) == null) {
            return;
        }
        updateGlobalEmojis(guildId, arrayList);
        updateAllowedGuildEmojis(guildId, guildMember.getRoles(), arrayList);
    }

    @Store3
    public final Unit handleGuildAdd(Guild guild) {
        Object next;
        Collection<? extends ModelEmojiCustom> collectionEmptyList;
        Intrinsics3.checkNotNullParameter(guild, "guild");
        List<com.discord.api.guildmember.GuildMember> listV = guild.v();
        if (listV == null) {
            return null;
        }
        Iterator<T> it = listV.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((com.discord.api.guildmember.GuildMember) next).getUser().getId() == this.me) {
                break;
            }
        }
        com.discord.api.guildmember.GuildMember guildMember = (com.discord.api.guildmember.GuildMember) next;
        if (guildMember == null) {
            return null;
        }
        long id2 = guild.getId();
        List<GuildEmoji> listK = guild.k();
        if (listK != null) {
            collectionEmptyList = new ArrayList<>(Iterables2.collectionSizeOrDefault(listK, 10));
            Iterator<T> it2 = listK.iterator();
            while (it2.hasNext()) {
                collectionEmptyList.add(new ModelEmojiCustom((GuildEmoji) it2.next(), id2));
            }
        } else {
            collectionEmptyList = Collections2.emptyList();
        }
        updateGlobalEmojis(id2, collectionEmptyList);
        updateAllowedGuildEmojis(id2, guildMember.l(), collectionEmptyList);
        return Unit.a;
    }

    @Store3
    public final void handleGuildMemberAdd(com.discord.api.guildmember.GuildMember member) {
        Collection<ModelEmojiCustom> collectionValues;
        Intrinsics3.checkNotNullParameter(member, "member");
        if (member.getUser().getId() == this.me) {
            long guildId = member.getGuildId();
            Map<Long, ModelEmojiCustom> map = this.allGuildEmoji.get(Long.valueOf(guildId));
            if (map == null || (collectionValues = map.values()) == null) {
                return;
            }
            updateAllowedGuildEmojis(guildId, member.l(), collectionValues);
        }
    }

    @Store3
    public final void handleGuildRemove(Guild guild) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        long id2 = guild.getId();
        if (this.allowedGuildEmojis.containsKey(Long.valueOf(id2))) {
            this.allowedGuildEmojis.remove(Long.valueOf(id2));
            markChanged();
        }
        if (this.allGuildEmoji.containsKey(Long.valueOf(id2))) {
            this.allGuildEmoji.remove(Long.valueOf(id2));
            markChanged();
        }
    }

    public final Observable<Map<Long, Map<Long, ModelEmojiCustom>>> observeAllowedGuildEmoji() {
        return this.allowedGuildEmojiPersister.getObservable();
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Long, Map<Long, ModelEmojiCustom>> entry : this.allGuildEmoji.entrySet()) {
            linkedHashMap.put(Long.valueOf(entry.getKey().longValue()), Maps6.toMap(entry.getValue()));
        }
        this.allGuildEmojiSnapshot = linkedHashMap;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry<Long, Map<Long, Map<Long, ModelEmojiCustom>>> entry2 : this.allowedGuildEmojis.entrySet()) {
            long jLongValue = entry2.getKey().longValue();
            Map<Long, Map<Long, ModelEmojiCustom>> value = entry2.getValue();
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            Iterator<Map.Entry<Long, Map<Long, ModelEmojiCustom>>> it = value.entrySet().iterator();
            while (it.hasNext()) {
                linkedHashMap3.putAll(it.next().getValue());
            }
            linkedHashMap2.put(Long.valueOf(jLongValue), linkedHashMap3);
        }
        Persister.set$default(this.allowedGuildEmojiPersister, linkedHashMap2, false, 2, null);
    }
}
