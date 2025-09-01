package com.discord.stores;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelInvite;
import com.discord.models.experiments.domain.Experiment;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreInstantInvites;
import com.discord.stores.StoreStream;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.functions.Func2;
import rx.subjects.BehaviorSubject;

/* compiled from: StoreInviteSettings.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 :2\u00020\u0001:\u0002:;B\u0007¢\u0006\u0004\b9\u0010\u0010J\u0015\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J/\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0010\b\u0002\u0010\u000b\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0002¢\u0006\u0004\b\u0012\u0010\u0005J%\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\u0010\u0014\u001a\u00060\tj\u0002`\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0002¢\u0006\u0004\b\u001b\u0010\u0005J\u0019\u0010\u001c\u001a\u00020\f2\n\u0010\u0014\u001a\u00060\tj\u0002`\u0013¢\u0006\u0004\b\u001c\u0010\u001dJ1\u0010$\u001a\u00020\f2\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030\u001e2\u0014\u0010!\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0012\u0004\u0012\u00020\f0 H\u0000¢\u0006\u0004\b\"\u0010#J\u0015\u0010&\u001a\u00020\f2\u0006\u0010%\u001a\u00020\u0011¢\u0006\u0004\b&\u0010'J/\u0010+\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\tj\u0002`)\u0012\u0004\u0012\u00020*0(0\u00022\n\u0010\u0014\u001a\u00060\tj\u0002`\u0013¢\u0006\u0004\b+\u0010,J+\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00022\n\u0010-\u001a\u00060\tj\u0002`)2\b\b\u0002\u0010%\u001a\u00020\u0011H\u0007¢\u0006\u0004\b.\u0010/J!\u00100\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u00022\n\u0010\u0014\u001a\u00060\tj\u0002`\u0013¢\u0006\u0004\b0\u0010,J\u0019\u0010\u0012\u001a\u00020\u00112\n\u0010\u0014\u001a\u00060\tj\u0002`\u0013¢\u0006\u0004\b\u0012\u00101R\u0016\u00102\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R.\u00106\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0003 5*\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u000104048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R:\u00108\u001a&\u0012\f\u0012\n 5*\u0004\u0018\u00010\u00110\u0011 5*\u0012\u0012\f\u0012\n 5*\u0004\u0018\u00010\u00110\u0011\u0018\u000104048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00107¨\u0006<"}, d2 = {"Lcom/discord/stores/StoreInviteSettings;", "Lcom/discord/stores/Store;", "Lrx/Observable;", "Lcom/discord/stores/StoreInviteSettings$InviteCode;", "getInviteCode", "()Lrx/Observable;", "", "inviteCode", "source", "", "Lcom/discord/primitives/GuildScheduledEventId;", "eventId", "", "setInviteCode", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "clearInviteCode", "()V", "Lcom/discord/models/domain/ModelInvite$Settings;", "getInviteSettings", "Lcom/discord/primitives/GuildId;", "guildId", "", "trackExposure", "Lcom/discord/models/experiments/domain/Experiment;", "getInviteGuildExperiment", "(JZ)Lcom/discord/models/experiments/domain/Experiment;", "Lcom/discord/models/domain/ModelInvite;", "getInvite", "handleGuildSelected", "(J)V", "Ljava/lang/Class;", "clazz", "Lkotlin/Function1;", "trackBlock", "trackWithInvite$app_productionGoogleRelease", "(Ljava/lang/Class;Lkotlin/jvm/functions/Function1;)V", "trackWithInvite", "settings", "setInviteSettings", "(Lcom/discord/models/domain/ModelInvite$Settings;)V", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/channel/Channel;", "getInvitableChannels", "(J)Lrx/Observable;", "channelId", "generateInvite", "(JLcom/discord/models/domain/ModelInvite$Settings;)Lrx/Observable;", "generateInviteDefaultChannel", "(J)Lcom/discord/models/domain/ModelInvite$Settings;", "inviteSettings", "Lcom/discord/models/domain/ModelInvite$Settings;", "Lrx/subjects/BehaviorSubject;", "kotlin.jvm.PlatformType", "pendingInviteCodeSubject", "Lrx/subjects/BehaviorSubject;", "inviteSettingsSubject", "<init>", "Companion", "InviteCode", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreInviteSettings extends Store {
    public static final String LOCATION_DEEPLINK = "Deeplink";
    public static final String LOCATION_JOIN = "Join Guild Modal";
    private ModelInvite.Settings inviteSettings = new ModelInvite.Settings(86400);
    private final BehaviorSubject<InviteCode> pendingInviteCodeSubject = BehaviorSubject.l0(null);
    private final BehaviorSubject<ModelInvite.Settings> inviteSettingsSubject = BehaviorSubject.l0(this.inviteSettings);

    /* compiled from: StoreInviteSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u000e\u0010\f\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0018\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ6\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\u0010\b\u0002\u0010\f\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0012J \u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eR\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001f\u001a\u0004\b \u0010\u0004R!\u0010\f\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010!\u001a\u0004\b\"\u0010\tR\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u001f\u001a\u0004\b#\u0010\u0004¨\u0006&"}, d2 = {"Lcom/discord/stores/StoreInviteSettings$InviteCode;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "", "Lcom/discord/primitives/GuildScheduledEventId;", "component3", "()Ljava/lang/Long;", "inviteCode", "source", "eventId", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/discord/stores/StoreInviteSettings$InviteCode;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getSource", "Ljava/lang/Long;", "getEventId", "getInviteCode", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class InviteCode implements Parcelable {
        public static final Parcelable.Creator<InviteCode> CREATOR = new Creator();
        private final Long eventId;
        private final String inviteCode;
        private final String source;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<InviteCode> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final InviteCode createFromParcel(Parcel parcel) {
                Intrinsics3.checkNotNullParameter(parcel, "in");
                return new InviteCode(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ InviteCode createFromParcel(Parcel parcel) {
                return createFromParcel(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final InviteCode[] newArray(int i) {
                return new InviteCode[i];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ InviteCode[] newArray(int i) {
                return newArray(i);
            }
        }

        public InviteCode(String str, String str2, Long l) {
            Intrinsics3.checkNotNullParameter(str, "inviteCode");
            Intrinsics3.checkNotNullParameter(str2, "source");
            this.inviteCode = str;
            this.source = str2;
            this.eventId = l;
        }

        public static /* synthetic */ InviteCode copy$default(InviteCode inviteCode, String str, String str2, Long l, int i, Object obj) {
            if ((i & 1) != 0) {
                str = inviteCode.inviteCode;
            }
            if ((i & 2) != 0) {
                str2 = inviteCode.source;
            }
            if ((i & 4) != 0) {
                l = inviteCode.eventId;
            }
            return inviteCode.copy(str, str2, l);
        }

        /* renamed from: component1, reason: from getter */
        public final String getInviteCode() {
            return this.inviteCode;
        }

        /* renamed from: component2, reason: from getter */
        public final String getSource() {
            return this.source;
        }

        /* renamed from: component3, reason: from getter */
        public final Long getEventId() {
            return this.eventId;
        }

        public final InviteCode copy(String inviteCode, String source, Long eventId) {
            Intrinsics3.checkNotNullParameter(inviteCode, "inviteCode");
            Intrinsics3.checkNotNullParameter(source, "source");
            return new InviteCode(inviteCode, source, eventId);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InviteCode)) {
                return false;
            }
            InviteCode inviteCode = (InviteCode) other;
            return Intrinsics3.areEqual(this.inviteCode, inviteCode.inviteCode) && Intrinsics3.areEqual(this.source, inviteCode.source) && Intrinsics3.areEqual(this.eventId, inviteCode.eventId);
        }

        public final Long getEventId() {
            return this.eventId;
        }

        public final String getInviteCode() {
            return this.inviteCode;
        }

        public final String getSource() {
            return this.source;
        }

        public int hashCode() {
            String str = this.inviteCode;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.source;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            Long l = this.eventId;
            return iHashCode2 + (l != null ? l.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("InviteCode(inviteCode=");
            sbU.append(this.inviteCode);
            sbU.append(", source=");
            sbU.append(this.source);
            sbU.append(", eventId=");
            return outline.G(sbU, this.eventId, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics3.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.inviteCode);
            parcel.writeString(this.source);
            Long l = this.eventId;
            if (l == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeLong(l.longValue());
            }
        }
    }

    /* compiled from: StoreInviteSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0003\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00060\u00062.\u0010\u0005\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003 \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/channel/Channel;", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Ljava/util/Collection;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreInviteSettings$generateInviteDefaultChannel$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Map<Long, ? extends Channel>, Collection<? extends Channel>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Collection<? extends Channel> call(Map<Long, ? extends Channel> map) {
            return call2((Map<Long, Channel>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Collection<Channel> call2(Map<Long, Channel> map) {
            return map.values();
        }
    }

    /* compiled from: StoreInviteSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00040\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/discord/api/channel/Channel;", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Collection;)Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreInviteSettings$generateInviteDefaultChannel$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements Func1<Collection<? extends Channel>, List<? extends Channel>> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ List<? extends Channel> call(Collection<? extends Channel> collection) {
            return call2((Collection<Channel>) collection);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final List<Channel> call2(Collection<Channel> collection) {
            Intrinsics3.checkNotNullExpressionValue(collection, "it");
            return _Collections.sortedWith(collection, ChannelUtils.h(Channel.INSTANCE));
        }
    }

    /* compiled from: StoreInviteSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/discord/api/channel/Channel;", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Ljava/util/List;)Ljava/lang/Long;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreInviteSettings$generateInviteDefaultChannel$3, reason: invalid class name */
    public static final class AnonymousClass3<T, R> implements Func1<List<? extends Channel>, Long> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Long call(List<? extends Channel> list) {
            return call2((List<Channel>) list);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Long call2(List<Channel> list) {
            Intrinsics3.checkNotNullExpressionValue(list, "it");
            Channel channel = (Channel) _Collections.firstOrNull((List) list);
            if (channel != null) {
                return Long.valueOf(channel.getId());
            }
            return null;
        }
    }

    /* compiled from: StoreInviteSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u001e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0003 \u0004*\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "channelId", "Lrx/Observable;", "Lcom/discord/models/domain/ModelInvite;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Long;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreInviteSettings$generateInviteDefaultChannel$4, reason: invalid class name */
    public static final class AnonymousClass4<T, R> implements Func1<Long, Observable<? extends ModelInvite>> {
        public final /* synthetic */ long $guildId;

        public AnonymousClass4(long j) {
            this.$guildId = j;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends ModelInvite> call(Long l) {
            return call2(l);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends ModelInvite> call2(Long l) {
            if (l != null) {
                long jLongValue = l.longValue();
                StoreInviteSettings storeInviteSettings = StoreInviteSettings.this;
                Observable<ModelInvite> observableGenerateInvite = storeInviteSettings.generateInvite(jLongValue, storeInviteSettings.getInviteSettings(this.$guildId));
                if (observableGenerateInvite != null) {
                    return observableGenerateInvite;
                }
            }
            return new ScalarSynchronousObservable(null);
        }
    }

    /* compiled from: StoreInviteSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u000b\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003 \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00000\u00002.\u0010\u0005\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003 \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00000\u00002V\u0010\b\u001aR\u0012\b\u0012\u00060\u0001j\u0002`\u0006\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0001j\u0002`\u00070\u0000 \u0004*(\u0012\b\u0012\u00060\u0001j\u0002`\u0006\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0001j\u0002`\u00070\u0000\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/channel/Channel;", "kotlin.jvm.PlatformType", "channels", "Lcom/discord/primitives/GuildId;", "Lcom/discord/api/permission/PermissionBit;", ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS, NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;Ljava/util/Map;)Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreInviteSettings$getInvitableChannels$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, R> implements Func2<Map<Long, ? extends Channel>, Map<Long, ? extends Map<Long, ? extends Long>>, Map<Long, ? extends Channel>> {
        public final /* synthetic */ long $guildId;

        public AnonymousClass1(long j) {
            this.$guildId = j;
        }

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ Map<Long, ? extends Channel> call(Map<Long, ? extends Channel> map, Map<Long, ? extends Map<Long, ? extends Long>> map2) {
            return call2((Map<Long, Channel>) map, (Map<Long, ? extends Map<Long, Long>>) map2);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Map<Long, Channel> call2(Map<Long, Channel> map, Map<Long, ? extends Map<Long, Long>> map2) {
            HashMap map3 = new HashMap();
            Map<Long, Long> map4 = map2.get(Long.valueOf(this.$guildId));
            if (map4 != null) {
                for (Map.Entry<Long, Long> entry : map4.entrySet()) {
                    long jLongValue = entry.getKey().longValue();
                    long jLongValue2 = entry.getValue().longValue();
                    Channel channel = map.get(Long.valueOf(jLongValue));
                    if (channel != null) {
                        Intrinsics3.checkNotNullParameter(channel, "$this$isInvitableChannel");
                        if ((ChannelUtils.v(channel) || ChannelUtils.w(channel)) && PermissionUtils.INSTANCE.hasAccess(channel, Long.valueOf(jLongValue2)) && PermissionUtils.can(1L, Long.valueOf(jLongValue2))) {
                            map3.put(Long.valueOf(jLongValue), channel);
                        }
                    }
                }
            }
            return map3;
        }
    }

    /* compiled from: StoreInviteSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u001e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0003 \u0004*\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/stores/StoreInviteSettings$InviteCode;", "inviteCode", "Lrx/Observable;", "Lcom/discord/stores/StoreInstantInvites$InviteState;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/stores/StoreInviteSettings$InviteCode;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreInviteSettings$getInvite$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<InviteCode, Observable<? extends StoreInstantInvites.InviteState>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends StoreInstantInvites.InviteState> call(InviteCode inviteCode) {
            return call2(inviteCode);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends StoreInstantInvites.InviteState> call2(InviteCode inviteCode) {
            return inviteCode == null ? new ScalarSynchronousObservable(null) : StoreStream.INSTANCE.getInstantInvites().observeInvite(ModelInvite.getInviteStoreKey(inviteCode.getInviteCode(), inviteCode.getEventId()));
        }
    }

    /* compiled from: StoreInviteSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/stores/StoreInstantInvites$InviteState;", "inviteState", "Lcom/discord/models/domain/ModelInvite;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/stores/StoreInstantInvites$InviteState;)Lcom/discord/models/domain/ModelInvite;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreInviteSettings$getInvite$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements Func1<StoreInstantInvites.InviteState, ModelInvite> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ ModelInvite call(StoreInstantInvites.InviteState inviteState) {
            return call2(inviteState);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final ModelInvite call2(StoreInstantInvites.InviteState inviteState) {
            if (inviteState instanceof StoreInstantInvites.InviteState.Resolved) {
                return ((StoreInstantInvites.InviteState.Resolved) inviteState).getInvite();
            }
            return null;
        }
    }

    public static /* synthetic */ Observable generateInvite$default(StoreInviteSettings storeInviteSettings, long j, ModelInvite.Settings settings, int i, Object obj) {
        if ((i & 2) != 0) {
            settings = storeInviteSettings.inviteSettings;
        }
        return storeInviteSettings.generateInvite(j, settings);
    }

    public static /* synthetic */ Experiment getInviteGuildExperiment$default(StoreInviteSettings storeInviteSettings, long j, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        return storeInviteSettings.getInviteGuildExperiment(j, z2);
    }

    public static /* synthetic */ void setInviteCode$default(StoreInviteSettings storeInviteSettings, String str, String str2, Long l, int i, Object obj) {
        if ((i & 4) != 0) {
            l = null;
        }
        storeInviteSettings.setInviteCode(str, str2, l);
    }

    public final void clearInviteCode() {
        this.pendingInviteCodeSubject.onNext(null);
    }

    public final Observable<ModelInvite> generateInvite(long j) {
        return generateInvite$default(this, j, null, 2, null);
    }

    public final synchronized Observable<ModelInvite> generateInvite(long channelId, ModelInvite.Settings settings) {
        Intrinsics3.checkNotNullParameter(settings, "settings");
        return ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().postChannelInvite(channelId, new RestAPIParams.Invite(settings.getMaxAge(), settings.getMaxUses(), settings.isTemporary(), null)), false, 1, null);
    }

    public final Observable<ModelInvite> generateInviteDefaultChannel(long guildId) {
        Observable<ModelInvite> observableA = getInvitableChannels(guildId).G(AnonymousClass1.INSTANCE).G(AnonymousClass2.INSTANCE).G(AnonymousClass3.INSTANCE).Z(1).A(new AnonymousClass4(guildId));
        Intrinsics3.checkNotNullExpressionValue(observableA, "getInvitableChannels(gui…le.just(null)\n          }");
        return observableA;
    }

    public final Observable<Map<Long, Channel>> getInvitableChannels(long guildId) {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable<Map<Long, Channel>> observableJ = Observable.j(companion.getChannels().observeGuildAndPrivateChannels(), companion.getPermissions().observeAllPermissions(), new AnonymousClass1(guildId));
        Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable\n        .comb…  }\n          }\n        }");
        return observableJ;
    }

    public final Observable<ModelInvite> getInvite() {
        Observable<ModelInvite> observableG = getInviteCode().A(AnonymousClass1.INSTANCE).G(AnonymousClass2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "getInviteCode()\n      .f…-> null\n        }\n      }");
        return observableG;
    }

    public final Observable<InviteCode> getInviteCode() {
        Observable<InviteCode> observableR = this.pendingInviteCodeSubject.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "pendingInviteCodeSubject.distinctUntilChanged()");
        return observableR;
    }

    public final Experiment getInviteGuildExperiment(long guildId, boolean trackExposure) {
        return StoreStream.INSTANCE.getExperiments().getGuildExperiment("2021-03_android_extend_invite_expiration", guildId, trackExposure);
    }

    public final Observable<ModelInvite.Settings> getInviteSettings() {
        BehaviorSubject<ModelInvite.Settings> behaviorSubject = this.inviteSettingsSubject;
        Intrinsics3.checkNotNullExpressionValue(behaviorSubject, "inviteSettingsSubject");
        Observable<ModelInvite.Settings> observableR = ObservableExtensionsKt.computationLatest(behaviorSubject).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "inviteSettingsSubject\n  …  .distinctUntilChanged()");
        return observableR;
    }

    public final void handleGuildSelected(long guildId) {
        setInviteSettings(getInviteSettings(guildId));
    }

    public final void setInviteCode(String inviteCode, String source, Long eventId) {
        Intrinsics3.checkNotNullParameter(inviteCode, "inviteCode");
        Intrinsics3.checkNotNullParameter(source, "source");
        this.pendingInviteCodeSubject.onNext(new InviteCode(inviteCode, source, eventId));
    }

    public final synchronized void setInviteSettings(ModelInvite.Settings settings) {
        Intrinsics3.checkNotNullParameter(settings, "settings");
        this.inviteSettings = settings;
        this.inviteSettingsSubject.onNext(settings);
    }

    public final void trackWithInvite$app_productionGoogleRelease(Class<?> clazz, Function1<? super ModelInvite, Unit> trackBlock) {
        Intrinsics3.checkNotNullParameter(clazz, "clazz");
        Intrinsics3.checkNotNullParameter(trackBlock, "trackBlock");
        Observable<ModelInvite> observableY = getInvite().y(StoreInviteSettings2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableY, "getInvite()\n        .filter { it != null }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationLatest(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableY, 250L, false, 2, null)), clazz, (Context) null, (Function1) null, new StoreInviteSettings3(trackBlock), (Function0) null, (Function0) null, trackBlock, 54, (Object) null);
    }

    public final ModelInvite.Settings getInviteSettings(long guildId) {
        Experiment inviteGuildExperiment$default = getInviteGuildExperiment$default(this, guildId, false, 2, null);
        if (inviteGuildExperiment$default != null && inviteGuildExperiment$default.getBucket() == 1) {
            return new ModelInvite.Settings(ModelInvite.Settings.SEVEN_DAYS);
        }
        return new ModelInvite.Settings(86400);
    }
}
