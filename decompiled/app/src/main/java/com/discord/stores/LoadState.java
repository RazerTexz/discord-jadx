package com.discord.stores;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: StoreApplicationCommands.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\u0007\b\t\n\u000b\f\rB\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u0082\u0001\u0007\u000e\u000f\u0010\u0011\u0012\u0013\u0014¨\u0006\u0015"}, d2 = {"Lcom/discord/stores/LoadState;", "", "", "isLoading", "()Z", "<init>", "()V", "JustLoadedAll", "JustLoadedDown", "JustLoadedUp", "Loading", "LoadingDown", "LoadingUp", "None", "Lcom/discord/stores/LoadState$None;", "Lcom/discord/stores/LoadState$Loading;", "Lcom/discord/stores/LoadState$LoadingUp;", "Lcom/discord/stores/LoadState$LoadingDown;", "Lcom/discord/stores/LoadState$JustLoadedAll;", "Lcom/discord/stores/LoadState$JustLoadedUp;", "Lcom/discord/stores/LoadState$JustLoadedDown;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public abstract class LoadState {

    /* compiled from: StoreApplicationCommands.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/LoadState$JustLoadedAll;", "Lcom/discord/stores/LoadState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class JustLoadedAll extends LoadState {
        public static final JustLoadedAll INSTANCE = new JustLoadedAll();

        private JustLoadedAll() {
            super(null);
        }
    }

    /* compiled from: StoreApplicationCommands.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/LoadState$JustLoadedDown;", "Lcom/discord/stores/LoadState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class JustLoadedDown extends LoadState {
        public static final JustLoadedDown INSTANCE = new JustLoadedDown();

        private JustLoadedDown() {
            super(null);
        }
    }

    /* compiled from: StoreApplicationCommands.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/LoadState$JustLoadedUp;", "Lcom/discord/stores/LoadState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class JustLoadedUp extends LoadState {
        public static final JustLoadedUp INSTANCE = new JustLoadedUp();

        private JustLoadedUp() {
            super(null);
        }
    }

    /* compiled from: StoreApplicationCommands.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/LoadState$Loading;", "Lcom/discord/stores/LoadState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Loading extends LoadState {
        public static final Loading INSTANCE = new Loading();

        private Loading() {
            super(null);
        }
    }

    /* compiled from: StoreApplicationCommands.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/LoadState$LoadingDown;", "Lcom/discord/stores/LoadState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class LoadingDown extends LoadState {
        public static final LoadingDown INSTANCE = new LoadingDown();

        private LoadingDown() {
            super(null);
        }
    }

    /* compiled from: StoreApplicationCommands.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/LoadState$LoadingUp;", "Lcom/discord/stores/LoadState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class LoadingUp extends LoadState {
        public static final LoadingUp INSTANCE = new LoadingUp();

        private LoadingUp() {
            super(null);
        }
    }

    /* compiled from: StoreApplicationCommands.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/LoadState$None;", "Lcom/discord/stores/LoadState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class None extends LoadState {
        public static final None INSTANCE = new None();

        private None() {
            super(null);
        }
    }

    private LoadState() {
    }

    public final boolean isLoading() {
        return (this instanceof Loading) || (this instanceof LoadingUp) || (this instanceof LoadingDown);
    }

    public /* synthetic */ LoadState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
