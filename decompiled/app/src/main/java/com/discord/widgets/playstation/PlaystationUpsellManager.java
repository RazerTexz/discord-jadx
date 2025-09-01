package com.discord.widgets.playstation;

import android.content.SharedPreferences;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.models.user.User;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreUserConnections;
import com.discord.utilities.platform.Platform;
import com.discord.utilities.time.Clock;
import com.discord.utilities.user.UserUtils;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;

/* compiled from: PlaystationUpsellManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u001f\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\r\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/discord/widgets/playstation/PlaystationUpsellManager;", "", "", "hasBeenShown", "()Z", "Lcom/discord/models/user/User;", "user", "isAccountOldEnough", "(Lcom/discord/models/user/User;)Z", "Lcom/discord/stores/StoreUserConnections$State;", "connectedAccountsState", "isUserMissingPlaystationAccountIntegration", "(Lcom/discord/stores/StoreUserConnections$State;)Z", "canShow", "(Lcom/discord/models/user/User;Lcom/discord/stores/StoreUserConnections$State;)Z", "", "setHasBeenShown", "()V", "Landroid/content/SharedPreferences;", "sharedPreferences", "Landroid/content/SharedPreferences;", "Lcom/discord/stores/StoreExperiments;", "experimentStore", "Lcom/discord/stores/StoreExperiments;", "Lcom/discord/utilities/time/Clock;", "clock", "Lcom/discord/utilities/time/Clock;", "<init>", "(Landroid/content/SharedPreferences;Lcom/discord/stores/StoreExperiments;Lcom/discord/utilities/time/Clock;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class PlaystationUpsellManager {
    private static final String SHOWN_CACHE_KEY = "HAS_PLAYSTATION_UPSELL_BEEN_SHOWN";
    private final Clock clock;
    private final StoreExperiments experimentStore;
    private final SharedPreferences sharedPreferences;

    public PlaystationUpsellManager(SharedPreferences sharedPreferences, StoreExperiments storeExperiments, Clock clock) {
        Intrinsics3.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        Intrinsics3.checkNotNullParameter(storeExperiments, "experimentStore");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        this.sharedPreferences = sharedPreferences;
        this.experimentStore = storeExperiments;
        this.clock = clock;
    }

    private final boolean hasBeenShown() {
        return this.sharedPreferences.getBoolean(SHOWN_CACHE_KEY, false);
    }

    private final boolean isAccountOldEnough(User user) {
        return UserUtils.INSTANCE.getAgeMs(user, this.clock) > 604800000;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean isUserMissingPlaystationAccountIntegration(StoreUserConnections.State connectedAccountsState) {
        boolean z2;
        if (!Intrinsics3.areEqual(connectedAccountsState, StoreUserConnections.State.Loading.INSTANCE)) {
            if ((connectedAccountsState instanceof Collection) && connectedAccountsState.isEmpty()) {
                z2 = true;
                if (!z2) {
                }
            } else {
                Iterator<ConnectedAccount> it = connectedAccountsState.iterator();
                while (it.hasNext()) {
                    if (Platform.INSTANCE.from(it.next()) == Platform.PLAYSTATION) {
                        z2 = false;
                        break;
                    }
                }
                z2 = true;
                if (!z2) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean canShow(User user, StoreUserConnections.State connectedAccountsState) {
        Intrinsics3.checkNotNullParameter(user, "user");
        Intrinsics3.checkNotNullParameter(connectedAccountsState, "connectedAccountsState");
        return isAccountOldEnough(user) && isUserMissingPlaystationAccountIntegration(connectedAccountsState) && !hasBeenShown() && PlaystationExperimentUtils.canSeePlaystationUpsells(this.experimentStore);
    }

    public final void setHasBeenShown() {
        this.sharedPreferences.edit().putBoolean(SHOWN_CACHE_KEY, true).apply();
    }
}
