package com.discord.utilities.channel;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: GuildChannelIconUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\t\u0004\u0005\u0006\u0007\b\t\n\u000b\fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0012\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e¨\u0006\u001f"}, d2 = {"Lcom/discord/utilities/channel/GuildChannelIconType;", "", "<init>", "()V", "Announcements", "Directory", "Forum", "ForumPost", "Locked", "NSFW", "Text", "Thread", "Voice", "Lcom/discord/utilities/channel/GuildChannelIconType$NSFW$Text;", "Lcom/discord/utilities/channel/GuildChannelIconType$NSFW$Announcements;", "Lcom/discord/utilities/channel/GuildChannelIconType$NSFW$Thread;", "Lcom/discord/utilities/channel/GuildChannelIconType$NSFW$Voice;", "Lcom/discord/utilities/channel/GuildChannelIconType$NSFW$Forum;", "Lcom/discord/utilities/channel/GuildChannelIconType$NSFW$ForumPost;", "Lcom/discord/utilities/channel/GuildChannelIconType$Locked$Text;", "Lcom/discord/utilities/channel/GuildChannelIconType$Locked$Announcements;", "Lcom/discord/utilities/channel/GuildChannelIconType$Locked$Thread;", "Lcom/discord/utilities/channel/GuildChannelIconType$Locked$Forum;", "Lcom/discord/utilities/channel/GuildChannelIconType$Locked$ForumPost;", "Lcom/discord/utilities/channel/GuildChannelIconType$Thread;", "Lcom/discord/utilities/channel/GuildChannelIconType$Text;", "Lcom/discord/utilities/channel/GuildChannelIconType$Announcements;", "Lcom/discord/utilities/channel/GuildChannelIconType$Directory;", "Lcom/discord/utilities/channel/GuildChannelIconType$Voice;", "Lcom/discord/utilities/channel/GuildChannelIconType$Forum;", "Lcom/discord/utilities/channel/GuildChannelIconType$ForumPost;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.channel.GuildChannelIconType, reason: use source file name */
/* loaded from: classes2.dex */
public abstract class GuildChannelIconUtils {

    /* compiled from: GuildChannelIconUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/utilities/channel/GuildChannelIconType$Announcements;", "Lcom/discord/utilities/channel/GuildChannelIconType;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.channel.GuildChannelIconType$Announcements */
    public static final class Announcements extends GuildChannelIconUtils {
        public static final Announcements INSTANCE = new Announcements();

        private Announcements() {
            super(null);
        }
    }

    /* compiled from: GuildChannelIconUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/utilities/channel/GuildChannelIconType$Directory;", "Lcom/discord/utilities/channel/GuildChannelIconType;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.channel.GuildChannelIconType$Directory */
    public static final class Directory extends GuildChannelIconUtils {
        public static final Directory INSTANCE = new Directory();

        private Directory() {
            super(null);
        }
    }

    /* compiled from: GuildChannelIconUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/utilities/channel/GuildChannelIconType$Forum;", "Lcom/discord/utilities/channel/GuildChannelIconType;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.channel.GuildChannelIconType$Forum */
    public static final class Forum extends GuildChannelIconUtils {
        public static final Forum INSTANCE = new Forum();

        private Forum() {
            super(null);
        }
    }

    /* compiled from: GuildChannelIconUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/utilities/channel/GuildChannelIconType$ForumPost;", "Lcom/discord/utilities/channel/GuildChannelIconType;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.channel.GuildChannelIconType$ForumPost */
    public static final class ForumPost extends GuildChannelIconUtils {
        public static final ForumPost INSTANCE = new ForumPost();

        private ForumPost() {
            super(null);
        }
    }

    /* compiled from: GuildChannelIconUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\b6\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\t"}, d2 = {"Lcom/discord/utilities/channel/GuildChannelIconType$Locked;", "", "<init>", "()V", "Announcements", "Forum", "ForumPost", "Text", "Thread", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.channel.GuildChannelIconType$Locked */
    public static abstract class Locked {

        /* compiled from: GuildChannelIconUtils.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/utilities/channel/GuildChannelIconType$Locked$Announcements;", "Lcom/discord/utilities/channel/GuildChannelIconType;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        /* renamed from: com.discord.utilities.channel.GuildChannelIconType$Locked$Announcements */
        public static final class Announcements extends GuildChannelIconUtils {
            public static final Announcements INSTANCE = new Announcements();

            private Announcements() {
                super(null);
            }
        }

        /* compiled from: GuildChannelIconUtils.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/utilities/channel/GuildChannelIconType$Locked$Forum;", "Lcom/discord/utilities/channel/GuildChannelIconType;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        /* renamed from: com.discord.utilities.channel.GuildChannelIconType$Locked$Forum */
        public static final class Forum extends GuildChannelIconUtils {
            public static final Forum INSTANCE = new Forum();

            private Forum() {
                super(null);
            }
        }

        /* compiled from: GuildChannelIconUtils.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/utilities/channel/GuildChannelIconType$Locked$ForumPost;", "Lcom/discord/utilities/channel/GuildChannelIconType;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        /* renamed from: com.discord.utilities.channel.GuildChannelIconType$Locked$ForumPost */
        public static final class ForumPost extends GuildChannelIconUtils {
            public static final ForumPost INSTANCE = new ForumPost();

            private ForumPost() {
                super(null);
            }
        }

        /* compiled from: GuildChannelIconUtils.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/utilities/channel/GuildChannelIconType$Locked$Text;", "Lcom/discord/utilities/channel/GuildChannelIconType;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        /* renamed from: com.discord.utilities.channel.GuildChannelIconType$Locked$Text */
        public static final class Text extends GuildChannelIconUtils {
            public static final Text INSTANCE = new Text();

            private Text() {
                super(null);
            }
        }

        /* compiled from: GuildChannelIconUtils.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/utilities/channel/GuildChannelIconType$Locked$Thread;", "Lcom/discord/utilities/channel/GuildChannelIconType;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        /* renamed from: com.discord.utilities.channel.GuildChannelIconType$Locked$Thread */
        public static final class Thread extends GuildChannelIconUtils {
            public static final Thread INSTANCE = new Thread();

            private Thread() {
                super(null);
            }
        }

        private Locked() {
        }
    }

    /* compiled from: GuildChannelIconUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\b6\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\n"}, d2 = {"Lcom/discord/utilities/channel/GuildChannelIconType$NSFW;", "", "<init>", "()V", "Announcements", "Forum", "ForumPost", "Text", "Thread", "Voice", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.channel.GuildChannelIconType$NSFW */
    public static abstract class NSFW {

        /* compiled from: GuildChannelIconUtils.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/utilities/channel/GuildChannelIconType$NSFW$Announcements;", "Lcom/discord/utilities/channel/GuildChannelIconType;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        /* renamed from: com.discord.utilities.channel.GuildChannelIconType$NSFW$Announcements */
        public static final class Announcements extends GuildChannelIconUtils {
            public static final Announcements INSTANCE = new Announcements();

            private Announcements() {
                super(null);
            }
        }

        /* compiled from: GuildChannelIconUtils.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/utilities/channel/GuildChannelIconType$NSFW$Forum;", "Lcom/discord/utilities/channel/GuildChannelIconType;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        /* renamed from: com.discord.utilities.channel.GuildChannelIconType$NSFW$Forum */
        public static final class Forum extends GuildChannelIconUtils {
            public static final Forum INSTANCE = new Forum();

            private Forum() {
                super(null);
            }
        }

        /* compiled from: GuildChannelIconUtils.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/utilities/channel/GuildChannelIconType$NSFW$ForumPost;", "Lcom/discord/utilities/channel/GuildChannelIconType;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        /* renamed from: com.discord.utilities.channel.GuildChannelIconType$NSFW$ForumPost */
        public static final class ForumPost extends GuildChannelIconUtils {
            public static final ForumPost INSTANCE = new ForumPost();

            private ForumPost() {
                super(null);
            }
        }

        /* compiled from: GuildChannelIconUtils.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/utilities/channel/GuildChannelIconType$NSFW$Text;", "Lcom/discord/utilities/channel/GuildChannelIconType;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        /* renamed from: com.discord.utilities.channel.GuildChannelIconType$NSFW$Text */
        public static final class Text extends GuildChannelIconUtils {
            public static final Text INSTANCE = new Text();

            private Text() {
                super(null);
            }
        }

        /* compiled from: GuildChannelIconUtils.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/utilities/channel/GuildChannelIconType$NSFW$Thread;", "Lcom/discord/utilities/channel/GuildChannelIconType;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        /* renamed from: com.discord.utilities.channel.GuildChannelIconType$NSFW$Thread */
        public static final class Thread extends GuildChannelIconUtils {
            public static final Thread INSTANCE = new Thread();

            private Thread() {
                super(null);
            }
        }

        /* compiled from: GuildChannelIconUtils.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/utilities/channel/GuildChannelIconType$NSFW$Voice;", "Lcom/discord/utilities/channel/GuildChannelIconType;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        /* renamed from: com.discord.utilities.channel.GuildChannelIconType$NSFW$Voice */
        public static final class Voice extends GuildChannelIconUtils {
            public static final Voice INSTANCE = new Voice();

            private Voice() {
                super(null);
            }
        }

        private NSFW() {
        }
    }

    /* compiled from: GuildChannelIconUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/utilities/channel/GuildChannelIconType$Text;", "Lcom/discord/utilities/channel/GuildChannelIconType;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.channel.GuildChannelIconType$Text */
    public static final class Text extends GuildChannelIconUtils {
        public static final Text INSTANCE = new Text();

        private Text() {
            super(null);
        }
    }

    /* compiled from: GuildChannelIconUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/utilities/channel/GuildChannelIconType$Thread;", "Lcom/discord/utilities/channel/GuildChannelIconType;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.channel.GuildChannelIconType$Thread */
    public static final class Thread extends GuildChannelIconUtils {
        public static final Thread INSTANCE = new Thread();

        private Thread() {
            super(null);
        }
    }

    /* compiled from: GuildChannelIconUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/utilities/channel/GuildChannelIconType$Voice;", "Lcom/discord/utilities/channel/GuildChannelIconType;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.channel.GuildChannelIconType$Voice */
    public static final class Voice extends GuildChannelIconUtils {
        public static final Voice INSTANCE = new Voice();

        private Voice() {
            super(null);
        }
    }

    private GuildChannelIconUtils() {
    }

    public /* synthetic */ GuildChannelIconUtils(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
