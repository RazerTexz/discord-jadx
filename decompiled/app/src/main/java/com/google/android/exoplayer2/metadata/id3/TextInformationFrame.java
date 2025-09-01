package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import b.d.b.a.outline;
import b.i.a.c.MediaMetadata;
import b.i.a.c.f3.Util2;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public final class TextInformationFrame extends Id3Frame {
    public static final Parcelable.Creator<TextInformationFrame> CREATOR = new a();

    @Nullable
    public final String k;
    public final String l;

    public class a implements Parcelable.Creator<TextInformationFrame> {
        @Override // android.os.Parcelable.Creator
        public TextInformationFrame createFromParcel(Parcel parcel) {
            return new TextInformationFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public TextInformationFrame[] newArray(int i) {
            return new TextInformationFrame[i];
        }
    }

    public TextInformationFrame(String str, @Nullable String str2, String str3) {
        super(str);
        this.k = str2;
        this.l = str3;
    }

    public static List<Integer> a(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            if (str.length() >= 10) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(8, 10))));
            } else if (str.length() >= 7) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
            } else if (str.length() >= 4) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
            }
            return arrayList;
        } catch (NumberFormatException unused) {
            return new ArrayList();
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TextInformationFrame.class != obj.getClass()) {
            return false;
        }
        TextInformationFrame textInformationFrame = (TextInformationFrame) obj;
        return Util2.a(this.j, textInformationFrame.j) && Util2.a(this.k, textInformationFrame.k) && Util2.a(this.l, textInformationFrame.l);
    }

    public int hashCode() {
        int iM = outline.m(this.j, 527, 31);
        String str = this.k;
        int iHashCode = (iM + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.l;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame, com.google.android.exoplayer2.metadata.Metadata.Entry
    public void n(MediaMetadata.b bVar) throws NumberFormatException {
        String str = this.j;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case 82815:
                if (str.equals("TAL")) {
                    c = 0;
                    break;
                }
                break;
            case 82878:
                if (str.equals("TCM")) {
                    c = 1;
                    break;
                }
                break;
            case 82897:
                if (str.equals("TDA")) {
                    c = 2;
                    break;
                }
                break;
            case 83253:
                if (str.equals("TP1")) {
                    c = 3;
                    break;
                }
                break;
            case 83254:
                if (str.equals("TP2")) {
                    c = 4;
                    break;
                }
                break;
            case 83255:
                if (str.equals("TP3")) {
                    c = 5;
                    break;
                }
                break;
            case 83341:
                if (str.equals("TRK")) {
                    c = 6;
                    break;
                }
                break;
            case 83378:
                if (str.equals("TT2")) {
                    c = 7;
                    break;
                }
                break;
            case 83536:
                if (str.equals("TXT")) {
                    c = '\b';
                    break;
                }
                break;
            case 83552:
                if (str.equals("TYE")) {
                    c = '\t';
                    break;
                }
                break;
            case 2567331:
                if (str.equals("TALB")) {
                    c = '\n';
                    break;
                }
                break;
            case 2569357:
                if (str.equals("TCOM")) {
                    c = 11;
                    break;
                }
                break;
            case 2569891:
                if (str.equals("TDAT")) {
                    c = '\f';
                    break;
                }
                break;
            case 2570401:
                if (str.equals("TDRC")) {
                    c = '\r';
                    break;
                }
                break;
            case 2570410:
                if (str.equals("TDRL")) {
                    c = 14;
                    break;
                }
                break;
            case 2571565:
                if (str.equals("TEXT")) {
                    c = 15;
                    break;
                }
                break;
            case 2575251:
                if (str.equals("TIT2")) {
                    c = 16;
                    break;
                }
                break;
            case 2581512:
                if (str.equals("TPE1")) {
                    c = 17;
                    break;
                }
                break;
            case 2581513:
                if (str.equals("TPE2")) {
                    c = 18;
                    break;
                }
                break;
            case 2581514:
                if (str.equals("TPE3")) {
                    c = 19;
                    break;
                }
                break;
            case 2583398:
                if (str.equals("TRCK")) {
                    c = 20;
                    break;
                }
                break;
            case 2590194:
                if (str.equals("TYER")) {
                    c = 21;
                    break;
                }
                break;
        }
        try {
            switch (c) {
                case 0:
                case '\n':
                    bVar.c = this.l;
                    break;
                case 1:
                case 11:
                    bVar.f1053y = this.l;
                    break;
                case 2:
                case '\f':
                    int i = Integer.parseInt(this.l.substring(2, 4));
                    int i2 = Integer.parseInt(this.l.substring(0, 2));
                    bVar.f1051s = Integer.valueOf(i);
                    bVar.t = Integer.valueOf(i2);
                    break;
                case 3:
                case 17:
                    bVar.f1050b = this.l;
                    break;
                case 4:
                case 18:
                    bVar.d = this.l;
                    break;
                case 5:
                case 19:
                    bVar.f1054z = this.l;
                    break;
                case 6:
                case 20:
                    String[] strArrH = Util2.H(this.l, AutocompleteViewModel.COMMAND_DISCOVER_TOKEN);
                    int i3 = Integer.parseInt(strArrH[0]);
                    Integer numValueOf = strArrH.length > 1 ? Integer.valueOf(Integer.parseInt(strArrH[1])) : null;
                    bVar.n = Integer.valueOf(i3);
                    bVar.o = numValueOf;
                    break;
                case 7:
                case 16:
                    bVar.a = this.l;
                    break;
                case '\b':
                case 15:
                    bVar.f1052x = this.l;
                    break;
                case '\t':
                case 21:
                    bVar.r = Integer.valueOf(Integer.parseInt(this.l));
                    break;
                case '\r':
                    ArrayList arrayList = (ArrayList) a(this.l);
                    int size = arrayList.size();
                    if (size != 1) {
                        if (size != 2) {
                            if (size == 3) {
                                bVar.t = (Integer) arrayList.get(2);
                            }
                        }
                        bVar.f1051s = (Integer) arrayList.get(1);
                    }
                    bVar.r = (Integer) arrayList.get(0);
                    break;
                case 14:
                    ArrayList arrayList2 = (ArrayList) a(this.l);
                    int size2 = arrayList2.size();
                    if (size2 != 1) {
                        if (size2 != 2) {
                            if (size2 == 3) {
                                bVar.w = (Integer) arrayList2.get(2);
                            }
                        }
                        bVar.v = (Integer) arrayList2.get(1);
                    }
                    bVar.u = (Integer) arrayList2.get(0);
                    break;
            }
        } catch (NumberFormatException | StringIndexOutOfBoundsException unused) {
        }
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public String toString() {
        String str = this.j;
        String str2 = this.k;
        String str3 = this.l;
        StringBuilder sbS = outline.S(outline.b(str3, outline.b(str2, outline.b(str, 22))), str, ": description=", str2, ": value=");
        sbS.append(str3);
        return sbS.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.j);
        parcel.writeString(this.k);
        parcel.writeString(this.l);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public TextInformationFrame(Parcel parcel) {
        String string = parcel.readString();
        int i = Util2.a;
        super(string);
        this.k = parcel.readString();
        this.l = parcel.readString();
    }
}
