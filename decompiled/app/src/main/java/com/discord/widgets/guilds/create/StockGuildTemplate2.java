package com.discord.widgets.guilds.create;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: StockGuildTemplate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u000f\u0010B!\b\u0002\u0012\u000e\u0010\t\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R!\u0010\t\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u0082\u0001\u0002\u0011\u0012¨\u0006\u0013"}, d2 = {"Lcom/discord/widgets/guilds/create/ChannelTemplate;", "", "", ModelAuditLogEntry.CHANGE_KEY_NAME, "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "", "Lcom/discord/primitives/ChannelId;", ModelAuditLogEntry.CHANGE_KEY_ID, "Ljava/lang/Long;", "getId", "()Ljava/lang/Long;", "<init>", "(Ljava/lang/Long;Ljava/lang/String;)V", "NormalChannel", "SystemChannel", "Lcom/discord/widgets/guilds/create/ChannelTemplate$NormalChannel;", "Lcom/discord/widgets/guilds/create/ChannelTemplate$SystemChannel;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guilds.create.ChannelTemplate, reason: use source file name */
/* loaded from: classes2.dex */
public abstract class StockGuildTemplate2 {
    private final Long id;
    private final String name;

    /* compiled from: StockGuildTemplate.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/widgets/guilds/create/ChannelTemplate$NormalChannel;", "Lcom/discord/widgets/guilds/create/ChannelTemplate;", "", ModelAuditLogEntry.CHANGE_KEY_NAME, "<init>", "(Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.create.ChannelTemplate$NormalChannel */
    public static final class NormalChannel extends StockGuildTemplate2 {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NormalChannel(String str) {
            super(null, str, null);
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        }
    }

    /* compiled from: StockGuildTemplate.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/widgets/guilds/create/ChannelTemplate$SystemChannel;", "Lcom/discord/widgets/guilds/create/ChannelTemplate;", "", ModelAuditLogEntry.CHANGE_KEY_NAME, "<init>", "(Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.create.ChannelTemplate$SystemChannel */
    public static final class SystemChannel extends StockGuildTemplate2 {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SystemChannel(String str) {
            super(11L, str, null);
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        }
    }

    private StockGuildTemplate2(Long l, String str) {
        this.id = l;
        this.name = str;
    }

    public final Long getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public /* synthetic */ StockGuildTemplate2(Long l, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(l, str);
    }
}
