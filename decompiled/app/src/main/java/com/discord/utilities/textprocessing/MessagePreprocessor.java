package com.discord.utilities.textprocessing;

import b.a.t.b.a.TextNode;
import b.a.t.b.c.NodeProcessor;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import com.discord.api.message.embed.MessageEmbed;
import com.discord.simpleast.code.CodeNode;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.StyleNode;
import com.discord.stores.StoreMessageState;
import com.discord.utilities.embed.EmbedResourceUtils;
import com.discord.utilities.textprocessing.node.BasicRenderContext;
import com.discord.utilities.textprocessing.node.BlockQuoteNode;
import com.discord.utilities.textprocessing.node.EmojiNode;
import com.discord.utilities.textprocessing.node.SpoilerNode;
import com.discord.utilities.textprocessing.node.UrlNode;
import d0.g0.StringsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.TypeIntrinsics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: MessagePreprocessor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 <2\u00020\u0001:\u0002<=BM\u0012\n\u0010(\u001a\u00060&j\u0002`'\u0012\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019\u0012\b\b\u0002\u00105\u001a\u00020#\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010,¢\u0006\u0004\b6\u00107B\u001f\b\u0016\u0012\n\u0010(\u001a\u00060&j\u0002`'\u0012\b\u00109\u001a\u0004\u0018\u000108¢\u0006\u0004\b6\u0010:BA\b\u0016\u0012\n\u0010(\u001a\u00060&j\u0002`'\u0012\b\u00109\u001a\u0004\u0018\u000108\u0012\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019\u0012\u0006\u00105\u001a\u00020#\u0012\b\u00101\u001a\u0004\u0018\u00010,¢\u0006\u0004\b6\u0010;J-\u0010\b\u001a\u00020\u0007\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ-\u0010\f\u001a\u00020\u0007\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\nH\u0002¢\u0006\u0004\b\f\u0010\tJ\u000f\u0010\r\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0010\u001a\u00020\u00072\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00050\nH\u0002¢\u0006\u0004\b\u0010\u0010\tJ-\u0010\u0011\u001a\u00020\u0007\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\tJ5\u0010\u0011\u001a\u00020\u0007\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\n2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0011\u0010\u0014J+\u0010\u0015\u001a\u00020\u0007\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004¢\u0006\u0004\b\u0015\u0010\tJ\u001b\u0010\u0017\u001a\u00020\u00072\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u001e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR<\u0010 \u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001e\u0018\u00010\u001d2\u0012\u0010\u001f\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001e\u0018\u00010\u001d8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b \u0010\u001c\u001a\u0004\b!\u0010\"R\u0013\u0010$\u001a\u00020#8F@\u0006¢\u0006\u0006\u001a\u0004\b$\u0010%R\u001d\u0010(\u001a\u00060&j\u0002`'8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001e\u0010-\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u00048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00101\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00103\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00105\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00104¨\u0006>"}, d2 = {"Lcom/discord/utilities/textprocessing/MessagePreprocessor;", "Lb/a/t/b/c/a;", "Lcom/discord/utilities/textprocessing/node/BasicRenderContext;", "R", "", "Lcom/discord/simpleast/core/node/Node;", "ast", "", "processQuoteChildren", "(Ljava/util/Collection;)V", "", "nodes", "mergeConsecutiveQuoteNodes", "processSpoilerChildren", "()V", "Lcom/discord/utilities/textprocessing/MessageRenderContext;", "stripSimpleEmbedLink", "constrainAST", "Lcom/discord/utilities/textprocessing/MessagePreprocessor$ConstrainState;", "state", "(Ljava/util/Collection;Lcom/discord/utilities/textprocessing/MessagePreprocessor$ConstrainState;)V", "process", "node", "processNode", "(Lcom/discord/simpleast/core/node/Node;)V", "", "Lcom/discord/api/message/embed/MessageEmbed;", "embeds", "Ljava/util/List;", "", "Lcom/discord/utilities/textprocessing/node/SpoilerNode;", "<set-?>", "spoilers", "getSpoilers", "()Ljava/util/List;", "", "isLinkifyConflicting", "()Z", "", "Lcom/discord/primitives/UserId;", "myUserId", "J", "getMyUserId", "()J", "", "visibleSpoilerNodeIndices", "Ljava/util/Collection;", "customEmojiCount", "I", "maxNodes", "Ljava/lang/Integer;", "hasLinkConflictingNode", "Z", "shouldJumboify", "<init>", "(JLjava/util/Collection;Ljava/util/List;ZLjava/lang/Integer;)V", "Lcom/discord/stores/StoreMessageState$State;", "messageState", "(JLcom/discord/stores/StoreMessageState$State;)V", "(JLcom/discord/stores/StoreMessageState$State;Ljava/util/List;ZLjava/lang/Integer;)V", "Companion", "ConstrainState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class MessagePreprocessor implements NodeProcessor {
    private static final int MAX_JUMBO_EMOJI_COUNT = 27;
    private int customEmojiCount;
    private final List<MessageEmbed> embeds;
    private boolean hasLinkConflictingNode;
    private final Integer maxNodes;
    private final long myUserId;
    private boolean shouldJumboify;
    private List<SpoilerNode<?>> spoilers;
    private final Collection<Integer> visibleSpoilerNodeIndices;

    /* compiled from: MessagePreprocessor.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\b\u0082\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0013J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\u0004J\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0004\"\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/discord/utilities/textprocessing/MessagePreprocessor$ConstrainState;", "", "", "component1", "()I", "limit", "copy", "(I)Lcom/discord/utilities/textprocessing/MessagePreprocessor$ConstrainState;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getLimit", "setLimit", "(I)V", "<init>", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ConstrainState {
        private int limit;

        public ConstrainState(int i) {
            this.limit = i;
        }

        public static /* synthetic */ ConstrainState copy$default(ConstrainState constrainState, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = constrainState.limit;
            }
            return constrainState.copy(i);
        }

        /* renamed from: component1, reason: from getter */
        public final int getLimit() {
            return this.limit;
        }

        public final ConstrainState copy(int limit) {
            return new ConstrainState(limit);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof ConstrainState) && this.limit == ((ConstrainState) other).limit;
            }
            return true;
        }

        public final int getLimit() {
            return this.limit;
        }

        public int hashCode() {
            return this.limit;
        }

        public final void setLimit(int i) {
            this.limit = i;
        }

        public String toString() {
            return outline.B(outline.U("ConstrainState(limit="), this.limit, ")");
        }
    }

    /* compiled from: MessagePreprocessor.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u0006\"\b\b\u0000\u0010\u0001*\u00020\u00002\u001a\u0010\u0005\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0003 \u0004*\b\u0012\u0002\b\u0003\u0018\u00010\u00020\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/discord/utilities/textprocessing/node/BasicRenderContext;", "R", "Lcom/discord/simpleast/core/node/Node;", "", "kotlin.jvm.PlatformType", "it", "", "processNode", "(Lcom/discord/simpleast/core/node/Node;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.textprocessing.MessagePreprocessor$process$1, reason: invalid class name */
    public static final class AnonymousClass1 implements NodeProcessor {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // b.a.t.b.c.NodeProcessor
        public final void processNode(Node<Object> node) {
            if (node instanceof EmojiNode) {
                ((EmojiNode) node).setJumbo(true);
            }
        }
    }

    /* compiled from: MessagePreprocessor.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u0006\"\b\b\u0000\u0010\u0001*\u00020\u00002\u001a\u0010\u0005\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0003 \u0004*\b\u0012\u0002\b\u0003\u0018\u00010\u00020\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/discord/utilities/textprocessing/node/BasicRenderContext;", "R", "Lcom/discord/simpleast/core/node/Node;", "", "kotlin.jvm.PlatformType", "node", "", "processNode", "(Lcom/discord/simpleast/core/node/Node;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.textprocessing.MessagePreprocessor$processQuoteChildren$1, reason: invalid class name */
    public static final class AnonymousClass1 implements NodeProcessor {
        public AnonymousClass1() {
        }

        @Override // b.a.t.b.c.NodeProcessor
        public final void processNode(Node<Object> node) {
            Collection<Node<Object>> children = node.getChildren();
            if (children != null) {
                MessagePreprocessor.access$mergeConsecutiveQuoteNodes(MessagePreprocessor.this, TypeIntrinsics.asMutableCollection(children));
            }
        }
    }

    public MessagePreprocessor(long j, Collection<Integer> collection, List<MessageEmbed> list, boolean z2, Integer num) {
        this.myUserId = j;
        this.visibleSpoilerNodeIndices = collection;
        this.embeds = list;
        this.shouldJumboify = z2;
        this.maxNodes = num;
    }

    public static final /* synthetic */ void access$mergeConsecutiveQuoteNodes(MessagePreprocessor messagePreprocessor, Collection collection) {
        messagePreprocessor.mergeConsecutiveQuoteNodes(collection);
    }

    private final <R extends BasicRenderContext> void constrainAST(Collection<? extends Node<R>> nodes) {
        if (this.maxNodes != null) {
            Objects.requireNonNull(nodes, "null cannot be cast to non-null type kotlin.collections.MutableCollection<com.discord.simpleast.core.node.Node<R>>");
            constrainAST(TypeIntrinsics.asMutableCollection(nodes), new ConstrainState(this.maxNodes.intValue()));
        }
    }

    private final <R extends BasicRenderContext> void mergeConsecutiveQuoteNodes(Collection<Node<R>> nodes) {
        ArrayList arrayList = new ArrayList();
        while (true) {
            BlockQuoteNode blockQuoteNode = null;
            for (Node<R> node : nodes) {
                if (!(node instanceof BlockQuoteNode)) {
                    break;
                }
                if (blockQuoteNode == null) {
                    blockQuoteNode = (BlockQuoteNode) node;
                } else {
                    arrayList.add(node);
                    Collection<Node<R>> children = node.getChildren();
                    if (children != null) {
                        Iterator<Node<R>> it = children.iterator();
                        while (it.hasNext()) {
                            blockQuoteNode.addChild(it.next());
                        }
                    }
                }
            }
            nodes.removeAll(arrayList);
            return;
        }
    }

    private final <R extends BasicRenderContext> void processQuoteChildren(Collection<? extends Node<R>> ast) {
        Objects.requireNonNull(ast, "null cannot be cast to non-null type kotlin.collections.MutableCollection<com.discord.simpleast.core.node.Node<R>>");
        mergeConsecutiveQuoteNodes(TypeIntrinsics.asMutableCollection(ast));
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        Iterator<? extends Node<R>> it = ast.iterator();
        while (it.hasNext()) {
            AnimatableValueParser.k2(it.next(), anonymousClass1);
        }
    }

    private final void processSpoilerChildren() {
        List<SpoilerNode<?>> list = this.spoilers;
        if (!(!(list == null || list.isEmpty()))) {
            list = null;
        }
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (!((SpoilerNode) obj).getIsRevealed()) {
                    arrayList.add(obj);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                AnimatableValueParser.i2(((SpoilerNode) it.next()).getChildren(), MessagePreprocessor2.INSTANCE);
            }
        }
    }

    private final void stripSimpleEmbedLink(Collection<Node<MessageRenderContext>> nodes) {
        List<MessageEmbed> list;
        if (nodes.size() == 1 && (list = this.embeds) != null && list.size() == 1) {
            Node node = (Node) _Collections.elementAt(nodes, 0);
            MessageEmbed messageEmbed = this.embeds.get(0);
            if ((node instanceof UrlNode) && EmbedResourceUtils.INSTANCE.isSimpleEmbed(messageEmbed)) {
                nodes.clear();
            }
        }
    }

    public final long getMyUserId() {
        return this.myUserId;
    }

    public final List<SpoilerNode<?>> getSpoilers() {
        return this.spoilers;
    }

    public final boolean isLinkifyConflicting() {
        if (!this.hasLinkConflictingNode) {
            List<SpoilerNode<?>> list = this.spoilers;
            if (list == null || list.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public final <R extends BasicRenderContext> void process(Collection<? extends Node<R>> ast) {
        Intrinsics3.checkNotNullParameter(ast, "ast");
        stripSimpleEmbedLink(TypeIntrinsics.asMutableCollection(ast));
        AnimatableValueParser.i2(ast, this);
        if (this.shouldJumboify) {
            AnimatableValueParser.i2(ast, AnonymousClass1.INSTANCE);
        }
        processSpoilerChildren();
        processQuoteChildren(ast);
        constrainAST(ast);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0019  */
    @Override // b.a.t.b.c.NodeProcessor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void processNode(Node<?> node) {
        boolean z2;
        boolean zIsBlank;
        Intrinsics3.checkNotNullParameter(node, "node");
        if (this.shouldJumboify) {
            if (node instanceof EmojiNode) {
                int i = this.customEmojiCount + 1;
                this.customEmojiCount = i;
                zIsBlank = i <= 27;
            } else if (!(node instanceof StyleNode)) {
                if (node instanceof TextNode) {
                    zIsBlank = StringsJVM.isBlank(((TextNode) node).getContent());
                }
            }
            if (zIsBlank) {
                z2 = true;
            }
        } else {
            z2 = false;
        }
        this.shouldJumboify = z2;
        if (node instanceof CodeNode) {
            this.hasLinkConflictingNode = true;
            return;
        }
        if (node instanceof UrlNode) {
            this.hasLinkConflictingNode = true;
            return;
        }
        if (node instanceof SpoilerNode) {
            List arrayList = this.spoilers;
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.spoilers = arrayList;
            }
            int size = arrayList.size();
            arrayList.add(node);
            Collection<Integer> collection = this.visibleSpoilerNodeIndices;
            ((SpoilerNode) node).updateState(size, collection != null ? collection.contains(Integer.valueOf(size)) : false);
        }
    }

    public /* synthetic */ MessagePreprocessor(long j, Collection collection, List list, boolean z2, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (Collection<Integer>) ((i & 2) != 0 ? null : collection), (List<MessageEmbed>) ((i & 4) != 0 ? null : list), (i & 8) != 0 ? true : z2, (i & 16) != 0 ? null : num);
    }

    public MessagePreprocessor(long j, StoreMessageState.State state) {
        this(j, state != null ? state.getVisibleSpoilerNodeIndices() : null, null, false, null, 24, null);
    }

    private final <R extends BasicRenderContext> void constrainAST(Collection<Node<R>> nodes, ConstrainState state) {
        Iterator<Node<R>> it = nodes.iterator();
        while (it.hasNext()) {
            Node<R> next = it.next();
            if (!Intrinsics3.areEqual(next.getClass(), TextNode.class)) {
                state.setLimit(state.getLimit() - 1);
            }
            if (state.getLimit() <= 0) {
                it.remove();
            } else if (next.hasChildren()) {
                Collection<Node<R>> children = next.getChildren();
                Objects.requireNonNull(children, "null cannot be cast to non-null type kotlin.collections.MutableCollection<com.discord.simpleast.core.node.Node<R>>");
                constrainAST(TypeIntrinsics.asMutableCollection(children), state);
                if (!next.hasChildren()) {
                    it.remove();
                }
            }
        }
    }

    public MessagePreprocessor(long j, StoreMessageState.State state, List<MessageEmbed> list, boolean z2, Integer num) {
        this(j, state != null ? state.getVisibleSpoilerNodeIndices() : null, list, z2, num);
    }
}
