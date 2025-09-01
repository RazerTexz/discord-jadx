package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.member.GuildMember;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.Parser;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.textprocessing.MessageParseState;
import com.discord.utilities.textprocessing.MessagePreprocessor;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.textprocessing.TagsBuilder;
import com.discord.utilities.textprocessing.TagsBuilder2;
import com.discord.utilities.textprocessing.node.SpoilerNode;
import com.discord.utilities.view.text.LinkifiedTextView;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Func2;
import rx.functions.Func3;

/* compiled from: GuildScheduledEventDescriptionParser.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 (2\u00020\u0001:\u0003()*B\u000f\u0012\u0006\u0010%\u001a\u00020\"¢\u0006\u0004\b&\u0010'J!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\u000f\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0018\u00010\u000bj\u0004\u0018\u0001`\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0014\u001a\u00020\u00132\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u00112\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J5\u0010\u001a\u001a\u00020\u00132\u0016\u0010\u0016\u001a\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bj\u0002`\u000e2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ#\u0010\u001c\u001a\u00020\u00132\b\u0010\n\u001a\u0004\u0018\u00010\t2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006+"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDescriptionParser;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lrx/Observable;", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDescriptionParser$MessageRenderContextModel;", "getRenderContext", "(J)Lrx/Observable;", "", ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, "", "Lcom/discord/simpleast/core/node/Node;", "Lcom/discord/utilities/textprocessing/MessageRenderContext;", "Lcom/discord/widgets/guildscheduledevent/DescriptionAST;", "parseAndSaveDescription", "(Ljava/lang/String;)Ljava/util/List;", "Lcom/discord/utilities/textprocessing/node/SpoilerNode;", "spoilerNode", "", "handleSpoilerClicked", "(Lcom/discord/utilities/textprocessing/node/SpoilerNode;J)V", "ast", "", "", "visibleSpoilerNodeIndices", "updateAstForSpoiler", "(Ljava/util/List;Ljava/util/Set;)V", "configureDescription", "(Ljava/lang/String;J)V", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDescriptionParser$DescriptionCache;", "savedDescriptionCache", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDescriptionParser$DescriptionCache;", "Ljava/lang/ref/WeakReference;", "Lcom/discord/utilities/view/text/LinkifiedTextView;", "weakRefTextView", "Ljava/lang/ref/WeakReference;", "textView", "<init>", "(Lcom/discord/utilities/view/text/LinkifiedTextView;)V", "Companion", "DescriptionCache", "MessageRenderContextModel", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GuildScheduledEventDescriptionParser {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy INSTANCE$delegate = LazyJVM.lazy(GuildScheduledEventDescriptionParser3.INSTANCE);
    private DescriptionCache savedDescriptionCache;
    private final WeakReference<LinkifiedTextView> weakRefTextView;

    /* compiled from: GuildScheduledEventDescriptionParser.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR5\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0004\u0012\u0004\u0012\u00020\u00050\u00028B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDescriptionParser$Companion;", "", "Lcom/discord/simpleast/core/parser/Parser;", "Lcom/discord/utilities/textprocessing/MessageRenderContext;", "Lcom/discord/simpleast/core/node/Node;", "Lcom/discord/utilities/textprocessing/MessageParseState;", "INSTANCE$delegate", "Lkotlin/Lazy;", "getINSTANCE", "()Lcom/discord/simpleast/core/parser/Parser;", "INSTANCE", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Parser access$getINSTANCE$p(Companion companion) {
            return companion.getINSTANCE();
        }

        private final Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> getINSTANCE() {
            Lazy lazyAccess$getINSTANCE$cp = GuildScheduledEventDescriptionParser.access$getINSTANCE$cp();
            Companion companion = GuildScheduledEventDescriptionParser.INSTANCE;
            return (Parser) lazyAccess$getINSTANCE$cp.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: GuildScheduledEventDescriptionParser.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0002\u0011\u0012B/\b\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u001a\u0010\u000b\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\u0007j\u0004\u0018\u0001`\n¢\u0006\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R-\u0010\u000b\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\u0007j\u0004\u0018\u0001`\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u0082\u0001\u0002\u0013\u0014¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDescriptionParser$DescriptionCache;", "", "", "maybeDescription", "Ljava/lang/String;", "getMaybeDescription", "()Ljava/lang/String;", "", "Lcom/discord/simpleast/core/node/Node;", "Lcom/discord/utilities/textprocessing/MessageRenderContext;", "Lcom/discord/widgets/guildscheduledevent/DescriptionAST;", "maybeAst", "Ljava/util/List;", "getMaybeAst", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "HasDescription", "NoDescription", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDescriptionParser$DescriptionCache$HasDescription;", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDescriptionParser$DescriptionCache$NoDescription;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class DescriptionCache {
        private final List<Node<MessageRenderContext>> maybeAst;
        private final String maybeDescription;

        /* compiled from: GuildScheduledEventDescriptionParser.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0016\u0010\u0010\u001a\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005j\u0002`\b\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005j\u0002`\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJD\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\u0018\b\u0002\u0010\u0010\u001a\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005j\u0002`\b2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u001f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\u001f\u0010\u000eR)\u0010\u0010\u001a\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005j\u0002`\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b!\u0010\n¨\u0006$"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDescriptionParser$DescriptionCache$HasDescription;", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDescriptionParser$DescriptionCache;", "", "component1", "()Ljava/lang/String;", "", "Lcom/discord/simpleast/core/node/Node;", "Lcom/discord/utilities/textprocessing/MessageRenderContext;", "Lcom/discord/widgets/guildscheduledevent/DescriptionAST;", "component2", "()Ljava/util/List;", "", "", "component3", "()Ljava/util/Set;", ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, "ast", "shownSpoilerIndices", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/util/Set;)Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDescriptionParser$DescriptionCache$HasDescription;", "toString", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getDescription", "Ljava/util/Set;", "getShownSpoilerIndices", "Ljava/util/List;", "getAst", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/Set;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class HasDescription extends DescriptionCache {
            private final List<Node<MessageRenderContext>> ast;
            private final String description;
            private final Set<Integer> shownSpoilerIndices;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public HasDescription(String str, List<Node<MessageRenderContext>> list, Set<Integer> set) {
                super(str, list, null);
                Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
                Intrinsics3.checkNotNullParameter(list, "ast");
                Intrinsics3.checkNotNullParameter(set, "shownSpoilerIndices");
                this.description = str;
                this.ast = list;
                this.shownSpoilerIndices = set;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ HasDescription copy$default(HasDescription hasDescription, String str, List list, Set set, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = hasDescription.description;
                }
                if ((i & 2) != 0) {
                    list = hasDescription.ast;
                }
                if ((i & 4) != 0) {
                    set = hasDescription.shownSpoilerIndices;
                }
                return hasDescription.copy(str, list, set);
            }

            /* renamed from: component1, reason: from getter */
            public final String getDescription() {
                return this.description;
            }

            public final List<Node<MessageRenderContext>> component2() {
                return this.ast;
            }

            public final Set<Integer> component3() {
                return this.shownSpoilerIndices;
            }

            public final HasDescription copy(String description, List<Node<MessageRenderContext>> ast, Set<Integer> shownSpoilerIndices) {
                Intrinsics3.checkNotNullParameter(description, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
                Intrinsics3.checkNotNullParameter(ast, "ast");
                Intrinsics3.checkNotNullParameter(shownSpoilerIndices, "shownSpoilerIndices");
                return new HasDescription(description, ast, shownSpoilerIndices);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof HasDescription)) {
                    return false;
                }
                HasDescription hasDescription = (HasDescription) other;
                return Intrinsics3.areEqual(this.description, hasDescription.description) && Intrinsics3.areEqual(this.ast, hasDescription.ast) && Intrinsics3.areEqual(this.shownSpoilerIndices, hasDescription.shownSpoilerIndices);
            }

            public final List<Node<MessageRenderContext>> getAst() {
                return this.ast;
            }

            public final String getDescription() {
                return this.description;
            }

            public final Set<Integer> getShownSpoilerIndices() {
                return this.shownSpoilerIndices;
            }

            public int hashCode() {
                String str = this.description;
                int iHashCode = (str != null ? str.hashCode() : 0) * 31;
                List<Node<MessageRenderContext>> list = this.ast;
                int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
                Set<Integer> set = this.shownSpoilerIndices;
                return iHashCode2 + (set != null ? set.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("HasDescription(description=");
                sbU.append(this.description);
                sbU.append(", ast=");
                sbU.append(this.ast);
                sbU.append(", shownSpoilerIndices=");
                return outline.N(sbU, this.shownSpoilerIndices, ")");
            }
        }

        /* compiled from: GuildScheduledEventDescriptionParser.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDescriptionParser$DescriptionCache$NoDescription;", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDescriptionParser$DescriptionCache;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class NoDescription extends DescriptionCache {
            public static final NoDescription INSTANCE = new NoDescription();

            private NoDescription() {
                super(null, null, null);
            }
        }

        private DescriptionCache(String str, List<Node<MessageRenderContext>> list) {
            this.maybeDescription = str;
            this.maybeAst = list;
        }

        public final List<Node<MessageRenderContext>> getMaybeAst() {
            return this.maybeAst;
        }

        public final String getMaybeDescription() {
            return this.maybeDescription;
        }

        public /* synthetic */ DescriptionCache(String str, List list, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, list);
        }
    }

    /* compiled from: GuildScheduledEventDescriptionParser.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0082\b\u0018\u00002\u00020\u0001B[\u0012\u001a\b\u0002\u0010\r\u001a\u0014\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0002\u0012\u001a\b\u0002\u0010\u000e\u001a\u0014\u0012\b\u0012\u00060\u0003j\u0002`\b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0002\u0012\u001a\b\u0002\u0010\u000f\u001a\u0014\u0012\b\u0012\u00060\u0003j\u0002`\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0002¢\u0006\u0004\b\u001f\u0010 J\"\u0010\u0006\u001a\u0014\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\t\u001a\u0014\u0012\b\u0012\u00060\u0003j\u0002`\b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\"\u0010\f\u001a\u0014\u0012\b\u0012\u00060\u0003j\u0002`\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0007Jd\u0010\u0010\u001a\u00020\u00002\u001a\b\u0002\u0010\r\u001a\u0014\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00022\u001a\b\u0002\u0010\u000e\u001a\u0014\u0012\b\u0012\u00060\u0003j\u0002`\b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00022\u001a\b\u0002\u0010\u000f\u001a\u0014\u0012\b\u0012\u00060\u0003j\u0002`\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR+\u0010\u000e\u001a\u0014\u0012\b\u0012\u00060\u0003j\u0002`\b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007R+\u0010\r\u001a\u0014\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001d\u0010\u0007R+\u0010\u000f\u001a\u0014\u0012\b\u0012\u00060\u0003j\u0002`\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b\u001e\u0010\u0007¨\u0006!"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDescriptionParser$MessageRenderContextModel;", "", "", "", "Lcom/discord/primitives/ChannelId;", "", "component1", "()Ljava/util/Map;", "Lcom/discord/primitives/UserId;", "component2", "Lcom/discord/primitives/RoleId;", "Lcom/discord/api/role/GuildRole;", "component3", "channelNames", "userNames", "roles", "copy", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDescriptionParser$MessageRenderContextModel;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getUserNames", "getChannelNames", "getRoles", "<init>", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class MessageRenderContextModel {
        private final Map<Long, String> channelNames;
        private final Map<Long, GuildRole> roles;
        private final Map<Long, String> userNames;

        public MessageRenderContextModel() {
            this(null, null, null, 7, null);
        }

        public MessageRenderContextModel(Map<Long, String> map, Map<Long, String> map2, Map<Long, GuildRole> map3) {
            this.channelNames = map;
            this.userNames = map2;
            this.roles = map3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MessageRenderContextModel copy$default(MessageRenderContextModel messageRenderContextModel, Map map, Map map2, Map map3, int i, Object obj) {
            if ((i & 1) != 0) {
                map = messageRenderContextModel.channelNames;
            }
            if ((i & 2) != 0) {
                map2 = messageRenderContextModel.userNames;
            }
            if ((i & 4) != 0) {
                map3 = messageRenderContextModel.roles;
            }
            return messageRenderContextModel.copy(map, map2, map3);
        }

        public final Map<Long, String> component1() {
            return this.channelNames;
        }

        public final Map<Long, String> component2() {
            return this.userNames;
        }

        public final Map<Long, GuildRole> component3() {
            return this.roles;
        }

        public final MessageRenderContextModel copy(Map<Long, String> channelNames, Map<Long, String> userNames, Map<Long, GuildRole> roles) {
            return new MessageRenderContextModel(channelNames, userNames, roles);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MessageRenderContextModel)) {
                return false;
            }
            MessageRenderContextModel messageRenderContextModel = (MessageRenderContextModel) other;
            return Intrinsics3.areEqual(this.channelNames, messageRenderContextModel.channelNames) && Intrinsics3.areEqual(this.userNames, messageRenderContextModel.userNames) && Intrinsics3.areEqual(this.roles, messageRenderContextModel.roles);
        }

        public final Map<Long, String> getChannelNames() {
            return this.channelNames;
        }

        public final Map<Long, GuildRole> getRoles() {
            return this.roles;
        }

        public final Map<Long, String> getUserNames() {
            return this.userNames;
        }

        public int hashCode() {
            Map<Long, String> map = this.channelNames;
            int iHashCode = (map != null ? map.hashCode() : 0) * 31;
            Map<Long, String> map2 = this.userNames;
            int iHashCode2 = (iHashCode + (map2 != null ? map2.hashCode() : 0)) * 31;
            Map<Long, GuildRole> map3 = this.roles;
            return iHashCode2 + (map3 != null ? map3.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("MessageRenderContextModel(channelNames=");
            sbU.append(this.channelNames);
            sbU.append(", userNames=");
            sbU.append(this.userNames);
            sbU.append(", roles=");
            return outline.M(sbU, this.roles, ")");
        }

        public /* synthetic */ MessageRenderContextModel(Map map, Map map2, Map map3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : map, (i & 2) != 0 ? null : map2, (i & 4) != 0 ? null : map3);
        }
    }

    /* compiled from: GuildScheduledEventDescriptionParser.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\r\u001a¬\u0001\u0012\u0016\u0012\u0014 \u0005*\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00020\u0001j\u0002`\u0002\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00070\u0007 \u0005*V\u0012\u0016\u0012\u0014 \u0005*\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00020\u0001j\u0002`\u0002\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\tj*\u0012\u0016\u0012\u0014 \u0005*\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00020\u0001j\u0002`\u0002\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00070\u0007\u0018\u0001`\n0\tj(\u0012\u0016\u0012\u0014 \u0005*\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00020\u0001j\u0002`\u0002\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00070\u0007`\n26\u0010\u0006\u001a2\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u0004 \u0005*\u0018\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0018\u00010\u00000\u00002.\u0010\b\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0007 \u0005*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/ClientGuildMember;", "kotlin.jvm.PlatformType", "members", "", "usernames", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;Ljava/util/Map;)Ljava/util/HashMap;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventDescriptionParser$getRenderContext$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, R> implements Func2<Map<Long, ? extends GuildMember>, Map<Long, ? extends String>, HashMap<Long, String>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ HashMap<Long, String> call(Map<Long, ? extends GuildMember> map, Map<Long, ? extends String> map2) {
            return call2((Map<Long, GuildMember>) map, (Map<Long, String>) map2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final HashMap<Long, String> call2(Map<Long, GuildMember> map, Map<Long, String> map2) {
            Intrinsics3.checkNotNullExpressionValue(map, "members");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<Long, GuildMember> entry : map.entrySet()) {
                if (entry.getValue().getNick() != null) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            HashMap<Long, String> map3 = new HashMap<>(map2);
            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                Object key = entry2.getKey();
                String nick = ((GuildMember) entry2.getValue()).getNick();
                Intrinsics3.checkNotNull(nick);
                map3.put(key, nick);
            }
            return map3;
        }
    }

    /* compiled from: GuildScheduledEventDescriptionParser.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0010\u001a\n \u0004*\u0004\u0018\u00010\r0\r2.\u0010\u0005\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003 \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00000\u00002±\u0001\u0010\t\u001a¬\u0001\u0012\u0016\u0012\u0014 \u0004*\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00070\u0001j\u0002`\u0007\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*V\u0012\u0016\u0012\u0014 \u0004*\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00070\u0001j\u0002`\u0007\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u0006j*\u0012\u0016\u0012\u0014 \u0004*\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00070\u0001j\u0002`\u0007\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u0001`\b0\u0006j(\u0012\u0016\u0012\u0014 \u0004*\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00070\u0001j\u0002`\u0007\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003`\b2.\u0010\f\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\n\u0012\u0004\u0012\u00020\u000b \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u000e\u0010\u000f"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "", "kotlin.jvm.PlatformType", "channelNames", "Ljava/util/HashMap;", "Lcom/discord/primitives/UserId;", "Lkotlin/collections/HashMap;", "userNames", "Lcom/discord/primitives/RoleId;", "Lcom/discord/api/role/GuildRole;", "roles", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDescriptionParser$MessageRenderContextModel;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;Ljava/util/HashMap;Ljava/util/Map;)Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDescriptionParser$MessageRenderContextModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventDescriptionParser$getRenderContext$2, reason: invalid class name */
    public static final class AnonymousClass2<T1, T2, T3, R> implements Func3<Map<Long, ? extends String>, HashMap<Long, String>, Map<Long, ? extends GuildRole>, MessageRenderContextModel> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // rx.functions.Func3
        public /* bridge */ /* synthetic */ MessageRenderContextModel call(Map<Long, ? extends String> map, HashMap<Long, String> map2, Map<Long, ? extends GuildRole> map3) {
            return call2((Map<Long, String>) map, map2, (Map<Long, GuildRole>) map3);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final MessageRenderContextModel call2(Map<Long, String> map, HashMap<Long, String> map2, Map<Long, GuildRole> map3) {
            return new MessageRenderContextModel(map, map2, map3);
        }
    }

    public GuildScheduledEventDescriptionParser(LinkifiedTextView linkifiedTextView) {
        Intrinsics3.checkNotNullParameter(linkifiedTextView, "textView");
        this.weakRefTextView = new WeakReference<>(linkifiedTextView);
        this.savedDescriptionCache = DescriptionCache.NoDescription.INSTANCE;
    }

    public static final /* synthetic */ Lazy access$getINSTANCE$cp() {
        return INSTANCE$delegate;
    }

    public static final /* synthetic */ void access$handleSpoilerClicked(GuildScheduledEventDescriptionParser guildScheduledEventDescriptionParser, SpoilerNode spoilerNode, long j) {
        guildScheduledEventDescriptionParser.handleSpoilerClicked(spoilerNode, j);
    }

    private final Observable<MessageRenderContextModel> getRenderContext(long guildId) {
        TagsBuilder2 tagsBuilder2Build = new TagsBuilder().build();
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable<MessageRenderContextModel> observableI = Observable.i(companion.getChannels().observeNames(), Observable.j(companion.getGuilds().observeComputed(guildId), companion.getUsers().observeUsernames(tagsBuilder2Build.getUsers()), AnonymousClass1.INSTANCE), companion.getGuilds().observeRoles(guildId), AnonymousClass2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableI, "Observable.combineLatest…      roles\n      )\n    }");
        return observableI;
    }

    private final void handleSpoilerClicked(SpoilerNode<?> spoilerNode, long guildId) {
        DescriptionCache descriptionCache = this.savedDescriptionCache;
        if (!(descriptionCache instanceof DescriptionCache.HasDescription)) {
            descriptionCache = null;
        }
        DescriptionCache.HasDescription hasDescription = (DescriptionCache.HasDescription) descriptionCache;
        if (hasDescription != null) {
            hasDescription.getShownSpoilerIndices().add(Integer.valueOf(spoilerNode.getId()));
            updateAstForSpoiler(hasDescription.getAst(), hasDescription.getShownSpoilerIndices());
            configureDescription(hasDescription.getDescription(), guildId);
        }
    }

    private final List<Node<MessageRenderContext>> parseAndSaveDescription(String description) {
        if (Intrinsics3.areEqual(this.savedDescriptionCache.getMaybeDescription(), description)) {
            return this.savedDescriptionCache.getMaybeAst();
        }
        if (description == null) {
            DescriptionCache.NoDescription noDescription = DescriptionCache.NoDescription.INSTANCE;
            this.savedDescriptionCache = noDescription;
            return noDescription.getMaybeAst();
        }
        DescriptionCache.HasDescription hasDescription = new DescriptionCache.HasDescription(description, Parser.parse$default(Companion.access$getINSTANCE$p(INSTANCE), description, MessageParseState.INSTANCE.getInitialState(), null, 4, null), new LinkedHashSet());
        this.savedDescriptionCache = hasDescription;
        return hasDescription.getMaybeAst();
    }

    private final void updateAstForSpoiler(List<Node<MessageRenderContext>> ast, Set<Integer> visibleSpoilerNodeIndices) {
        new MessagePreprocessor(-1L, visibleSpoilerNodeIndices, null, false, null, 28, null).process(ast);
    }

    public final void configureDescription(String description, long guildId) {
        List<Node<MessageRenderContext>> andSaveDescription = parseAndSaveDescription(description);
        LinkifiedTextView linkifiedTextView = this.weakRefTextView.get();
        if (linkifiedTextView != null) {
            if (andSaveDescription == null || !(!andSaveDescription.isEmpty())) {
                linkifiedTextView.setVisibility(8);
                return;
            }
            linkifiedTextView.setVisibility(0);
            Observable<MessageRenderContextModel> observableZ = getRenderContext(guildId).z();
            Intrinsics3.checkNotNullExpressionValue(observableZ, "getRenderContext(guildId)\n            .first()");
            ObservableExtensionsKt.appSubscribe$default(observableZ, LinkifiedTextView.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new GuildScheduledEventDescriptionParser2(linkifiedTextView, this, andSaveDescription, guildId), 62, (Object) null);
        }
    }
}
