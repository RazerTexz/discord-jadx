package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.Parser;
import com.discord.utilities.textprocessing.AstRenderer;
import com.discord.utilities.textprocessing.MessageParseState;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventLocationInfo;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: GuildScheduledEventExternalLocationParser.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0002\u0013\u0012B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventExternalLocationParser;", "", "Landroid/content/Context;", "context", "", ModelAuditLogEntry.CHANGE_KEY_LOCATION, "", "parse", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/CharSequence;", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventLocationInfo;", "locationInfo", "getTextFromLocation", "(Landroid/content/Context;Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventLocationInfo;)Ljava/lang/CharSequence;", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventExternalLocationParser$Cache;", "cache", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventExternalLocationParser$Cache;", "<init>", "()V", "Companion", "Cache", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GuildScheduledEventExternalLocationParser {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy PARSER$delegate = LazyJVM.lazy(GuildScheduledEventExternalLocationParser2.INSTANCE);
    private Cache cache = new Cache("", "");

    /* compiled from: GuildScheduledEventExternalLocationParser.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004¨\u0006\u001a"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventExternalLocationParser$Cache;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/lang/CharSequence;", ModelAuditLogEntry.CHANGE_KEY_LOCATION, "output", "copy", "(Ljava/lang/String;Ljava/lang/CharSequence;)Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventExternalLocationParser$Cache;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/CharSequence;", "getOutput", "Ljava/lang/String;", "getLocation", "<init>", "(Ljava/lang/String;Ljava/lang/CharSequence;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Cache {
        private final String location;
        private final CharSequence output;

        public Cache(String str, CharSequence charSequence) {
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
            Intrinsics3.checkNotNullParameter(charSequence, "output");
            this.location = str;
            this.output = charSequence;
        }

        public static /* synthetic */ Cache copy$default(Cache cache, String str, CharSequence charSequence, int i, Object obj) {
            if ((i & 1) != 0) {
                str = cache.location;
            }
            if ((i & 2) != 0) {
                charSequence = cache.output;
            }
            return cache.copy(str, charSequence);
        }

        /* renamed from: component1, reason: from getter */
        public final String getLocation() {
            return this.location;
        }

        /* renamed from: component2, reason: from getter */
        public final CharSequence getOutput() {
            return this.output;
        }

        public final Cache copy(String location, CharSequence output) {
            Intrinsics3.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
            Intrinsics3.checkNotNullParameter(output, "output");
            return new Cache(location, output);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Cache)) {
                return false;
            }
            Cache cache = (Cache) other;
            return Intrinsics3.areEqual(this.location, cache.location) && Intrinsics3.areEqual(this.output, cache.output);
        }

        public final String getLocation() {
            return this.location;
        }

        public final CharSequence getOutput() {
            return this.output;
        }

        public int hashCode() {
            String str = this.location;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            CharSequence charSequence = this.output;
            return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Cache(location=");
            sbU.append(this.location);
            sbU.append(", output=");
            return outline.E(sbU, this.output, ")");
        }
    }

    /* compiled from: GuildScheduledEventExternalLocationParser.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR5\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0004\u0012\u0004\u0012\u00020\u00050\u00028B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventExternalLocationParser$Companion;", "", "Lcom/discord/simpleast/core/parser/Parser;", "Lcom/discord/utilities/textprocessing/MessageRenderContext;", "Lcom/discord/simpleast/core/node/Node;", "Lcom/discord/utilities/textprocessing/MessageParseState;", "PARSER$delegate", "Lkotlin/Lazy;", "getPARSER", "()Lcom/discord/simpleast/core/parser/Parser;", "PARSER", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Parser access$getPARSER$p(Companion companion) {
            return companion.getPARSER();
        }

        private final Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> getPARSER() {
            Lazy lazyAccess$getPARSER$cp = GuildScheduledEventExternalLocationParser.access$getPARSER$cp();
            Companion companion = GuildScheduledEventExternalLocationParser.INSTANCE;
            return (Parser) lazyAccess$getPARSER$cp.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final /* synthetic */ Lazy access$getPARSER$cp() {
        return PARSER$delegate;
    }

    private final CharSequence parse(Context context, String location) {
        if (Intrinsics3.areEqual(this.cache.getLocation(), location)) {
            return this.cache.getOutput();
        }
        DraweeSpanStringBuilder draweeSpanStringBuilderRender = AstRenderer.render(Parser.parse$default(Companion.access$getPARSER$p(INSTANCE), location, MessageParseState.INSTANCE.getInitialState(), null, 4, null), new MessageRenderContext(context, 0L, false, null, null, null, 0, null, null, 0, 0, null, null, null, 16376, null));
        this.cache = new Cache(location, draweeSpanStringBuilderRender);
        return draweeSpanStringBuilderRender;
    }

    public final CharSequence getTextFromLocation(Context context, GuildScheduledEventLocationInfo locationInfo) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(locationInfo, "locationInfo");
        if (locationInfo instanceof GuildScheduledEventLocationInfo.ChannelLocation) {
            return locationInfo.getLocationName();
        }
        if (locationInfo instanceof GuildScheduledEventLocationInfo.ExternalLocation) {
            return parse(context, locationInfo.getLocationName());
        }
        throw new NoWhenBranchMatchedException();
    }
}
