package com.discord.utilities.guilds;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.discord.api.guild.GuildFeature;
import com.discord.api.guildjoinrequest.ApplicationStatus;
import com.discord.api.guildjoinrequest.GuildJoinRequest;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelInvite;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.widgets.servers.member_verification.MemberVerificationPendingDialog;
import com.discord.widgets.servers.member_verification.MemberVerificationSuccessDialog;
import com.discord.widgets.servers.member_verification.WidgetMemberVerification;
import d0.Standard2;
import d0.t.Sets5;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: MemberVerificationUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ#\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ%\u0010\u000e\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ7\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00102\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J[\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ%\u0010\u001c\u001a\u00020\u001b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/discord/utilities/guilds/MemberVerificationUtils;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "Lcom/discord/primitives/GuildId;", "guildId", "", "showMemberVerificationPendingDialog", "(Landroidx/fragment/app/FragmentManager;J)V", "Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/models/domain/ModelInvite;", "invite", "showMemberVerificationSuccessDialog", "(Lcom/discord/models/guild/Guild;Lcom/discord/models/domain/ModelInvite;)V", "Landroid/content/Context;", "context", "", ModelAuditLogEntry.CHANGE_KEY_LOCATION, "showMemberVerificationWidget", "(Landroid/content/Context;JLjava/lang/String;Lcom/discord/models/domain/ModelInvite;)V", "Lkotlin/Function0;", "onMembershipGated", "onFullMembership", "maybeShowVerificationGate", "(Landroid/content/Context;Landroidx/fragment/app/FragmentManager;JLjava/lang/String;Lcom/discord/models/domain/ModelInvite;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "", "hasVerificationGate", "(Lcom/discord/models/guild/Guild;Lcom/discord/models/domain/ModelInvite;)Z", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class MemberVerificationUtils {
    public static final MemberVerificationUtils INSTANCE = new MemberVerificationUtils();

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ApplicationStatus.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[ApplicationStatus.APPROVED.ordinal()] = 1;
            iArr[ApplicationStatus.PENDING.ordinal()] = 2;
            iArr[ApplicationStatus.REJECTED.ordinal()] = 3;
            iArr[ApplicationStatus.STARTED.ordinal()] = 4;
            iArr[ApplicationStatus.UNKNOWN.ordinal()] = 5;
        }
    }

    /* compiled from: MemberVerificationUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.guilds.MemberVerificationUtils$maybeShowVerificationGate$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    }

    private MemberVerificationUtils() {
    }

    public static /* synthetic */ boolean hasVerificationGate$default(MemberVerificationUtils memberVerificationUtils, Guild guild, ModelInvite modelInvite, int i, Object obj) {
        if ((i & 1) != 0) {
            guild = null;
        }
        if ((i & 2) != 0) {
            modelInvite = null;
        }
        return memberVerificationUtils.hasVerificationGate(guild, modelInvite);
    }

    public static /* synthetic */ void maybeShowVerificationGate$default(MemberVerificationUtils memberVerificationUtils, Context context, FragmentManager fragmentManager, long j, String str, ModelInvite modelInvite, Function0 function0, Function0 function02, int i, Object obj) {
        memberVerificationUtils.maybeShowVerificationGate(context, fragmentManager, j, str, (i & 16) != 0 ? null : modelInvite, (i & 32) != 0 ? AnonymousClass1.INSTANCE : function0, function02);
    }

    private final void showMemberVerificationPendingDialog(FragmentManager fragmentManager, long guildId) {
        MemberVerificationPendingDialog.Companion.show$default(MemberVerificationPendingDialog.INSTANCE, fragmentManager, guildId, null, 4, null);
    }

    private final void showMemberVerificationSuccessDialog(Guild guild, ModelInvite invite) {
        String name;
        com.discord.api.guild.Guild guild2;
        if (guild == null || (name = guild.getName()) == null) {
            name = (invite == null || (guild2 = invite.guild) == null) ? null : guild2.getName();
        }
        if (name == null || guild == null) {
            return;
        }
        MemberVerificationSuccessDialog.INSTANCE.enqueue(guild.getId());
    }

    public static /* synthetic */ void showMemberVerificationSuccessDialog$default(MemberVerificationUtils memberVerificationUtils, Guild guild, ModelInvite modelInvite, int i, Object obj) {
        if ((i & 2) != 0) {
            modelInvite = null;
        }
        memberVerificationUtils.showMemberVerificationSuccessDialog(guild, modelInvite);
    }

    private final void showMemberVerificationWidget(Context context, long guildId, String location, ModelInvite invite) {
        WidgetMemberVerification.INSTANCE.create(context, guildId, location, invite);
    }

    public static /* synthetic */ void showMemberVerificationWidget$default(MemberVerificationUtils memberVerificationUtils, Context context, long j, String str, ModelInvite modelInvite, int i, Object obj) {
        if ((i & 8) != 0) {
            modelInvite = null;
        }
        memberVerificationUtils.showMemberVerificationWidget(context, j, str, modelInvite);
    }

    public final boolean hasVerificationGate(Guild guild, ModelInvite invite) {
        Collection collectionM;
        com.discord.api.guild.Guild guild2;
        if (guild == null || (collectionM = guild.getFeatures()) == null) {
            collectionM = (invite == null || (guild2 = invite.guild) == null) ? null : guild2.m();
        }
        if (collectionM == null) {
            collectionM = Sets5.emptySet();
        }
        return collectionM.contains(GuildFeature.MEMBER_VERIFICATION_GATE_ENABLED) && collectionM.contains(GuildFeature.COMMUNITY);
    }

    public final void maybeShowVerificationGate(Context context, FragmentManager fragmentManager, long guildId, String location, ModelInvite invite, Function0<Unit> onMembershipGated, Function0<Unit> onFullMembership) {
        int iOrdinal;
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        Intrinsics3.checkNotNullParameter(onMembershipGated, "onMembershipGated");
        Intrinsics3.checkNotNullParameter(onFullMembership, "onFullMembership");
        StoreStream.Companion companion = StoreStream.INSTANCE;
        StoreGuilds guilds = companion.getGuilds();
        GuildMember member = guilds.getMember(guildId, companion.getUsers().getMeSnapshot().getId());
        if (member != null && !member.getPending()) {
            onFullMembership.invoke();
            return;
        }
        Guild guild = guilds.getGuild(guildId);
        if (!hasVerificationGate(guild, invite)) {
            onFullMembership.invoke();
            return;
        }
        GuildJoinRequest guildJoinRequest = companion.getGuildJoinRequests().getGuildJoinRequest(guildId);
        ApplicationStatus applicationStatus = guildJoinRequest != null ? guildJoinRequest.getApplicationStatus() : null;
        if (applicationStatus == null || (iOrdinal = applicationStatus.ordinal()) == 0) {
            onMembershipGated.invoke();
            showMemberVerificationWidget(context, guildId, location, invite);
            return;
        }
        if (iOrdinal == 1) {
            onMembershipGated.invoke();
            showMemberVerificationPendingDialog(fragmentManager, guildId);
        } else if (iOrdinal == 2) {
            onMembershipGated.invoke();
            showMemberVerificationPendingDialog(fragmentManager, guildId);
        } else if (iOrdinal != 3) {
            if (iOrdinal == 4) {
                throw new Standard2(null, 1, null);
            }
        } else {
            onFullMembership.invoke();
            showMemberVerificationSuccessDialog(guild, invite);
        }
    }
}
