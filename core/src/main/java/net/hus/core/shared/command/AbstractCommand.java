package net.hus.core.shared.command;

import net.hus.core.shared.rpc.common.RpcCommand;
import net.hus.core.shared.rpc.common.RpcResponse;
import net.hus.core.shared.util.EncryptUtil;

@SuppressWarnings("serial")
public abstract class AbstractCommand implements RpcCommand, RpcResponse
{
  private String mEncryptKey;
  private String mUserInfo;
  private String mIpAddress;

  @Override
  public String getIpAddress()
  {
    return mIpAddress;
  }

  @Override
  public void setIpAddress(String inIp)
  {
    mIpAddress = inIp;
  }

  @Override
  public String getUserInfo()
  {
    return mUserInfo;
  }

  @Override
  public void setUserInfo(String inUser)
  {
    mUserInfo = inUser;
  }

  public String encryptKey()
  {
    return mEncryptKey;
  }

  // public String getEncryptKey()
  // {
  // return mEncryptKey;
  // }

  @Override
  public void setEncryptKey(String inEncryptKey)
  {
    mEncryptKey = inEncryptKey;
  }

  @Override
  public boolean isEncrypted()
  {
    return mEncryptKey != null && mEncryptKey.length() == 80;
  }

  @Override
  public boolean isEncryptRequired()
  {
    return true;
  }

  @Override
  public void decrypt()
  {
    mEncryptKey = EncryptUtil.decrypt(mEncryptKey);
  }

  @Override
  public void encrypt()
  {
    mEncryptKey = EncryptUtil.encrypt(mEncryptKey);
  }
}