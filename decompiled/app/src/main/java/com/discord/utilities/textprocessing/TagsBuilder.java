package com.discord.utilities.textprocessing;

import b.a.t.b.c.NodeProcessor;
import b.c.a.a0.AnimatableValueParser;
import com.discord.simpleast.core.node.Node;
import com.discord.utilities.textprocessing.node.ChannelMentionNode;
import com.discord.utilities.textprocessing.node.RoleMentionNode;
import com.discord.utilities.textprocessing.node.UserMentionNode;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: TagsBuilder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\b\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\n\u001a\u00020\u00052\n\u0010\t\u001a\u00060\u0002j\u0002`\bH\u0002¢\u0006\u0004\b\n\u0010\u0007J\u001b\u0010\r\u001a\u00020\u00052\n\u0010\f\u001a\u00060\u0002j\u0002`\u000bH\u0002¢\u0006\u0004\b\r\u0010\u0007J\u001f\u0010\u0011\u001a\u00020\u00052\u0010\u0010\u0010\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f0\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0017\u001a\u00020\u00052\f\u0010\u0016\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u000e\u0012\b\u0012\u00060\u0002j\u0002`\b\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\u000e\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\"\u0010\u001d\u001a\u000e\u0012\b\u0012\u00060\u0002j\u0002`\u000b\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001b¨\u0006!"}, d2 = {"Lcom/discord/utilities/textprocessing/TagsBuilder;", "Lb/a/t/b/c/a;", "", "Lcom/discord/primitives/UserId;", "userId", "", "addUser", "(J)V", "Lcom/discord/primitives/ChannelId;", "channelId", "addChannel", "Lcom/discord/primitives/RoleId;", "roleId", "addRole", "", "Lcom/discord/simpleast/core/node/Node;", "ast", "processAst", "(Ljava/util/Collection;)V", "Lcom/discord/utilities/textprocessing/Tags;", "build", "()Lcom/discord/utilities/textprocessing/Tags;", "node", "processNode", "(Lcom/discord/simpleast/core/node/Node;)V", "", "taggedChannelIds", "Ljava/util/Set;", "taggedUserIds", "taggedRoleIds", "<init>", "()V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class TagsBuilder implements NodeProcessor {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Set<Long> taggedChannelIds;
    private Set<Long> taggedRoleIds;
    private Set<Long> taggedUserIds;

    /* compiled from: TagsBuilder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u0006\u001a\u00020\u00052\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/discord/utilities/textprocessing/TagsBuilder$Companion;", "", "", "Lcom/discord/simpleast/core/node/Node;", "ast", "Lcom/discord/utilities/textprocessing/Tags;", "extractTags", "(Ljava/util/Collection;)Lcom/discord/utilities/textprocessing/Tags;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final TagsBuilder2 extractTags(Collection<? extends Node<?>> ast) {
            Intrinsics3.checkNotNullParameter(ast, "ast");
            TagsBuilder tagsBuilder = new TagsBuilder();
            tagsBuilder.processAst(ast);
            return tagsBuilder.build();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void addChannel(long channelId) {
        Set<Long> hashSet = this.taggedChannelIds;
        if (hashSet == null) {
            hashSet = new HashSet<>(4);
        }
        hashSet.add(Long.valueOf(channelId));
        this.taggedChannelIds = hashSet;
    }

    private final void addRole(long roleId) {
        Set<Long> hashSet = this.taggedRoleIds;
        if (hashSet == null) {
            hashSet = new HashSet<>(4);
        }
        hashSet.add(Long.valueOf(roleId));
        this.taggedRoleIds = hashSet;
    }

    private final void addUser(long userId) {
        Set<Long> hashSet = this.taggedUserIds;
        if (hashSet == null) {
            hashSet = new HashSet<>(4);
        }
        hashSet.add(Long.valueOf(userId));
        this.taggedUserIds = hashSet;
    }

    public final TagsBuilder2 build() {
        Set<Long> setEmptySet = this.taggedUserIds;
        if (setEmptySet == null) {
            setEmptySet = Collections.emptySet();
            Intrinsics3.checkNotNullExpressionValue(setEmptySet, "Collections.emptySet()");
        }
        Set<Long> setEmptySet2 = this.taggedChannelIds;
        if (setEmptySet2 == null) {
            setEmptySet2 = Collections.emptySet();
            Intrinsics3.checkNotNullExpressionValue(setEmptySet2, "Collections.emptySet()");
        }
        Set<Long> setEmptySet3 = this.taggedRoleIds;
        if (setEmptySet3 == null) {
            setEmptySet3 = Collections.emptySet();
            Intrinsics3.checkNotNullExpressionValue(setEmptySet3, "Collections.emptySet()");
        }
        return new TagsBuilder2(setEmptySet, setEmptySet2, setEmptySet3);
    }

    public final void processAst(Collection<? extends Node<?>> ast) {
        Intrinsics3.checkNotNullParameter(ast, "ast");
        AnimatableValueParser.i2(ast, this);
    }

    @Override // b.a.t.b.c.NodeProcessor
    public void processNode(Node<?> node) {
        if (node instanceof UserMentionNode) {
            UserMentionNode userMentionNode = (UserMentionNode) node;
            if (userMentionNode.getType() == UserMentionNode.Type.USER) {
                addUser(userMentionNode.getUserId());
                return;
            }
        }
        if (node instanceof RoleMentionNode) {
            addRole(((RoleMentionNode) node).getRoleId());
        } else if (node instanceof ChannelMentionNode) {
            addChannel(((ChannelMentionNode) node).getChannelId());
        }
    }
}
