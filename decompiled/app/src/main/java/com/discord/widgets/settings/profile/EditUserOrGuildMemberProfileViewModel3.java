package com.discord.widgets.settings.profile;

import androidx.core.app.NotificationCompat;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import kotlin.Metadata;
import kotlin.Tuples2;
import rx.functions.Func2;

/* compiled from: EditUserOrGuildMemberProfileViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a6\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00000\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0003 \u0001*\u001a\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00000\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00050\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/discord/models/user/MeUser;", "kotlin.jvm.PlatformType", "meUser", "Lcom/discord/models/guild/Guild;", "guild", "Lkotlin/Pair;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/user/MeUser;Lcom/discord/models/guild/Guild;)Lkotlin/Pair;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.profile.SettingsUserProfileViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class EditUserOrGuildMemberProfileViewModel3<T1, T2, R> implements Func2<MeUser, Guild, Tuples2<? extends MeUser, ? extends Guild>> {
    public static final EditUserOrGuildMemberProfileViewModel3 INSTANCE = new EditUserOrGuildMemberProfileViewModel3();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Tuples2<? extends MeUser, ? extends Guild> call(MeUser meUser, Guild guild) {
        return call2(meUser, guild);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Tuples2<MeUser, Guild> call2(MeUser meUser, Guild guild) {
        return new Tuples2<>(meUser, guild);
    }
}
