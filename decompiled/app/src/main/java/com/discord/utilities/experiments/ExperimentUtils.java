package com.discord.utilities.experiments;

import com.discord.api.guild.GuildFeature;
import com.discord.api.guild.GuildHubType;
import com.discord.models.experiments.domain.ExperimentHash;
import com.discord.models.experiments.dto.GuildExperimentBucketDto;
import com.discord.models.experiments.dto.GuildExperimentDto;
import com.discord.models.experiments.dto.GuildExperimentFilter;
import com.discord.models.experiments.dto.GuildExperimentOverridesDto;
import com.discord.models.experiments.dto.GuildExperimentPopulationDto;
import com.discord.models.guild.Guild;
import com.discord.widgets.chat.input.MentionUtils;
import d0.d0._Ranges;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ranges.Ranges2;

/* compiled from: ExperimentUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J;\u0010\r\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/discord/utilities/experiments/ExperimentUtils;", "", "", "experimentName", "", "Lcom/discord/primitives/GuildId;", "guildId", "", "guildMemberCount", "Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/models/experiments/dto/GuildExperimentDto;", "experiment", "computeGuildExperimentBucket", "(Ljava/lang/String;JILcom/discord/models/guild/Guild;Lcom/discord/models/experiments/dto/GuildExperimentDto;)I", "BUCKET_NOT_ELIGIBLE", "I", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ExperimentUtils {
    public static final int BUCKET_NOT_ELIGIBLE = -1;
    public static final ExperimentUtils INSTANCE = new ExperimentUtils();

    private ExperimentUtils() {
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x00a0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x00a0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x007c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x007c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0190 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:149:? A[LOOP:5: B:80:0x0149->B:149:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int computeGuildExperimentBucket(String experimentName, long guildId, int guildMemberCount, Guild guild, GuildExperimentDto experiment) {
        Object obj;
        boolean z2;
        boolean z3;
        boolean z4;
        String str = experimentName;
        Intrinsics3.checkNotNullParameter(str, "experimentName");
        Intrinsics3.checkNotNullParameter(experiment, "experiment");
        for (GuildExperimentOverridesDto guildExperimentOverridesDto : experiment.getOverrides()) {
            if (guildExperimentOverridesDto.getGuilds().contains(Long.valueOf(guildId))) {
                return guildExperimentOverridesDto.getBucket();
            }
        }
        StringBuilder sb = new StringBuilder();
        String hashKey = experiment.getHashKey();
        if (hashKey != null) {
            str = hashKey;
        }
        sb.append(str);
        sb.append(MentionUtils.EMOJIS_AND_STICKERS_CHAR);
        sb.append(guildId);
        long jFrom = ExperimentHash.INSTANCE.from(sb.toString()) % 10000;
        for (GuildExperimentPopulationDto guildExperimentPopulationDto : experiment.getPopulations()) {
            Iterator<GuildExperimentFilter> it = guildExperimentPopulationDto.getFilters().iterator();
            boolean z5 = true;
            while (true) {
                obj = null;
                if (!it.hasNext()) {
                    break;
                }
                GuildExperimentFilter next = it.next();
                if (next instanceof GuildExperimentFilter.GuildIdsFilter) {
                    if (!((GuildExperimentFilter.GuildIdsFilter) next).getGuildIds().contains(Long.valueOf(guildId))) {
                        z5 = false;
                    }
                } else if (next instanceof GuildExperimentFilter.GuildIdRangeFilter) {
                    if (!((GuildExperimentFilter.GuildIdRangeFilter) next).getRange().contains(guildId)) {
                        z5 = false;
                    }
                } else if (next instanceof GuildExperimentFilter.GuildMemberCountRangeFilter) {
                    if (!_Ranges.longRangeContains(((GuildExperimentFilter.GuildMemberCountRangeFilter) next).getRange(), guildMemberCount)) {
                        z5 = false;
                    }
                } else if (next instanceof GuildExperimentFilter.GuildHasFeatureFilter) {
                    Set<GuildFeature> features = ((GuildExperimentFilter.GuildHasFeatureFilter) next).getFeatures();
                    if ((features instanceof Collection) && features.isEmpty()) {
                        z3 = true;
                        if (!z3) {
                        }
                    } else {
                        Iterator<T> it2 = features.iterator();
                        while (it2.hasNext()) {
                            if (guild != null && guild.hasFeature((GuildFeature) it2.next())) {
                                z3 = false;
                                break;
                            }
                        }
                        z3 = true;
                        if (!z3) {
                            z5 = false;
                        }
                    }
                } else if (next instanceof GuildExperimentFilter.GuildHubTypesFeatureFilter) {
                    Set<GuildHubType> hubTypes = ((GuildExperimentFilter.GuildHubTypesFeatureFilter) next).getHubTypes();
                    if ((hubTypes instanceof Collection) && hubTypes.isEmpty()) {
                        z4 = true;
                        if (!z4) {
                        }
                    } else {
                        Iterator<T> it3 = hubTypes.iterator();
                        while (it3.hasNext()) {
                            if ((guild != null ? guild.getHubType() : null) == ((GuildHubType) it3.next())) {
                                z4 = false;
                                break;
                            }
                        }
                        z4 = true;
                        if (!z4) {
                            z5 = false;
                        }
                    }
                }
            }
            if (z5) {
                Iterator<T> it4 = guildExperimentPopulationDto.getBuckets().iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        break;
                    }
                    Object next2 = it4.next();
                    List<Ranges2> positions = ((GuildExperimentBucketDto) next2).getPositions();
                    if (!(positions instanceof Collection) || !positions.isEmpty()) {
                        for (Ranges2 ranges2 : positions) {
                            if (jFrom >= ((long) ranges2.getFirst()) && jFrom < ((long) ranges2.getLast())) {
                                z2 = true;
                                break;
                            }
                        }
                        z2 = false;
                        if (!z2) {
                            obj = next2;
                            break;
                        }
                    } else {
                        z2 = false;
                        if (!z2) {
                        }
                    }
                }
                GuildExperimentBucketDto guildExperimentBucketDto = (GuildExperimentBucketDto) obj;
                if (guildExperimentBucketDto != null) {
                    return guildExperimentBucketDto.getBucket();
                }
                return 0;
            }
        }
        return -1;
    }
}
