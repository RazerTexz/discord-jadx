package com.discord.utilities.guildscheduledevent;

import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventStatus;
import java.util.Comparator;
import kotlin.Metadata;

/* compiled from: GuildScheduledEventUtilities.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/discord/utilities/guildscheduledevent/GuildScheduledEventsComparator;", "Ljava/util/Comparator;", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "Lkotlin/Comparator;", "o1", "o2", "", "compare", "(Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;)I", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.guildscheduledevent.GuildScheduledEventsComparator, reason: use source file name */
/* loaded from: classes2.dex */
public final class GuildScheduledEventUtilities6 implements Comparator<GuildScheduledEvent> {
    public static final GuildScheduledEventUtilities6 INSTANCE = new GuildScheduledEventUtilities6();

    private GuildScheduledEventUtilities6() {
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(GuildScheduledEvent guildScheduledEvent, GuildScheduledEvent guildScheduledEvent2) {
        return compare2(guildScheduledEvent, guildScheduledEvent2);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001b  */
    /* renamed from: compare, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int compare2(GuildScheduledEvent o1, GuildScheduledEvent o2) {
        GuildScheduledEventStatus status = o1 != null ? o1.getStatus() : null;
        GuildScheduledEventStatus guildScheduledEventStatus = GuildScheduledEventStatus.ACTIVE;
        if (status != guildScheduledEventStatus) {
            if ((o1 != null ? o1.getStatus() : null) != guildScheduledEventStatus) {
                if ((o2 != null ? o2.getStatus() : null) == guildScheduledEventStatus) {
                    return 1;
                }
            }
            if (o1 != null && o2 != null) {
                return o1.getScheduledStartTime().f(o2.getScheduledStartTime());
            }
            if (o1 == null) {
                return 1;
            }
            if (o2 != null) {
                return 0;
            }
        } else {
            if ((o2 != null ? o2.getStatus() : null) == guildScheduledEventStatus) {
            }
        }
        return -1;
    }
}
