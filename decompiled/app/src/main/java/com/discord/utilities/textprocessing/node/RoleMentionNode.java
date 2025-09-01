package com.discord.utilities.textprocessing.node;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import androidx.core.graphics.ColorUtils;
import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.role.GuildRole;
import com.discord.simpleast.core.node.Node;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.textprocessing.node.RoleMentionNode.RenderContext;
import com.discord.widgets.chat.input.MentionUtils;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: RoleMentionNode.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\u0016B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0019\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/discord/utilities/textprocessing/node/RoleMentionNode;", "Lcom/discord/utilities/textprocessing/node/RoleMentionNode$RenderContext;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/discord/simpleast/core/node/Node;", "Landroid/text/SpannableStringBuilder;", "builder", "renderContext", "", "render", "(Landroid/text/SpannableStringBuilder;Lcom/discord/utilities/textprocessing/node/RoleMentionNode$RenderContext;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "roleId", "J", "getRoleId", "()J", "<init>", "(J)V", "RenderContext", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class RoleMentionNode<T extends RenderContext> extends Node<T> {
    private final long roleId;

    /* compiled from: RoleMentionNode.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R(\u0010\f\u001a\u0014\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/discord/utilities/textprocessing/node/RoleMentionNode$RenderContext;", "", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "", "", "Lcom/discord/primitives/RoleId;", "Lcom/discord/api/role/GuildRole;", "getRoles", "()Ljava/util/Map;", "roles", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public interface RenderContext {
        Context getContext();

        Map<Long, GuildRole> getRoles();
    }

    public RoleMentionNode(long j) {
        super(null, 1, null);
        this.roleId = j;
    }

    public boolean equals(Object other) {
        return (other instanceof RoleMentionNode) && ((RoleMentionNode) other).roleId == this.roleId;
    }

    public final long getRoleId() {
        return this.roleId;
    }

    @Override // com.discord.simpleast.core.node.Node
    public /* bridge */ /* synthetic */ void render(SpannableStringBuilder spannableStringBuilder, Object obj) {
        render(spannableStringBuilder, (SpannableStringBuilder) obj);
    }

    public void render(SpannableStringBuilder builder, T renderContext) {
        Intrinsics3.checkNotNullParameter(builder, "builder");
        Intrinsics3.checkNotNullParameter(renderContext, "renderContext");
        int length = builder.length();
        Map<Long, GuildRole> roles = renderContext.getRoles();
        GuildRole guildRole = roles != null ? roles.get(Long.valueOf(this.roleId)) : null;
        if (guildRole == null) {
            builder.append("deleted-role");
            return;
        }
        StringBuilder sbQ = outline.Q(MentionUtils.MENTIONS_CHAR);
        sbQ.append(guildRole.getName());
        String string = sbQ.toString();
        List listListOf = Collections2.listOf(new StyleSpan(1), new ForegroundColorSpan(!RoleUtils.isDefaultColor(guildRole) ? ColorUtils.setAlphaComponent(guildRole.getColor(), 255) : ColorCompat.getThemedColor(renderContext.getContext(), R.attr.theme_chat_mention_foreground)), new BackgroundColorSpan(!RoleUtils.isDefaultColor(guildRole) ? ColorUtils.setAlphaComponent(guildRole.getColor(), 25) : ColorCompat.getThemedColor(renderContext.getContext(), R.attr.theme_chat_mention_background)));
        builder.append((CharSequence) string);
        Iterator it = listListOf.iterator();
        while (it.hasNext()) {
            builder.setSpan(it.next(), length, builder.length(), 33);
        }
    }
}
