package com.discord.widgets.roles;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.api.role.GuildRole;
import com.discord.databinding.RoleIconViewBinding;
import com.discord.models.domain.emoji.ModelEmojiUnicode;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreStream;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.guilds.GuildUtils;
import com.discord.utilities.guilds.RoleIconUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.textprocessing.AstRenderer;
import com.discord.utilities.textprocessing.node.EmojiNode;
import com.discord.utilities.view.ToastManager;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Collections;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* compiled from: RoleIconView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\r\u001a\u00020\f*\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\f*\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u0013\u0010\u0010\u001a\u00020\f*\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u000eJ'\u0010\u0014\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u0013\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u0012¢\u0006\u0004\b\u0014\u0010\u0015J-\u0010\u0014\u001a\u00020\u00062\u000e\u0010\u0017\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u00162\u000e\u0010\u0013\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u0012¢\u0006\u0004\b\u0014\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0019\u0010\u000bJ\u0017\u0010\u0019\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u0019\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006$"}, d2 = {"Lcom/discord/widgets/roles/RoleIconView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Lcom/discord/api/role/GuildRole;", "role", "", "showRoleIconToast", "(Landroid/content/Context;Lcom/discord/api/role/GuildRole;)V", "guildRole", "setIcon", "(Lcom/discord/api/role/GuildRole;)V", "", "hasIcon", "(Lcom/discord/api/role/GuildRole;)Z", "hasUnicodeEmoji", "hasIconOrUnicodeEmoji", "", "Lcom/discord/primitives/GuildId;", "guildId", "setRole", "(Lcom/discord/api/role/GuildRole;Ljava/lang/Long;)V", "Lcom/discord/primitives/RoleId;", "roleId", "(Ljava/lang/Long;Ljava/lang/Long;)V", "setRoleIconPreview", "", "icon", "(Ljava/lang/String;)V", "Lcom/discord/databinding/RoleIconViewBinding;", "binding", "Lcom/discord/databinding/RoleIconViewBinding;", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class RoleIconView extends FrameLayout {
    private final RoleIconViewBinding binding;

    /* compiled from: RoleIconView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.roles.RoleIconView$setRole$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ GuildRole $role;

        public AnonymousClass1(GuildRole guildRole) {
            this.$role = guildRole;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            RoleIconView roleIconView = RoleIconView.this;
            Context context = roleIconView.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            RoleIconView.access$showRoleIconToast(roleIconView, context, this.$role);
        }
    }

    /* compiled from: RoleIconView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\t\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "Landroid/content/Context;", "<anonymous parameter 2>", "", "invoke", "(ZILandroid/content/Context;)Ljava/lang/String;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.roles.RoleIconView$showRoleIconToast$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function3<Boolean, Integer, Context, String> {
        public final /* synthetic */ GuildRole $role;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(GuildRole guildRole) {
            super(3);
            this.$role = guildRole;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ String invoke(Boolean bool, Integer num, Context context) {
            return invoke(bool.booleanValue(), num.intValue(), context);
        }

        public final String invoke(boolean z2, int i, Context context) {
            Intrinsics3.checkNotNullParameter(context, "<anonymous parameter 2>");
            IconUtils iconUtils = IconUtils.INSTANCE;
            long id2 = this.$role.getId();
            String icon = this.$role.getIcon();
            Intrinsics3.checkNotNull(icon);
            return IconUtils.getRoleIconUrl$default(iconUtils, id2, icon, null, 4, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoleIconView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrs");
        LayoutInflater.from(context).inflate(R.layout.role_icon_view, this);
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(R.id.role_icon_iv);
        if (simpleDraweeView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(R.id.role_icon_iv)));
        }
        RoleIconViewBinding roleIconViewBinding = new RoleIconViewBinding(this, simpleDraweeView);
        Intrinsics3.checkNotNullExpressionValue(roleIconViewBinding, "RoleIconViewBinding.infl…ater.from(context), this)");
        this.binding = roleIconViewBinding;
    }

    public static final /* synthetic */ void access$showRoleIconToast(RoleIconView roleIconView, Context context, GuildRole guildRole) {
        roleIconView.showRoleIconToast(context, guildRole);
    }

    private final boolean hasIcon(GuildRole guildRole) {
        if (guildRole.getIcon() != null) {
            String icon = guildRole.getIcon();
            Intrinsics3.checkNotNull(icon);
            if (icon.length() > 0) {
                return true;
            }
        }
        return false;
    }

    private final boolean hasIconOrUnicodeEmoji(GuildRole guildRole) {
        return hasIcon(guildRole) || hasUnicodeEmoji(guildRole);
    }

    private final boolean hasUnicodeEmoji(GuildRole guildRole) {
        if (guildRole.getUnicodeEmoji() != null) {
            String unicodeEmoji = guildRole.getUnicodeEmoji();
            Intrinsics3.checkNotNull(unicodeEmoji);
            if (unicodeEmoji.length() > 0) {
                return true;
            }
        }
        return false;
    }

    private final void setIcon(GuildRole guildRole) {
        if (hasIcon(guildRole)) {
            SimpleDraweeView simpleDraweeView = this.binding.f2139b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.roleIconIv");
            IconUtils.setIcon$default(simpleDraweeView, guildRole, R.dimen.role_icon_size, (MGImages.ChangeDetector) null, 8, (Object) null);
        } else if (hasUnicodeEmoji(guildRole)) {
            ModelEmojiUnicode modelEmojiUnicode = StoreStream.INSTANCE.getEmojis().getUnicodeEmojiSurrogateMap().get(guildRole.getUnicodeEmoji());
            String imageUri = ModelEmojiUnicode.getImageUri(modelEmojiUnicode != null ? modelEmojiUnicode.getCodePoints() : null, getContext());
            SimpleDraweeView simpleDraweeView2 = this.binding.f2139b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.roleIconIv");
            IconUtils.setIcon$default(simpleDraweeView2, imageUri, 0, (Function1) null, (MGImages.ChangeDetector) null, 28, (Object) null);
        }
    }

    private final void showRoleIconToast(Context context, GuildRole role) {
        ModelEmojiUnicode modelEmojiUnicode;
        EmojiNode emojiNode = hasIcon(role) ? new EmojiNode(role.getName(), new AnonymousClass1(role), new EmojiNode.EmojiIdAndType.Unicode(""), DimenUtils.dpToPixels(24), DimenUtils.dpToPixels(24)) : (!hasUnicodeEmoji(role) || (modelEmojiUnicode = StoreStream.INSTANCE.getEmojis().getUnicodeEmojiSurrogateMap().get(role.getUnicodeEmoji())) == null) ? null : EmojiNode.INSTANCE.from(modelEmojiUnicode, DimenUtils.dpToPixels(24));
        if (emojiNode == null) {
            return;
        }
        RoleIconView2 roleIconView2 = new RoleIconView2(context);
        Set setSingleton = Collections.singleton(emojiNode);
        Intrinsics3.checkNotNullExpressionValue(setSingleton, "Collections.singleton(iconNode)");
        ToastManager.show$default(new ToastManager(), context, AstRenderer.render(setSingleton, roleIconView2).append((CharSequence) " ").append(FormatUtils.h(context, R.string.role_icon_toast_message, new Object[]{role.getName()}, null, 4)), 0, 4, (Object) null);
    }

    public final void setRole(GuildRole role, Long guildId) {
        Guild guild = guildId != null ? StoreStream.INSTANCE.getGuilds().getGuild(guildId.longValue()) : null;
        if (role == null || !hasIconOrUnicodeEmoji(role) || guild == null || !RoleIconUtils.INSTANCE.canUseRoleIcons(guild, role)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        setIcon(role);
        Context context = getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        setContentDescription(FormatUtils.h(context, R.string.role_icon_alt_text, new Object[]{role.getName()}, null, 4));
        setOnClickListener(new AnonymousClass1(role));
    }

    public final void setRoleIconPreview(GuildRole guildRole) {
        if (guildRole == null || !hasIconOrUnicodeEmoji(guildRole)) {
            setVisibility(8);
        } else {
            setVisibility(0);
            setIcon(guildRole);
        }
    }

    public final void setRoleIconPreview(String icon) {
        if (icon == null || StringsJVM.isBlank(icon)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        SimpleDraweeView simpleDraweeView = this.binding.f2139b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.roleIconIv");
        IconUtils.setIcon$default(simpleDraweeView, icon, R.dimen.role_icon_size, (Function1) null, (MGImages.ChangeDetector) null, 24, (Object) null);
    }

    public final void setRole(Long roleId, Long guildId) {
        setRole(GuildUtils.getGuildRole(roleId), guildId);
    }
}
