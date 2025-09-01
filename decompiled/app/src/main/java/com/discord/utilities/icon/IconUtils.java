package com.discord.utilities.icon;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.annotation.DimenRes;
import b.d.b.a.outline;
import com.discord.BuildConfig;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.role.GuildRole;
import com.discord.models.commands.Application;
import com.discord.models.commands.Application3;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.CoreUser;
import com.discord.models.user.User;
import com.discord.nullserializable.NullSerializable;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.string.StringUtils2;
import com.discord.widgets.chat.input.MentionUtils;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.t.Iterables2;
import d0.t.Iterators4;
import d0.t._Arrays;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.Ranges2;

/* compiled from: IconUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u000b\b\u0002¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001JM\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0003\u0010\u0007\u001a\u00020\u00062\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b2\b\b\u0002\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ]\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u00122\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b2\b\b\u0002\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000e\u0010\u0014JY\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\b\u0003\u0010\u0007\u001a\u00020\u00062\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b2\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0007¢\u0006\u0004\b\u000e\u0010\u0019J}\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u001d\u001a\n\u0018\u00010\u001bj\u0004\u0018\u0001`\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00062\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b2\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0007¢\u0006\u0004\b\u000e\u0010 J5\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\"\u001a\u0004\u0018\u00010!2\b\b\u0003\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000e\u0010#J?\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\"\u001a\u0004\u0018\u00010$2\b\b\u0003\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010%\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u000e\u0010&J5\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\"\u001a\u0004\u0018\u00010'2\b\b\u0003\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000e\u0010(J1\u0010*\u001a\u0004\u0018\u00010\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010%\u001a\u00020\u00122\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b*\u0010+J%\u0010,\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010)\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b,\u0010-JM\u0010*\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u001d\u001a\n\u0018\u00010\u001bj\u0004\u0018\u0001`\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010%\u001a\u00020\u00122\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b*\u0010.J?\u00103\u001a\u0004\u0018\u00010\u00042\u0006\u0010/\u001a\u00020\u001b2\b\u00100\u001a\u0004\u0018\u00010\u00042\u0006\u00101\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u00122\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b3\u00104J'\u00103\u001a\u0004\u0018\u00010\u00042\b\u00105\u001a\u0004\u0018\u00010!2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b3\u00106JG\u00108\u001a\u0004\u0018\u00010\u00042\b\u0010/\u001a\u0004\u0018\u00010\u001b2\b\u00100\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010%\u001a\u00020\u00122\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b8\u00109J=\u00108\u001a\u0004\u0018\u00010\u00042\b\u0010:\u001a\u0004\u0018\u00010$2\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010%\u001a\u00020\u00122\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b8\u0010;J-\u0010@\u001a\u00020\u00042\n\u0010=\u001a\u00060\u001bj\u0002`<2\u0006\u0010>\u001a\u00020\u00042\b\b\u0002\u0010?\u001a\u00020\u0006H\u0007¢\u0006\u0004\b@\u0010AJ\u001f\u0010D\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010C\u001a\u00020BH\u0007¢\u0006\u0004\bD\u0010EJ!\u0010H\u001a\u0004\u0018\u00010\u00042\u0006\u0010F\u001a\u00020\u00042\u0006\u0010G\u001a\u00020\u0004H\u0002¢\u0006\u0004\bH\u0010IJ\u0017\u0010J\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u0006H\u0007¢\u0006\u0004\bJ\u0010KJ9\u0010L\u001a\u0004\u0018\u00010\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010%\u001a\u00020\u0012¢\u0006\u0004\bL\u0010MJ-\u0010N\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0018\u001a\u00020\u00172\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010%\u001a\u00020\u0012¢\u0006\u0004\bN\u0010OJG\u0010N\u001a\u0004\u0018\u00010\u00042\b\u0010P\u001a\u0004\u0018\u00010\u00042\n\u0010R\u001a\u00060\u001bj\u0002`Q2\n\u0010\u001d\u001a\u00060\u001bj\u0002`\u001c2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010%\u001a\u00020\u0012¢\u0006\u0004\bN\u0010SJ;\u0010U\u001a\u0004\u0018\u00010\u00042\n\u0010\u001d\u001a\u00060\u001bj\u0002`\u001c2\b\u0010T\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010%\u001a\u00020\u0012¢\u0006\u0004\bU\u0010VJG\u0010X\u001a\u0004\u0018\u00010\u00042\b\u0010W\u001a\u0004\u0018\u00010\u00042\n\u0010R\u001a\u00060\u001bj\u0002`Q2\n\u0010\u001d\u001a\u00060\u001bj\u0002`\u001c2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010%\u001a\u00020\u0012¢\u0006\u0004\bX\u0010SJ\u0019\u0010Z\u001a\u00020\u00042\n\u0010/\u001a\u00060\u001bj\u0002`Y¢\u0006\u0004\bZ\u0010[J/\u0010\\\u001a\u0004\u0018\u00010\u00042\b\u0010:\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010%\u001a\u00020\u0012¢\u0006\u0004\b\\\u0010]J?\u0010\\\u001a\u0004\u0018\u00010\u00042\u000e\u0010R\u001a\n\u0018\u00010\u001bj\u0004\u0018\u0001`Q2\b\u0010^\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010%\u001a\u00020\u0012¢\u0006\u0004\b\\\u0010_J-\u0010`\u001a\u0004\u0018\u00010\u00042\b\u0010=\u001a\u0004\u0018\u00010\u001b2\u0006\u0010>\u001a\u00020\u00042\b\b\u0002\u0010?\u001a\u00020\u0006H\u0007¢\u0006\u0004\b`\u0010aJ-\u0010b\u001a\u0004\u0018\u00010\u00042\b\u0010=\u001a\u0004\u0018\u00010\u001b2\u0006\u0010>\u001a\u00020\u00042\b\b\u0002\u0010)\u001a\u00020\u0006H\u0007¢\u0006\u0004\bb\u0010aJ1\u0010d\u001a\u0004\u0018\u00010\u00042\n\u0010=\u001a\u00060\u001bj\u0002`<2\b\u0010c\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\bd\u0010eJ\u001f\u0010@\u001a\u00020\u00042\u0006\u0010C\u001a\u00020B2\b\b\u0002\u0010?\u001a\u00020\u0006¢\u0006\u0004\b@\u0010fJ-\u0010h\u001a\u00020\u00042\n\u0010R\u001a\u00060\u001bj\u0002`Q2\u0006\u0010g\u001a\u00020\u00042\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\bh\u0010eJ%\u0010h\u001a\u0004\u0018\u00010\u00042\b\u0010:\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\bh\u0010iJ\u0015\u0010k\u001a\u00020\u00122\u0006\u0010j\u001a\u00020\u0004¢\u0006\u0004\bk\u0010lJ\u0015\u0010n\u001a\u00020\u00122\u0006\u0010m\u001a\u00020\u0004¢\u0006\u0004\bn\u0010lJ\u001d\u0010p\u001a\u00020\u00042\u0006\u0010j\u001a\u00020\u00042\u0006\u0010o\u001a\u00020\u0012¢\u0006\u0004\bp\u0010qJ-\u0010u\u001a\u00020\u00042\n\u0010s\u001a\u00060\u001bj\u0002`r2\u0006\u0010t\u001a\u00020\u00042\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\bu\u0010eR\u001c\u0010w\u001a\b\u0012\u0004\u0012\u00020\u00040v8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bw\u0010xR\u0016\u0010y\u001a\u00020\u00068\u0002@\u0003X\u0083T¢\u0006\u0006\n\u0004\by\u0010zR\u0016\u0010{\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b{\u0010|R\u0016\u0010}\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b}\u0010|R\u0016\u0010~\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b~\u0010|R\u0016\u0010\u007f\u001a\u00020\u00068\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u007f\u0010zR \u0010\u0081\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060\u0080\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001¨\u0006\u0085\u0001"}, d2 = {"Lcom/discord/utilities/icon/IconUtils;", "", "Landroid/widget/ImageView;", "imageView", "", "url", "", "sizeDimenRes", "Lkotlin/Function1;", "Lcom/facebook/imagepipeline/request/ImageRequestBuilder;", "", "transform", "Lcom/discord/utilities/images/MGImages$ChangeDetector;", "changeDetector", "setIcon", "(Landroid/widget/ImageView;Ljava/lang/String;ILkotlin/jvm/functions/Function1;Lcom/discord/utilities/images/MGImages$ChangeDetector;)V", "widthPixels", "heightPixels", "", "useSmallCache", "(Landroid/widget/ImageView;Ljava/lang/String;IIZLkotlin/jvm/functions/Function1;Lcom/discord/utilities/images/MGImages$ChangeDetector;)V", "Lcom/discord/models/user/User;", "user", "Lcom/discord/models/member/GuildMember;", "guildMember", "(Landroid/widget/ImageView;Lcom/discord/models/user/User;ILkotlin/jvm/functions/Function1;Lcom/discord/utilities/images/MGImages$ChangeDetector;Lcom/discord/models/member/GuildMember;)V", "username", "", "Lcom/discord/primitives/UserId;", "userId", "userAvatar", "discriminator", "(Landroid/widget/ImageView;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;ILkotlin/jvm/functions/Function1;Lcom/discord/utilities/images/MGImages$ChangeDetector;Lcom/discord/models/member/GuildMember;)V", "Lcom/discord/api/channel/Channel;", "entity", "(Landroid/widget/ImageView;Lcom/discord/api/channel/Channel;ILcom/discord/utilities/images/MGImages$ChangeDetector;)V", "Lcom/discord/models/guild/Guild;", "animated", "(Landroid/widget/ImageView;Lcom/discord/models/guild/Guild;ILcom/discord/utilities/images/MGImages$ChangeDetector;Z)V", "Lcom/discord/api/role/GuildRole;", "(Landroid/widget/ImageView;Lcom/discord/api/role/GuildRole;ILcom/discord/utilities/images/MGImages$ChangeDetector;)V", "size", "getForUser", "(Lcom/discord/models/user/User;ZLjava/lang/Integer;)Ljava/lang/String;", "withSize", "(Ljava/lang/String;Ljava/lang/Integer;)Ljava/lang/String;", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;ZLjava/lang/Integer;)Ljava/lang/String;", ModelAuditLogEntry.CHANGE_KEY_ID, "icon", "type", "returnDefaultAsset", "getForChannel", "(JLjava/lang/String;IZLjava/lang/Integer;)Ljava/lang/String;", "channel", "(Lcom/discord/api/channel/Channel;Ljava/lang/Integer;)Ljava/lang/String;", "defaultIcon", "getForGuild", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Integer;)Ljava/lang/String;", "guild", "(Lcom/discord/models/guild/Guild;Ljava/lang/String;ZLjava/lang/Integer;)Ljava/lang/String;", "Lcom/discord/primitives/ApplicationId;", "applicationId", "imageId", "sizePx", "getApplicationIcon", "(JLjava/lang/String;I)Ljava/lang/String;", "Lcom/discord/models/commands/Application;", "application", "setApplicationIcon", "(Landroid/widget/ImageView;Lcom/discord/models/commands/Application;)V", "platform", "data", "getAssetPlatformUrl", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "getMediaProxySize", "(I)I", "getForGuildMemberOrUser", "(Lcom/discord/models/user/User;Lcom/discord/models/member/GuildMember;Ljava/lang/Integer;Z)Ljava/lang/String;", "getForGuildMember", "(Lcom/discord/models/member/GuildMember;Ljava/lang/Integer;Z)Ljava/lang/String;", "guildMemberAvatar", "Lcom/discord/primitives/GuildId;", "guildId", "(Ljava/lang/String;JJLjava/lang/Integer;Z)Ljava/lang/String;", "bannerHash", "getForUserBanner", "(JLjava/lang/String;Ljava/lang/Integer;Z)Ljava/lang/String;", "guildMemberBanner", "getForGuildMemberBanner", "Lcom/discord/primitives/ChannelId;", "getDefaultForGroupDM", "(J)Ljava/lang/String;", "getBannerForGuild", "(Lcom/discord/models/guild/Guild;Ljava/lang/Integer;Z)Ljava/lang/String;", "banner", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Z)Ljava/lang/String;", "getAssetImage", "(Ljava/lang/Long;Ljava/lang/String;I)Ljava/lang/String;", "getStoreAssetImage", "hash", "getGiftSplashUrl", "(JLjava/lang/String;Ljava/lang/Integer;)Ljava/lang/String;", "(Lcom/discord/models/commands/Application;I)Ljava/lang/String;", "splashHash", "getGuildSplashUrl", "(Lcom/discord/models/guild/Guild;Ljava/lang/Integer;)Ljava/lang/String;", "imageHash", "isImageHashAnimated", "(Ljava/lang/String;)Z", "dataUrl", "isDataUrlForGif", "allowAnimation", "getImageExtension", "(Ljava/lang/String;Z)Ljava/lang/String;", "Lcom/discord/primitives/RoleId;", "roleId", "iconHash", "getRoleIconUrl", "", "GROUP_DM_DEFAULT_ICONS", "Ljava/util/List;", "UNRESTRICTED", "I", "DEFAULT_ICON", "Ljava/lang/String;", "DEFAULT_ICON_BLURPLE", "ANIMATED_IMAGE_EXTENSION", "IMAGE_SIZE_ASSET_DEFAULT_PX", "", "MEDIA_PROXY_SIZES", "[Ljava/lang/Integer;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class IconUtils {
    public static final String ANIMATED_IMAGE_EXTENSION = "gif";
    public static final String DEFAULT_ICON = "asset://asset/images/default_icon.jpg";
    public static final String DEFAULT_ICON_BLURPLE = "asset://asset/images/default_icon_selected.jpg";
    private static final List<String> GROUP_DM_DEFAULT_ICONS;
    private static final int IMAGE_SIZE_ASSET_DEFAULT_PX = 160;
    public static final IconUtils INSTANCE = new IconUtils();
    private static final Integer[] MEDIA_PROXY_SIZES;

    @DimenRes
    private static final int UNRESTRICTED = 2131165301;

    static {
        Ranges2 ranges2 = new Ranges2(0, 7);
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(ranges2, 10));
        Iterator<Integer> it = ranges2.iterator();
        while (it.hasNext()) {
            arrayList.add("asset://asset/images/group_dm_icon_" + ((Iterators4) it).nextInt() + ".png");
        }
        GROUP_DM_DEFAULT_ICONS = arrayList;
        MEDIA_PROXY_SIZES = new Integer[]{16, 20, 22, 24, 28, 32, 40, 44, 48, 56, 60, 64, 80, 96, 100, 128, 160, 240, 256, 300, 320, 480, 512, 600, 640, 1024, 1280, 1536, 2048, 3072, 4096};
    }

    private IconUtils() {
    }

    public static final String getApplicationIcon(long applicationId, String imageId, int sizePx) {
        Intrinsics3.checkNotNullParameter(imageId, "imageId");
        return "https://cdn.discordapp.com/app-icons/" + applicationId + MentionUtils.SLASH_CHAR + imageId + '.' + StringUtils2.getSTATIC_IMAGE_EXTENSION() + "?size=" + getMediaProxySize(sizePx);
    }

    public static /* synthetic */ String getApplicationIcon$default(long j, String str, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 160;
        }
        return getApplicationIcon(j, str, i);
    }

    public static /* synthetic */ String getAssetImage$default(IconUtils iconUtils, Long l, String str, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 160;
        }
        return iconUtils.getAssetImage(l, str, i);
    }

    private final String getAssetPlatformUrl(String platform, String data) {
        int iHashCode = platform.hashCode();
        if (iHashCode != -1998723398) {
            if (iHashCode == 3491 && platform.equals("mp")) {
                return outline.w("https://media.discordapp.net/", data);
            }
        } else if (platform.equals("spotify")) {
            return outline.w("https://i.scdn.co/image/", data);
        }
        return null;
    }

    public static /* synthetic */ String getBannerForGuild$default(IconUtils iconUtils, Guild guild, Integer num, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        return iconUtils.getBannerForGuild(guild, num, z2);
    }

    public static final String getForChannel(long id2, String icon, int type, boolean returnDefaultAsset, Integer size) {
        if (icon == null || icon.length() == 0) {
            if (type == 3) {
                return INSTANCE.getDefaultForGroupDM(id2);
            }
            if (returnDefaultAsset) {
                return "";
            }
            return null;
        }
        if (BuildConfig.HOST_CDN.length() == 0) {
            return "https://discord.com/api//channels/" + id2 + "/icons/" + icon + ".jpg";
        }
        return INSTANCE.withSize("https://cdn.discordapp.com/channel-icons/" + id2 + MentionUtils.SLASH_CHAR + icon + '.' + StringUtils2.getSTATIC_IMAGE_EXTENSION(), size);
    }

    public static /* synthetic */ String getForChannel$default(long j, String str, int i, boolean z2, Integer num, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            num = null;
        }
        return getForChannel(j, str, i, z2, num);
    }

    public static final String getForGuild(Guild guild) {
        return getForGuild$default(guild, null, false, null, 14, null);
    }

    public static final String getForGuild(Guild guild, String str) {
        return getForGuild$default(guild, str, false, null, 12, null);
    }

    public static final String getForGuild(Guild guild, String str, boolean z2) {
        return getForGuild$default(guild, str, z2, null, 8, null);
    }

    public static final String getForGuild(Long l, String str) {
        return getForGuild$default(l, str, null, false, null, 28, null);
    }

    public static final String getForGuild(Long l, String str, String str2) {
        return getForGuild$default(l, str, str2, false, null, 24, null);
    }

    public static final String getForGuild(Long l, String str, String str2, boolean z2) {
        return getForGuild$default(l, str, str2, z2, null, 16, null);
    }

    public static final String getForGuild(Long id2, String icon, String defaultIcon, boolean animated, Integer size) {
        String str;
        if (TextUtils.isEmpty(icon) || id2 == null) {
            return defaultIcon;
        }
        Integer numValueOf = size != null ? Integer.valueOf(getMediaProxySize(size.intValue())) : null;
        StringBuilder sb = new StringBuilder();
        if (BuildConfig.HOST_CDN.length() == 0) {
            str = "https://discord.com/api//guilds/" + id2 + "/icons/" + icon + ".jpg";
        } else {
            IconUtils iconUtils = INSTANCE;
            Intrinsics3.checkNotNull(icon);
            str = "https://cdn.discordapp.com/icons/" + id2 + MentionUtils.SLASH_CHAR + icon + '.' + iconUtils.getImageExtension(icon, animated);
        }
        sb.append(str);
        String strQ = numValueOf != null ? outline.q("?size=", numValueOf.intValue()) : null;
        if (strQ == null) {
            strQ = "";
        }
        sb.append(strQ);
        return sb.toString();
    }

    public static /* synthetic */ String getForGuild$default(Long l, String str, String str2, boolean z2, Integer num, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            z2 = false;
        }
        if ((i & 16) != 0) {
            num = null;
        }
        return getForGuild(l, str, str2, z2, num);
    }

    public static /* synthetic */ String getForGuildMember$default(IconUtils iconUtils, GuildMember guildMember, Integer num, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        return iconUtils.getForGuildMember(guildMember, num, z2);
    }

    public static /* synthetic */ String getForGuildMemberBanner$default(IconUtils iconUtils, String str, long j, long j2, Integer num, boolean z2, int i, Object obj) {
        return iconUtils.getForGuildMemberBanner(str, j, j2, (i & 8) != 0 ? null : num, (i & 16) != 0 ? false : z2);
    }

    public static /* synthetic */ String getForGuildMemberOrUser$default(IconUtils iconUtils, User user, GuildMember guildMember, Integer num, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            z2 = false;
        }
        return iconUtils.getForGuildMemberOrUser(user, guildMember, num, z2);
    }

    public static final String getForUser(User user) {
        return getForUser$default(user, false, null, 6, null);
    }

    public static final String getForUser(User user, boolean z2) {
        return getForUser$default(user, z2, null, 4, null);
    }

    public static final String getForUser(User user, boolean animated, Integer size) {
        return getForUser(user != null ? Long.valueOf(user.getId()) : null, user != null ? user.getAvatar() : null, user != null ? Integer.valueOf(user.getDiscriminator()) : null, animated, size);
    }

    public static final String getForUser(Long l, String str) {
        return getForUser$default(l, str, null, false, null, 28, null);
    }

    public static final String getForUser(Long l, String str, Integer num) {
        return getForUser$default(l, str, num, false, null, 24, null);
    }

    public static final String getForUser(Long l, String str, Integer num, boolean z2) {
        return getForUser$default(l, str, num, z2, null, 16, null);
    }

    public static /* synthetic */ String getForUser$default(User user, boolean z2, Integer num, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        if ((i & 4) != 0) {
            num = null;
        }
        return getForUser(user, z2, num);
    }

    public static /* synthetic */ String getForUserBanner$default(IconUtils iconUtils, long j, String str, Integer num, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            num = null;
        }
        return iconUtils.getForUserBanner(j, str, num, (i & 8) != 0 ? false : z2);
    }

    public static /* synthetic */ String getGiftSplashUrl$default(IconUtils iconUtils, long j, String str, Integer num, int i, Object obj) {
        if ((i & 4) != 0) {
            num = null;
        }
        return iconUtils.getGiftSplashUrl(j, str, num);
    }

    public static /* synthetic */ String getGuildSplashUrl$default(IconUtils iconUtils, long j, String str, Integer num, int i, Object obj) {
        if ((i & 4) != 0) {
            num = null;
        }
        return iconUtils.getGuildSplashUrl(j, str, num);
    }

    public static final int getMediaProxySize(int size) {
        for (Integer num : MEDIA_PROXY_SIZES) {
            if (num.intValue() >= size) {
                return num.intValue();
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static /* synthetic */ String getRoleIconUrl$default(IconUtils iconUtils, long j, String str, Integer num, int i, Object obj) {
        if ((i & 4) != 0) {
            num = null;
        }
        return iconUtils.getRoleIconUrl(j, str, num);
    }

    public static /* synthetic */ String getStoreAssetImage$default(IconUtils iconUtils, Long l, String str, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 160;
        }
        return iconUtils.getStoreAssetImage(l, str, i);
    }

    public static final void setApplicationIcon(ImageView imageView, Application application) {
        Intrinsics3.checkNotNullParameter(imageView, "imageView");
        Intrinsics3.checkNotNullParameter(application, "application");
        String applicationIcon$default = getApplicationIcon$default(INSTANCE, application, 0, 2, (Object) null);
        if (application.getIconRes() == null || Application3.hasBotAvatar(application)) {
            MGImages.setImage$default(imageView, applicationIcon$default, 0, 0, false, null, null, 124, null);
            return;
        }
        int themedColor = ColorCompat.getThemedColor(imageView, R.attr.colorTextMuted);
        Context context = imageView.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "imageView.context");
        Drawable drawable$default = DrawableCompat.getDrawable$default(context, application.getIconRes().intValue(), themedColor, false, 4, null);
        if (drawable$default != null) {
            MGImages.setImage$default(MGImages.INSTANCE, imageView, drawable$default, (MGImages.ChangeDetector) null, 4, (Object) null);
        } else {
            MGImages.setImage$default(MGImages.INSTANCE, imageView, application.getIconRes().intValue(), (MGImages.ChangeDetector) null, 4, (Object) null);
        }
    }

    public static final void setIcon(ImageView imageView, Channel channel) {
        setIcon$default(imageView, channel, 0, (MGImages.ChangeDetector) null, 12, (Object) null);
    }

    public static final void setIcon(ImageView imageView, Channel channel, @DimenRes int i) {
        setIcon$default(imageView, channel, i, (MGImages.ChangeDetector) null, 8, (Object) null);
    }

    public static final void setIcon(ImageView imageView, GuildRole guildRole) {
        setIcon$default(imageView, guildRole, 0, (MGImages.ChangeDetector) null, 12, (Object) null);
    }

    public static final void setIcon(ImageView imageView, GuildRole guildRole, @DimenRes int i) {
        setIcon$default(imageView, guildRole, i, (MGImages.ChangeDetector) null, 8, (Object) null);
    }

    public static final void setIcon(ImageView imageView, Guild guild) {
        setIcon$default(imageView, guild, 0, (MGImages.ChangeDetector) null, false, 28, (Object) null);
    }

    public static final void setIcon(ImageView imageView, Guild guild, @DimenRes int i) {
        setIcon$default(imageView, guild, i, (MGImages.ChangeDetector) null, false, 24, (Object) null);
    }

    public static final void setIcon(ImageView imageView, Guild guild, @DimenRes int i, MGImages.ChangeDetector changeDetector) {
        setIcon$default(imageView, guild, i, changeDetector, false, 16, (Object) null);
    }

    public static final void setIcon(ImageView imageView, User user) {
        setIcon$default(imageView, user, 0, null, null, null, 60, null);
    }

    public static final void setIcon(ImageView imageView, User user, @DimenRes int i) {
        setIcon$default(imageView, user, i, null, null, null, 56, null);
    }

    public static final void setIcon(ImageView imageView, User user, @DimenRes int i, Function1<? super ImageRequestBuilder, Unit> function1) {
        setIcon$default(imageView, user, i, function1, null, null, 48, null);
    }

    public static final void setIcon(ImageView imageView, User user, @DimenRes int i, Function1<? super ImageRequestBuilder, Unit> function1, MGImages.ChangeDetector changeDetector) {
        setIcon$default(imageView, user, i, function1, changeDetector, null, 32, null);
    }

    public static final void setIcon(ImageView imageView, String str) {
        setIcon$default(imageView, str, 0, (Function1) null, (MGImages.ChangeDetector) null, 28, (Object) null);
    }

    public static final void setIcon(ImageView imageView, String str, @DimenRes int i) {
        setIcon$default(imageView, str, i, (Function1) null, (MGImages.ChangeDetector) null, 24, (Object) null);
    }

    public static final void setIcon(ImageView imageView, String str, int i, int i2) {
        setIcon$default(imageView, str, i, i2, false, null, null, 112, null);
    }

    public static final void setIcon(ImageView imageView, String str, int i, int i2, boolean z2) {
        setIcon$default(imageView, str, i, i2, z2, null, null, 96, null);
    }

    public static final void setIcon(ImageView imageView, String str, int i, int i2, boolean z2, Function1<? super ImageRequestBuilder, Unit> function1) {
        setIcon$default(imageView, str, i, i2, z2, function1, null, 64, null);
    }

    public static final void setIcon(ImageView imageView, String str, @DimenRes int i, Function1<? super ImageRequestBuilder, Unit> function1) {
        setIcon$default(imageView, str, i, function1, (MGImages.ChangeDetector) null, 16, (Object) null);
    }

    public static final void setIcon(ImageView imageView, String url, @DimenRes int sizeDimenRes, Function1<? super ImageRequestBuilder, Unit> transform, MGImages.ChangeDetector changeDetector) {
        Intrinsics3.checkNotNullParameter(imageView, "imageView");
        Intrinsics3.checkNotNullParameter(changeDetector, "changeDetector");
        setIcon(imageView, url, imageView.getResources().getDimensionPixelSize(sizeDimenRes), imageView.getResources().getDimensionPixelSize(sizeDimenRes), true, transform, changeDetector);
    }

    public static final void setIcon(ImageView imageView, String str, Long l, String str2, Integer num) {
        setIcon$default(imageView, str, l, str2, num, 0, null, null, null, 480, null);
    }

    public static final void setIcon(ImageView imageView, String str, Long l, String str2, Integer num, @DimenRes int i) {
        setIcon$default(imageView, str, l, str2, num, i, null, null, null, 448, null);
    }

    public static final void setIcon(ImageView imageView, String str, Long l, String str2, Integer num, @DimenRes int i, Function1<? super ImageRequestBuilder, Unit> function1) {
        setIcon$default(imageView, str, l, str2, num, i, function1, null, null, 384, null);
    }

    public static final void setIcon(ImageView imageView, String str, Long l, String str2, Integer num, @DimenRes int i, Function1<? super ImageRequestBuilder, Unit> function1, MGImages.ChangeDetector changeDetector) {
        setIcon$default(imageView, str, l, str2, num, i, function1, changeDetector, null, 256, null);
    }

    public static /* synthetic */ void setIcon$default(ImageView imageView, String str, int i, Function1 function1, MGImages.ChangeDetector changeDetector, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = R.dimen.avatar_size_unrestricted;
        }
        if ((i2 & 8) != 0) {
            function1 = null;
        }
        if ((i2 & 16) != 0) {
            changeDetector = MGImages.AlwaysUpdateChangeDetector.INSTANCE;
        }
        setIcon(imageView, str, i, (Function1<? super ImageRequestBuilder, Unit>) function1, changeDetector);
    }

    private final String withSize(String url, Integer size) {
        if (url == null || size == null || size.intValue() <= 0) {
            return url;
        }
        StringBuilder sbX = outline.X(url, "?size=");
        sbX.append(getMediaProxySize(size.intValue()));
        return sbX.toString();
    }

    @SuppressLint({"DefaultLocale"})
    public final String getAssetImage(Long applicationId, String imageId, int sizePx) {
        Intrinsics3.checkNotNullParameter(imageId, "imageId");
        int mediaProxySize = getMediaProxySize(sizePx);
        if (Strings4.contains$default((CharSequence) imageId, MentionUtils.EMOJIS_AND_STICKERS_CHAR, false, 2, (Object) null)) {
            List listSplit$default = Strings4.split$default((CharSequence) imageId, new char[]{MentionUtils.EMOJIS_AND_STICKERS_CHAR}, false, 2, 2, (Object) null);
            String str = (String) listSplit$default.get(0);
            Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = str.toLowerCase();
            Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
            return getAssetPlatformUrl(lowerCase, (String) listSplit$default.get(1));
        }
        if (applicationId == null) {
            return null;
        }
        return "https://cdn.discordapp.com/app-assets/" + applicationId + MentionUtils.SLASH_CHAR + imageId + ".jpg?size=" + mediaProxySize;
    }

    public final String getBannerForGuild(Guild guild, Integer size, boolean animated) {
        return getBannerForGuild(guild != null ? Long.valueOf(guild.getId()) : null, guild != null ? guild.getBanner() : null, size, animated);
    }

    public final String getDefaultForGroupDM(long id2) {
        long j = (id2 >>> 22) + SnowflakeUtils.DISCORD_EPOCH;
        return GROUP_DM_DEFAULT_ICONS.get((int) (j % r0.size()));
    }

    public final String getForGuildMember(GuildMember guildMember, Integer sizePx, boolean animated) {
        Intrinsics3.checkNotNullParameter(guildMember, "guildMember");
        return getForGuildMember(guildMember.getAvatarHash(), guildMember.getGuildId(), guildMember.getUserId(), sizePx, animated);
    }

    public final String getForGuildMemberBanner(String guildMemberBanner, long guildId, long userId, Integer sizePx, boolean animated) {
        if ((guildMemberBanner == null || StringsJVM.isBlank(guildMemberBanner)) || guildId == 0 || userId == 0) {
            return null;
        }
        return withSize("https://cdn.discordapp.com/guilds/" + guildId + "/users/" + userId + "/banners/" + guildMemberBanner + '.' + getImageExtension(guildMemberBanner, animated), sizePx);
    }

    public final String getForGuildMemberOrUser(User user, GuildMember guildMember, Integer sizePx, boolean animated) {
        return (guildMember == null || !guildMember.hasAvatar()) ? getForUser(user, animated, sizePx) : getForGuildMember(guildMember, sizePx, animated);
    }

    public final String getForUserBanner(long userId, String bannerHash, Integer sizePx, boolean animated) {
        if (bannerHash == null || StringsJVM.isBlank(bannerHash)) {
            return null;
        }
        return withSize("https://cdn.discordapp.com/banners/" + userId + MentionUtils.SLASH_CHAR + bannerHash + '.' + getImageExtension(bannerHash, animated), sizePx);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String getGiftSplashUrl(long applicationId, String hash, Integer size) {
        String str;
        Integer numValueOf = null;
        if (hash == null) {
            return null;
        }
        if (size != null) {
            size.intValue();
            Integer[] numArr = MEDIA_PROXY_SIZES;
            int length = numArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                Integer num = numArr[i];
                if (num.intValue() > size.intValue()) {
                    numValueOf = num;
                    break;
                }
                i++;
            }
            numValueOf = Integer.valueOf(numValueOf != null ? numValueOf.intValue() : ((Number) _Arrays.last(MEDIA_PROXY_SIZES)).intValue());
        }
        StringBuilder sbU = outline.U("?");
        if (numValueOf != null) {
            numValueOf.intValue();
            str = "size=" + numValueOf + "&keep_aspect_ratio=true";
            if (str == null) {
                str = "keep_aspect_ratio=true";
            }
        }
        sbU.append(str);
        return "https://cdn.discordapp.com/app-icons/" + applicationId + MentionUtils.SLASH_CHAR + hash + '.' + StringUtils2.getSTATIC_IMAGE_EXTENSION() + sbU.toString();
    }

    public final String getGuildSplashUrl(long guildId, String splashHash, Integer size) {
        String str;
        Intrinsics3.checkNotNullParameter(splashHash, "splashHash");
        Integer numValueOf = size != null ? Integer.valueOf(getMediaProxySize(size.intValue())) : null;
        if (BuildConfig.HOST_CDN.length() == 0) {
            str = "https://discord.com/api//guilds/" + guildId + "/splashes/" + splashHash + ".jpg";
        } else {
            str = "https://cdn.discordapp.com/splashes/" + guildId + MentionUtils.SLASH_CHAR + splashHash + '.' + StringUtils2.getSTATIC_IMAGE_EXTENSION();
        }
        StringBuilder sbU = outline.U(str);
        String strQ = numValueOf != null ? outline.q("?size=", numValueOf.intValue()) : null;
        if (strQ == null) {
            strQ = "";
        }
        sbU.append(strQ);
        return sbU.toString();
    }

    public final String getImageExtension(String imageHash, boolean allowAnimation) {
        Intrinsics3.checkNotNullParameter(imageHash, "imageHash");
        return (allowAnimation && isImageHashAnimated(imageHash)) ? ANIMATED_IMAGE_EXTENSION : StringUtils2.getSTATIC_IMAGE_EXTENSION();
    }

    public final String getRoleIconUrl(long roleId, String iconHash, Integer size) {
        String str;
        Intrinsics3.checkNotNullParameter(iconHash, "iconHash");
        Integer numValueOf = size != null ? Integer.valueOf(getMediaProxySize(size.intValue())) : null;
        if (BuildConfig.HOST_CDN.length() == 0) {
            str = "https://discord.com/api//roles/" + roleId + "/icons/" + iconHash + ".png";
        } else {
            str = "https://cdn.discordapp.com/role-icons/" + roleId + MentionUtils.SLASH_CHAR + iconHash + '.' + StringUtils2.getSTATIC_IMAGE_EXTENSION();
        }
        StringBuilder sbU = outline.U(str);
        String strQ = numValueOf != null ? outline.q("?size=", numValueOf.intValue()) : null;
        if (strQ == null) {
            strQ = "";
        }
        sbU.append(strQ);
        return sbU.toString();
    }

    @SuppressLint({"DefaultLocale"})
    public final String getStoreAssetImage(Long applicationId, String imageId, int size) {
        Intrinsics3.checkNotNullParameter(imageId, "imageId");
        int mediaProxySize = getMediaProxySize(size);
        if (applicationId != null && (!StringsJVM.isBlank(BuildConfig.HOST_CDN))) {
            return "https://cdn.discordapp.com/app-assets/" + applicationId + "/store/" + imageId + ".jpg?size=" + mediaProxySize;
        }
        if (applicationId == null) {
            return null;
        }
        return "https://discord.com/api/store/applications/" + applicationId + "/assets/" + imageId + ".jpg?size=" + mediaProxySize;
    }

    public final boolean isDataUrlForGif(String dataUrl) {
        Intrinsics3.checkNotNullParameter(dataUrl, "dataUrl");
        return StringsJVM.startsWith$default(dataUrl, "data:image/gif", false, 2, null);
    }

    public final boolean isImageHashAnimated(String imageHash) {
        Intrinsics3.checkNotNullParameter(imageHash, "imageHash");
        return StringsJVM.startsWith$default(imageHash, "a_", false, 2, null);
    }

    public static /* synthetic */ String getApplicationIcon$default(IconUtils iconUtils, Application application, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 160;
        }
        return iconUtils.getApplicationIcon(application, i);
    }

    public static /* synthetic */ String getBannerForGuild$default(IconUtils iconUtils, Long l, String str, Integer num, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            z2 = false;
        }
        return iconUtils.getBannerForGuild(l, str, num, z2);
    }

    public static /* synthetic */ String getForChannel$default(Channel channel, Integer num, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        return getForChannel(channel, num);
    }

    public static /* synthetic */ String getForGuild$default(Guild guild, String str, boolean z2, Integer num, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        if ((i & 8) != 0) {
            num = null;
        }
        return getForGuild(guild, str, z2, num);
    }

    public static /* synthetic */ String getForGuildMember$default(IconUtils iconUtils, String str, long j, long j2, Integer num, boolean z2, int i, Object obj) {
        return iconUtils.getForGuildMember(str, j, j2, (i & 8) != 0 ? null : num, (i & 16) != 0 ? false : z2);
    }

    public static /* synthetic */ String getForUser$default(Long l, String str, Integer num, boolean z2, Integer num2, int i, Object obj) {
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            z2 = false;
        }
        if ((i & 16) != 0) {
            num2 = null;
        }
        return getForUser(l, str, num, z2, num2);
    }

    public static /* synthetic */ String getGuildSplashUrl$default(IconUtils iconUtils, Guild guild, Integer num, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        return iconUtils.getGuildSplashUrl(guild, num);
    }

    public static /* synthetic */ void setIcon$default(ImageView imageView, String str, int i, int i2, boolean z2, Function1 function1, MGImages.ChangeDetector changeDetector, int i3, Object obj) {
        boolean z3 = (i3 & 16) != 0 ? true : z2;
        if ((i3 & 32) != 0) {
            function1 = null;
        }
        Function1 function12 = function1;
        if ((i3 & 64) != 0) {
            changeDetector = MGImages.AlwaysUpdateChangeDetector.INSTANCE;
        }
        setIcon(imageView, str, i, i2, z3, (Function1<? super ImageRequestBuilder, Unit>) function12, changeDetector);
    }

    public final String getBannerForGuild(Long guildId, String banner, Integer size, boolean animated) {
        String str;
        if (guildId == null || banner == null) {
            return null;
        }
        Integer numValueOf = size != null ? Integer.valueOf(getMediaProxySize(size.intValue())) : null;
        StringBuilder sb = new StringBuilder();
        if (BuildConfig.HOST_CDN.length() == 0) {
            str = "https://discord.com/api//guilds/" + guildId + "/banners/" + banner + ".jpg";
        } else {
            str = "https://cdn.discordapp.com/banners/" + guildId + MentionUtils.SLASH_CHAR + banner + '.' + getImageExtension(banner, animated);
        }
        sb.append(str);
        String strQ = numValueOf != null ? outline.q("?size=", numValueOf.intValue()) : null;
        if (strQ == null) {
            strQ = "";
        }
        sb.append(strQ);
        return sb.toString();
    }

    public static /* synthetic */ void setIcon$default(ImageView imageView, User user, int i, Function1 function1, MGImages.ChangeDetector changeDetector, GuildMember guildMember, int i2, Object obj) {
        int i3 = (i2 & 4) != 0 ? R.dimen.avatar_size_unrestricted : i;
        Function1 function12 = (i2 & 8) != 0 ? null : function1;
        if ((i2 & 16) != 0) {
            changeDetector = MGImages.AlwaysUpdateChangeDetector.INSTANCE;
        }
        setIcon(imageView, user, i3, (Function1<? super ImageRequestBuilder, Unit>) function12, changeDetector, (i2 & 32) != 0 ? null : guildMember);
    }

    public final String getApplicationIcon(Application application, int sizePx) {
        Intrinsics3.checkNotNullParameter(application, "application");
        com.discord.api.user.User bot = application.getBot();
        String icon = application.getIcon();
        String applicationIcon = null;
        if (icon == null || StringsJVM.isBlank(icon)) {
            icon = null;
        }
        CoreUser coreUser = bot != null ? new CoreUser(bot) : null;
        boolean z2 = coreUser != null && (bot.a() instanceof NullSerializable.b);
        int discriminator = (coreUser != null ? coreUser.getDiscriminator() : 0) % 5;
        if (z2) {
            applicationIcon = getForUser$default(coreUser, false, null, 6, null);
        } else if (icon != null) {
            applicationIcon = getApplicationIcon(application.getId(), icon, sizePx);
        }
        return applicationIcon != null ? applicationIcon : outline.r("asset://asset/images/default_avatar_", discriminator, ".png");
    }

    public static final void setIcon(ImageView imageView, String url, int widthPixels, int heightPixels, boolean useSmallCache, Function1<? super ImageRequestBuilder, Unit> transform, MGImages.ChangeDetector changeDetector) {
        Intrinsics3.checkNotNullParameter(imageView, "imageView");
        Intrinsics3.checkNotNullParameter(changeDetector, "changeDetector");
        MGImages.setImage(imageView, url, widthPixels, heightPixels, useSmallCache, transform, changeDetector);
    }

    public static final String getForUser(Long userId, String userAvatar, Integer discriminator, boolean animated, Integer size) {
        if (userId != null) {
            if (-1 == userId.longValue()) {
                return userAvatar;
            }
            if (userAvatar != null) {
                if ((BuildConfig.HOST_CDN.length() == 0 ? 1 : 0) != 0) {
                    return "https://discord.com/api//users/" + userId + "/avatars/" + userAvatar + ".jpg";
                }
                IconUtils iconUtils = INSTANCE;
                return iconUtils.withSize("https://cdn.discordapp.com/avatars/" + userId + MentionUtils.SLASH_CHAR + userAvatar + '.' + iconUtils.getImageExtension(userAvatar, animated), size);
            }
            if (discriminator != null) {
                iIntValue = discriminator.intValue() % 5;
            }
        }
        return outline.r("asset://asset/images/default_avatar_", iIntValue, ".png");
    }

    public static final void setIcon(ImageView imageView, User user, @DimenRes int sizeDimenRes, Function1<? super ImageRequestBuilder, Unit> transform, MGImages.ChangeDetector changeDetector, GuildMember guildMember) {
        Intrinsics3.checkNotNullParameter(imageView, "imageView");
        Intrinsics3.checkNotNullParameter(changeDetector, "changeDetector");
        setIcon(imageView, user != null ? user.getUsername() : null, user != null ? Long.valueOf(user.getId()) : null, user != null ? user.getAvatar() : null, user != null ? Integer.valueOf(user.getDiscriminator()) : null, sizeDimenRes, transform, changeDetector, guildMember);
    }

    public static /* synthetic */ void setIcon$default(ImageView imageView, String str, Long l, String str2, Integer num, int i, Function1 function1, MGImages.ChangeDetector changeDetector, GuildMember guildMember, int i2, Object obj) {
        setIcon(imageView, str, l, str2, num, (i2 & 32) != 0 ? R.dimen.avatar_size_unrestricted : i, (i2 & 64) != 0 ? null : function1, (i2 & 128) != 0 ? MGImages.AlwaysUpdateChangeDetector.INSTANCE : changeDetector, (i2 & 256) != 0 ? null : guildMember);
    }

    public final String getForGuildMember(String guildMemberAvatar, long guildId, long userId, Integer sizePx, boolean animated) {
        if ((guildMemberAvatar == null || StringsJVM.isBlank(guildMemberAvatar)) || guildId == 0 || userId == 0) {
            return null;
        }
        return withSize("https://cdn.discordapp.com/guilds/" + guildId + "/users/" + userId + "/avatars/" + guildMemberAvatar + '.' + getImageExtension(guildMemberAvatar, animated), sizePx);
    }

    public static final String getForChannel(Channel channel, Integer size) {
        if (channel == null) {
            return null;
        }
        if (channel.getType() == 1) {
            return getForUser$default(ChannelUtils.a(channel), false, null, 6, null);
        }
        return getForChannel(channel.getId(), channel.getIcon(), channel.getType(), false, size);
    }

    public final String getGuildSplashUrl(Guild guild, Integer size) {
        if ((guild != null ? guild.getSplash() : null) == null) {
            return null;
        }
        return getGuildSplashUrl(guild.getId(), guild.getSplash(), size);
    }

    public static /* synthetic */ void setIcon$default(ImageView imageView, Channel channel, int i, MGImages.ChangeDetector changeDetector, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = R.dimen.avatar_size_unrestricted;
        }
        if ((i2 & 8) != 0) {
            changeDetector = MGImages.AlwaysUpdateChangeDetector.INSTANCE;
        }
        setIcon(imageView, channel, i, changeDetector);
    }

    public static /* synthetic */ void setIcon$default(ImageView imageView, Guild guild, int i, MGImages.ChangeDetector changeDetector, boolean z2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = R.dimen.avatar_size_unrestricted;
        }
        if ((i2 & 8) != 0) {
            changeDetector = MGImages.AlwaysUpdateChangeDetector.INSTANCE;
        }
        if ((i2 & 16) != 0) {
            z2 = false;
        }
        setIcon(imageView, guild, i, changeDetector, z2);
    }

    public static final String getForGuild(Guild guild, String defaultIcon, boolean animated, Integer size) {
        return getForGuild(guild != null ? Long.valueOf(guild.getId()) : null, guild != null ? guild.getIcon() : null, defaultIcon, animated, size);
    }

    public static final void setIcon(ImageView imageView, String username, Long userId, String userAvatar, Integer discriminator, @DimenRes int sizeDimenRes, Function1<? super ImageRequestBuilder, Unit> transform, MGImages.ChangeDetector changeDetector, GuildMember guildMember) {
        String forUser$default;
        Intrinsics3.checkNotNullParameter(imageView, "imageView");
        Intrinsics3.checkNotNullParameter(changeDetector, "changeDetector");
        Integer numValueOf = sizeDimenRes != R.dimen.avatar_size_unrestricted ? Integer.valueOf(imageView.getResources().getDimensionPixelSize(sizeDimenRes)) : null;
        if (guildMember != null && guildMember.hasAvatar()) {
            forUser$default = getForGuildMember$default(INSTANCE, guildMember, numValueOf, false, 4, null);
        } else {
            forUser$default = getForUser$default(userId, userAvatar, discriminator, false, numValueOf, 8, null);
        }
        setIcon$default(imageView, forUser$default, numValueOf != null ? numValueOf.intValue() : 0, numValueOf != null ? numValueOf.intValue() : 0, false, transform, changeDetector, 16, null);
        imageView.setContentDescription(username);
    }

    public static /* synthetic */ void setIcon$default(ImageView imageView, GuildRole guildRole, int i, MGImages.ChangeDetector changeDetector, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = R.dimen.avatar_size_unrestricted;
        }
        if ((i2 & 8) != 0) {
            changeDetector = MGImages.AlwaysUpdateChangeDetector.INSTANCE;
        }
        setIcon(imageView, guildRole, i, changeDetector);
    }

    public static final void setIcon(ImageView imageView, Channel entity, @DimenRes int sizeDimenRes, MGImages.ChangeDetector changeDetector) {
        Intrinsics3.checkNotNullParameter(imageView, "imageView");
        Intrinsics3.checkNotNullParameter(changeDetector, "changeDetector");
        setIcon$default(imageView, getForChannel$default(entity, null, 2, null), sizeDimenRes, (Function1) null, changeDetector, 8, (Object) null);
        imageView.setContentDescription(entity != null ? ChannelUtils.c(entity) : null);
    }

    public static final void setIcon(ImageView imageView, Guild entity, @DimenRes int sizeDimenRes, MGImages.ChangeDetector changeDetector, boolean animated) {
        Intrinsics3.checkNotNullParameter(imageView, "imageView");
        Intrinsics3.checkNotNullParameter(changeDetector, "changeDetector");
        setIcon$default(imageView, getForGuild$default(entity, null, animated, null, 10, null), sizeDimenRes, (Function1) null, changeDetector, 8, (Object) null);
        imageView.setContentDescription(entity != null ? entity.getName() : null);
    }

    public static final void setIcon(ImageView imageView, GuildRole entity, @DimenRes int sizeDimenRes, MGImages.ChangeDetector changeDetector) {
        String icon;
        Intrinsics3.checkNotNullParameter(imageView, "imageView");
        Intrinsics3.checkNotNullParameter(changeDetector, "changeDetector");
        if (entity == null || (icon = entity.getIcon()) == null) {
            return;
        }
        setIcon$default(imageView, getRoleIconUrl$default(INSTANCE, entity.getId(), icon, null, 4, null), sizeDimenRes, (Function1) null, changeDetector, 8, (Object) null);
    }
}
