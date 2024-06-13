import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.fisco.bcos.sdk.abi.FunctionEncoder;
import org.fisco.bcos.sdk.abi.FunctionReturnDecoder;
import org.fisco.bcos.sdk.abi.TypeReference;
import org.fisco.bcos.sdk.abi.datatypes.Address;
import org.fisco.bcos.sdk.abi.datatypes.DynamicArray;
import org.fisco.bcos.sdk.abi.datatypes.DynamicStruct;
import org.fisco.bcos.sdk.abi.datatypes.Event;
import org.fisco.bcos.sdk.abi.datatypes.Function;
import org.fisco.bcos.sdk.abi.datatypes.Type;
import org.fisco.bcos.sdk.abi.datatypes.Utf8String;
import org.fisco.bcos.sdk.abi.datatypes.generated.Int256;
import org.fisco.bcos.sdk.abi.datatypes.generated.Uint256;
import org.fisco.bcos.sdk.abi.datatypes.generated.tuples.generated.Tuple1;
import org.fisco.bcos.sdk.abi.datatypes.generated.tuples.generated.Tuple2;
import org.fisco.bcos.sdk.abi.datatypes.generated.tuples.generated.Tuple5;
import org.fisco.bcos.sdk.client.Client;
import org.fisco.bcos.sdk.contract.Contract;
import org.fisco.bcos.sdk.crypto.CryptoSuite;
import org.fisco.bcos.sdk.crypto.keypair.CryptoKeyPair;
import org.fisco.bcos.sdk.eventsub.EventCallback;
import org.fisco.bcos.sdk.model.CryptoType;
import org.fisco.bcos.sdk.model.TransactionReceipt;
import org.fisco.bcos.sdk.model.callback.TransactionCallback;
import org.fisco.bcos.sdk.transaction.model.exception.ContractException;

@SuppressWarnings("unchecked")
public class Project extends Contract {
    public static final String[] BINARY_ARRAY = {};

    public static final String BINARY = org.fisco.bcos.sdk.utils.StringUtils.joinAll("", BINARY_ARRAY);

    public static final String[] SM_BINARY_ARRAY = {"60806040523480156200001157600080fd5b50604051620028f6380380620028f68339810180604052620000379190810190620003cb565b8260008190555081600190805190602001906200005692919062000221565b50806003819055506000600481905550600060028190555033600660006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600560a0604051908101604052803373ffffffffffffffffffffffffffffffffffffffff16815260200160008152602001600081526020014281526020016040805190810160405280600c81526020017fe9a1b9e79baee7ab8be9a1b900000000000000000000000000000000000000008152508152509080600181540180825580915050906001820390600052602060002090600502016000909192909190915060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506020820151816001015560408201518160020155606082015181600301556080820151816004019080519060200190620001d4929190620002a8565b505050507fc2933a6d21f65a42477fae15e87e01a58252ece9cd07cf2a52b5cc87f9a23f493360008042604051620002109493929190620004b5565b60405180910390a15050506200060e565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106200026457805160ff191683800117855562000295565b8280016001018555821562000295579182015b828111156200029457825182559160200191906001019062000277565b5b509050620002a491906200032f565b5090565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10620002eb57805160ff19168380011785556200031c565b828001600101855582156200031c579182015b828111156200031b578251825591602001919060010190620002fe565b5b5090506200032b91906200032f565b5090565b6200035491905b808211156200035057600081600090555060010162000336565b5090565b90565b600082601f83011215156200036b57600080fd5b8151620003826200037c8262000545565b62000517565b915080825260208301602083018583830111156200039f57600080fd5b620003ac838284620005d8565b50505092915050565b6000620003c38251620005a6565b905092915050565b600080600060608486031215620003e157600080fd5b6000620003f186828701620003b5565b935050602084015167ffffffffffffffff8111156200040f57600080fd5b6200041d8682870162000357565b92505060406200043086828701620003b5565b9150509250925092565b620004458162000572565b82525050565b6200045681620005b0565b82525050565b6200046781620005c4565b82525050565b6000600682527f63726561746500000000000000000000000000000000000000000000000000006020830152604082019050919050565b620004af816200059c565b82525050565b600060a082019050620004cc60008301876200043a565b620004db60208301866200044b565b620004ea60408301856200045c565b620004f96060830184620004a4565b81810360808301526200050c816200046d565b905095945050505050565b6000604051905081810181811067ffffffffffffffff821117156200053b57600080fd5b8060405250919050565b600067ffffffffffffffff8211156200055d57600080fd5b601f19601f8301169050602081019050919050565b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b6000819050919050565b6000819050919050565b6000819050919050565b6000620005bd8262000592565b9050919050565b6000620005d1826200059c565b9050919050565b60005b83811015620005f8578082015181840152602081019050620005db565b8381111562000608576000848401525b50505050565b6122d8806200061e6000396000f3006080604052600436106100fc576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680630d34a9e81461010157806344b298521461012c5780634b0d55e1146101575780634f457948146101825780635089e2c8146101ab5780637e4cf0e2146101d65780637f7b8fbc1461020157806398eeb4df1461022c5780639d92cba414610255578063a3f3eb821461027e578063bc9739fe146102a9578063bef03f2b146102d2578063c6076258146102fd578063da2c581f1461033e578063dfd2baec14610369578063ede7ddf614610392578063fa0370a6146103bd578063fb699658146103e6575b600080fd5b34801561010d57600080fd5b5061011661040f565b60405161012391906120a9565b60405180910390f35b34801561013857600080fd5b50610141610415565b60405161014e919061202a565b60405180910390f35b34801561016357600080fd5b5061016c61058b565b60405161017991906120a9565b60405180910390f35b34801561018e57600080fd5b506101a960048036036101a49190810190611ab9565b610595565b005b3480156101b757600080fd5b506101c06107aa565b6040516101cd9190611d31565b60405180910390f35b3480156101e257600080fd5b506101eb6107d0565b6040516101f891906120a9565b60405180910390f35b34801561020d57600080fd5b506102166107d6565b60405161022391906120a9565b60405180910390f35b34801561023857600080fd5b50610253600480360361024e91908101906119f3565b6107e0565b005b34801561026157600080fd5b5061027c60048036036102779190810190611a4b565b610ad8565b005b34801561028a57600080fd5b50610293610cdd565b6040516102a09190612067565b60405180910390f35b3480156102b557600080fd5b506102d060048036036102cb9190810190611a4b565b610d7b565b005b3480156102de57600080fd5b506102e7610f80565b6040516102f4919061204c565b60405180910390f35b34801561030957600080fd5b50610324600480360361031f9190810190611a90565b611020565b604051610335959493929190611d4c565b60405180910390f35b34801561034a57600080fd5b5061035361111d565b6040516103609190611d31565b60405180910390f35b34801561037557600080fd5b50610390600480360361038b9190810190611ab9565b611143565b005b34801561039e57600080fd5b506103a7611408565b6040516103b491906120a9565b60405180910390f35b3480156103c957600080fd5b506103e460048036036103df9190810190611ab9565b61140e565b005b3480156103f257600080fd5b5061040d60048036036104089190810190611ab9565b6116c7565b005b60035481565b60606005805480602002602001604051908101604052809291908181526020016000905b82821015610582578382906000526020600020906005020160a060405190810160405290816000820160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001600182015481526020016002820154815260200160038201548152602001600482018054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561056a5780601f1061053f5761010080835404028352916020019161056a565b820191906000526020600020905b81548152906001019060200180831161054d57829003601f168201915b50505050508152505081526020019060010190610439565b50505050905090565b6000600454905090565b600660009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610627576040517fc703cb1200000000000000000000000000000000000000000000000000000000815260040161061e90612089565b60405180910390fd5b600560a0604051908101604052803373ffffffffffffffffffffffffffffffffffffffff1681526020016004815260200185815260200142815260200184848080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050508152509080600181540180825580915050906001820390600052602060002090600502016000909192909190915060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060208201518160010155604082015181600201556060820151816003015560808201518160040190805190602001906107469291906118da565b505050508260046000828254019250508190555060046002819055507fc2933a6d21f65a42477fae15e87e01a58252ece9cd07cf2a52b5cc87f9a23f49336004600042868660405161079d96959493929190611eba565b60405180910390a1505050565b600660009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b60005481565b6000600254905090565b600660009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610872576040517fc703cb1200000000000000000000000000000000000000000000000000000000815260040161086990612089565b60405180910390fd5b82600760006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600760009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166358687d426000543085856040518563ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040161093294939291906120c4565b600060405180830381600087803b15801561094c57600080fd5b505af1158015610960573d6000803e3d6000fd5b505050506001600281905550600560a0604051908101604052803373ffffffffffffffffffffffffffffffffffffffff168152602001600181526020016000815260200142815260200184848080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505081525090","80600181540180825580915050906001820390600052602060002090600502016000909192909190915060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506020820151816001015560408201518160020155606082015181600301556080820151816004019080519060200190610a8c9291906118da565b505050507fc2933a6d21f65a42477fae15e87e01a58252ece9cd07cf2a52b5cc87f9a23f493360016000428686604051610acb96959493929190611da6565b60405180910390a1505050565b600660009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610b6a576040517fc703cb12000000000000000000000000000000000000000000000000000000008152600401610b6190612089565b60405180910390fd5b600560a0604051908101604052803373ffffffffffffffffffffffffffffffffffffffff168152602001600581526020016000815260200142815260200184848080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050508152509080600181540180825580915050906001820390600052602060002090600502016000909192909190915060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506020820151816001015560408201518160020155606082015181600301556080820151816004019080519060200190610c8a9291906118da565b5050505060056002819055507fc2933a6d21f65a42477fae15e87e01a58252ece9cd07cf2a52b5cc87f9a23f493360056000428686604051610cd196959493929190611f16565b60405180910390a15050565b60018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610d735780601f10610d4857610100808354040283529160200191610d73565b820191906000526020600020905b815481529060010190602001808311610d5657829003601f168201915b505050505081565b600760009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610e0d576040517fc703cb12000000000000000000000000000000000000000000000000000000008152600401610e0490612089565b60405180910390fd5b600560a0604051908101604052803373ffffffffffffffffffffffffffffffffffffffff168152602001600381526020016000815260200142815260200184848080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050508152509080600181540180825580915050906001820390600052602060002090600502016000909192909190915060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506020820151816001015560408201518160020155606082015181600301556080820151816004019080519060200190610f2d9291906118da565b5050505060036002819055507fc2933a6d21f65a42477fae15e87e01a58252ece9cd07cf2a52b5cc87f9a23f493360036000428686604051610f7496959493929190611e5e565b60405180910390a15050565b6000600660009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515611014576040517fc703cb1200000000000000000000000000000000000000000000000000000000815260040161100b90612089565b60405180910390fd5b60045460035403905090565b60058181548110151561102f57fe5b90600052602060002090600502016000915090508060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1690806001015490806002015490806003015490806004018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156111135780601f106110e857610100808354040283529160200191611113565b820191906000526020600020905b8154815290600101906020018083116110f657829003601f168201915b5050505050905085565b600760009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b600660009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156111d5576040517fc703cb120000000000000000000000000000000000000000000000000000000081526004016111cc90612089565b60405180910390fd5b600560a0604051908101604052803373ffffffffffffffffffffffffffffffffffffffff1681526020016006815260200185815260200142815260200184848080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050508152509080600181540180825580915050906001820390600052602060002090600502016000909192909190915060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060208201518160010155604082015181600201556060820151816003015560808201518160040190805190602001906112f49291906118da565b50505050826004600082825401925050819055506006600281905550600760009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166358687d426000543085856040518563ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040161138f94939291906120c4565b600060405180830381600087803b1580156113a957600080fd5b505af11580156113bd573d6000803e3d6000fd5b505050507fc2933a6d21f65a42477fae15e87e01a58252ece9cd07cf2a52b5cc87f9a23f49336006854286866040516113fb96959493929190611fce565b60405180910390a1505050565b60025481565b600660009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156114a0576040517fc703cb1200000000000000000000000000000000000000000000000000000000815260040161149790612089565b60405180910390fd5b600560a0604051908101604052803373ffffffffffffffffffffffffffffffffffffffff1681526020016005815260200185815260200142815260200184848080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050508152509080600181540180825580915050906001820390600052602060002090600502016000909192909190915060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060208201518160010155604082015181600201556060820151816003015560808201518160040190805190602001906115bf9291906118da565b50505050600760009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166382e9d0f6600054856040518363ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040161163e929190612104565b600060405180830381600087803b15801561165857600080fd5b505af115801561166c573d6000803e3d6000fd5b50505050826004600082825401925050819055507fc2933a6d21f65a42477fae15e87e01a58252ece9cd07cf2a52b5cc87f9a23f49336005854286866040516116ba96959493929190611f72565b60405180910390a1505050565b600760009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515611759576040517fc703cb1200000000000000000000000000000000000000000000000000000000815260040161175090612089565b60405180910390fd5b600560a0604051908101604052803373ffffffffffffffffffffffffffffffffffffffff1681526020016002815260200185815260200142815260200184848080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050508152509080600181540180825580915050906001820390600052602060002090600502016000909192909190915060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060208201518160010155604082015181600201556060820151816003015560808201518160040190805190602001906118789291906118da565b5050505082600460008282540192505081905550600280819055507fc2933a6d21f65a42477fae15e87e01a58252ece9cd07cf2a52b5cc87f9a23f49336002854286866040516118cd96959493929190611e02565b60405180910390a1505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061191b57805160ff1916838001178555611949565b82800160010185558215611949579182015b8281111561194857825182559160200191906001019061192d565b5b509050611956919061195a565b5090565b61197c91905b80821115611978576000816000905550600101611960565b5090565b90565b600061198b8235612191565b905092915050565b60008083601f84011215156119a757600080fd5b8235905067ffffffffffffffff8111156119c057600080fd5b6020830191508360018202830111156119d857600080fd5b9250929050565b6000","6119eb82356121b1565b905092915050565b600080600060408486031215611a0857600080fd5b6000611a168682870161197f565b935050602084013567ffffffffffffffff811115611a3357600080fd5b611a3f86828701611993565b92509250509250925092565b60008060208385031215611a5e57600080fd5b600083013567ffffffffffffffff811115611a7857600080fd5b611a8485828601611993565b92509250509250929050565b600060208284031215611aa257600080fd5b6000611ab0848285016119df565b91505092915050565b600080600060408486031215611ace57600080fd5b6000611adc868287016119df565b935050602084013567ffffffffffffffff811115611af957600080fd5b611b0586828701611993565b92509250509250925092565b611b1a8161215d565b82525050565b6000611b2b8261213a565b80845260208401935083602082028501611b448561212d565b60005b84811015611b7d578383038852611b5f838351611cac565b9250611b6a82612150565b9150602088019750600181019050611b47565b508196508694505050505092915050565b611b97816121bb565b82525050565b611ba68161217d565b82525050565b611bb5816121cd565b82525050565b611bc4816121df565b82525050565b611bd3816121f1565b82525050565b611be281612203565b82525050565b611bf181612215565b82525050565b611c0081612227565b82525050565b611c0f81612239565b82525050565b6000828452602084019350611c2b83858461224b565b611c348361228d565b840190509392505050565b6000611c4a82612145565b808452611c5e81602086016020860161225a565b611c678161228d565b602085010191505092915050565b6000600a82527fe697a0e69d83e9999021000000000000000000000000000000000000000000006020830152604082019050919050565b600060a083016000830151611cc46000860182611b11565b506020830151611cd76020860182611b9d565b506040830151611cea6040860182611d22565b506060830151611cfd6060860182611d22565b5060808301518482036080860152611d158282611c3f565b9150508091505092915050565b611d2b81612187565b82525050565b6000602082019050611d466000830184611b11565b92915050565b600060a082019050611d616000830188611b11565b611d6e6020830187611b9d565b611d7b6040830186611d22565b611d886060830185611d22565b8181036080830152611d9a8184611c3f565b90509695505050505050565b600060a082019050611dbb6000830189611b11565b611dc86020830188611bbb565b611dd56040830187611bac565b611de26060830186611d22565b8181036080830152611df5818486611c15565b9050979650505050505050565b600060a082019050611e176000830189611b11565b611e246020830188611bca565b611e316040830187611d22565b611e3e6060830186611d22565b8181036080830152611e51818486611c15565b9050979650505050505050565b600060a082019050611e736000830189611b11565b611e806020830188611bd9565b611e8d6040830187611bac565b611e9a6060830186611d22565b8181036080830152611ead818486611c15565b9050979650505050505050565b600060a082019050611ecf6000830189611b11565b611edc6020830188611be8565b611ee96040830187611bac565b611ef66060830186611d22565b8181036080830152611f09818486611c15565b9050979650505050505050565b600060a082019050611f2b6000830189611b11565b611f386020830188611bf7565b611f456040830187611bac565b611f526060830186611d22565b8181036080830152611f65818486611c15565b9050979650505050505050565b600060a082019050611f876000830189611b11565b611f946020830188611bf7565b611fa16040830187611d22565b611fae6060830186611d22565b8181036080830152611fc1818486611c15565b9050979650505050505050565b600060a082019050611fe36000830189611b11565b611ff06020830188611c06565b611ffd6040830187611d22565b61200a6060830186611d22565b818103608083015261201d818486611c15565b9050979650505050505050565b600060208201905081810360008301526120448184611b20565b905092915050565b60006020820190506120616000830184611b9d565b92915050565b600060208201905081810360008301526120818184611c3f565b905092915050565b600060208201905081810360008301526120a281611c75565b9050919050565b60006020820190506120be6000830184611d22565b92915050565b60006060820190506120d96000830187611d22565b6120e66020830186611b8e565b81810360408301526120f9818486611c15565b905095945050505050565b60006040820190506121196000830185611d22565b6121266020830184611d22565b9392505050565b6000602082019050919050565b600081519050919050565b600081519050919050565b6000602082019050919050565b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b6000819050919050565b6000819050919050565b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b6000819050919050565b60006121c68261215d565b9050919050565b60006121d882612187565b9050919050565b60006121ea8261217d565b9050919050565b60006121fc8261217d565b9050919050565b600061220e8261217d565b9050919050565b60006122208261217d565b9050919050565b60006122328261217d565b9050919050565b60006122448261217d565b9050919050565b82818337600083830152505050565b60005b8381101561227857808201518184015260208101905061225d565b83811115612287576000848401525b50505050565b6000601f19601f83011690509190505600a265627a7a723058203102494f61a5bb65675aaedb7f2a9466b3ccf0d16369f4b0498ed76e9ef43d526c6578706572696d656e74616cf50037"};

    public static final String SM_BINARY = org.fisco.bcos.sdk.utils.StringUtils.joinAll("", SM_BINARY_ARRAY);

    public static final String[] ABI_ARRAY = {"[{\"constant\":true,\"inputs\":[],\"name\":\"bal\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getTraceInfo\",\"outputs\":[{\"components\":[{\"name\":\"addr\",\"type\":\"address\"},{\"name\":\"status\",\"type\":\"int256\"},{\"name\":\"money\",\"type\":\"uint256\"},{\"name\":\"timestamp\",\"type\":\"uint256\"},{\"name\":\"remark\",\"type\":\"string\"}],\"name\":\"_data\",\"type\":\"tuple[]\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getPrice\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"money\",\"type\":\"uint256\"},{\"name\":\"remark\",\"type\":\"string\"}],\"name\":\"Pass\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"owner\",\"outputs\":[{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"ProjectId\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getStatus\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"target\",\"type\":\"address\"},{\"name\":\"remark\",\"type\":\"string\"}],\"name\":\"Deal\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"remark\",\"type\":\"string\"}],\"name\":\"Work\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"ProjectName\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"remark\",\"type\":\"string\"}],\"name\":\"Finish\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getRev\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"name\":\"traceData\",\"outputs\":[{\"name\":\"addr\",\"type\":\"address\"},{\"name\":\"status\",\"type\":\"int256\"},{\"name\":\"money\",\"type\":\"uint256\"},{\"name\":\"timestamp\",\"type\":\"uint256\"},{\"name\":\"remark\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"builder\",\"outputs\":[{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"money\",\"type\":\"uint256\"},{\"name\":\"remark\",\"type\":\"string\"}],\"name\":\"AfterMarket\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"_status\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"money\",\"type\":\"uint256\"},{\"name\":\"remark\",\"type\":\"string\"}],\"name\":\"Salary\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"money\",\"type\":\"uint256\"},{\"name\":\"remark\",\"type\":\"string\"}],\"name\":\"Build\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"inputs\":[{\"name\":\"id\",\"type\":\"uint256\"},{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"balance\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"constructor\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"addr\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"status\",\"type\":\"int256\"},{\"indexed\":false,\"name\":\"money\",\"type\":\"uint256\"},{\"indexed\":false,\"name\":\"timestamp\",\"type\":\"uint256\"},{\"indexed\":false,\"name\":\"remark\",\"type\":\"string\"}],\"name\":\"newStatus\",\"type\":\"event\"}]"};

    public static final String ABI = org.fisco.bcos.sdk.utils.StringUtils.joinAll("", ABI_ARRAY);

    public static final String FUNC_BAL = "bal";

    public static final String FUNC_GETTRACEINFO = "getTraceInfo";

    public static final String FUNC_GETPRICE = "getPrice";

    public static final String FUNC_PASS = "Pass";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_PROJECTID = "ProjectId";

    public static final String FUNC_GETSTATUS = "getStatus";

    public static final String FUNC_DEAL = "Deal";

    public static final String FUNC_WORK = "Work";

    public static final String FUNC_PROJECTNAME = "ProjectName";

    public static final String FUNC_FINISH = "Finish";

    public static final String FUNC_GETREV = "getRev";

    public static final String FUNC_TRACEDATA = "traceData";

    public static final String FUNC_BUILDER = "builder";

    public static final String FUNC_AFTERMARKET = "AfterMarket";

    public static final String FUNC__STATUS = "_status";

    public static final String FUNC_SALARY = "Salary";

    public static final String FUNC_BUILD = "Build";

    public static final Event NEWSTATUS_EVENT = new Event("newStatus", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Int256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}));
    ;

    protected Project(String contractAddress, Client client, CryptoKeyPair credential) {
        super(getBinary(client.getCryptoSuite()), contractAddress, client, credential);
    }

    public static String getBinary(CryptoSuite cryptoSuite) {
        return (cryptoSuite.getCryptoTypeConfig() == CryptoType.ECDSA_TYPE ? BINARY : SM_BINARY);
    }

    public BigInteger bal() throws ContractException {
        final Function function = new Function(FUNC_BAL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallWithSingleValueReturn(function, BigInteger.class);
    }

    public DynamicArray<Struct0> getTraceInfo() throws ContractException {
        final Function function = new Function(FUNC_GETTRACEINFO, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Struct0>>() {}));
        return executeCallWithSingleValueReturn(function, DynamicArray.class);
    }

    public BigInteger getPrice() throws ContractException {
        final Function function = new Function(FUNC_GETPRICE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallWithSingleValueReturn(function, BigInteger.class);
    }

    public TransactionReceipt Pass(BigInteger money, String remark) {
        final Function function = new Function(
                FUNC_PASS, 
                Arrays.<Type>asList(new org.fisco.bcos.sdk.abi.datatypes.generated.Uint256(money), 
                new org.fisco.bcos.sdk.abi.datatypes.Utf8String(remark)), 
                Collections.<TypeReference<?>>emptyList());
        return executeTransaction(function);
    }

    public byte[] Pass(BigInteger money, String remark, TransactionCallback callback) {
        final Function function = new Function(
                FUNC_PASS, 
                Arrays.<Type>asList(new org.fisco.bcos.sdk.abi.datatypes.generated.Uint256(money), 
                new org.fisco.bcos.sdk.abi.datatypes.Utf8String(remark)), 
                Collections.<TypeReference<?>>emptyList());
        return asyncExecuteTransaction(function, callback);
    }

    public String getSignedTransactionForPass(BigInteger money, String remark) {
        final Function function = new Function(
                FUNC_PASS, 
                Arrays.<Type>asList(new org.fisco.bcos.sdk.abi.datatypes.generated.Uint256(money), 
                new org.fisco.bcos.sdk.abi.datatypes.Utf8String(remark)), 
                Collections.<TypeReference<?>>emptyList());
        return createSignedTransaction(function);
    }

    public Tuple2<BigInteger, String> getPassInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_PASS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());
        return new Tuple2<BigInteger, String>(

                (BigInteger) results.get(0).getValue(), 
                (String) results.get(1).getValue()
                );
    }

    public String owner() throws ContractException {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeCallWithSingleValueReturn(function, String.class);
    }

    public BigInteger ProjectId() throws ContractException {
        final Function function = new Function(FUNC_PROJECTID, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallWithSingleValueReturn(function, BigInteger.class);
    }

    public BigInteger getStatus() throws ContractException {
        final Function function = new Function(FUNC_GETSTATUS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallWithSingleValueReturn(function, BigInteger.class);
    }

    public TransactionReceipt Deal(String target, String remark) {
        final Function function = new Function(
                FUNC_DEAL, 
                Arrays.<Type>asList(new org.fisco.bcos.sdk.abi.datatypes.Address(target), 
                new org.fisco.bcos.sdk.abi.datatypes.Utf8String(remark)), 
                Collections.<TypeReference<?>>emptyList());
        return executeTransaction(function);
    }

    public byte[] Deal(String target, String remark, TransactionCallback callback) {
        final Function function = new Function(
                FUNC_DEAL, 
                Arrays.<Type>asList(new org.fisco.bcos.sdk.abi.datatypes.Address(target), 
                new org.fisco.bcos.sdk.abi.datatypes.Utf8String(remark)), 
                Collections.<TypeReference<?>>emptyList());
        return asyncExecuteTransaction(function, callback);
    }

    public String getSignedTransactionForDeal(String target, String remark) {
        final Function function = new Function(
                FUNC_DEAL, 
                Arrays.<Type>asList(new org.fisco.bcos.sdk.abi.datatypes.Address(target), 
                new org.fisco.bcos.sdk.abi.datatypes.Utf8String(remark)), 
                Collections.<TypeReference<?>>emptyList());
        return createSignedTransaction(function);
    }

    public Tuple2<String, String> getDealInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_DEAL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());
        return new Tuple2<String, String>(

                (String) results.get(0).getValue(), 
                (String) results.get(1).getValue()
                );
    }

    public TransactionReceipt Work(String remark) {
        final Function function = new Function(
                FUNC_WORK, 
                Arrays.<Type>asList(new org.fisco.bcos.sdk.abi.datatypes.Utf8String(remark)), 
                Collections.<TypeReference<?>>emptyList());
        return executeTransaction(function);
    }

    public byte[] Work(String remark, TransactionCallback callback) {
        final Function function = new Function(
                FUNC_WORK, 
                Arrays.<Type>asList(new org.fisco.bcos.sdk.abi.datatypes.Utf8String(remark)), 
                Collections.<TypeReference<?>>emptyList());
        return asyncExecuteTransaction(function, callback);
    }

    public String getSignedTransactionForWork(String remark) {
        final Function function = new Function(
                FUNC_WORK, 
                Arrays.<Type>asList(new org.fisco.bcos.sdk.abi.datatypes.Utf8String(remark)), 
                Collections.<TypeReference<?>>emptyList());
        return createSignedTransaction(function);
    }

    public Tuple1<String> getWorkInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_WORK, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());
        return new Tuple1<String>(

                (String) results.get(0).getValue()
                );
    }

    public String ProjectName() throws ContractException {
        final Function function = new Function(FUNC_PROJECTNAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeCallWithSingleValueReturn(function, String.class);
    }

    public TransactionReceipt Finish(String remark) {
        final Function function = new Function(
                FUNC_FINISH, 
                Arrays.<Type>asList(new org.fisco.bcos.sdk.abi.datatypes.Utf8String(remark)), 
                Collections.<TypeReference<?>>emptyList());
        return executeTransaction(function);
    }

    public byte[] Finish(String remark, TransactionCallback callback) {
        final Function function = new Function(
                FUNC_FINISH, 
                Arrays.<Type>asList(new org.fisco.bcos.sdk.abi.datatypes.Utf8String(remark)), 
                Collections.<TypeReference<?>>emptyList());
        return asyncExecuteTransaction(function, callback);
    }

    public String getSignedTransactionForFinish(String remark) {
        final Function function = new Function(
                FUNC_FINISH, 
                Arrays.<Type>asList(new org.fisco.bcos.sdk.abi.datatypes.Utf8String(remark)), 
                Collections.<TypeReference<?>>emptyList());
        return createSignedTransaction(function);
    }

    public Tuple1<String> getFinishInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_FINISH, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());
        return new Tuple1<String>(

                (String) results.get(0).getValue()
                );
    }

    public BigInteger getRev() throws ContractException {
        final Function function = new Function(FUNC_GETREV, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeCallWithSingleValueReturn(function, BigInteger.class);
    }

    public Tuple5<String, BigInteger, BigInteger, BigInteger, String> traceData(BigInteger param0) throws ContractException {
        final Function function = new Function(FUNC_TRACEDATA, 
                Arrays.<Type>asList(new org.fisco.bcos.sdk.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Int256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}));
        List<Type> results = executeCallWithMultipleValueReturn(function);
        return new Tuple5<String, BigInteger, BigInteger, BigInteger, String>(
                (String) results.get(0).getValue(), 
                (BigInteger) results.get(1).getValue(), 
                (BigInteger) results.get(2).getValue(), 
                (BigInteger) results.get(3).getValue(), 
                (String) results.get(4).getValue());
    }

    public String builder() throws ContractException {
        final Function function = new Function(FUNC_BUILDER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeCallWithSingleValueReturn(function, String.class);
    }

    public TransactionReceipt AfterMarket(BigInteger money, String remark) {
        final Function function = new Function(
                FUNC_AFTERMARKET, 
                Arrays.<Type>asList(new org.fisco.bcos.sdk.abi.datatypes.generated.Uint256(money), 
                new org.fisco.bcos.sdk.abi.datatypes.Utf8String(remark)), 
                Collections.<TypeReference<?>>emptyList());
        return executeTransaction(function);
    }

    public byte[] AfterMarket(BigInteger money, String remark, TransactionCallback callback) {
        final Function function = new Function(
                FUNC_AFTERMARKET, 
                Arrays.<Type>asList(new org.fisco.bcos.sdk.abi.datatypes.generated.Uint256(money), 
                new org.fisco.bcos.sdk.abi.datatypes.Utf8String(remark)), 
                Collections.<TypeReference<?>>emptyList());
        return asyncExecuteTransaction(function, callback);
    }

    public String getSignedTransactionForAfterMarket(BigInteger money, String remark) {
        final Function function = new Function(
                FUNC_AFTERMARKET, 
                Arrays.<Type>asList(new org.fisco.bcos.sdk.abi.datatypes.generated.Uint256(money), 
                new org.fisco.bcos.sdk.abi.datatypes.Utf8String(remark)), 
                Collections.<TypeReference<?>>emptyList());
        return createSignedTransaction(function);
    }

    public Tuple2<BigInteger, String> getAfterMarketInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_AFTERMARKET, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());
        return new Tuple2<BigInteger, String>(

                (BigInteger) results.get(0).getValue(), 
                (String) results.get(1).getValue()
                );
    }

    public BigInteger _status() throws ContractException {
        final Function function = new Function(FUNC__STATUS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallWithSingleValueReturn(function, BigInteger.class);
    }

    public TransactionReceipt Salary(BigInteger money, String remark) {
        final Function function = new Function(
                FUNC_SALARY, 
                Arrays.<Type>asList(new org.fisco.bcos.sdk.abi.datatypes.generated.Uint256(money), 
                new org.fisco.bcos.sdk.abi.datatypes.Utf8String(remark)), 
                Collections.<TypeReference<?>>emptyList());
        return executeTransaction(function);
    }

    public byte[] Salary(BigInteger money, String remark, TransactionCallback callback) {
        final Function function = new Function(
                FUNC_SALARY, 
                Arrays.<Type>asList(new org.fisco.bcos.sdk.abi.datatypes.generated.Uint256(money), 
                new org.fisco.bcos.sdk.abi.datatypes.Utf8String(remark)), 
                Collections.<TypeReference<?>>emptyList());
        return asyncExecuteTransaction(function, callback);
    }

    public String getSignedTransactionForSalary(BigInteger money, String remark) {
        final Function function = new Function(
                FUNC_SALARY, 
                Arrays.<Type>asList(new org.fisco.bcos.sdk.abi.datatypes.generated.Uint256(money), 
                new org.fisco.bcos.sdk.abi.datatypes.Utf8String(remark)), 
                Collections.<TypeReference<?>>emptyList());
        return createSignedTransaction(function);
    }

    public Tuple2<BigInteger, String> getSalaryInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SALARY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());
        return new Tuple2<BigInteger, String>(

                (BigInteger) results.get(0).getValue(), 
                (String) results.get(1).getValue()
                );
    }

    public TransactionReceipt Build(BigInteger money, String remark) {
        final Function function = new Function(
                FUNC_BUILD, 
                Arrays.<Type>asList(new org.fisco.bcos.sdk.abi.datatypes.generated.Uint256(money), 
                new org.fisco.bcos.sdk.abi.datatypes.Utf8String(remark)), 
                Collections.<TypeReference<?>>emptyList());
        return executeTransaction(function);
    }

    public byte[] Build(BigInteger money, String remark, TransactionCallback callback) {
        final Function function = new Function(
                FUNC_BUILD, 
                Arrays.<Type>asList(new org.fisco.bcos.sdk.abi.datatypes.generated.Uint256(money), 
                new org.fisco.bcos.sdk.abi.datatypes.Utf8String(remark)), 
                Collections.<TypeReference<?>>emptyList());
        return asyncExecuteTransaction(function, callback);
    }

    public String getSignedTransactionForBuild(BigInteger money, String remark) {
        final Function function = new Function(
                FUNC_BUILD, 
                Arrays.<Type>asList(new org.fisco.bcos.sdk.abi.datatypes.generated.Uint256(money), 
                new org.fisco.bcos.sdk.abi.datatypes.Utf8String(remark)), 
                Collections.<TypeReference<?>>emptyList());
        return createSignedTransaction(function);
    }

    public Tuple2<BigInteger, String> getBuildInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_BUILD, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());
        return new Tuple2<BigInteger, String>(

                (BigInteger) results.get(0).getValue(), 
                (String) results.get(1).getValue()
                );
    }

    public List<NewStatusEventResponse> getNewStatusEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(NEWSTATUS_EVENT, transactionReceipt);
        ArrayList<NewStatusEventResponse> responses = new ArrayList<NewStatusEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            NewStatusEventResponse typedResponse = new NewStatusEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.addr = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.status = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.money = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.timestamp = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.remark = (String) eventValues.getNonIndexedValues().get(4).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public void subscribeNewStatusEvent(String fromBlock, String toBlock, List<String> otherTopics, EventCallback callback) {
        String topic0 = eventEncoder.encode(NEWSTATUS_EVENT);
        subscribeEvent(ABI,BINARY,topic0,fromBlock,toBlock,otherTopics,callback);
    }

    public void subscribeNewStatusEvent(EventCallback callback) {
        String topic0 = eventEncoder.encode(NEWSTATUS_EVENT);
        subscribeEvent(ABI,BINARY,topic0,callback);
    }

    public static Project load(String contractAddress, Client client, CryptoKeyPair credential) {
        return new Project(contractAddress, client, credential);
    }

    public static Project deploy(Client client, CryptoKeyPair credential, BigInteger id, String name, BigInteger balance) throws ContractException {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.sdk.abi.datatypes.generated.Uint256(id), 
                new org.fisco.bcos.sdk.abi.datatypes.Utf8String(name), 
                new org.fisco.bcos.sdk.abi.datatypes.generated.Uint256(balance)));
        return deploy(Project.class, client, credential, getBinary(client.getCryptoSuite()), encodedConstructor);
    }

    public static class Struct0 extends DynamicStruct {
        public String addr;

        public BigInteger status;

        public BigInteger money;

        public BigInteger timestamp;

        public String remark;

        public Struct0(Address addr, Int256 status, Uint256 money, Uint256 timestamp, Utf8String remark) {
            super(addr,status,money,timestamp,remark);
            this.addr = addr.getValue();
            this.status = status.getValue();
            this.money = money.getValue();
            this.timestamp = timestamp.getValue();
            this.remark = remark.getValue();
        }

        public Struct0(String addr, BigInteger status, BigInteger money, BigInteger timestamp, String remark) {
            super(new org.fisco.bcos.sdk.abi.datatypes.Address(addr),new org.fisco.bcos.sdk.abi.datatypes.generated.Int256(status),new org.fisco.bcos.sdk.abi.datatypes.generated.Uint256(money),new org.fisco.bcos.sdk.abi.datatypes.generated.Uint256(timestamp),new org.fisco.bcos.sdk.abi.datatypes.Utf8String(remark));
            this.addr = addr;
            this.status = status;
            this.money = money;
            this.timestamp = timestamp;
            this.remark = remark;
        }
    }

    public static class NewStatusEventResponse {
        public TransactionReceipt.Logs log;

        public String addr;

        public BigInteger status;

        public BigInteger money;

        public BigInteger timestamp;

        public String remark;
    }
}
