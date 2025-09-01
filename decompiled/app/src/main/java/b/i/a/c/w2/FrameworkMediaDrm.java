package b.i.a.c.w2;

import android.annotation.SuppressLint;
import android.media.DeniedByServerException;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaDrm;
import android.media.MediaDrmException;
import android.media.NotProvisionedException;
import android.media.UnsupportedSchemeException;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.c.C;
import b.i.a.c.f3.Log2;
import b.i.a.c.f3.Util2;
import b.i.a.c.v2.CryptoConfig;
import b.i.a.c.w2.ExoMediaDrm;
import b.i.a.c.x2.i0.PsshAtomUtil;
import b.i.b.a.Charsets;
import com.discord.widgets.chat.input.MentionUtils;
import com.google.android.exoplayer2.drm.DrmInitData;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FrameworkMediaDrm.java */
@RequiresApi(18)
/* renamed from: b.i.a.c.w2.c0, reason: use source file name */
/* loaded from: classes3.dex */
public final class FrameworkMediaDrm implements ExoMediaDrm {
    public static final /* synthetic */ int a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final UUID f1151b;
    public final MediaDrm c;
    public int d;

    /* compiled from: FrameworkMediaDrm.java */
    @RequiresApi(31)
    /* renamed from: b.i.a.c.w2.c0$a */
    public static class a {
        @DoNotInline
        public static boolean a(MediaDrm mediaDrm, String str) {
            return mediaDrm.requiresSecureDecoder(str);
        }
    }

    public FrameworkMediaDrm(UUID uuid) throws UnsupportedSchemeException {
        Objects.requireNonNull(uuid);
        UUID uuid2 = C.f1158b;
        AnimatableValueParser.m(!uuid2.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.f1151b = uuid;
        MediaDrm mediaDrm = new MediaDrm((Util2.a >= 27 || !C.c.equals(uuid)) ? uuid : uuid2);
        this.c = mediaDrm;
        this.d = 1;
        if (C.d.equals(uuid) && "ASUS_Z00AD".equals(Util2.d)) {
            mediaDrm.setPropertyString("securityLevel", "L3");
        }
    }

    @Override // b.i.a.c.w2.ExoMediaDrm
    public Map<String, String> a(byte[] bArr) {
        return this.c.queryKeyStatus(bArr);
    }

    @Override // b.i.a.c.w2.ExoMediaDrm
    public ExoMediaDrm.d b() {
        MediaDrm.ProvisionRequest provisionRequest = this.c.getProvisionRequest();
        return new ExoMediaDrm.d(provisionRequest.getData(), provisionRequest.getDefaultUrl());
    }

    @Override // b.i.a.c.w2.ExoMediaDrm
    public CryptoConfig c(byte[] bArr) throws MediaCryptoException {
        int i = Util2.a;
        boolean z2 = i < 21 && C.d.equals(this.f1151b) && "L3".equals(this.c.getPropertyString("securityLevel"));
        UUID uuid = this.f1151b;
        if (i < 27 && C.c.equals(uuid)) {
            uuid = C.f1158b;
        }
        return new FrameworkCryptoConfig(uuid, bArr, z2);
    }

    @Override // b.i.a.c.w2.ExoMediaDrm
    public byte[] d() throws MediaDrmException {
        return this.c.openSession();
    }

    @Override // b.i.a.c.w2.ExoMediaDrm
    public boolean e(byte[] bArr, String str) {
        if (Util2.a >= 31) {
            return a.a(this.c, str);
        }
        try {
            MediaCrypto mediaCrypto = new MediaCrypto(this.f1151b, bArr);
            try {
                return mediaCrypto.requiresSecureDecoderComponent(str);
            } finally {
                mediaCrypto.release();
            }
        } catch (MediaCryptoException unused) {
            return true;
        }
    }

    @Override // b.i.a.c.w2.ExoMediaDrm
    public void f(byte[] bArr, byte[] bArr2) {
        this.c.restoreKeys(bArr, bArr2);
    }

    @Override // b.i.a.c.w2.ExoMediaDrm
    public void g(byte[] bArr) {
        this.c.closeSession(bArr);
    }

    @Override // b.i.a.c.w2.ExoMediaDrm
    public void h(@Nullable ExoMediaDrm.b bVar) {
        this.c.setOnEventListener(new o(this, bVar));
    }

    @Override // b.i.a.c.w2.ExoMediaDrm
    @Nullable
    public byte[] i(byte[] bArr, byte[] bArr2) throws JSONException, DeniedByServerException, NotProvisionedException {
        if (C.c.equals(this.f1151b) && Util2.a < 27) {
            try {
                JSONObject jSONObject = new JSONObject(Util2.l(bArr2));
                StringBuilder sb = new StringBuilder("{\"keys\":[");
                JSONArray jSONArray = jSONObject.getJSONArray("keys");
                for (int i = 0; i < jSONArray.length(); i++) {
                    if (i != 0) {
                        sb.append(",");
                    }
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    sb.append("{\"k\":\"");
                    sb.append(jSONObject2.getString("k").replace('-', '+').replace('_', MentionUtils.SLASH_CHAR));
                    sb.append("\",\"kid\":\"");
                    sb.append(jSONObject2.getString("kid").replace('-', '+').replace('_', MentionUtils.SLASH_CHAR));
                    sb.append("\",\"kty\":\"");
                    sb.append(jSONObject2.getString("kty"));
                    sb.append("\"}");
                }
                sb.append("]}");
                bArr2 = Util2.w(sb.toString());
            } catch (JSONException e) {
                String strL = Util2.l(bArr2);
                Log2.b("ClearKeyUtil", strL.length() != 0 ? "Failed to adjust response data: ".concat(strL) : new String("Failed to adjust response data: "), e);
            }
        }
        return this.c.provideKeyResponse(bArr, bArr2);
    }

    @Override // b.i.a.c.w2.ExoMediaDrm
    public void j(byte[] bArr) throws DeniedByServerException {
        this.c.provideProvisionResponse(bArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0206  */
    @Override // b.i.a.c.w2.ExoMediaDrm
    @SuppressLint({"WrongConstant"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ExoMediaDrm.a k(byte[] bArr, @Nullable List<DrmInitData.SchemeData> list, int i, @Nullable HashMap<String, String> map) throws NotProvisionedException {
        byte[] bArr2;
        String str;
        DrmInitData.SchemeData schemeData;
        boolean z2;
        byte[] bArrW1;
        DrmInitData.SchemeData schemeData2 = null;
        if (list != null) {
            if (!C.d.equals(this.f1151b)) {
                schemeData = list.get(0);
            } else if (Util2.a < 28 || list.size() <= 1) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    DrmInitData.SchemeData schemeData3 = list.get(i2);
                    byte[] bArr3 = schemeData3.n;
                    Objects.requireNonNull(bArr3);
                    PsshAtomUtil psshAtomUtilV1 = AnimatableValueParser.v1(bArr3);
                    int i3 = psshAtomUtilV1 == null ? -1 : psshAtomUtilV1.f1227b;
                    int i4 = Util2.a;
                    if ((i4 < 23 && i3 == 0) || (i4 >= 23 && i3 == 1)) {
                        schemeData2 = schemeData3;
                        break;
                    }
                }
                schemeData = list.get(0);
            } else {
                DrmInitData.SchemeData schemeData4 = list.get(0);
                int length = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    DrmInitData.SchemeData schemeData5 = list.get(i5);
                    byte[] bArr4 = schemeData5.n;
                    Objects.requireNonNull(bArr4);
                    if (Util2.a(schemeData5.m, schemeData4.m) && Util2.a(schemeData5.l, schemeData4.l)) {
                        if (AnimatableValueParser.v1(bArr4) != null) {
                            length += bArr4.length;
                        }
                    }
                    z2 = false;
                }
                z2 = true;
                if (z2) {
                    byte[] bArr5 = new byte[length];
                    int i6 = 0;
                    for (int i7 = 0; i7 < list.size(); i7++) {
                        byte[] bArr6 = list.get(i7).n;
                        Objects.requireNonNull(bArr6);
                        int length2 = bArr6.length;
                        System.arraycopy(bArr6, 0, bArr5, i6, length2);
                        i6 += length2;
                    }
                    schemeData = new DrmInitData.SchemeData(schemeData4.k, schemeData4.l, schemeData4.m, bArr5);
                }
            }
            schemeData2 = schemeData;
            UUID uuid = this.f1151b;
            byte[] bArrArray = schemeData2.n;
            Objects.requireNonNull(bArrArray);
            UUID uuid2 = C.e;
            if (uuid2.equals(uuid)) {
                byte[] bArrW12 = AnimatableValueParser.w1(bArrArray, uuid);
                if (bArrW12 != null) {
                    bArrArray = bArrW12;
                }
                int i8 = (bArrArray[0] & 255) | ((bArrArray[1] & 255) << 8) | ((bArrArray[2] & 255) << 16) | ((bArrArray[3] & 255) << 24);
                short s2 = (short) (((bArrArray[5] & 255) << 8) | (bArrArray[4] & 255));
                short s3 = (short) (((bArrArray[7] & 255) << 8) | (bArrArray[6] & 255));
                if (s2 == 1 && s3 == 1) {
                    short s4 = (short) (((bArrArray[9] & 255) << 8) | (bArrArray[8] & 255));
                    Charset charset = Charsets.d;
                    String str2 = new String(bArrArray, 10, s4, charset);
                    if (!str2.contains("<LA_URL>")) {
                        int iIndexOf = str2.indexOf("</DATA>");
                        if (iIndexOf == -1) {
                            Log.w("FrameworkMediaDrm", "Could not find the </DATA> tag. Skipping LA_URL workaround.");
                        }
                        String strSubstring = str2.substring(0, iIndexOf);
                        String strSubstring2 = str2.substring(iIndexOf);
                        String strK = outline.k(outline.b(strSubstring2, outline.b(strSubstring, 26)), strSubstring, "<LA_URL>https://x</LA_URL>", strSubstring2);
                        int i9 = i8 + 52;
                        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i9);
                        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
                        byteBufferAllocate.putInt(i9);
                        byteBufferAllocate.putShort(s2);
                        byteBufferAllocate.putShort(s3);
                        byteBufferAllocate.putShort((short) (strK.length() * 2));
                        byteBufferAllocate.put(strK.getBytes(charset));
                        bArrArray = byteBufferAllocate.array();
                    }
                } else {
                    Log.i("FrameworkMediaDrm", "Unexpected record count or type. Skipping LA_URL workaround.");
                }
                int length3 = (bArrArray != null ? bArrArray.length : 0) + 32;
                ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(length3);
                byteBufferAllocate2.putInt(length3);
                byteBufferAllocate2.putInt(1886614376);
                byteBufferAllocate2.putInt(0);
                byteBufferAllocate2.putLong(uuid2.getMostSignificantBits());
                byteBufferAllocate2.putLong(uuid2.getLeastSignificantBits());
                if (bArrArray != null && bArrArray.length != 0) {
                    byteBufferAllocate2.putInt(bArrArray.length);
                    byteBufferAllocate2.put(bArrArray);
                }
                bArrArray = byteBufferAllocate2.array();
            }
            int i10 = Util2.a;
            if (i10 >= 23 || !C.d.equals(uuid)) {
                if (uuid2.equals(uuid) && "Amazon".equals(Util2.c)) {
                    String str3 = Util2.d;
                    if ("AFTB".equals(str3) || "AFTS".equals(str3) || "AFTM".equals(str3) || "AFTT".equals(str3)) {
                        bArrW1 = AnimatableValueParser.w1(bArrArray, uuid);
                        if (bArrW1 == null) {
                        }
                        UUID uuid3 = this.f1151b;
                        String str4 = schemeData2.m;
                        bArr2 = bArrW1;
                        str = (i10 >= 26 && C.c.equals(uuid3) && ("video/mp4".equals(str4) || "audio/mp4".equals(str4))) ? "cenc" : str4;
                    }
                }
                bArrW1 = bArrArray;
                UUID uuid32 = this.f1151b;
                String str42 = schemeData2.m;
                if (i10 >= 26) {
                    bArr2 = bArrW1;
                    str = (i10 >= 26 && C.c.equals(uuid32) && ("video/mp4".equals(str42) || "audio/mp4".equals(str42))) ? "cenc" : str42;
                }
            }
        } else {
            bArr2 = null;
            str = null;
        }
        MediaDrm.KeyRequest keyRequest = this.c.getKeyRequest(bArr, bArr2, str, i, map);
        UUID uuid4 = this.f1151b;
        byte[] data = keyRequest.getData();
        if (C.c.equals(uuid4) && Util2.a < 27) {
            data = Util2.w(Util2.l(data).replace('+', '-').replace(MentionUtils.SLASH_CHAR, '_'));
        }
        String defaultUrl = keyRequest.getDefaultUrl();
        if ("https://x".equals(defaultUrl)) {
            defaultUrl = "";
        }
        if (TextUtils.isEmpty(defaultUrl) && schemeData2 != null && !TextUtils.isEmpty(schemeData2.l)) {
            defaultUrl = schemeData2.l;
        }
        return new ExoMediaDrm.a(data, defaultUrl, Util2.a >= 23 ? keyRequest.getRequestType() : Integer.MIN_VALUE);
    }

    @Override // b.i.a.c.w2.ExoMediaDrm
    public int l() {
        return 2;
    }

    @Override // b.i.a.c.w2.ExoMediaDrm
    public synchronized void release() {
        int i = this.d - 1;
        this.d = i;
        if (i == 0) {
            this.c.release();
        }
    }
}
